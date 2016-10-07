package starkemulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import starkemulator.ui.MainFrame;
import java_cup.runtime.Symbol;

/**
 * Compiler class
 *
 * @author jaam
 */
public class MyCompiler {

    private boolean branchFlag;
    private ArrayList<BasicBlock> progrBlocks;

    public MyCompiler() {
        branchFlag = false;
        progrBlocks = new ArrayList<>();
    }

    // Modo principal del compilador, se encarga del procesamiento de la entrada
    public boolean procesarEntrada(File pFile) {

        boolean canGenerateBlock = false;

        MyLexer AnalizadorLexico = null;
        MyParser AnalizadorSintactico = null;

        if (!hasTags(pFile)) {

            try {

                AnalizadorLexico = new MyLexer(new FileReader(pFile));
                AnalizadorSintactico = new MyParser(AnalizadorLexico);

                AnalizadorLexico.setGenMCode();

                AnalizadorSintactico.parse();

                //canGenerateBlock = true;
                System.out.println("Fin de escaneo..!!");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Symbol currToken = null;
            try {
                canGenerateBlock = true;

                AnalizadorLexico = new MyLexer(new FileReader(pFile));
                do {
                    currToken = AnalizadorLexico.next_token();
                } while (currToken.sym != sym.EOF);
            } catch (IOException ex) {
                Logger.getLogger(MyCompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return canGenerateBlock;
    }

    public boolean hasTags(File pTempFile) {
        Scanner sc = null;
        boolean tagFlag = false;

        try {
            sc = new Scanner(pTempFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (sc.hasNext()) {
            String line = sc.nextLine();

            String pattern = "^[a-zA-Z0-9_]*:$";
            Pattern r = Pattern.compile(pattern);
            // create matcher object.
            Matcher m = r.matcher(line);

            if (m.find()) {
                tagFlag = true;
                break;
            }
        }

        return tagFlag;
    }

    public void execBranches() {
        //System.out.println("Going to run code with branches");
        //BasicBlock firstBlock = progrBlocks.get(0);
        int index = 0;

        do {
            BasicBlock tempBlock = progrBlocks.get(index);
            
            if (tempBlock.getBlockTag().equals("d3f4ul7_")) {
                String tmpStr = execBranchesAux(tempBlock.getInstructions());
                stepAnalysis(tmpStr);
                tempBlock.setChecked(true);
            } else //System.out.println("Index: " + index);
            if (blockhasBranches(tempBlock.getInstructions())) {
                // ejecutar cada bloque de codigo que tiene algun tipo de salto
                runBranchesOnBlock(tempBlock);
                tempBlock.setChecked(true);
            } else {
                String tmpStr = execBranchesAux(tempBlock.getInstructions());
                stepAnalysis(tmpStr);
                tempBlock.setChecked(true);
            }
            // incrementar el indice
            if (index == progrBlocks.size()) {
                index = 1;
            } else {
                index += 1;
            }
        } while (!isAllChecked(progrBlocks));
        
        System.out.println("execBranches_Done");
    }

    private void runBranchesOnBlock(BasicBlock pCurrentBlock) {
        ArrayList<String> currentBlockInstr = pCurrentBlock.getInstructions();
        String lastInstr = currentBlockInstr.get(currentBlockInstr.size() - 1);

        if (lastInstr.startsWith("j") && !lastInstr.startsWith("je") && !lastInstr.startsWith("jne")
                && !lastInstr.startsWith("jlt") && !lastInstr.startsWith("jgt")) {
            runJBranch(pCurrentBlock, lastInstr);
        } else if (lastInstr.startsWith("je")) {

        } else if (lastInstr.startsWith("jne")) {

        } else if (lastInstr.startsWith("jlt")) {

        } else if (lastInstr.startsWith("jgt")) {

        }
    }

    private void runJBranch(BasicBlock pCurrentBlock, String pBranchInstr) {
        String currentBranchInstr = pBranchInstr;

        String jumpTag = currentBranchInstr.substring(2, currentBranchInstr.length());
        //System.out.println("Jump Tag: " + jumpTag);
        String tmpStr = execBranchesAux(pCurrentBlock.getInstructions());
        stepAnalysis(tmpStr);
        
        tmpStr = execBranchesAux(getJumpBlock(jumpTag).getInstructions());
        stepAnalysis(tmpStr);
    }
    
    private BasicBlock getJumpBlock(String pTag) {
        BasicBlock retBlock = null;
        
        for (int i = 0; i < progrBlocks.size(); i++) {
            if(progrBlocks.get(i).getBlockTag().equals(pTag)) {
                retBlock = progrBlocks.get(i);
            }
        }
        
        return retBlock;
    }

    private boolean isAllChecked(ArrayList<BasicBlock> pBlocks) {
        boolean retVal = false;

        int count = 0;

        for (int i = 0; i < pBlocks.size(); i++) {
            if (pBlocks.get(i).isChecked()) {
                count += 1;
            }
        }

        if (count == pBlocks.size()) {
            retVal = true;
        }

        return retVal;
    }

    private boolean blockhasBranches(ArrayList<String> pBlock) {
        boolean retVal = false;

        for (int i = 0; i < pBlock.size(); i++) {
            if (pBlock.get(i).contains("j") || pBlock.get(i).contains("je")
                    || pBlock.get(i).contains("jne") || pBlock.get(i).contains("jlt")
                    || pBlock.get(i).contains("jgt")) {
                retVal = true;
                break;
            }
        }

        return retVal;
    }

    private String execBranchesAux(ArrayList<String> pBlock) {
        String retCode = "";

        for (int i = 0; i < pBlock.size(); i++) {
            retCode = retCode + pBlock.get(i) + "\n";
        }

        return retCode;
    }

    private void stepAnalysis(String pCode) {
        BufferedWriter out = null;
        File temp = null;

        try {
            temp = File.createTempFile("TmpScrpt", ".txt");
            //create a temp file
            temp.deleteOnExit();

            out = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
            out.write(pCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        MyLexer AnalizadorLexico = null;
        MyParser AnalizadorSintactico = null;
        try {
            AnalizadorLexico = new MyLexer(new FileReader(temp));
            AnalizadorSintactico = new MyParser(AnalizadorLexico);
            AnalizadorSintactico.parse();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MyCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearBancoInstr(File pTempFile) {
        Scanner sc = null;
        boolean tagFlag = false;

        try {
            sc = new Scanner(pTempFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        BasicBlock newBlock = new BasicBlock();
        newBlock.setBlockTag("d3f4ul7_");

        while (sc.hasNext()) {
            String line = sc.nextLine();
            //System.out.println(line);

            String pattern = "^[a-zA-Z0-9_]*:$";
            Pattern r = Pattern.compile(pattern);
            // create matcher object.
            Matcher m = r.matcher(line);

            if (m.find()) {
                //System.out.println("Tag found!!!!!!");
                if (tagFlag == true) {
                    progrBlocks.add(newBlock);
                    tagFlag = false;
                }

                if (tagFlag == false) {
                    if (newBlock.getBlockTag().equals("d3f4ul7_") && progrBlocks.isEmpty()) {
                        progrBlocks.add(newBlock);
                    }
                    newBlock = new BasicBlock();
                    newBlock.setBlockTag(line.replace(":", ""));
                    tagFlag = true;
                }
            } else {
                // append the other instructions
                if (!line.equals("") && newBlock != null) {
                    newBlock.addInstr(line);
                }

                if (sc.hasNext() == false && tagFlag == true) {
                    progrBlocks.add(newBlock);
                }
            }
        }

        System.out.println("-------------------------");
        System.out.println(progrBlocks.size());
        for (int i = 0; i < progrBlocks.size(); i++) {
            BasicBlock tem = progrBlocks.get(i);
            System.out.println(progrBlocks.get(i).getBlockTag());
            for (int j = 0; j < tem.getInstructions().size(); j++) {
                System.out.println(tem.getInstructions().get(j));
            }
        }
        System.out.println("-------------------------");
    }

    public boolean isBranchFlag() {
        return branchFlag;
    }

    public void setBranchFlag(boolean branchFlag) {
        this.branchFlag = branchFlag;
    }

}

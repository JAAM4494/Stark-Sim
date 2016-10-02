package starkemulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        try {

            MyLexer AnalizadorLexico = new MyLexer(new FileReader(pFile));
            MyParser AnalizadorSintactico = new MyParser(AnalizadorLexico);

            if (hasTags(pFile)) {
                AnalizadorLexico.setGenMCode();
            }

            AnalizadorSintactico.parse();

            canGenerateBlock = true;

            // Symbol currToken;
            //   do {
            // currToken = AnalizadorLexico.next_token();
            // } while (currToken.sym != sym.EOF);
            System.out.println("Fin de escaneo..!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println("Going to run branches");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.scheduler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import starkemulator.MyCompiler;
import starkemulator.MyLexer;
import static starkemulator.scheduler.Scheduler.clk;
import starkemulator.ui.MainFrame;

/**
 *
 * @author jaam
 */
public class RunnableInstruction implements Runnable {

    private Thread t;
    private String threadName;

    private String instruction;

    private MyCompiler compiler;

    public RunnableInstruction(String name) {
        threadName = name;
        //System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        int opCode = -1;

        boolean cantExecute = true;
        try {
            
            opCode = getInstructionFU();
            
            //System.out.println("opCode:"+opCode);
            
            // check functional units available
            while (cantExecute) {
                //System.out.println("Runnning:"+cantExecute);
                switch (opCode) {
                    case 0: // ALU OP
                        //System.out.println("ALU-"+Scheduler.getUnit(0));
                        if(Scheduler.getUnit(0) == false) {
                            //System.out.println("Enter1");
                            cantExecute = false;
                        } else if (Scheduler.getUnit(1) == false) {
                            //System.out.println("Enter2");
                            cantExecute = false;
                        } else {
                            //System.out.println("Invalid---------------");
                            Thread.sleep(2000);
                        }
                        break;
                    case 1: // LD/ST OP
                        //System.out.println("LD");
                        if (Scheduler.getUnit(2) == false) {
                            cantExecute = false;
                        } else {
                            Thread.sleep(2000);
                        }
                        break;
                    case 2: // MUL OP
                        //System.out.println("MUL");
                        if(Scheduler.getUnit(3) == false) {
                            cantExecute = false;
                        } else {
                            Thread.sleep(2000);
                        }
                        break;
                }
                if(cantExecute == false) {
                    break;
                }
            }
            // next, sleep for the execution time
            //System.out.println("PassCheck");
            Thread.sleep(2000);
            System.out.println("Execute Stage, Instruction-"+ threadName + ", Cycle:" + clk);
            MainFrame.refreshTomasuloTable(Integer.toString(clk), Integer.parseInt(threadName)-1, 2);
            long delay = getExecuteDelay(opCode);
            System.out.println("Delay:"+delay);
            Thread.sleep(delay);
            
            Thread.sleep(2000);

            compiler = new MyCompiler();
            compiler.stepAnalysis(instruction);
            System.out.println("WriteBack Stage, Instruction-" + threadName + ", Cycle:" + clk);
            MainFrame.refreshTomasuloTable(Integer.toString(clk), Integer.parseInt(threadName)-1, 3);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunnableInstruction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start(String pInstruction) {
        instruction = pInstruction;
        //System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public long getExecuteDelay(int pType) {
        long retVal = 0;

        switch (pType) {
            case 0: // ALU OP
                retVal = 0;
                break;
            case 1: // LD/ST OP
                retVal = 2000;
                break;
            case 2: // MUL OP
                retVal = 4000;
                break;
        }

        return retVal;
    }

    public int getInstructionFU() {
        int retVal = -1;

        BufferedWriter out = null;
        File tempFile = null;

        try {
            tempFile = File.createTempFile("TmpScrpt" + threadName, ".txt");
            //create a temp file
            tempFile.deleteOnExit();

            out = new BufferedWriter(new FileWriter(tempFile.getAbsolutePath()));
            out.write(instruction);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(RunnableInstruction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        MyLexer lexicalAnalisis;
        try {
            lexicalAnalisis = new MyLexer(new FileReader(tempFile));

            lexicalAnalisis.next_token();
            //System.out.println("Out: "+lexicalAnalisis.yytext());
            retVal = getInstructionFU_Aux(lexicalAnalisis.yytext());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RunnableInstruction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RunnableInstruction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retVal;
    }

    public int getInstructionFU_Aux(String pInstruction) {
        int retVal = -1;

        if (pInstruction.equals("plus") || pInstruction.equals("min")
                || pInstruction.equals("and") || pInstruction.equals("nand")
                || pInstruction.equals("or") || pInstruction.equals("xor")
                || pInstruction.equals("shl") || pInstruction.equals("shr")) {
            retVal = 0; // ALU TYPE
        } else if (pInstruction.equals("sb") || pInstruction.equals("lb")
                || pInstruction.equals("sw") || pInstruction.equals("lw")
                || pInstruction.equals("smw") || pInstruction.equals("lmw")) {
            retVal = 1; // LD/ST TYPE
        } else if (pInstruction.equals("mul")) {
            retVal = 2; // MUL TYPE
        }

        return retVal;
    }

}

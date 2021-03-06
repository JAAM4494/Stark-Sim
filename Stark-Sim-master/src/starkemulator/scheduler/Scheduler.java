/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.scheduler;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import starkemulator.Main;
import starkemulator.ui.MainFrame;

/**
 *
 * @author jaam
 */
public class Scheduler {
    
    public static boolean alu1busy = false;
    public static boolean alu2busy = false;
    public static boolean ldstbusy = false;
    public static boolean mulbusy = false;
    
    private Scanner stepScanner;
    
    private Thread clkThread;
    public static int clk;
    
    public Scheduler() {
        
        clk = 0;
        
        if (clkThread == null) {
         clkThread = new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     while(true) {
                         Thread.sleep(2000);
                         clk++;
                         System.out.println("CLK:"+clk);
                     }
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }, "CLK");
         clkThread.start ();
      }
    }
    
    public void start(String pInput) {
        String program = pInput;
        int instructionCounter = 0;
        
        stepScanner = new Scanner(program);
        
        while(stepScanner.hasNext()) {
            String line = stepScanner.nextLine();
            if(line.equals("") && stepScanner.hasNext()) {
                 line = stepScanner.nextLine();
            }
            instructionCounter++;
            try {
                Thread.sleep(2000);
               // System.out.println("Issue Stage, Instruction-" + instructionCounter + ", Cycle:" + clk);
               // MainFrame.refreshTomasuloTable(Integer.toString(instructionCounter), instructionCounter-1, 0);
               // MainFrame.refreshTomasuloTable(Integer.toString(clk), instructionCounter-1, 1);
                RunnableInstruction newInstruction = new RunnableInstruction(Integer.toString(instructionCounter));
                newInstruction.start(line);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stop() {
        
    }
    
    // return's true if the unit is busy
    public static boolean getUnit(int pType) {
        boolean busyVal = true;
        
        switch(pType) {
            case 0: // ALU 1
                if(Scheduler.alu1busy == false) {
                    busyVal = false;
                    Scheduler.alu1busy = true;
                }
            break;
            case 1: // ALU 2
                if(Scheduler.alu2busy == false) {
                    busyVal = false;
                    Scheduler.alu2busy = true;
                }
            break;
            case 2: // LD/ST
                if(Scheduler.ldstbusy == false) {
                    busyVal = false;
                    Scheduler.ldstbusy = true;
                }
            break;
            case 3: // MUL
                if(Scheduler.mulbusy == false) {
                    busyVal = false;
                    Scheduler.mulbusy = true;
                }
            break;
        }
        
        return busyVal;
    }
    
}

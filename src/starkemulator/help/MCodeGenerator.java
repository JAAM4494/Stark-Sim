/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.help;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaam
 */
public class MCodeGenerator {

    private ArrayList<String> codeList;
    
    private String tempLine;

    public MCodeGenerator() {
        codeList = new ArrayList<>();
        tempLine = "";
    }
    
    public void genMid() {
        //String reverse = new StringBuffer(this.tempLine).reverse().toString();
        //System.out.println(reverse);
        this.codeList.add(this.tempLine);
        this.tempLine = "";
    }
    
    public void genFinal() {
        FileWriter filew = null;
        PrintWriter pw = null;

        try {
            filew = new FileWriter("src/starkemulator/mCode.stark");
            pw = new PrintWriter(filew);

            for (int i = 0; i < this.codeList.size(); i++) {
                pw.println(this.codeList.get(i));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(MCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (null != filew) {
                    filew.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    // ------------------- IMMIDIATE ----------------- FALTA****
    public void appendImm(String pToken, int pImm) {
         
    }
    
    // ------------------- REGISTERS -----------------
    public void appendReg(String pToken) {
        switch(pToken) {
            case "r0":
                tempLine = "0000" + tempLine;
                break;
            case "r1":
                tempLine = "0001" + tempLine;
                break;
            case "r2":
                tempLine = "0010" + tempLine;
                break;
            case "r3":
                tempLine = "0011" + tempLine;
                break;
            case "r4":
                tempLine = "0100" + tempLine;
                break;
            case "r5":
                tempLine = "0101" + tempLine;
                break;
            case "r6":
                tempLine = "0110" + tempLine;
                break;
            case "r7":
                tempLine = "0111" + tempLine;
                break;
            case "r8":
                tempLine = "1000" + tempLine;
                break;
            case "r9":
                tempLine = "1001" + tempLine;
                break;
            case "r10":
                tempLine = "1010" + tempLine;
                break;
            case "r11":
                tempLine = "1011" + tempLine;
                break;
            case "r12":
                tempLine = "1100" + tempLine;
                break;
            case "r13":
                tempLine = "1101" + tempLine;
                break;
            case "r14":
                tempLine = "1110" + tempLine;
                break;
            case "r15":
                tempLine = "1111" + tempLine;
                break;
        }
    }

    // ------------------- OPERATIONS -----------------
    public void appendOp(String pToken) {
        switch(pToken) {
            case "plus":
                tempLine = "000" + "000";
                break;
            case "min":
                tempLine = "001" + "000";
                break;
            case "mul":
                tempLine = "010" + "000";
                break;
            case "and":
                tempLine = "000" + "001";
                break;
            case "nand":
                tempLine = "001" + "001";
                break;
            case "or":
                tempLine = "010" + "001";
                break;
            case "xor":
                tempLine = "011" + "001";
                break;
            case "shl":
                tempLine = "000" + "010";
                break;
            case "shr":
                tempLine = "001" + "010";
                break;
            case "sb":
                tempLine = "000" + "011";
                break;
            case "lb":
                tempLine = "001" + "011";
                break;
            case "sw":
                tempLine = "010" + "011";
                break;
            case "lw":
                tempLine = "011" + "011";
                break;
            case "smw":
                tempLine = "100" + "011";
                break;
            case "lmw":
                tempLine = "101" + "011";
                break;
            case "je":
                tempLine = "000" + "100";
                break;
            case "jne":
                tempLine = "001" + "100";
                break;
            case "jlt":
                tempLine = "010" + "100";
                break;
            case "jgt":
                tempLine = "011" + "100";
                break;
            case "j":
                tempLine = "100" + "100";
                break;
        }
    }

}

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
    private String tempLineReg;
    private int counterReg;

    
    private boolean inmmediateFlag;

    public MCodeGenerator() {
        codeList = new ArrayList<>();
        tempLine = "";
        tempLineReg="";
        inmmediateFlag=false;
        counterReg=0;
    }
    
    public void setInmediateFlag(boolean valFlag){
        inmmediateFlag=valFlag;
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
    public void appendImm(String pType, String inmmediate ) {
        String binaryImm;
        switch(pType) {
            case "H":
                inmmediate=inmmediate.replace("0x", "");
                binaryImm =Integer.toBinaryString(Integer.parseInt(inmmediate,16) );
                binaryImm=pad(binaryImm,17);
                tempLine=tempLineReg+binaryImm+ "1" + tempLine;
                break;
            case "D":
               binaryImm =Integer.toBinaryString(Integer.parseInt(inmmediate) );
               binaryImm=pad(binaryImm,17);
               tempLine=tempLineReg+binaryImm+ "1" + tempLine;
                break;
        }    
        
       
    }
    
    private String pad(String s, int numDigits){
        StringBuffer sb = new StringBuffer(s);
        int numZeros = numDigits - s.length();
        while(numZeros-- > 0) { 
            sb.insert(0, "0");
        }
        return sb.toString();
    }
    
    // ------------------- REGISTERS -----------------
    public void appendReg(String pToken) {
        counterReg++;
        switch(pToken) {
            case "r0":
                tempLineReg = tempLineReg+ "0000"  ;
                break;
            case "r1":
                tempLineReg = tempLineReg+ "0001" ;
                break;
            case "r2":
                tempLineReg = tempLineReg+"0010" ;
                break;
            case "r3":
                tempLineReg = tempLineReg+ "0011" ;
                break;
            case "r4":
                tempLineReg = tempLineReg+"0100";
                break;
            case "r5":
                tempLineReg = tempLineReg+"0101" ;
                break;
            case "r6":
                tempLineReg = tempLineReg+"0110" ;
                break;
            case "r7":
                tempLineReg = tempLineReg+"0111" ;
                break;
            case "r8":
                tempLineReg = tempLineReg+"1000" ;
                break;
            case "r9":
                tempLineReg = tempLineReg+"1001" ;
                break;
            case "r10":
                tempLineReg = tempLineReg+"1010";
                break;
            case "r11":
                tempLineReg = tempLineReg+"1011" ;
                break;
            case "r12":
                tempLineReg = tempLineReg+"1100" ;
                break;
            case "r13":
                tempLineReg = tempLineReg+"1101" ;
                break;
            case "r14":
                tempLineReg = tempLineReg+"1110" ;
                break;
            case "r15":
                tempLineReg = tempLineReg+"1111";
                break;
        }
        verifyRegCount();
    }
    
    private void verifyRegCount(){
        System.out.println("verifying" + tempLine);
        if(counterReg==3){
            tempLine=tempLineReg+"000000000000000"+ "0" + tempLine;
            counterReg=0;
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

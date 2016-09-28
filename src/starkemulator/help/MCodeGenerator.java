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
    private Boolean shiftOp;
    private Boolean memOp;


    

    public MCodeGenerator() {
        codeList = new ArrayList<>();
        tempLine = "";
        tempLineReg="";
        counterReg=0;
        shiftOp=false;
        memOp=false;
        
    }
    
    
    
    public void genMid() {
        //String reverse = new StringBuffer(this.tempLine).reverse().toString();
        //System.out.println(reverse);
        if( memOp==true){  tempLine=tempLineReg+tempLine;  memOp=false;   }
        this.codeList.add(this.tempLine);
        this.tempLine = "";
        this.tempLineReg = "";
        counterReg=0;
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
    
    // ------------------- IMMIDIATE -----------------
    public void appendImm(String pType, String inmmediate ) {
        switch(pType) {
            case "H":
                if(shiftOp){  appendShiftDisp(pType,inmmediate);  }
                else if (memOp){ appendMem (pType,inmmediate);   }
                else{ appendArithLogic(pType,inmmediate); }
                
                break;
            case "D":
                if(shiftOp){   appendShiftDisp(pType,inmmediate);   }
                else if (memOp){ appendMem (pType,inmmediate);   }
                else{ appendArithLogic(pType,inmmediate); }

                break;
        }    
    }
    
    private void appendArithLogic(String type,String immediate){
        String binaryImm="";
        
        switch(type) {
            case "H":
                immediate=immediate.replace("0x", "");
                binaryImm =Integer.toBinaryString(Integer.parseInt(immediate,16) );
                binaryImm=pad(binaryImm,17);
                tempLine=tempLineReg+binaryImm+ "1" + tempLine;
                break;
            case "D":
               binaryImm =Integer.toBinaryString(Integer.parseInt(immediate) );
               binaryImm=pad(binaryImm,17);
               tempLine=tempLineReg+binaryImm+ "1" + tempLine;

               break;
        }
    }
    
    private void appendMem(String type,String immediate){
        String binaryImm;
        switch(type) {
            case "H":
                immediate=immediate.replace("0x", "");
                binaryImm =Integer.toBinaryString(Integer.parseInt(immediate,16) );
                binaryImm=pad(binaryImm,17);
                tempLine=binaryImm+ "1" + tempLine;
                break;
            case "D":
               binaryImm =Integer.toBinaryString(Integer.parseInt(immediate) );
               binaryImm=pad(binaryImm,17);
               tempLine=binaryImm+ "1" + tempLine;
               break;
        }
    }
    
    private void appendShiftDisp(String type,String immediate){
        String binaryImm;
        shiftOp=false;
        switch(type) {
            case "H":
                immediate=immediate.replace("0x", "");
                binaryImm =Integer.toBinaryString(Integer.parseInt(immediate,16) );
                binaryImm=pad(binaryImm,18);
                tempLine=tempLineReg+binaryImm + tempLine;
                break;
            case "D":
               binaryImm =Integer.toBinaryString(Integer.parseInt(immediate) );
               binaryImm=pad(binaryImm,18);
               tempLine=tempLineReg+binaryImm + tempLine;
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
        if(counterReg==3){
            System.out.println("verif tmpLineReg" +tempLineReg);
            if(memOp){ tempLineReg= rotateRegisters(tempLineReg) ;   }
            System.out.println("verif tmpLineReg" +tempLineReg);
            tempLine=tempLineReg+"0000000000000"+ "0" + tempLine;
            counterReg=0;
            memOp=false;
        }
    }
    
    private String rotateRegisters(String tmpLineReg){
       String Reg1=tmpLineReg.substring(0, 4);
       String Reg2=tmpLineReg.substring(4, 8);
       String Reg3=tmpLineReg.substring(8, 12);
       System.out.println("Reg1"+Reg1);
       System.out.println("Reg2"+Reg2);
       System.out.println("Reg3"+Reg3);

       String rotatedReg=Reg1+Reg3+Reg2;
       return rotatedReg;
        
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
                shiftOp=true;
                break;
            case "shr":
                tempLine = "001" + "010";
                shiftOp=true;

                break;
            case "sb":
                tempLine = "000" + "011";
                memOp=true;
                break;
            case "lb":
                tempLine = "001" + "011";
                memOp=true;
                break;
            case "sw":
                tempLine = "010" + "011";
                memOp=true;
                break;
            case "lw":
                memOp=true;
                tempLine = "011" + "011";
                break;
            case "smw":
                memOp=true;
                tempLine = "100" + "011";
                break;
            case "lmw":
                memOp=true;
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

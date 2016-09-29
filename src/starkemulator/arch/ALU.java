/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.arch;

import starkemulator.ui.MainFrame;

/**
 *
 * @author jaam
 */
public class ALU {
    
    public int doOp(int pOperationCode, int pDestiny, int pOperand1, int pOperand2) {
        //int retVal = 0;
        switch(pOperationCode) {
            case 0: // suma
                pDestiny = pOperand1 + pOperand2;
                break;
            case 1: // resta
                
                pDestiny = pOperand1 - pOperand2;
                break;
            case 2: // mul
                pDestiny = pOperand1 * pOperand2;
                break;    
            case 3: // and
                pDestiny = pOperand1 & pOperand2;
                break;
            case 4: // or
                pDestiny = pOperand1 | pOperand2;
                break;
            case 5: // xor
                pDestiny = pOperand1 ^ pOperand2;
                break;
            case 6: // nand
                pDestiny = ~(pOperand1 & pOperand2);
                break;
        }
        return pDestiny;
    }
    
    public void aluArithmeticLogicAdmin(int opCode,String regDest,String pOperand1,String pOperand2){
        if(!pOperand2.contains("r")|| pOperand2.contains("0x")  ){ 
            makeImmOp(opCode,regDest,pOperand1,pOperand2);  
        }
        else{
            makeRegistersOp(opCode,regDest,pOperand1,pOperand2);
        }
         
    }
    
    private void makeImmOp(int opCode,String regDest,String pOperand1,String pOperand2){
        if(pOperand2.contains("0x")){
            pOperand2=pOperand2.replace("0x", "");
            pOperand2=Integer.toString(Integer.parseInt(pOperand2, 16 ));
            int regtoModVal=getReg(regDest);
            int op1=getReg(pOperand1);
            int result=doOp(opCode,regtoModVal,op1,Integer.parseInt(pOperand2));
            setReg(regDest, result);
            updateGUI(regDest,result);
        }
        else{
            int regtoModVal=getReg(regDest);
            int op1=getReg(pOperand1);
            int result=doOp(opCode,regtoModVal,op1,Integer.parseInt(pOperand2));
            setReg(regDest, result);
            updateGUI(regDest,result); 

        }
    }
    
    private void makeRegistersOp(int opCode,String regDest,String pOperand1,String pOperand2){
        int regtoModVal=getReg(regDest);
        int op1=getReg(pOperand1);
        int op2=getReg(pOperand2);
        int result=doOp(opCode,regtoModVal,op1,op2);
        System.out.println("result"+result);
        setReg(regDest, result);
        updateGUI(regDest,result); 
    }
    
    
    private void updateGUI(String regDest,int regtoModVal){
        MainFrame.modified=true;
        MainFrame.regMod=regDest;
        MainFrame.newVal=Integer.toString(regtoModVal);
    }
    
    
    
    private int getReg(String pReg){
        switch(pReg) {
            case "r0" :
                return Register.R0;
            case "r1":
                return Register.R1;
            case "r2":
                return Register.R2;
            case "r3":
                return Register.R3;  
            case "r4":
                return Register.R4;
            case "r5":
                return Register.R5;
            case "r6":
               return Register.R6;
            case "r7":
                return Register.R7;
            case "r8":
                return Register.R8;
            case "r9":
                return Register.R9;
            case "r10":
                return Register.R10;
            case "r11":
                return Register.R11;
            case "r12":
                return Register.R12;
            case "r13":
                return Register.R13;
            case "r14":
                return Register.R14;
            case "r15":
               return Register.R15;
        }
        return 0;
        
       
    }
    
     private void setReg(String pReg,int value){
        System.out.println("setting  reg"+pReg);
        switch(pReg) {
            case "r0" :
                Register.R0=value;
                break;
            case "r1":
                Register.R1=value;
                break;
            case "r2":
                Register.R2=value;
                 break;
            case "r3":
                Register.R3=value;
                 break;
            case "r4":
                Register.R4=value;
                 break;
            case "r5":
                Register.R5=value;
                 break;
            case "r6":
                Register.R6=value;
                 break;
            case "r7":
                Register.R7=value;
                 break;
            case "r8":
                Register.R8=value;
                 break;
            case "r9":
                Register.R9=value;
                 break;
            case "r10":
                Register.R10=value;
                 break;
            case "r11":
                Register.R11=value;
                 break;
            case "r12":
                Register.R12=value;
                 break;
            case "r13":
                Register.R13=value;
                 break;
            case "r14":
                Register.R14=value;
                 break;
            case "r15":
                Register.R15=value;
                 break;
        }
        
       
    }
    
    
    
    
}

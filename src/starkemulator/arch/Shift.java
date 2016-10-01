/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.arch;

import starkemulator.ui.MainFrame;

/**
 *
 * @author edwin
 */

/*
    *
    * Class that makes all the logic of the Shift operations(Shift Right,Left)
    *
    */
    
public class Shift {
    public Shift(){
        
    }
    
    /*
    *
    * Calls the method of the shift operation depending if it is Shift Left
    *  Shift Right, based on the Shift type
    *
    */
    
    public void makeShiftOp(int shiftType,String pRegDest ,String pOperand1,String shiftDisp ){
        if(shiftType==0){
            shiftRightOp(pRegDest,pOperand1,shiftDisp);
        }
        else {
            shiftLeftOp(pRegDest,pOperand1,shiftDisp);
        }
    }
   
    /*
    *
    * Makes all the logic of the Shift Right operation
    *  Calls the register that is going to be updated
    *   Calls the method that refreshes the register in the GUI
    */
    
    private void shiftRightOp(String pRegDest,String pRegister,String pDisp){
        int operandReg=getReg(pRegister);
        if(pDisp.contains("0x") ){   pDisp= hexImm(pDisp);     }
        int resultVal=(operandReg >> Integer.parseInt(pDisp)); 
        setReg(pRegDest, resultVal);
        updateGUI(pRegDest, resultVal);
    }
    /*
    *
    * Notifies the GUI, that the register has 
    * changed
    *
    */
    
    private void updateGUI(String regDest,int regtoModVal){
        MainFrame.modified=true;
        MainFrame.regMod=regDest;
        MainFrame.newVal=Integer.toString(regtoModVal);
    }
    /*
    *
    * Makes all the logic of the Shift Left operation
    *  Calls the register that is going to be updated
    *   Calls the method that refreshes the register in the GUI
    */
    
    private void shiftLeftOp(String pRegDest,String pRegister,String pDisp){
         int operandReg=getReg(pRegister);
        if(pDisp.contains("0x") ){   pDisp= hexImm(pDisp);     }
        int resultVal=(operandReg << Integer.parseInt(pDisp)); 
        setReg(pRegDest, resultVal);
        updateGUI(pRegDest, resultVal);
    }
    
     /*
    *
    * Method that converts the hexadecimal immediate to a decimal value
    */
    private String hexImm(String pImmHex){
        String result=pImmHex.replace("0x", "");
        return result=Integer.toString(Integer.parseInt(result, 16 ));
    }
    
     /*
    *
    * Returns the value of the specified register
    */
    
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
      /*
    *
    * Sets the specified value of a register
    */
    
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









/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.machineCodeAdmin;

import starkemulator.arch.ALU;

/**
 *
 * @author edwin
 */
public class SimulateMachineCode {
    ALU arithLog;
    public SimulateMachineCode(){
       arithLog=new ALU();
        
    }
    
    public void proccessMachineCode(String pmachineCode){
        if(pmachineCode.length()!=32){
            
        }
        else{
               String opCode=getOpCode(pmachineCode);
               processInstByType(opCode, pmachineCode  );
        }
    }
    
    private void processInstByType(String pType,String pInstruction){
        switch(pType) {
            case "A":
               proccessArithInstr(pInstruction);
                break;
            case "L":
               // proccessLogicInstr(pInstruction);

                break;
            case "S":
                //proccessShiftInstr(pInstruction);

                break;
            case "M":
               // proccessMemInstr(pInstruction);

                break;
            case "J":
                //proccessJumpInstr(pInstruction);
                break;
           
        }
        
    }
    
    private void proccessArithInstr(String pInstruction){
        String opType=pInstruction.substring(26, 29);
        int OpTypeI=getOpTypeA(opType);
        String immFlag= pInstruction.substring(25, 26);
        String cmp=pInstruction.substring(8, 25);
        String rb =getRb(cmp,immFlag);
        String ra =getRegister(pInstruction.substring(4, 8));
        String rc =getRegister(pInstruction.substring(0, 4));
        arithLog.aluArithmeticLogicAdmin(OpTypeI,rc ,ra, rb);
        

       
    }
    
    private String getRb(String pCmp,String pImmFlag){
        if(pImmFlag.equals("1")){
            return Integer.toString(Integer.parseInt(pCmp, 2));
        }
        else{
            return getRegister(pCmp.substring(0,4));
        }
        
    }
    
    private String getRegister(String pReg){
        String result=""; 
        switch(pReg) {
            case "0000":
                result = "r0"  ;
                break;
            case "0001":
                result = "r1" ;
                break;
            case "0010":
                result = "r2" ;
                break;
            case "0011":
                result = "r3" ;
                break;
            case "0100":
                 result = "r4" ;
                break;
            case "0101":
                 result = "r5" ;
                break;
            case "0110":
               result = "r6" ;
                break;
            case "0111":
                 result = "r7" ;
                break;
            case "1000":
                result = "r8" ;
                break;
            case "1001":
               result = "r9" ;
                break;
            case "1010":
                 result = "r10" ;
                break;
            case "1011":
               result = "r11" ;
                break;
            case "1100":
                 result = "r12" ;
                break;
            case "1101":
                result = "r13" ;
                break;
            case "1110":
                result = "r14" ;
                break;
            case "1111":
               result = "r15" ;
                break;
        }
        return result;
    }
    
    
    
    
    
    
    private int getOpTypeA(String pOpType){
        int result=9;
        switch(pOpType) {
            case "000":
               result=0;
                break;
            case "001":
                result=1;
                break;
            case "010":
                result=2;
                break;
        }
        
        return result;
        
    }
    
    
    private String getOpCode(String pmachineCode){
        String opCode=pmachineCode.substring(29, 32);
        String result="";
        switch(opCode) {
            case "000":
               result="A";
                break;
            case "001":
                result="L";
                break;
            case "010":
                result="S";
                break;
            case "011":
                result="M";
                break;
            case "100":
                result="J";
                break;
           
        }
        
        return result;
        
    }
    
    
    
    
}

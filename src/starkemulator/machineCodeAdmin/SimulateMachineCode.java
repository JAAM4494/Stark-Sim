/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.machineCodeAdmin;

import starkemulator.arch.ALU;
import starkemulator.arch.Shift;

/**
 *
 * @author edwin
 */

/*
 *
 * Simulates the machine Code specified by the user
 *
*/
public class SimulateMachineCode {
    ALU arithLog;
    Shift ShiftOp;
    public SimulateMachineCode(){
       arithLog=new ALU();
       ShiftOp= new Shift();
        
    }
    /*
    *
    * Verifies if the instruction specified is of lenght 32
    * If it is not, the instructions is not analized
    *
   */
    public void proccessMachineCode(String pmachineCode){
        if(pmachineCode.length()!=32){
            
        }
        else{
               String opCode=getOpCode(pmachineCode);
               processInstByType(opCode, pmachineCode  );
        }
    }
    
    /*
    *
    * Process the instruction based on the opCode
    * And calls a process function 
    * depending if it is an arithmetic,logic,etc instruction
    *
    *
   */
    private void processInstByType(String pType,String pInstruction){
        switch(pType) {
            case "A":
               proccessArithInstr(pInstruction);
                break;
            case "L":
                proccessLogicInstr(pInstruction);

                break;
            case "S":
                proccessShiftInstr(pInstruction);

                break;
            case "M":
               // proccessMemInstr(pInstruction);

                break;
            case "J":
                //proccessJumpInstr(pInstruction);
                break;
           
        }
        
    }
    
    /*
    *
    * Process the machine code of an arithmetic instruction
    * Calls the ALU function to perform the specified operation
    *
    *
   */
    
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
    
     /*
    *
    * Process the machine code of an logic instruction
    * Calls the ALU function to perform the specified operation
    *
    *
   */
    
    private void proccessLogicInstr(String pInstruction){
        String opType=pInstruction.substring(26, 29);
        int OpTypeI=getOpTypeL(opType);
        String immFlag= pInstruction.substring(25, 26);
        String cmp=pInstruction.substring(8, 25);
        String rb =getRb(cmp,immFlag);
        String ra =getRegister(pInstruction.substring(4, 8));
        String rc =getRegister(pInstruction.substring(0, 4));
        arithLog.aluArithmeticLogicAdmin(OpTypeI,rc ,ra, rb);
    }
     /*
    *
    * Process the machine code of an shift instruction
    * Calls the Shift function to perform the specified operation
    *
    *
   */
    
    private void proccessShiftInstr(String pInstruction){
        System.out.println("Entra");
        String opType=pInstruction.substring(26, 29);
        int OpTypeI=getOpTypeS(opType);
        String cmp=pInstruction.substring(8, 26);
        String shiftDisp =getRb(cmp,"1");
        System.out.println("Shift Disp"+shiftDisp);
        String ra =getRegister(pInstruction.substring(4, 8));
        String rc =getRegister(pInstruction.substring(0, 4));
        ShiftOp.makeShiftOp(OpTypeI,rc ,ra, shiftDisp);
    }
    
    /*
    *
    * Returns the value of the Second operand
    * If the flag of the immediate is 1, 
    * Returns the value of the immediate
    * If it is not, returns the value of the register
    *
   */
    
    private String getRb(String pCmp,String pImmFlag){
        if(pImmFlag.equals("1")){
            return Integer.toString(Integer.parseInt(pCmp, 2));
        }
        else{
            return getRegister(pCmp.substring(0,4));
        }
        
    }
    /*
    *
    * Returns the register depending of the binary representation
    *
   */
    
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
    
    
    
   /*
    *
    * Returns the operation number of the ALU depending 
    * of the OpType for arithmetic operations
    *
   */
    
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
    
     /*
    *
    * Returns the operation number of the ALU depending 
    * of the OpType for logic operations
    *
   */
    private int getOpTypeL(String pOpType){
        int result=9;
        switch(pOpType) {
            case "000":
               result=3;
                break;
            case "001":
                result=6;
                break;
            case "010":
                result=4;
                break;
            case "011":
                result=5;
                break;
        }
        
        return result;
        
    }
    /*
    *
    * Returns the operation number of the Shift operations depending 
    * of the OpType for Shift instructions
    *
   */
    
    private int getOpTypeS(String pOpType){
        int result=9;
        switch(pOpType) {
            case "000":
               result=1;
                break;
            case "001":
                result=0;
                break;
        }
        
        return result;
        
    }
    /*
    *
    * Based on the op Code of the instruction, returns what type 
    * Of instruction is, if it is Arithmetic(A),Logic(L), etc
    *
   */
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.arch;

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
            case 2: // and
                pDestiny = pOperand1 & pOperand2;
                break;
            case 3: // or
                pDestiny = pOperand1 | pOperand2;
                break;
            case 4: // xor
                pDestiny = pOperand1 ^ pOperand2;
                break;
            case 5: // nand
                pDestiny = Math.abs(~(pOperand1 & pOperand2));
                break;
        }
        return pDestiny;
    }
    
}

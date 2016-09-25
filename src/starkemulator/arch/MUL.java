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
public class MUL {

    public void doMul(int pOperationCode, int pDestiny, int pOperand1, int pOperand2) {
        // doing mul
        pDestiny = pOperand1 * pOperand2;
    }

}

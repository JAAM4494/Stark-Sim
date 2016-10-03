/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.arch;

import static java.lang.Thread.sleep;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import jdk.nashorn.internal.codegen.CompilerConstants;
import starkemulator.ui.MainFrame;

/**
 *
 * @author jaam
 */
public class Memory {

    private static byte[] storage = new byte[2048];
    
    public static byte[] getMemory() {
        return Memory.storage;
    }

    public void memoryAdmin(int opCode, String regDest, String pOperand1, String pOperand2) throws InterruptedException {
        if (!pOperand2.contains("r") || pOperand2.contains("0x")) {
            makeImmOp(opCode, regDest, pOperand1, pOperand2);
        } else {
            makeRegistersOp(opCode, regDest, pOperand1, pOperand2);
        }
    }

    private void makeImmOp(int opCode, String regDest, String pOperand1, String pOperand2) throws InterruptedException {
        if (pOperand2.contains("0x")) {
            pOperand2 = pOperand2.replace("0x", "");
            pOperand2 = Integer.toString(Integer.parseInt(pOperand2, 16));
            int regtoModVal = getReg(regDest);
            int op1 = getReg(pOperand1);
            int result = doOp(opCode, regtoModVal, op1, Integer.parseInt(pOperand2));
            if (opCode == 1 || opCode == 3 || opCode == 5) {
                setReg(regDest, result);
                updateGUI(regDest, result);
            } 
        } else {
            int regtoModVal = getReg(regDest);
            int op1 = getReg(pOperand1);
            int result = doOp(opCode, regtoModVal, op1, Integer.parseInt(pOperand2));
            if (opCode == 1 || opCode == 3 || opCode == 5) {
                setReg(regDest, result);
                updateGUI(regDest, result);
            } 

        }
    }

    private void makeRegistersOp(int opCode, String regDest, String pOperand1, String pOperand2) throws InterruptedException {
        int regtoModVal = getReg(regDest);
        int op1 = getReg(pOperand1);
        int op2 = getReg(pOperand2);
        int result = doOp(opCode, regtoModVal, op1, op2);
        System.out.println("result" + result);
        if (opCode == 1 || opCode == 3 || opCode == 5) {
            setReg(regDest, result);
            updateGUI(regDest, result);
        } 
    }

    /*
    * Makes the Alu operations (ADD,SUB,ETC) based on a operation Code
    * Two registers are the operands and returns the result value.
     */
    public int doOp(int pOperationCode, int pDestiny, int pOperand1, int pOperand2) {
        int address = pOperand1 + pOperand2;
        int retVal = 0;
        switch (pOperationCode) {
            case 0: // store word
                this.storeWord(pDestiny, address);
                break;
            case 1: // load word
                retVal = this.loadWord(address);
                break;
            case 2: // store halfword
                ByteBuffer byb = ByteBuffer.allocate(4);
                byb.putInt(pDestiny);

                this.storeHalfWord(byb.getShort(0), address);
                break;
            case 3: // load halfword
                ByteBuffer bb = ByteBuffer.allocate(4);

                short tmp = 0;
                bb.putShort(tmp);
                bb.putShort(this.loadHalfWord(address));

                retVal = bb.getInt(0);
                break;
            case 4: // store byte
                ByteBuffer byb2 = ByteBuffer.allocate(4);
                byb2.putInt(pDestiny);

                this.storeByte(byb2.get(0), address);
                break;
            case 5: // load byte
                ByteBuffer bb2 = ByteBuffer.allocate(4);

                short tmp2 = 0;
                byte tmp3 = 0;
                bb2.putShort(tmp2);
                bb2.put(tmp3);
                bb2.put(this.loadByte(address));

                retVal = bb2.getInt(0);
                break;
        }
        return retVal;
    }

    private void storeWord(int pStoreVar, int pPos) {
        byte[] word = ByteBuffer.allocate(4).putInt(pStoreVar).array();

        int tempPointer = pPos;
        for (byte b : word) {
            this.storage[tempPointer] = b;
            tempPointer += 1;
        }
    }

    private int loadWord(int pPos) {
        int retVal = 0;

        ByteBuffer bb = ByteBuffer.allocate(4);
        //bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.put(this.storage[pPos]);
        bb.put(this.storage[pPos + 1]);
        bb.put(this.storage[pPos + 2]);
        bb.put(this.storage[pPos + 3]);

        retVal = bb.getInt(0);

        return retVal;
    }

    private void storeHalfWord(short pStoreVar, int pPos) {
        byte[] halfword = ByteBuffer.allocate(2).putShort(pStoreVar).array();

        int tempPointer = pPos;
        for (byte b : halfword) {
            this.storage[tempPointer] = b;
            tempPointer += 1;
        }
    }

    private short loadHalfWord(int pPos) {
        short retVal = 0;

        ByteBuffer bb = ByteBuffer.allocate(2);
        //bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.put(this.storage[pPos]);
        bb.put(this.storage[pPos + 1]);

        retVal = bb.getShort(0);

        return retVal;
    }

    private void storeByte(byte pStoreVar, int pPos) {

        this.storage[pPos] = pStoreVar;

    }

    private byte loadByte(int pPos) {
        byte retVal = 0;

        retVal = this.storage[pPos];

        return retVal;
    }

    public void printMem() {
        for (byte b : storage) {
            System.out.format("0x%x ", b);
        }
    }

    /*
    *
    * Notifies the GUI, that the register has 
    * changed
    *
     */
    private void updateGUI(String regDest, int regtoModVal) throws InterruptedException {
        MainFrame.modified = true;
        MainFrame.regMod = regDest;
        MainFrame.newVal = Integer.toString(regtoModVal);
        System.out.println("Updating");
        sleep(1000);
    }

    /*
    *
    * Returns the value of the specified register
     */
    private int getReg(String pReg) {
        switch (pReg) {
            case "r0":
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
    private void setReg(String pReg, int value) {
        System.out.println("setting  reg" + pReg);
        switch (pReg) {
            case "r0":
                Register.R0 = value;
                break;
            case "r1":
                Register.R1 = value;
                break;
            case "r2":
                Register.R2 = value;
                break;
            case "r3":
                Register.R3 = value;
                break;
            case "r4":
                Register.R4 = value;
                break;
            case "r5":
                Register.R5 = value;
                break;
            case "r6":
                Register.R6 = value;
                break;
            case "r7":
                Register.R7 = value;
                break;
            case "r8":
                Register.R8 = value;
                break;
            case "r9":
                Register.R9 = value;
                break;
            case "r10":
                Register.R10 = value;
                break;
            case "r11":
                Register.R11 = value;
                break;
            case "r12":
                Register.R12 = value;
                break;
            case "r13":
                Register.R13 = value;
                break;
            case "r14":
                Register.R14 = value;
                break;
            case "r15":
                Register.R15 = value;
                break;
        }

    }

}

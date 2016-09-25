/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.arch;

import java.nio.ByteBuffer;

/**
 *
 * @author jaam
 */
public class Memory {

    private byte[] storage = new byte[1024];

    public void storeWord(int pStoreVar, int pBase) {
        byte[] word = ByteBuffer.allocate(4).putInt(pStoreVar).array();

        int tempPointer = pBase;
        for (byte b : word) {
            this.storage[tempPointer] = b;
            tempPointer += 1;
        }
    }

    public void storeHalfWord(short pStoreVar, int pBase) {
        byte[] halfword = ByteBuffer.allocate(2).putShort(pStoreVar).array();

        int tempPointer = pBase;
        for (byte b : halfword) {
            this.storage[tempPointer] = b;
            tempPointer += 1;
        }
    }

    public void storeByte(byte pStoreVar, int pBase) {

        this.storage[pBase] = pStoreVar;

    }

    public void printMem() {
        for (byte b : storage) {
            System.out.format("0x%x ", b);
        }
    }

}

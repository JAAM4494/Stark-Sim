/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.arch;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author jaam
 */
public class Memory {

    private byte[] storage = new byte[2048];

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

}

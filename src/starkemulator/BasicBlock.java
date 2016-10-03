/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator;

import java.util.ArrayList;

/**
 *
 * @author jaam
 */
public class BasicBlock {
    
    private String blockTag;
    private boolean checked;
    private ArrayList<String> instructions;
    
    public BasicBlock() {
        blockTag = "";
        instructions = new ArrayList<>();
        checked = false;
    }
    
    public void addInstr(String pInstr) {
        instructions.add(pInstr);
    }

    public String getBlockTag() {
        return blockTag;
    }

    public void setBlockTag(String blockTag) {
        this.blockTag = blockTag;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
}

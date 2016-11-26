/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.dependencymanager;

/**
 *
 * @author 
 */
public class InstrDependency {
    private int numInstruction;
    private String mnemonic;
    private String regDes;
    private String regOp1;
    private String regOp2;
    private int dependency;
    private int wbClk;
    
    public int getNumInstr(){
        return numInstruction;
    }
    
    public String getMnemonic(){
        return mnemonic;
    }
    public String getRegDes(){
        return regDes;
    }
    
    public String getRegOp1(){
        return regOp1;
    }
    public String getRegOp2(){
        return regOp2;
    }
    
    public int getDependency(){
        return dependency;
    }
    
     public int getWBClk(){
        return wbClk;
    }
    
    
    public void setNumInstr(int pNum){
        numInstruction=pNum;
    }
    
    public void setMnemonic(String pMnemonic){
        mnemonic=pMnemonic;
    }
    public void setRegDes(String pRegDes){
        regDes=pRegDes;
    }
    
    public void setRegOp1(String pRegOp1){
        regOp1=pRegOp1;
    }
    public void setRegOp2(String pRegOp2){
        regOp2=pRegOp2;
    }
    public void setDependency(int pDependency){
        dependency=pDependency;
    }
    public void setWBCLK(int pClk){
        wbClk=pClk;
    }
    
    
    
    
}

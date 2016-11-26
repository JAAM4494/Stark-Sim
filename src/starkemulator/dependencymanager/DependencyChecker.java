/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.dependencymanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import starkemulator.MyLexer;
import starkemulator.scheduler.RunnableInstruction;

/**
 *
 * @author 
 */
public class DependencyChecker {
    String program;
    MyLexer tokenExtr;
    ArrayList<InstrDependency> instructionsL;
    InstrDependency intrData;
    int intrCount;
    int regCount;
    
    public DependencyChecker(String pProgram){
        program=pProgram;
        intrCount=0;
        instructionsL = new ArrayList<>();
        intrData= new InstrDependency();
        getTokens();
        regCount=0;
    }  
    
    private void getTokens(){
        BufferedWriter out = null;
        File tempFile = null;

        try {
            tempFile = File.createTempFile("TmpScrptProgram" , ".txt");
            //create a temp file
            tempFile.deleteOnExit();

            out = new BufferedWriter(new FileWriter(tempFile.getAbsolutePath()));
            out.write(program);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(RunnableInstruction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

       
        try {
            tokenExtr = new MyLexer(new FileReader(tempFile));
            
            extractTokens();
            
            

        }  catch (IOException ex) {
            Logger.getLogger(RunnableInstruction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void extractTokens() throws IOException{
        tokenExtr.next_token();
        while(!tokenExtr.yytext().equals("") ){
            try {
                //System.out.println("Value read: "+tokenExtr.yytext());
                processToken(tokenExtr.yytext());
                tokenExtr.next_token();
                
            } catch (IOException ex) {
                Logger.getLogger(DependencyChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        intrData.setDependency(0);
        addInstr();
       /* System.out.println("------------Valores Lista--------------");
        System.out.println("------------Primer valor--------------");
        System.out.println("Dato num Instr:"+instructionsL.get(0).getNumInstr());
        System.out.println("Dato Mnemonico:"+instructionsL.get(0).getMnemonic());
        System.out.println("Dato RegDes:"+instructionsL.get(0).getRegDes());
        System.out.println("Dato RegOp1:"+instructionsL.get(0).getRegOp1());
        System.out.println("Dato RegOp2:"+instructionsL.get(0).getRegOp2());
        System.out.println("------------Segundo valor--------------");
         System.out.println("Dato num Instr:"+instructionsL.get(1).getNumInstr());
        System.out.println("Dato Mnemonico:"+instructionsL.get(1).getMnemonic());
        System.out.println("Dato RegDes:"+instructionsL.get(1).getRegDes());
        System.out.println("Dato RegOp1:"+instructionsL.get(1).getRegOp1());
        System.out.println("Dato RegOp2:"+instructionsL.get(1).getRegOp2());*/
        verifyDependencies();
    }
    
    private void verifyDependencies(){
        for (int i = 1; i < instructionsL.size(); i++) {
            String regWritten=instructionsL.get(i-1).getRegDes();
            if( regWritten.equals(instructionsL.get(i).getRegOp1()) || 
                regWritten.equals(instructionsL.get(i).getRegOp2()) ){
                instructionsL.get(i).setDependency(1);
                
            }   
        }
    }
    
    public ArrayList<InstrDependency> getDependencyList(){
        return instructionsL;
    }
    
    private String verifyHexTok(String pToken){
        if(pToken.contains("0x")){
            return "#";
        }
        return pToken;
    }
    
    private void processToken(String pToken){
        pToken=verifyHexTok(pToken);
         switch(pToken) {
            case "plus":
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("plus");
                break;
            case "min": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("min");
                break;
            case "mul": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("mul");
                break;    
            case "and":
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("and");
                break;
            case "nand": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("nand");
                break;  
            case "or":
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("or");
                break;    
            case "xor": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("xor");
                break;
            case "shl": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("shl");
                break;
            case "shr": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("shr");
                break;
            case "sb":
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("sb");
                break; 
            case "lb": 
                addInstr();
                intrData.setNumInstr(intrCount);
                intrData.setMnemonic("lb");
                break; 
                
            case "r0":
                addReg("r0");
                break;  
            case "r1":
                addReg("r1");
                break;    
            case "r2": 
                addReg("r2");
                break;
            case "r3":
                addReg("r3");
                break;
            case "r4":
                addReg("r4");
                break;
            case "r5":
                addReg("r5");
                break; 
            case "r6": 
                addReg("r6");
                break; 
            case "r7": 
                addReg("r7");
                break; 
            case "r8":
                addReg("r8");
                break; 
            case "r9":
                addReg("r9");
                break;  
            case "r10": 
                addReg("r10");
                break; 
            case "r11":
                addReg("r11");
                break; 
            case "r12":
                addReg("r12");
                break; 
            case "r13": 
                addReg("r13");
                break;  
            case "r14":
                addReg("r14");
                break; 
            case "r15": 
                addReg("r15");
                break; 
            case "#": 
                addReg("");
            break; 
            
        }   
    }
    
    private void addInstr(){
      if(intrCount!=0){
          intrData.setDependency(0);
          instructionsL.add(intrData);
          intrCount++;
          intrData= new InstrDependency();
      }
      else{
          intrCount++;
      }
        
    }

private void addReg(String pReg){
       switch(regCount) {
             case 0:
                intrData.setRegDes(pReg);
                regCount++;
                break;
            case 1:
                intrData.setRegOp1(pReg);
                regCount++;
                break;
            case 2:
                intrData.setRegOp2(pReg);
                regCount=0;
                break;
       }
                
        
    }        
    
    
    
    
}

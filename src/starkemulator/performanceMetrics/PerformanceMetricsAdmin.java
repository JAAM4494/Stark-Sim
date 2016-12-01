/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.performanceMetrics;

import java.util.ArrayList;
import starkemulator.dependencymanager.InstrDependency;
import starkemulator.ui.MainFrame;

/**
 *
 * @author edwin
 */

public class PerformanceMetricsAdmin {
    int freqclk=1000000;
    ArrayList<InstrDependency> dependencyL; 
    float IPC;
    float IPS;
    
    
    
    public PerformanceMetricsAdmin(ArrayList<InstrDependency> pDependencyL){
        IPC=0;
        IPS=0;
        dependencyL=pDependencyL;
        makeCalc(); 
    }
    
    private void makeCalc(){
        processInstr();
        MainFrame.modifiedPerformance=true;
        MainFrame.performanceData="IPC:"+IPC +"  "+"IPS:"+IPS;
    }
    
    private void processInstr(){
        for (int i = 0; i < dependencyL.size(); i++) {
            processType(dependencyL.get(i).getMnemonic(),i );
        }
        IPC=dependencyL.size()/IPC;
        System.out.println("VALOR SIZE"+dependencyL.size());
        System.out.println("VALOR IPC"+IPC);
        IPS=1000000/( (1/IPC)  ); 
        
        
    
    }
    
    private void processType(String pToken,int pPos){
         switch(pToken) {
            case "plus":
                arithLogInstr(pPos);
                break;
            case "min": 
                arithLogInstr(pPos);
                break;
            case "mul": 
               mulInstr(pPos);
                break;    
            case "and":
                arithLogInstr(pPos);
              
                break;
            case "nand": 
                arithLogInstr(pPos);
                
                break;  
            case "or":
                arithLogInstr(pPos);
               
                break;    
            case "xor":
                arithLogInstr(pPos);
                break;
            case "shl": 
                arithLogInstr(pPos); 
                break;
            case "shr": 
                arithLogInstr(pPos);
                break;
            case "sb":
                memInstr(pPos);
                break; 
            case "lb": 
                memInstr(pPos);
                break; 
            case "sw": 
                memInstr(pPos);
                break;        
            case "lw": 
                memInstr(pPos);
                break;      
            case "smw": 
               memInstr(pPos);
                break; 
            case "lmw": 
                memInstr(pPos);
                break; 
          
            
        }   
    }
    
    private void arithLogInstr(int pPos){
        if(dependencyL.get(pPos).getDependency()==1){
            IPC+=0.75;
        }
        else{
            IPC+=0.65;
        }  
    }
    
    private void memInstr(int pPos){
        if(dependencyL.get(pPos).getDependency()==1){
            IPC+=0.85;
        }
        else{
            IPC+=0.75;
        }  
    }
    
    private void mulInstr(int pPos){
        if(dependencyL.get(pPos).getDependency()==1){
            IPC+=0.95;
        }
        else{
            IPC+=0.85;
        }  
    }
        
    
    
    
    
    
    
    
    
    
    
}
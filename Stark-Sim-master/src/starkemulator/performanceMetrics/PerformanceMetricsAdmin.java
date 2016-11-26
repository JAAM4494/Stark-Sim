/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.performanceMetrics;

import starkemulator.ui.MainFrame;

/**
 *
 * @author edwin
 */

public class PerformanceMetricsAdmin {
    int freqclk=1000000;
    String regWritten;
    int cantArith;
    int cantLog;
    int cantShift;
    int cantMem;
    int cantJmp;
    int durArith;
    int durLog;
    int durShift;
    int durMem;
    int durJmp;
    static int resultIPC;
    
    public PerformanceMetricsAdmin(){
        cantArith=0;
        cantLog=0;
        cantShift=0;
        cantMem=0;
        cantJmp=0;
        durArith=1;
        durLog=1;
        durShift=1;
        durMem=1;
        durJmp=1;
        regWritten="";
        resultIPC=0;
        
        
    }
    public void makeCalc(){
        float result1=(cantArith*durArith)+(cantLog*durLog)+(cantShift*durShift)+(cantMem*durMem)+(cantJmp*durJmp);
        System.out.println("Revisando Mul:"+cantArith*durArith);
        float cantInstr=cantArith+cantLog+cantShift+cantMem+cantJmp;
        float CPI=result1/cantInstr;
        float IPC=1/CPI;
        float IPS=1000000/CPI;
      /*  System.out.println("durArith:"+durArith);
        System.out.println("durLog:"+durLog);
        System.out.println("durMem:"+durMem);
        System.out.println("result1:"+result1);
        System.out.println("cantInstr"+cantInstr);
        System.out.println("CPI"+CPI);
        System.out.println("IPC"+IPC);
        System.out.println("IPS"+IPS); */
        MainFrame.modifiedPerformance=true;
        MainFrame.performanceData="IPC:"+IPC +"  "+"IPS:"+IPS;
    }
    
    public void verifyLostData(String instrType,String pRegWritten,String regOp1,String regOp2){
        if(regOp1.equals(regWritten) || regOp2.equals(regWritten)  ){
            addNopsDuration(instrType);
        }
        regWritten=pRegWritten;
        
    }
    
    
    
    
    private void addNopsDuration(String instrType){
          switch(instrType) {
            case "A":
                durArith=durArith+3;
                break;
            case "L":
                durLog=durLog+3;
                break;
            case "S":
                durShift=durShift+3;
                break;
            case "M":
                durMem=durMem+3;
                break;
            case "J":
                durJmp=durJmp+3;
                break;
        }
    }
    
    private void addDurationFInstr(String instrType){
          switch(instrType) {
            case "A":
                durArith=5;
                break;
            case "L":
                durLog=5;
                break;
            case "S":
                durShift=5;
                break;
            case "M":
                durMem=5;
                break;
            case "J":
                durJmp=5;
                break;
          }
    }
    
   
    
    
    public void newInstr(String instrType){
        switch(instrType) {
            case "A":
                cantArith++;
                break;
            case "L":
                cantLog++;
                break;
            case "S":
                cantShift++;
                break;
            case "M":
                cantMem++;
                break;
            case "J":
                cantJmp++;
                break;
        }
        if((cantArith+cantLog+cantShift+cantMem+cantJmp)==1){
            addDurationFInstr(instrType);
        }
        
    }
    
    
    
    
}
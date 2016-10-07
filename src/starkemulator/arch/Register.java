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
public class Register {
    
    public static int R0= 0;
    public static int R1= 0;
    public static int R2= 0;
    public static int R3= 0;
    public static int R4= 0;
    public static int R5= 0;
    public static int R6= 0;
    public static int R7= 0;
    public static int R8= 0;
    public static int R9= 0;
    public static int R10= 0;
    public static int R11= 0;
    public static int R12= 0;
    public static int R13= 0;
    public static int R14= 0;
    public static int R15= 0;
    
    public static void resetRegisters() {
        Register.R0 = 0;Register.R1 = 0;Register.R2 = 0;Register.R3 = 0;
        Register.R4 = 0;Register.R5 = 0;Register.R6 = 0;Register.R7 = 0;
        Register.R8 = 0;Register.R9 = 0;Register.R10 = 0;Register.R11 = 0;
        Register.R12 = 0;Register.R13 = 0;Register.R14 = 0;Register.R15 = 0;
    }
    
    
}

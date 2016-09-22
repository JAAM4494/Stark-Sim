/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator;

import java.io.File;
import starkemulator.ui.MainFrame;

/**
 *
 * @author jaam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
        
        // generateScanner();
        // generateParser();
    }
    
        // Metodo que genera el analizador lexico, usando jFlex
    private static void generateScanner() {
        String path = "src/starkemulator/scanner.flex";
        File file = new File(path); // path -> donde se encuentra el archivo scanner.lex
        jflex.Main.generate(file);
    }

    //Metodo que genera el analizador sintáctico y la tabla de simbolos usando jCup
    private static void generateParser() {
        String opciones[] = new String[5];
        // habilita la opcion de guardar en directorio
        opciones[0] = "-destdir";
        // path donde se va guardar
        opciones[1] = "src/starkemulator/";
        // habilita la opcion de nombre
        opciones[2] = "-parser";
        // nombre dela clase del parser
        opciones[3] = "Parser";
        // path donde se encuentra el archivo parser.cup
        opciones[4] = "src/starkemulator/parser.cup";
        try {
            java_cup.Main.main(opciones);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}

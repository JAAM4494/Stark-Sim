package starkemulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import starkemulator.ui.MainFrame;

/**
 * Compiler class
 * @author jaam
 */
public class MyCompiler {
    
    // Metodo principal del compilador, se encarga del procesamiento de la entrada
    public void procesarEntrada(String pPathEntrada) {

        try {
            //canGenerateCode = true;
            
            MyLexer AnalizadorLexico = new MyLexer(new FileReader(pPathEntrada));
            MyParser AnalizadorSintactico = new MyParser(AnalizadorLexico);
            
            AnalizadorSintactico.parse();
            
            //Symbol currToken;
            //   do {
            // currToken = AnalizadorLexico.next_token();
            //} while (currToken.sym != sym.EOF);
            
            System.out.println("Fin de escaneo..!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
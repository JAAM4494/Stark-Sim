package starkemulator;

import java_cup.runtime.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

%%
%class MyLexer

%{String literal;
  String temp_include;
%}

%{
int columna=1;
%}

%{
boolean newLineFlag = false;
%}

%public
%cup
%line
%full
%ignorecase
%char

%{
  public String sourceFilename;
    StringBuffer string = new StringBuffer();
    int ultimoEstado = 0;
 public void init(){};

Vector TokensOut = new Vector();

public void echo(int pToken)  {
      try {
          String TokenName = returnTokenName(pToken);

          if(!TokenName.equals("NewLine")) {
            TokensOut.addElement("Token: " + TokenName + " Lex: " + yytext());
            System.out.println("Token: " + TokenName + " Lex: " + yytext());
          }
      } catch (IllegalArgumentException | IllegalAccessException ex) {
          Logger.getLogger(MyLexer.class.getName()).log(Level.SEVERE, null, ex);
      }
}

private static void writeOut(Vector pVector) {
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter("src/starkemulator/OutputAnalisisLexico.txt");
            pw = new PrintWriter(fichero);
            pw.println("***********  LEXICAL ANALISIS  ***********");
            
            for (Object pVector1 : pVector) {
                pw.println(pVector1);
                //System.out.println("Line " + i);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // asegurarnos que se cierra el fichero.
            if (null != fichero) {
                try {
                    fichero.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}

private static String returnTokenName(int pIntToken) throws IllegalArgumentException, IllegalAccessException {
        String out = null;
        sym Bridge = null;
        Field fields[] = sym.class.getDeclaredFields();
        
        for (int i = 0; i < fields.length-1; i++) {
            Field temp0 = fields[i];
            temp0.setAccessible(true);
            Object valueObject = temp0.get(Bridge);
            //System.out.println(value);
            // System.out.println("Variable Name is : " + fld[i].getName());
            if(pIntToken == (int)valueObject) {
                //System.out.println(temp0.getName());
                out = temp0.getName();
            }
        }
        return out;
}

%}

%eofval{
{return new Symbol(sym.EOF,null);}
%eofval}

%eof{
writeOut(TokensOut);
%eof}

LETTER=[a-zA-Z]
DIGIT=[0-9]
ALPHA_NUMERIC={LETTER}|{DIGIT}

ID=("_"|{LETTER})({ALPHA_NUMERIC})*

Hexadecimal=("0x") ({ALPHA_NUMERIC})* 




NEW_LINE=(\n|\r|\r\n)
WHITE_SPACE=([\ |\t|\f])
 
PHRASE=("_"|{ALPHA_NUMERIC})("_"|{ALPHA_NUMERIC})*

%%
[\n] {yychar=0;}

[ \t\f] {/* ignore white space. */ }

\' { /* ignora apostrofes. */ }

<YYINITIAL> {WHITE_SPACE}      {/*no hace nada, aumenta una columna,continua lectura*/yychar++; }
<YYINITIAL> {NEW_LINE}*        {yychar=0; yyline=0; echo(sym.NewLine);
                                    if(newLineFlag == true) {
                                        //System.out.println("Salto linea");
                                        newLineFlag = false;
                                        return  new Symbol(sym.NewLine,  yyline, yychar, yytext());
                                    }}

<YYINITIAL>"plus"              {echo(sym.Plus); return new Symbol(sym.Plus,     yyline, yychar, yytext());}
<YYINITIAL>"min"               {echo(sym.Min); return new Symbol(sym.Min,       yyline, yychar, yytext());}
<YYINITIAL>"mul"               {echo(sym.Mul); return new Symbol(sym.Mul,       yyline, yychar, yytext());}
<YYINITIAL>"and"               {echo(sym.And); return new Symbol(sym.And,       yyline, yychar, yytext());}
<YYINITIAL>"nand"              {echo(sym.Nand); return new Symbol(sym.Nand,     yyline, yychar, yytext());}
<YYINITIAL>"or"                {echo(sym.Or); return new Symbol(sym.Or,         yyline, yychar, yytext());}
<YYINITIAL>"xor"               {echo(sym.Xor); return new Symbol(sym.Xor,       yyline, yychar, yytext());}
<YYINITIAL>"shl"               {echo(sym.Shl); return new Symbol(sym.Shl,       yyline, yychar, yytext());}
<YYINITIAL>"shr"               {echo(sym.Shr); return new Symbol(sym.Shr,       yyline, yychar, yytext());}
<YYINITIAL>"sb"                {echo(sym.Sb); return new Symbol(sym.Sb,         yyline, yychar, yytext());}
<YYINITIAL>"lb"                {echo(sym.Lb); return new Symbol(sym.Lb,         yyline, yychar, yytext());}
<YYINITIAL>"sw"                {echo(sym.Sw); return new Symbol(sym.Sw,         yyline, yychar, yytext());}
<YYINITIAL>"lw"                {echo(sym.Lw); return new Symbol(sym.Lw,         yyline, yychar, yytext());}
<YYINITIAL>"smw"               {echo(sym.Smw); return new Symbol(sym.Smw,       yyline, yychar, yytext());}
<YYINITIAL>"lmw"               {echo(sym.Lmw); return new Symbol(sym.Lmw,       yyline, yychar, yytext());}
<YYINITIAL>"je"                {echo(sym.Je); return new Symbol(sym.Je,         yyline, yychar, yytext());}
<YYINITIAL>"jne"               {echo(sym.Jne); return new Symbol(sym.Jne,       yyline, yychar, yytext());}
<YYINITIAL>"jlt"               {echo(sym.Jlt); return new Symbol(sym.Jlt,       yyline, yychar, yytext());}		
<YYINITIAL>"jgt"               {echo(sym.Jgt); return new Symbol(sym.Jgt,       yyline, yychar, yytext());}
<YYINITIAL>"j"                 {echo(sym.J); return new Symbol(sym.J,           yyline, yychar, yytext());}

<YYINITIAL>"r0"                {echo(sym.R0); return new Symbol(sym.R0,         yyline, yychar, yytext());}
<YYINITIAL>"r1"                {echo(sym.R1); return new Symbol(sym.R1,         yyline, yychar, yytext());}
<YYINITIAL>"r2"                {echo(sym.R2); return new Symbol(sym.R2,         yyline, yychar, yytext());}
<YYINITIAL>"r3"                {echo(sym.R3); return new Symbol(sym.R3,         yyline, yychar, yytext());}
<YYINITIAL>"r4"                {echo(sym.R4); return new Symbol(sym.R4,         yyline, yychar, yytext());}
<YYINITIAL>"r5"                {echo(sym.R5); return new Symbol(sym.R5,         yyline, yychar, yytext());}
<YYINITIAL>"r6"                {echo(sym.R6); return new Symbol(sym.R6,         yyline, yychar, yytext());}
<YYINITIAL>"r7"                {echo(sym.R7); return new Symbol(sym.R7,         yyline, yychar, yytext());}
<YYINITIAL>"r8"                {echo(sym.R8); return new Symbol(sym.R8,         yyline, yychar, yytext());}
<YYINITIAL>"r9"                {echo(sym.R9); return new Symbol(sym.R9,         yyline, yychar, yytext());}
<YYINITIAL>"r10"               {echo(sym.R10); return new Symbol(sym.R10,       yyline, yychar, yytext());}
<YYINITIAL>"r11"               {echo(sym.R11); return new Symbol(sym.R11,       yyline, yychar, yytext());}
<YYINITIAL>"r12"               {echo(sym.R12); return new Symbol(sym.R12,       yyline, yychar, yytext());}
<YYINITIAL>"r13"               {echo(sym.R13); return new Symbol(sym.R13,       yyline, yychar, yytext());}
<YYINITIAL>"r14"               {echo(sym.R14); return new Symbol(sym.R14,       yyline, yychar, yytext());}
<YYINITIAL>"r15"               {echo(sym.R15); return new Symbol(sym.R15,       yyline, yychar, yytext());}

<YYINITIAL>"("                 {echo(sym.OpPar); return new Symbol(sym.OpPar,   yyline, yychar, yytext());}
<YYINITIAL>")"                 {echo(sym.ClPar); return new Symbol(sym.ClPar,   yyline, yychar, yytext());}
<YYINITIAL>"{"                 {echo(sym.OpKey); return new Symbol(sym.OpKey,   yyline, yychar, yytext());}
<YYINITIAL>"}"                 {echo(sym.ClKey); return new Symbol(sym.ClKey,   yyline, yychar, yytext());}
<YYINITIAL>"#"                 {echo(sym.Tag ); return new Symbol(sym.Tag,   yyline, yychar, yytext());}

<YYINITIAL>","                 {echo(sym.Comma); return new Symbol(sym.Comma,   yyline, yychar, yytext());}
<YYINITIAL>";"                 {echo(sym.SemCo); return new Symbol(sym.SemCo,   yyline, yychar, yytext());}

<YYINITIAL>":"                 {echo(sym.Points); return new Symbol(sym.Points,   yyline, yychar, yytext());}




<YYINITIAL>{DIGIT}+            {echo(sym.Num); return new Symbol(sym.Num,       yyline, yychar, yytext());}

<YYINITIAL>{ID}                {echo(sym.ID); return new Symbol(sym.ID,         yyline, yychar, yytext());}

<YYINITIAL>{Hexadecimal}                {echo(sym.Hexadecimal); return new Symbol(sym.Hexadecimal,         yyline, yychar, yytext());}


. {TokensOut.addElement("WARNING, Unknow character, line: " + yyline + ", column: " + yychar);
System.out.println("WARNING, Unknow character, line: " + yyline + ", column: " + yychar);}
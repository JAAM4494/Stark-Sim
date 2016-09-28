/* The following code was generated by JFlex 1.6.1 */

package starkemulator;

import java_cup.runtime.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import starkemulator.help.MCodeGenerator;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/starkemulator/scanner.flex</tt>
 */
public class MyLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\11\1\6\1\57\1\11\1\7\22\0\1\11\2\0\1\53"+
    "\3\0\1\12\1\47\1\50\2\0\1\54\3\0\1\4\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\45\1\46\1\2\1\56\1\55\5\0"+
    "\1\24\1\31\1\1\1\25\1\34\1\1\1\36\1\30\1\22\1\33"+
    "\1\1\1\14\1\20\1\23\1\26\1\13\1\1\1\27\1\17\1\35"+
    "\1\15\1\1\1\32\1\5\2\1\4\0\1\3\1\0\1\24\1\31"+
    "\1\1\1\25\1\34\1\1\1\36\1\30\1\22\1\33\1\1\1\14"+
    "\1\20\1\23\1\26\1\13\1\1\1\27\1\17\1\35\1\15\1\1"+
    "\1\32\1\5\2\1\1\51\1\10\1\52\7\0\1\57\252\0\2\21"+
    "\115\0\1\16\u1ea8\0\1\57\1\57\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\2\4\1\3\1\5\1\1\1\6"+
    "\1\7\1\10\2\3\1\2\6\3\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\3\3"+
    "\1\23\1\24\2\0\1\25\1\26\2\3\1\25\1\26"+
    "\1\3\1\0\3\3\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\2\3\1\42"+
    "\1\3\1\43\1\3\1\44\1\45\1\46\1\47\1\45"+
    "\1\46\1\47\1\50\2\51\1\3\1\52\1\53\1\54"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\1\63\2\64"+
    "\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0120"+
    "\0\60\0\60\0\60\0\u0150\0\u0180\0\u01b0\0\u01e0\0\u0210"+
    "\0\u0240\0\u0270\0\u02a0\0\u02d0\0\u0300\0\60\0\60\0\60"+
    "\0\60\0\60\0\60\0\60\0\60\0\u0330\0\u0360\0\u0390"+
    "\0\u03c0\0\140\0\140\0\u03f0\0\u0420\0\60\0\60\0\u0450"+
    "\0\u0480\0\140\0\140\0\u04b0\0\u04e0\0\u0510\0\u0540\0\u0570"+
    "\0\140\0\140\0\140\0\u05a0\0\140\0\140\0\140\0\140"+
    "\0\140\0\140\0\140\0\u05d0\0\u0600\0\140\0\u0630\0\140"+
    "\0\u0660\0\140\0\60\0\60\0\60\0\140\0\140\0\140"+
    "\0\140\0\60\0\140\0\u0690\0\140\0\140\0\140\0\140"+
    "\0\140\0\140\0\140\0\140\0\140\0\140\0\60\0\140"+
    "\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\3\1\16\1\17"+
    "\1\20\1\2\1\3\1\21\1\22\1\3\1\23\1\24"+
    "\3\3\1\25\3\3\10\4\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\62\0\2\3\1\0\2\3"+
    "\5\0\3\3\1\0\2\3\1\0\25\3\13\0\1\4"+
    "\1\0\1\4\32\0\10\4\13\0\1\4\1\0\1\4"+
    "\1\36\31\0\10\4\12\0\2\3\1\0\2\3\5\0"+
    "\3\3\1\0\2\3\1\0\4\3\1\37\20\3\17\0"+
    "\2\10\51\0\2\3\1\0\2\3\5\0\1\3\1\40"+
    "\1\3\1\0\2\3\1\0\25\3\12\0\2\3\1\0"+
    "\2\3\5\0\3\3\1\0\1\3\1\41\1\0\7\3"+
    "\1\42\1\43\14\3\31\0\1\44\7\0\1\45\1\46"+
    "\1\47\26\0\2\3\1\0\2\3\5\0\3\3\1\0"+
    "\1\3\1\50\1\0\6\3\1\51\1\52\1\53\14\3"+
    "\12\0\2\3\1\0\2\3\5\0\2\3\1\54\1\0"+
    "\2\3\1\55\1\56\24\3\12\0\2\3\1\0\2\3"+
    "\5\0\3\3\1\0\2\3\1\0\2\3\1\57\22\3"+
    "\12\0\2\3\1\0\2\3\5\0\3\3\1\0\2\3"+
    "\1\0\1\3\1\60\23\3\12\0\2\3\1\0\2\3"+
    "\5\0\3\3\1\0\2\3\1\0\5\3\1\61\17\3"+
    "\12\0\1\3\1\62\1\0\1\63\1\3\5\0\3\3"+
    "\1\0\2\3\1\0\15\3\1\64\1\65\1\66\1\67"+
    "\1\70\1\71\1\72\1\73\12\0\2\3\1\0\2\3"+
    "\5\0\1\3\1\74\1\3\1\0\2\3\1\0\1\3"+
    "\1\75\10\3\1\76\1\3\1\77\10\3\12\0\2\36"+
    "\1\0\2\36\5\0\3\36\1\0\2\36\1\0\25\36"+
    "\12\0\2\3\1\0\2\3\5\0\3\3\1\0\2\3"+
    "\1\0\5\3\1\100\17\3\12\0\2\3\1\0\2\3"+
    "\5\0\2\3\1\101\1\0\2\3\1\0\25\3\12\0"+
    "\2\3\1\0\2\3\5\0\3\3\1\0\2\3\1\0"+
    "\10\3\1\102\14\3\43\0\1\103\41\0\1\104\12\0"+
    "\1\105\31\0\2\3\1\0\2\3\5\0\3\3\1\0"+
    "\2\3\1\0\10\3\1\106\14\3\12\0\2\3\1\0"+
    "\2\3\5\0\1\3\1\107\1\3\1\0\2\3\1\0"+
    "\5\3\1\110\17\3\12\0\2\3\1\0\2\3\5\0"+
    "\1\3\1\111\1\3\1\0\2\3\1\0\25\3\34\0"+
    "\1\112\35\0\2\3\1\0\2\3\5\0\3\3\1\0"+
    "\2\3\1\0\1\3\1\113\23\3\12\0\2\3\1\0"+
    "\2\3\5\0\3\3\1\0\2\3\1\0\1\3\1\114"+
    "\23\3\12\0\2\3\1\0\2\3\5\0\3\3\1\0"+
    "\2\3\1\0\3\3\1\115\21\3\12\0\2\3\1\0"+
    "\1\116\1\3\5\0\3\3\1\0\2\3\1\0\15\3"+
    "\1\117\1\120\1\121\1\122\1\123\3\3\12\0\2\3"+
    "\1\0\2\3\5\0\3\3\1\0\2\3\1\0\13\3"+
    "\1\124\11\3\12\0\2\3\1\0\2\3\5\0\3\3"+
    "\1\0\2\3\1\0\12\3\1\125\12\3\12\0\2\3"+
    "\1\0\2\3\5\0\3\3\1\0\2\3\1\0\13\3"+
    "\1\126\11\3\12\0\2\3\1\0\2\3\5\0\3\3"+
    "\1\127\1\130\1\3\1\0\25\3\12\0\2\3\1\0"+
    "\2\3\5\0\3\3\1\0\2\3\1\0\3\3\1\131"+
    "\21\3\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1728];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\6\1\3\11\12\1\10\11\6\1\2\0"+
    "\2\11\5\1\1\0\25\1\3\11\4\1\1\11\14\1"+
    "\1\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  String temp_include;
int columna=1;
boolean newLineFlag = false;
  public String sourceFilename;
    StringBuffer string = new StringBuffer();
    int ultimoEstado = 0;
 public void init(){};

Vector TokensOut = new Vector();

public MCodeGenerator codeGen = new MCodeGenerator();

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



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public MyLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 224) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    writeOut(TokensOut);
  yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { {return new Symbol(sym.EOF,null);}
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { echo(sym.NewLine); codeGen.genMid();
                                    return  new Symbol(sym.NewLine,  yyline, yychar, yytext());
                                    /* if(newLineFlag == true) {
                                        //System.out.println("Salto linea");
                                        newLineFlag = false;
                                        return  new Symbol(sym.NewLine,  yyline, yychar, yytext());
                                    }*/
            }
          case 54: break;
          case 2: 
            { TokensOut.addElement("WARNING, Unknow character, line: " + yyline + ", column: " + yychar);
System.out.println("WARNING, Unknow character, line: " + yyline + ", column: " + yychar);
            }
          case 55: break;
          case 3: 
            { echo(sym.ID); return new Symbol(sym.ID,         yyline, yychar, yytext());
            }
          case 56: break;
          case 4: 
            { echo(sym.Num); codeGen.appendImm("D",yytext());  return new Symbol(sym.Num,       yyline, yychar, yytext());
            }
          case 57: break;
          case 5: 
            { yychar=0;
            }
          case 58: break;
          case 6: 
            { /*no hace nada, aumenta una columna,continua lectura*/yychar++;
            }
          case 59: break;
          case 7: 
            { /* ignore white space. */
            }
          case 60: break;
          case 8: 
            { /* ignora apostrofes. */
            }
          case 61: break;
          case 9: 
            { echo(sym.J);    codeGen.appendOp("j");     return new Symbol(sym.J,           yyline, yychar, yytext());
            }
          case 62: break;
          case 10: 
            { echo(sym.OpPar); return new Symbol(sym.OpPar,   yyline, yychar, yytext());
            }
          case 63: break;
          case 11: 
            { echo(sym.ClPar); return new Symbol(sym.ClPar,   yyline, yychar, yytext());
            }
          case 64: break;
          case 12: 
            { echo(sym.OpKey); return new Symbol(sym.OpKey,   yyline, yychar, yytext());
            }
          case 65: break;
          case 13: 
            { echo(sym.ClKey); return new Symbol(sym.ClKey,   yyline, yychar, yytext());
            }
          case 66: break;
          case 14: 
            { echo(sym.Tag );  return new Symbol(sym.Tag,      yyline, yychar, yytext());
            }
          case 67: break;
          case 15: 
            { echo(sym.Comma); return new Symbol(sym.Comma,   yyline, yychar, yytext());
            }
          case 68: break;
          case 16: 
            { echo(sym.SemCo); return new Symbol(sym.SemCo,   yyline, yychar, yytext());
            }
          case 69: break;
          case 17: 
            { echo(sym.Points); codeGen.genFinal(); return new Symbol(sym.Points, yyline, yychar, yytext());
            }
          case 70: break;
          case 18: 
            { echo(sym.Hexadecimal); codeGen.appendImm("H",yytext());  return new Symbol(sym.Hexadecimal,         yyline, yychar, yytext());
            }
          case 71: break;
          case 19: 
            { echo(sym.Lb);   codeGen.appendOp("lb");    return new Symbol(sym.Lb,         yyline, yychar, yytext());
            }
          case 72: break;
          case 20: 
            { echo(sym.Lw);   codeGen.appendOp("lw");    return new Symbol(sym.Lw,         yyline, yychar, yytext());
            }
          case 73: break;
          case 21: 
            { echo(sym.Sb);   codeGen.appendOp("sb");    return new Symbol(sym.Sb,         yyline, yychar, yytext());
            }
          case 74: break;
          case 22: 
            { echo(sym.Sw);   codeGen.appendOp("sw");    return new Symbol(sym.Sw,         yyline, yychar, yytext());
            }
          case 75: break;
          case 23: 
            { echo(sym.Or);   codeGen.appendOp("or");    return new Symbol(sym.Or,         yyline, yychar, yytext());
            }
          case 76: break;
          case 24: 
            { echo(sym.R9);   codeGen.appendReg("r9");return new Symbol(sym.R9,         yyline, yychar, yytext());
            }
          case 77: break;
          case 25: 
            { echo(sym.R0);   codeGen.appendReg("r0");    return new Symbol(sym.R0,         yyline, yychar, yytext());
            }
          case 78: break;
          case 26: 
            { echo(sym.R1);   codeGen.appendReg("r1");  return new Symbol(sym.R1,         yyline, yychar, yytext());
            }
          case 79: break;
          case 27: 
            { echo(sym.R2);   codeGen.appendReg("r2"); return new Symbol(sym.R2,         yyline, yychar, yytext());
            }
          case 80: break;
          case 28: 
            { echo(sym.R3);   codeGen.appendReg("r3");return new Symbol(sym.R3,         yyline, yychar, yytext());
            }
          case 81: break;
          case 29: 
            { echo(sym.R4);   codeGen.appendReg("r4");return new Symbol(sym.R4,         yyline, yychar, yytext());
            }
          case 82: break;
          case 30: 
            { echo(sym.R5);   codeGen.appendReg("r5");return new Symbol(sym.R5,         yyline, yychar, yytext());
            }
          case 83: break;
          case 31: 
            { echo(sym.R6);   codeGen.appendReg("r6");return new Symbol(sym.R6,         yyline, yychar, yytext());
            }
          case 84: break;
          case 32: 
            { echo(sym.R7);   codeGen.appendReg("r7");return new Symbol(sym.R7,         yyline, yychar, yytext());
            }
          case 85: break;
          case 33: 
            { echo(sym.R8);   codeGen.appendReg("r8");return new Symbol(sym.R8,         yyline, yychar, yytext());
            }
          case 86: break;
          case 34: 
            { echo(sym.Je);   codeGen.appendOp("je");    return new Symbol(sym.Je,         yyline, yychar, yytext());
            }
          case 87: break;
          case 35: 
            { echo(sym.Xor);  codeGen.appendOp("xor");   return new Symbol(sym.Xor,       yyline, yychar, yytext());
            }
          case 88: break;
          case 36: 
            { echo(sym.Lmw);  codeGen.appendOp("lmw");   return new Symbol(sym.Lmw,       yyline, yychar, yytext());
            }
          case 89: break;
          case 37: 
            { echo(sym.Smw);  codeGen.appendOp("smw");   return new Symbol(sym.Smw,       yyline, yychar, yytext());
            }
          case 90: break;
          case 38: 
            { echo(sym.Shl);  codeGen.appendOp("shl");   return new Symbol(sym.Shl,       yyline, yychar, yytext());
            }
          case 91: break;
          case 39: 
            { echo(sym.Shr);  codeGen.appendOp("shr");   return new Symbol(sym.Shr,       yyline, yychar, yytext());
            }
          case 92: break;
          case 40: 
            { echo(sym.Mul);  codeGen.appendOp("mul");   return new Symbol(sym.Mul,       yyline, yychar, yytext());
            }
          case 93: break;
          case 41: 
            { echo(sym.Min);  codeGen.appendOp("min");   return new Symbol(sym.Min,       yyline, yychar, yytext());
            }
          case 94: break;
          case 42: 
            { echo(sym.And);  codeGen.appendOp("and");   return new Symbol(sym.And,       yyline, yychar, yytext());
            }
          case 95: break;
          case 43: 
            { echo(sym.R10);  codeGen.appendReg("r10");return new Symbol(sym.R10,       yyline, yychar, yytext());
            }
          case 96: break;
          case 44: 
            { echo(sym.R11);  codeGen.appendReg("r11");return new Symbol(sym.R11,       yyline, yychar, yytext());
            }
          case 97: break;
          case 45: 
            { echo(sym.R12);  codeGen.appendReg("r12");return new Symbol(sym.R12,       yyline, yychar, yytext());
            }
          case 98: break;
          case 46: 
            { echo(sym.R13);  codeGen.appendReg("r13");return new Symbol(sym.R13,       yyline, yychar, yytext());
            }
          case 99: break;
          case 47: 
            { echo(sym.R14);  codeGen.appendReg("r14");return new Symbol(sym.R14,       yyline, yychar, yytext());
            }
          case 100: break;
          case 48: 
            { echo(sym.R15);  codeGen.appendReg("r15");return new Symbol(sym.R15,       yyline, yychar, yytext());
            }
          case 101: break;
          case 49: 
            { echo(sym.Jlt);  codeGen.appendOp("jlt");   return new Symbol(sym.Jlt,       yyline, yychar, yytext());
            }
          case 102: break;
          case 50: 
            { echo(sym.Jne);  codeGen.appendOp("jne");   return new Symbol(sym.Jne,       yyline, yychar, yytext());
            }
          case 103: break;
          case 51: 
            { echo(sym.Jgt);  codeGen.appendOp("jgt");   return new Symbol(sym.Jgt,       yyline, yychar, yytext());
            }
          case 104: break;
          case 52: 
            { echo(sym.Plus); codeGen.appendOp("plus");   return new Symbol(sym.Plus,     yyline, yychar, yytext());
            }
          case 105: break;
          case 53: 
            { echo(sym.Nand); codeGen.appendOp("nand");  return new Symbol(sym.Nand,     yyline, yychar, yytext());
            }
          case 106: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.ui;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jaam
 */
public class CustomDocumentFilter extends DocumentFilter {
   
    // Use a regular expression to find the words you are looking for
    Pattern pattern = buildPattern();
    
    private StyledDocument styledDocument;
    private StyleContext styleContext;
    private AttributeSet greenAttributeSet;
    private AttributeSet blackAttributeSet;
    
    private JTextPane textPane;

    public CustomDocumentFilter(JTextPane pPane) {
        
        textPane = pPane;
        
        styledDocument = textPane.getStyledDocument();
        
        styleContext = StyleContext.getDefaultStyleContext();

        //
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setBold(attrs, true);
        StyleConstants.setForeground(attrs, Color.BLUE);
        StyleConstants.setFontSize(attrs, 16);
        StyleConstants.setItalic(attrs, true);
        StyleConstants.setAlignment(attrs, 4);
        //
        SimpleAttributeSet attrs2 = new SimpleAttributeSet();
        StyleConstants.setBold(attrs2, true);
        StyleConstants.setForeground(attrs2, Color.BLACK);
        StyleConstants.setFontSize(attrs2, 16);
        StyleConstants.setAlignment(attrs2, 4);

        greenAttributeSet = styleContext.addAttributes(styleContext.getEmptySet(), attrs);
        blackAttributeSet = styleContext.addAttributes(styleContext.getEmptySet(), attrs2);
    }
    
    public void setPane() {
        ((AbstractDocument) textPane.getDocument()).setDocumentFilter(new CustomDocumentFilter(textPane));
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
        super.insertString(fb, offset, text, attributeSet);

        handleTextChanged();
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);

        handleTextChanged();
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
        super.replace(fb, offset, length, text, attributeSet);

        handleTextChanged();
    }

    /**
     * Runs your updates later, not during the event notification.
     */
    private void handleTextChanged() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                updateTextStyles();
                
            }
        });
    }

    /**
     * Build the regular expression that looks for the whole word of each word
     * that you wish to find. The "\\b" is the beginning or end of a word
     * boundary. The "|" is a regex "or" operator.
     *
     * @return
     */
    private Pattern buildPattern() {
        StringBuilder sb = new StringBuilder();
        String[] array = {"plus", "min","mul","and","nand","or","xor","shl","shr",
        "sb","lb","sw","lw","smw","lmw","je","jne","jlt","jgt","j"};
        for (String token : array) {
            sb.append("\\b"); // Start of word boundary
            sb.append(token);
            sb.append("\\b|"); // End of word boundary and an or for the next word
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing "|"
        }

        Pattern p = Pattern.compile(sb.toString());

        return p;
    }

    private void updateTextStyles() {
        // Clear existing styles
        styledDocument.setCharacterAttributes(0, textPane.getText().length(), blackAttributeSet, true);

        // Look for tokens and highlight them
        Matcher matcher = pattern.matcher(textPane.getText());
        while (matcher.find()) {
            // Change the color of recognized tokens
            styledDocument.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), greenAttributeSet, false);
        }
    }
}

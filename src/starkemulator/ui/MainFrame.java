/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.ui;

import starkemulator.ui.CustomDocumentFilter;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author jaam
 */
public class MainFrame extends javax.swing.JFrame {

    private CustomDocumentFilter docFilter;
    
    private ArrayList<JTextPane> paneList;
    private int numScripts;
    private int numTabs;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        this.setName("STARK Simulator");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.paneList = new ArrayList<>();
        paneList.add(mainTextPane);
        numScripts = 1;
        numTabs = 0;

        
        
        TextLineNumber lineNum = new TextLineNumber(mainTextPane);
        jScrollPane3.setRowHeaderView( lineNum );
        
        docFilter = new CustomDocumentFilter(mainTextPane);
        docFilter.setPane();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newBtn = new javax.swing.JButton();
        openBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        exeBtn = new javax.swing.JButton();
        resBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        mainTextPane = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        r0Tv = new javax.swing.JTextField();
        r1Tv = new javax.swing.JTextField();
        r2Tv = new javax.swing.JTextField();
        r3Tv = new javax.swing.JTextField();
        r4Tv = new javax.swing.JTextField();
        r5Tv = new javax.swing.JTextField();
        r6Tv = new javax.swing.JTextField();
        r7Tv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        r8Tv = new javax.swing.JTextField();
        r9Tv = new javax.swing.JTextField();
        r10Tv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        r11Tv = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        r12Tv = new javax.swing.JTextField();
        r13Tv = new javax.swing.JTextField();
        r14Tv = new javax.swing.JTextField();
        r15Tv = new javax.swing.JTextField();
        decBtn = new javax.swing.JButton();
        binBtn = new javax.swing.JButton();
        hexBtn = new javax.swing.JButton();
        openMcBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        runMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newBtn.setText("New");
        newBtn.setToolTipText("New Script");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        openBtn.setText("Open");
        openBtn.setToolTipText("Open Script");

        saveBtn.setText("Save");
        saveBtn.setToolTipText("Save Script");

        exeBtn.setText("Execute");
        exeBtn.setToolTipText("Execute Script");

        resBtn.setText("Reset");
        resBtn.setToolTipText("Reset");

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setAutoscrolls(true);

        jScrollPane3.setViewportView(mainTextPane);

        jTabbedPane1.addTab("Script 1", jScrollPane3);
        jScrollPane3.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("REGISTERS");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel2.setText("R0");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel3.setText("R1");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel4.setText("R2");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel5.setText("R3");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel6.setText("R4");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel7.setText("R5");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel8.setText("R6");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel9.setText("R7");

        r0Tv.setEditable(false);
        r0Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r0Tv.setText("0x0");

        r1Tv.setEditable(false);
        r1Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r1Tv.setText("0x0");

        r2Tv.setEditable(false);
        r2Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r2Tv.setText("0x0");

        r3Tv.setEditable(false);
        r3Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r3Tv.setText("0x0");

        r4Tv.setEditable(false);
        r4Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r4Tv.setText("0x0");

        r5Tv.setEditable(false);
        r5Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r5Tv.setText("0x0");

        r6Tv.setEditable(false);
        r6Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r6Tv.setText("0x0");
        r6Tv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6TvActionPerformed(evt);
            }
        });

        r7Tv.setEditable(false);
        r7Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r7Tv.setText("0x0");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel10.setText("R8");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel11.setText("R9");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel12.setText("R10");

        r8Tv.setEditable(false);
        r8Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r8Tv.setText("0x0");

        r9Tv.setEditable(false);
        r9Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r9Tv.setText("0x0");

        r10Tv.setEditable(false);
        r10Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r10Tv.setText("0x0");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel13.setText("R11");

        r11Tv.setEditable(false);
        r11Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r11Tv.setText("0x0");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel14.setText("R12");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel15.setText("R13");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel16.setText("R14");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel17.setText("R15");

        r12Tv.setEditable(false);
        r12Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r12Tv.setText("0x0");

        r13Tv.setEditable(false);
        r13Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r13Tv.setText("0x0");

        r14Tv.setEditable(false);
        r14Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r14Tv.setText("0x0");

        r15Tv.setEditable(false);
        r15Tv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r15Tv.setText("0x0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(r15Tv, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(r14Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(r13Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(r12Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(r11Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(r10Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27)
                        .addComponent(r9Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)
                        .addComponent(r8Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(r7Tv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(r5Tv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r4Tv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(r6Tv)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(r2Tv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r1Tv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r0Tv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(r3Tv)))
                    .addComponent(jLabel6))
                .addGap(30, 49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(r0Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(r1Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(r2Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(r3Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(r4Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(r5Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(r6Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(r7Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(r8Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(r9Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(r10Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(r11Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(r12Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addComponent(r13Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(r14Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(r15Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        decBtn.setText("Dec");
        decBtn.setToolTipText("Decimal");

        binBtn.setText("Bin");
        binBtn.setToolTipText("Binary");

        hexBtn.setText("Hex");
        hexBtn.setToolTipText("Hexadecimal");

        openMcBtn.setText("Open MC");
        openMcBtn.setToolTipText("Open Machine Code");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel18.setText("STARK Sim");

        fileMenu.setText("File");

        newMenu.setText("New Script");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        fileMenu.add(newMenu);

        jMenuItem2.setText("Open Script");
        fileMenu.add(jMenuItem2);

        jMenuItem3.setText("Save Script");
        fileMenu.add(jMenuItem3);

        jMenuItem4.setText("Open STARK Machine Code");
        fileMenu.add(jMenuItem4);
        fileMenu.add(jSeparator1);

        jMenuItem5.setText("Exit");
        fileMenu.add(jMenuItem5);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        runMenu.setText("Run");

        jMenuItem6.setText("Execute");
        runMenu.add(jMenuItem6);

        jMenuItem7.setText("Reset");
        runMenu.add(jMenuItem7);

        jMenuBar1.add(runMenu);

        toolsMenu.setText("Tools");
        jMenuBar1.add(toolsMenu);

        helpMenu.setText("Help");
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(decBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(binBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hexBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(newBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openMcBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resBtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(newBtn)
                    .addComponent(openBtn)
                    .addComponent(saveBtn)
                    .addComponent(exeBtn)
                    .addComponent(resBtn)
                    .addComponent(decBtn)
                    .addComponent(binBtn)
                    .addComponent(hexBtn)
                    .addComponent(openMcBtn)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        newScript();
    }//GEN-LAST:event_newBtnActionPerformed

    private void r6TvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6TvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r6TvActionPerformed

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        // TODO add your handling code here:
        newScript();
    }//GEN-LAST:event_newMenuActionPerformed

    private void newScript() {
        JTextPane newScriptPane = new JTextPane();
        newScriptPane.setLayout(new BorderLayout());

        CustomDocumentFilter tempDocFil = new CustomDocumentFilter(newScriptPane);
        tempDocFil.setPane();
        
        JScrollPane sp = new JScrollPane();
        sp.setAutoscrolls(true);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setViewportView(newScriptPane);
        
        TextLineNumber lineNum = new TextLineNumber(newScriptPane);
        sp.setRowHeaderView( lineNum );

        jTabbedPane1.addTab("Script " + Integer.toString(numScripts += 1), sp);
        jTabbedPane1.setSelectedIndex(numTabs += 1);

        paneList.add(newScriptPane);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton binBtn;
    private javax.swing.JButton decBtn;
    private javax.swing.JMenu editMenu;
    private javax.swing.JButton exeBtn;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton hexBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane mainTextPane;
    private javax.swing.JButton newBtn;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JButton openBtn;
    private javax.swing.JButton openMcBtn;
    private javax.swing.JTextField r0Tv;
    private javax.swing.JTextField r10Tv;
    private javax.swing.JTextField r11Tv;
    private javax.swing.JTextField r12Tv;
    private javax.swing.JTextField r13Tv;
    private javax.swing.JTextField r14Tv;
    private javax.swing.JTextField r15Tv;
    private javax.swing.JTextField r1Tv;
    private javax.swing.JTextField r2Tv;
    private javax.swing.JTextField r3Tv;
    private javax.swing.JTextField r4Tv;
    private javax.swing.JTextField r5Tv;
    private javax.swing.JTextField r6Tv;
    private javax.swing.JTextField r7Tv;
    private javax.swing.JTextField r8Tv;
    private javax.swing.JTextField r9Tv;
    private javax.swing.JButton resBtn;
    private javax.swing.JMenu runMenu;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenu toolsMenu;
    // End of variables declaration//GEN-END:variables

}

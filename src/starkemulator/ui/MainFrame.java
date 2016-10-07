/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starkemulator.ui;

import starkemulator.ui.CustomDocumentFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import starkemulator.MyCompiler;
import starkemulator.arch.Memory;
import starkemulator.arch.Register;
import starkemulator.help.Converter;

/**
 *
 * @author jaam
 */
public class MainFrame extends javax.swing.JFrame {

    private CustomDocumentFilter docFilter;

    private ArrayList<JTextPane> paneList;
    private int numScripts;
    private int numTabs;

    private Path pathDeArchivo;
    private String retornoArchivo;

    private boolean binFlag;
    private boolean decFlag;
    private boolean hexFlag;
    public static boolean modified;
    public static String newVal;
    public static String regMod;

    public static MyCompiler compiler;
    public static String performanceData;
    public static boolean modifiedPerformance;

    private String stepCode;
    private boolean stepFlag;
    
    private Scanner stepScanner;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() throws InterruptedException {
        initComponents();

        this.setName("STARK Simulator");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        jPanel1.setBackground(Color.LIGHT_GRAY);

        this.paneList = new ArrayList<>();
        paneList.add(mainTextPane);
        numScripts = 1;
        numTabs = 0;

        jTabbedPane1.setToolTipTextAt(0, "Script 1");
        stepCode = "";
        stepFlag = false;

        TextLineNumber lineNum = new TextLineNumber(mainTextPane);
        jScrollPane3.setRowHeaderView(lineNum);

        docFilter = new CustomDocumentFilter(mainTextPane);
        docFilter.setPane();

        decFlag = false;
        binFlag = false;
        hexFlag = true;

        updateManager();

    }

    public void updateManager() throws InterruptedException {

        Thread one = new Thread() {
            public void run() {
                try {
                    while (true) {
                        if (modified) {
                            modified = false;
                            preparenewVal();
                            updateRegisters();
                        }
                        if (modifiedPerformance) {
                            modifiedPerformance = false;
                            updatePerformance();

                        }
                        sleep(1000);
                    }
                } catch (InterruptedException v) {
                    System.out.println(v);
                }
            }
        };

        one.start();
    }

    private void updatePerformance() {
        perfLbl.setText(performanceData);
    }

    private void preparenewVal() {
        if (hexFlag) {
            newVal = Integer.toHexString(Integer.parseInt(newVal));
            newVal = "0x" + newVal.toUpperCase();
        } else if (binFlag) {
            newVal = Integer.toBinaryString(Integer.parseInt(newVal));
            newVal = newVal.toUpperCase();
        }

    }

    private void updateRegisters() {
        switch (regMod) {
            case "r0":
                r0Tv.setText(newVal);
                break;
            case "r1":
                r1Tv.setText(newVal);
                break;
            case "r2":
                r2Tv.setText(newVal);
                break;
            case "r3":
                r3Tv.setText(newVal);
                break;
            case "r4":
                r4Tv.setText(newVal);
                break;
            case "r5":
                r5Tv.setText(newVal);
                break;
            case "r6":
                r6Tv.setText(newVal);
                break;
            case "r7":
                r7Tv.setText(newVal);
                break;
            case "r8":
                r8Tv.setText(newVal);
                break;
            case "r9":
                r9Tv.setText(newVal);
                break;
            case "r10":
                r10Tv.setText(newVal);
                break;
            case "r11":
                r11Tv.setText(newVal);
                break;
            case "r12":
                r12Tv.setText(newVal);
                break;
            case "r13":
                r13Tv.setText(newVal);
                break;
            case "r14":
                r14Tv.setText(newVal);
                break;
            case "r15":
                r15Tv.setText(newVal);
                break;
        }

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
        runBtn = new javax.swing.JButton();
        resBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        mainTextPane = new javax.swing.JTextPane();
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
        jLabel1 = new javax.swing.JLabel();
        openMcBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        stepFBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        perfLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        openMcMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenu = new javax.swing.JMenuItem();
        runningMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        meMapMenu = new javax.swing.JMenuItem();

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
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.setToolTipText("Save Script");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        runBtn.setText("Run");
        runBtn.setToolTipText("Run actual Script");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        resBtn.setText("Reset");
        resBtn.setToolTipText("Reset");
        resBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resBtnActionPerformed(evt);
            }
        });

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setAutoscrolls(true);

        jScrollPane3.setViewportView(mainTextPane);

        jTabbedPane1.addTab("Script 1", jScrollPane3);
        jScrollPane3.getAccessibleContext().setAccessibleParent(jTabbedPane1);

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
        r0Tv.setToolTipText("");

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

        decBtn.setText("Dec");
        decBtn.setToolTipText("Decimal");
        decBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decBtnActionPerformed(evt);
            }
        });

        binBtn.setText("Bin");
        binBtn.setToolTipText("Binary");
        binBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binBtnActionPerformed(evt);
            }
        });

        hexBtn.setText("Hex");
        hexBtn.setToolTipText("Hexadecimal");
        hexBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hexBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("REGISTERS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(decBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(binBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hexBtn)
                        .addGap(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decBtn)
                    .addComponent(binBtn)
                    .addComponent(hexBtn)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(r13Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(r14Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(r15Tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jScrollPane2.setViewportView(jPanel1);

        openMcBtn.setText("Open MC");
        openMcBtn.setToolTipText("Open Machine Code");
        openMcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMcBtnActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel18.setText("STARK-Sim");

        stepFBtn.setText("StepF");
        stepFBtn.setToolTipText("Step Forward");
        stepFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepFBtnActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/starkemulator/ui/images/stark.png"))); // NOI18N
        jLabel19.setText("jLabel19");

        perfLbl.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        perfLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perfLbl.setText("Performance");

        fileMenu.setText("File");

        newMenu.setText("New Script");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        fileMenu.add(newMenu);

        openMenu.setText("Open Script");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveMenu.setText("Save Script");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenu);

        openMcMenu.setText("Open STARK Machine Code");
        openMcMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMcMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMcMenu);
        fileMenu.add(jSeparator1);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        jMenuBar1.add(fileMenu);

        runningMenu.setText("Running");

        jMenuItem6.setText("Run");
        runningMenu.add(jMenuItem6);

        jMenuItem7.setText("Reset");
        runningMenu.add(jMenuItem7);

        jMenuBar1.add(runningMenu);

        toolsMenu.setText("Tools");

        meMapMenu.setText("View Memory Map");
        meMapMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meMapMenuActionPerformed(evt);
            }
        });
        toolsMenu.add(meMapMenu);

        jMenuBar1.add(toolsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openMcBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perfLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stepFBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resBtn)
                        .addContainerGap())
                    .addComponent(jTabbedPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(resBtn)
                                .addComponent(stepFBtn))
                            .addComponent(runBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(newBtn)
                                .addComponent(openBtn)
                                .addComponent(openMcBtn)
                                .addComponent(saveBtn))))
                    .addComponent(perfLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        newScript("");
    }//GEN-LAST:event_newBtnActionPerformed

    private void r6TvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6TvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r6TvActionPerformed

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        // TODO add your handling code here:
        newScript("");
    }//GEN-LAST:event_newMenuActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed
        // TODO add your handling code here:
        openScript();
    }//GEN-LAST:event_openBtnActionPerformed

    private void openMcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMcBtnActionPerformed
        // TODO add your handling code here:
        openMachineCode();
    }//GEN-LAST:event_openMcBtnActionPerformed

    private void openMcMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMcMenuActionPerformed
        // TODO add your handling code here:
        openMachineCode();
    }//GEN-LAST:event_openMcMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        // TODO add your handling code here:
        openScript();
    }//GEN-LAST:event_openMenuActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        saveScript();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
        saveScript();
    }//GEN-LAST:event_saveMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    private void decBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decBtnActionPerformed
        // TODO add your handling code here:
        this.decFlag = true;
        convertion(0);
    }//GEN-LAST:event_decBtnActionPerformed

    private void binBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binBtnActionPerformed
        // TODO add your handling code here:
        this.binFlag = true;
        convertion(1);
    }//GEN-LAST:event_binBtnActionPerformed

    private void hexBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hexBtnActionPerformed
        // TODO add your handling code here:
        this.hexFlag = true;
        convertion(2);
    }//GEN-LAST:event_hexBtnActionPerformed

    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        // TODO add your handling code here:
        runScript();
    }//GEN-LAST:event_runBtnActionPerformed

    private void meMapMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meMapMenuActionPerformed
        // TODO add your handling code here:
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
            MemoryMap window;

            public void run() {
                window = new MemoryMap();
                window.setVisible(true);
                window.updateMap();
            }
        });
    }//GEN-LAST:event_meMapMenuActionPerformed

    private void stepFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepFBtnActionPerformed
        // TODO add your handling code here:
        runStepScript();
    }//GEN-LAST:event_stepFBtnActionPerformed

    private void resBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resBtnActionPerformed
        // TODO add your handling code here:
        resetFunction();
    }//GEN-LAST:event_resBtnActionPerformed

    private void resetFunction() {
        Register.resetRegisters();
        Memory.cleanMem();
        
        if(this.hexFlag) {
            r1Tv.setText("0x");r2Tv.setText("0x");r3Tv.setText("0x");
            r4Tv.setText("0x");r5Tv.setText("0x");r6Tv.setText("0x");
            r7Tv.setText("0x");r8Tv.setText("0x");r9Tv.setText("0x");
            r10Tv.setText("0x");r11Tv.setText("0x");r12Tv.setText("0x");
            r13Tv.setText("0x");r14Tv.setText("0x");r15Tv.setText("0x");
            r0Tv.setText("0x");
        }
        if(this.decFlag || this.binFlag) {
            r1Tv.setText("0");r2Tv.setText("0");r3Tv.setText("0");
            r4Tv.setText("0");r5Tv.setText("0");r6Tv.setText("0");
            r7Tv.setText("0");r8Tv.setText("0");r9Tv.setText("0");
            r10Tv.setText("0");r11Tv.setText("0");r12Tv.setText("0");
            r13Tv.setText("0");r14Tv.setText("0");r15Tv.setText("0");
            r0Tv.setText("0");
        }
    }
    
    private void runStepScript() {
        if (stepFlag == false) {
            this.stepFlag = true;
            JTextPane tempPane = null;
            int textPaneSelected = jTabbedPane1.getSelectedIndex();
            if (textPaneSelected != -1) {
                tempPane = paneList.get(textPaneSelected);
            }
            if (tempPane != null) {
                this.stepCode = tempPane.getText();
            }
            stepScanner = new Scanner(this.stepCode);
            String line = stepScanner.nextLine();
            compiler = new MyCompiler();
            compiler.stepAnalysis(line);
        } else {
            if(stepScanner.hasNext()) {
                String line = stepScanner.nextLine();
                compiler = new MyCompiler();
                compiler.stepAnalysis(line);
            } else {
                this.stepFlag = false;
            }
        }
    }

    private void runScript() {
        this.stepFlag = false;
        
        BufferedWriter out = null;
        File temp = null;

        try {
            temp = File.createTempFile("Script", ".txt");
            //create a temp file
            temp.deleteOnExit();
            //System.out.println("Temp file : " + temp.getAbsolutePath());
            out = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
            JTextPane tempPane = null;
            int textPaneSelected = jTabbedPane1.getSelectedIndex();
            if (textPaneSelected != -1) {
                tempPane = paneList.get(textPaneSelected);
            }
            if (tempPane != null) {
                out.write(tempPane.getText());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // running the selected script 
        compiler = new MyCompiler();
        if (compiler.procesarEntrada(temp)) {
            compiler.crearBancoInstr(temp);
        }
        if (compiler.isBranchFlag()) {
            compiler.execBranches();
        }
    }

    private void convertion(int pType) {
        if (hexFlag && (pType == 0)) {
            this.hexFlag = false;
            convertionAux(0);
        }
        if (binFlag && (pType == 0)) {
            this.binFlag = false;
            convertionAux(1);
        }
        if (decFlag && (pType == 1)) {
            this.decFlag = false;
            convertionAux(2);
        }
        if (hexFlag && (pType == 1)) {
            this.hexFlag = false;
            convertionAux(3);
        }
        if (decFlag && (pType == 2)) {
            this.decFlag = false;
            convertionAux(4);
        }
        if (binFlag && (pType == 2)) {
            this.binFlag = false;
            convertionAux(5);
        }
    }

    private void convertionAux(int pOption) {
        Converter conv = new Converter();

        ArrayList<JTextField> list = doTvList();

        for (int i = 0; i < list.size(); i++) {
            switch (pOption) {
                case 0:
                    list.get(i).setText(conv.hexToDec(list.get(i).getText()));
                    break;
                case 1:
                    list.get(i).setText(conv.binToDec(list.get(i).getText()));
                    break;
                case 2:
                    list.get(i).setText(conv.decToBin(list.get(i).getText()));
                    break;
                case 3:
                    list.get(i).setText(conv.hexToBin(list.get(i).getText()));
                    break;
                case 4:
                    list.get(i).setText(conv.decToHex(list.get(i).getText()));
                    break;
                case 5:
                    list.get(i).setText(conv.binToHex(list.get(i).getText()));
                    break;
            }
        }
    }

    private ArrayList doTvList() {
        ArrayList<JTextField> list = new ArrayList<>();
        list.add(r0Tv);
        list.add(r1Tv);
        list.add(r2Tv);
        list.add(r3Tv);
        list.add(r4Tv);
        list.add(r5Tv);
        list.add(r6Tv);
        list.add(r7Tv);
        list.add(r8Tv);
        list.add(r9Tv);
        list.add(r10Tv);
        list.add(r11Tv);
        list.add(r12Tv);
        list.add(r13Tv);
        list.add(r14Tv);
        list.add(r15Tv);

        return list;
    }

    private void newScript(String pContent) {
        this.stepFlag = false;
        
        JTextPane newScriptPane = new JTextPane();
        newScriptPane.setLayout(new BorderLayout());
        newScriptPane.setText(pContent);

        CustomDocumentFilter tempDocFil = new CustomDocumentFilter(newScriptPane);
        tempDocFil.setPane();

        JScrollPane sp = new JScrollPane();
        sp.setAutoscrolls(true);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setViewportView(newScriptPane);

        TextLineNumber lineNum = new TextLineNumber(newScriptPane);
        sp.setRowHeaderView(lineNum);

        jTabbedPane1.addTab("Script " + Integer.toString(numScripts += 1), sp);
        jTabbedPane1.setSelectedIndex(numTabs += 1);
        jTabbedPane1.setToolTipTextAt(numTabs, "Script " + Integer.toString(numScripts));

        paneList.add(newScriptPane);

    }

    private void openScript() {
        this.stepFlag = false;
        
        JFileChooser Buscador = new JFileChooser();
        Buscador.setAcceptAllFileFilterUsed(false);
        Buscador.setMultiSelectionEnabled(false);
        Buscador.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        Buscador.showOpenDialog(Buscador);
        File file = Buscador.getSelectedFile();
        try {
            pathDeArchivo = Paths.get(file.getAbsolutePath());
            retornoArchivo = new String(Files.readAllBytes(pathDeArchivo));
            newScript(retornoArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR, we can't load the file");
        }
    }

    private void openMachineCode() {
        this.stepFlag = false;
        
        JFileChooser Buscador = new JFileChooser();
        Buscador.setAcceptAllFileFilterUsed(false);
        Buscador.setMultiSelectionEnabled(false);
        Buscador.setFileFilter(new FileNameExtensionFilter(".stark", "stark"));
        Buscador.showOpenDialog(Buscador);
        File file = Buscador.getSelectedFile();
        try {
            pathDeArchivo = Paths.get(file.getAbsolutePath());
            retornoArchivo = new String(Files.readAllBytes(pathDeArchivo));
            newScript(retornoArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR, we can't load the file");
        }
    }

    private void saveScript() {
        JFileChooser saveFile = new JFileChooser();
        //saveFile.showSaveDialog(null);
        int returnVal = saveFile.showSaveDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new FileWriter(saveFile.getSelectedFile().getPath() + ".txt"));
                JTextPane tempPane = null;
                int textPaneSelected = jTabbedPane1.getSelectedIndex();
                if (textPaneSelected != -1) {
                    tempPane = paneList.get(textPaneSelected);
                }
                if (tempPane != null) {
                    out.write(tempPane.getText());
                }
            } catch (IOException ex) {
                System.out.println("ERROR, with saving file");
            } finally {
                try {
                    out.close();

                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton binBtn;
    private javax.swing.JButton decBtn;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane mainTextPane;
    private javax.swing.JMenuItem meMapMenu;
    private javax.swing.JButton newBtn;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JButton openBtn;
    private javax.swing.JButton openMcBtn;
    private javax.swing.JMenuItem openMcMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JLabel perfLbl;
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
    private javax.swing.JButton runBtn;
    private javax.swing.JMenu runningMenu;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JButton stepFBtn;
    private javax.swing.JMenu toolsMenu;
    // End of variables declaration//GEN-END:variables

}

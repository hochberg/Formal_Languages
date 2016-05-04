
/**
 * file: Browser.java
 * author: Alexander Hochberg
 * course: CMPT 440
 * assignment: milestone2
 * due date: May 2, 2016
 * version: 1.2
 *
 * This file contains a basic text editor using JFrame. The editor implements
 * a DFA and highlights specific statements depending on the DFA accepting 
 * states.
 */

/*Imports*/
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 * Browser
 * 
 * This class extends the JFrame class to build a Java Swing JFrame panel
 * that holds the text area editor and implements the DFA.
 */
public class Browser extends javax.swing.JFrame {
    //records the index of the text buffer
    public int bufferIndex;

    /**
     * Creates new form of Browser
     */
    public Browser() {
        initComponents();
    }

    /**
     * intitComponents
     * 
     * This method is called from within the constructor to initialize the form.
     * Created using JFrame.
     */
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        runButton = new javax.swing.JButton();
        jComboBoxFont = new javax.swing.JComboBox();
        jComboBoxBackground = new javax.swing.JComboBox();
        jResetButton = new javax.swing.JButton();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        jScrollPane1.setViewportView(inputTextArea);
        Font afont = new Font("TimesRoman", Font.PLAIN, 18);
        inputTextArea.setFont(afont);

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jComboBoxFont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TimesRoman", "Serif", "Garamond" }));
        jComboBoxFont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxFontMouseClicked(evt);
            }
        });
        jComboBoxFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFontActionPerformed(evt);
            }
        });

        jComboBoxBackground.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "White", "Grey", "Blue"}));
        jComboBoxBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBackgroundActionPerformed(evt);
            }
        });

        jResetButton.setText("Reset");
        jResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxFont, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(jResetButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * runButtonActionPerformed
     * 
     * This function fires when the run button is clicked. It processes the 
     * text within the inputTextArea and highlights text depending on DFA 
     * states.
     * @param evt 
     */
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
         //get text from inputTextArea in form of string
         String input = inputTextArea.getText();
         //splits the string depending on different lines
         //populates an array of each line
         String splitInput[] = input.split("\\r\\n|\\n|\\r");
         //initializes the bufferIndex 
         this.bufferIndex = 0;
        
         //loops through array of input
         //runs process on each line of inputTextArea text
         for(int i = 0; i < splitInput.length; i++){
             //initializes buffer for each line
             String buffer = "";
             try {
                 //processes specific line with buffer
                 process(splitInput[i]+" ", buffer);
             } catch (BadLocationException ex) {
                 //logs excepeption
                 Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null, ex);
             }
         //resets buffer and state
         buffer = "";
         reset();
         }
    }//GEN-LAST:event_runButtonActionPerformed

     /**
     * jComboBoxFontActionPerformed
     * 
     * This function fires when the when a new value is picked from the combo
     * box. Depending on the value, the font changes in the inputTextArea.
     * 
     * @param evt 
     */
    private void jComboBoxFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFontActionPerformed
        //recieves string value from combo box
        String value = jComboBoxFont.getSelectedItem().toString();
        //changes to TimesRoman
        if (value == "TimesRoman"){
              Font afont = new Font("TimesRoman", Font.PLAIN, 18);
              inputTextArea.setFont(afont);
        }//changes to Serif
        if (value == "Serif"){
              Font afont = new Font("Serif", Font.PLAIN, 18);
              inputTextArea.setFont(afont);
        }//changes to Garamond
        if (value == "Garamond"){
              Font afont = new Font("Garamond", Font.PLAIN, 18);
              inputTextArea.setFont(afont);
        }
    }//GEN-LAST:event_jComboBoxFontActionPerformed

    
    private void jComboBoxFontMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxFontMouseClicked
    //IMMUTABLE JFRAME DEAD CODE
    }//GEN-LAST:event_jComboBoxFontMouseClicked
   
    /**
     * jComboBoxBackgroundActionPerformed
     * 
     * This function fires when the when a new value is picked from the combo
     * box. Depending on the value, the background changes in the inputTextArea.
     * 
     * @param evt 
     */
    private void jComboBoxBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBackgroundActionPerformed
        //recieves string value from combo box
        String value = jComboBoxBackground.getSelectedItem().toString();
        //changes to white
        if (value == "White"){
             inputTextArea.setBackground(new Color(255, 255, 255));
        }//changes to grey
        if (value == "Grey"){
              inputTextArea.setBackground(new Color(211, 211, 211));
        }//changes to blue
        if (value == "Blue"){
             inputTextArea.setBackground(new Color(245,254,254));
        }
    }//GEN-LAST:event_jComboBoxBackgroundActionPerformed
   
    /**
     * jResetButtonActionPerformed
     * 
     * This function fires when the when the reset button is clicked. The
     * inputTextArea is cleared and the buffer/bufferIndex is reset.
     * 
     * @param evt 
     */
    private void jResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetButtonActionPerformed
        //resets buffer, bufferIndex and clears inputTextArea
        reset();
        this.bufferIndex = 0;
        inputTextArea.setText("");
    }//GEN-LAST:event_jResetButtonActionPerformed

    /**
     * main
     * 
     * This is the main function of the Browser class and fires the programs 
     * functionality. It runs the JFrame panel on run.
     * 
     * @param args the command line arguments
     * 
     */
    public static void main(String args[]) {

       //JFrame preset "Nimbus" feel and preset exception catchers
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Browser().setVisible(true);
            }
        });
    }
    
     /* Constants */
    
    //State Declarations
    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private static final int q9 = 9;
    private static final int q10 = 10;
    private static final int q11 = 11;
    private static final int q12 = 12;
    private static final int q13 = 13;
    private static final int q14 = 14;
    private static final int q15 = 15;
    private static final int q16 = 16;
    private static final int q17 = 17;
    private static final int q18 = 18;
    private static final int q19 = 19;
    private static final int q20 = 20;
    private static final int q21 = 21;
    private static final int q22 = 22;
    private static final int q23 = 23;
    private static final int q24 = 24;
    private static final int q25 = 25;
    private static final int q26 = 26;
    private static final int q27 = 27;
    private static final int q28 = 28;
    private static final int q29 = 29;
    private static final int q30 = 30;
    private static final int q31 = 31;
    private static final int q32 = 32;
    private static final int q33 = 33;
    private static final int q34 = 34;
    private static final int q35 = 35;
    private static final int q36 = 36;
    private static final int q37 = 37;
    private static final int q38 = 38;
    private static final int q39 = 39;
    private static final int q40 = 40;
    private static final int q41 = 41;
    private static final int q42 = 42;
    private static final int q43 = 43;
    private static final int q44 = 44;
    private static final int q45 = 45;
    private static final int qError = 46;
    
  
    //2D array map of DFA
    static private int[][] delta = {
 //a	b	c	d	e	f	g	h	i	j	k	l	m	n	o	p	q	r	s	t	u	v	w	x	y	z	0	1	2	3	4	5	6	7	8	9	"	(	)	-	=	+	*	space	;
{q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q27,	q1,	q27,	q27,	q27,	q27,	q27,	q22,	q27,	q27,	q27,	q27,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q39,	qError, qError},//q0
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q2,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q28,    qError},//q1
{qError	,qError,qError,	qError,	qError,	qError,	qError,	qError,	q3,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q2
{qError	,qError,qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q4,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q3
{qError	,qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q5,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q4
{qError	,qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q6,     qError},//q5
{qError	,qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q7,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q6
{qError	,qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q8,     qError},//q7
{q9,     q9,	q9,	q9,       q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q9,	q19,	q19,	q19,	q19,	q19,	q19,	q19,	q19,	q19,	q19,	q13,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q8
{qError, qError,qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	q10,    qError},//q9
{qError, qError,qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q11,	qError,	qError,	qError,	qError,	qError, qError},//q10
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0},//q11
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q13,    qError},//q12
{q14,    q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q14,    qError},//q13
{q14,    q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q15,    qError},//q14
{q14,    q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	q14,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q16,	qError,	qError,	qError,	qError,	qError,	qError,	q15,    qError},//q15
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q17,    qError},//q16
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q18,	qError,	qError,	qError,	qError,	qError, qError},//q17
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0},//q18
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q20,    qError},//q19
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q21,	qError,	qError,	q7,	qError,	qError, qError},//q20
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0},//q21
{q23,    qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q28,    qError},//q22
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q24,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q23
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q25,    qError},//q24
{q26,    q26,   q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	q26,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q25
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0},//q26
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q28,    qError},//q27
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q29,	qError,	qError,	qError, qError},//q28
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q30,    qError},//q29
{q31,    q31,   q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q37,	q37,	q37,	q37,	q37,	q37,	q37,	q37,	q37,	q37,	q32,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError},//q30
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0},//q31
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q33,    qError},//q32
{q34,    q34,   q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q34,    qError},//q33
{q34,    q34,   q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q35,    qError},//q34
{q34,    q34,   q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	q34,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q36,	qError,	qError,	qError,	qError,	qError,	qError,	q35,    qError},//q35
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0},//q36
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q38,        q0},//q37
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q29,	qError,	qError, qError},//q38
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q40,	qError,	qError,	qError,	qError, qError},//q39
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q41,    qError},//q40
{q42,    q42,   q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q42,    qError},//q41
{q42,    q42,   q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q43,    qError},//q42
{q42,    q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	q42,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q44,	qError,	qError,	qError,	q43,    qError},//q43
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	q45,	qError, qError},//q44
{qError, qError,qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError, qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,	qError,     q0} //q45
};				

    /* Varaiable Initializations */
    
    //inital state
    int state = q0;
    //initialize invalid character
    boolean invalid = false;

   /* Functions */

    /**
     * reset
     *
     * This function resets the initial values for process the man-wolf-cabbage solution,
     * The values of variables, state and invalid, are reset to their initial values.
     *
     */
    public void reset() {
        //sets state and invalid to inital values
        state = q0;
        invalid = false;
        

    };

    /**
     * process
     *
     * This function processes the user's input string solution, compares each step to the
     * solution matrix step by step, determines if a working solution, a non-working solution
     * or invalid input was given, and then prints the results to the screen.
     *
     * Parameters:
     *   in: the string that is input by the user, their given solution
     *   buf: the string of the current buffer
     *
     */
    public void process(String in, String buf) throws BadLocationException{
        //initialize highlighter
        Highlighter highlight = inputTextArea.getHighlighter();
        //create all highlighter colors
        HighlightPainter pink = new DefaultHighlighter.DefaultHighlightPainter(new Color (245, 215, 240));
        HighlightPainter yellow = new DefaultHighlighter.DefaultHighlightPainter(new Color (255, 250, 205));
        HighlightPainter green = new DefaultHighlighter.DefaultHighlightPainter(new Color (230, 245, 230));
        HighlightPainter red = new DefaultHighlighter.DefaultHighlightPainter(new Color (240, 128, 128));
        HighlightPainter blue = new DefaultHighlighter.DefaultHighlightPainter(new Color (200, 225, 255));
        HighlightPainter orange = new DefaultHighlighter.DefaultHighlightPainter(new Color (255, 222, 173));
        HighlightPainter cyan = new DefaultHighlighter.DefaultHighlightPainter(new Color (200, 255, 255));
        HighlightPainter magenta = new DefaultHighlighter.DefaultHighlightPainter(new Color (230, 230, 250));
        HighlightPainter grey = new DefaultHighlighter.DefaultHighlightPainter(new Color (238, 233, 233));
        
        //loops through length of input string, char by char
        for(int i = 0; i < in.length();i++){

            //initalizes local variable, move
            int move;
        

            //finds current char, sets to lowercase
            char c = Character.toLowerCase(in.charAt(i));
           
            //add new char to buffer
            buf = buf + c;
            
            //increment indexBuffer 
            this.bufferIndex = this.bufferIndex+1;
            
            //compares current char to valid steps, w,g,c,and n
            //and sets move to proper location in transition matrix
            switch(c)
            {
                case 'a' :
                    move = 0;
                    break;
                case 'b' :
                    move = 1;
                    break;
                case 'c' :
                    move = 2;
                    break;
                case 'd' :
                    move = 3;
                    break;
                case 'e' :
                    move = 4;
                    break;
                case 'f' :
                    move = 5;
                    break;
                case 'g' :
                    move = 6;
                    break;
                case 'h' :
                    move = 7;
                    break;
                case 'i' :
                    move = 8;
                    break;
                case 'j' :
                    move = 9;
                    break;
                case 'k' :
                    move = 10;
                    break;
                case 'l' :
                    move = 11;
                    break;
                case 'm' :
                    move = 12;
                    break;
                case 'n' :
                    move = 13;
                    break;
                case 'o' :
                    move = 14;
                    break;
                case 'p' :
                    move = 15;
                    break;
                case 'q' :
                    move = 16;
                    break;
                case 'r' :
                    move = 17;
                    break;
                case 's' :
                    move = 18;
                    break;
                case 't' :
                    move = 19;
                    break;
                case 'u' :
                    move = 20;
                    break;
                case 'v' :
                    move = 21;
                    break;
                case 'w' :
                    move = 22;
                    break;
                case 'x' :
                    move = 23;
                    break;
                case 'y' :
                    move = 24;
                    break;
                case 'z' :
                    move = 25;
                    break;
                case '0' :
                    move = 26;
                    break;
                case '1' :
                    move = 27;
                    break;
                case '2' :
                    move = 28;
                    break;
                case '3' :
                    move = 29;
                    break;
                case '4' :
                    move = 30;
                    break;
                case '5' :
                    move = 31;
                    break;
                case '6' :
                    move = 32;
                    break;
                case '7' :
                    move = 33;
                    break;
                case '8' :
                    move = 34;
                    break;
                case '9' :
                    move = 35;
                    break;
                case '"' :
                    move = 36;
                    break;
                case '(' :
                    move = 37;
                    break;
                case ')' :
                    move = 38;
                    break;
                case '-' :
                    move = 39;
                    break;
                case '=' :
                    move = 40;
                    break;
                case '+' :
                    move = 41;
                    break;
                case '*' :
                    move = 42;
                    break;
                case ' ' :
                    move = 43;
                    break;
                case ';' :
                    move = 44;
                    //resets buffer
                    buf = "";
                    break;
               
                //if char other than alphabet is given
                //sets invalid to notify user of bad input
                default :
                    move = 0;
                    state = qError;
                    invalid = true;

            }
            //if state is invalid, prints invalid message
            if (state == qError){
                 System.out.println("Invalid state.");
                
            }else {  
            //changes state depending on current state and next move that
            //was just calculated
            state = delta[state][move];
                System.out.println(state);
        
        //in case of invalid character, prints invalid message
        if(invalid){
            System.out.println("An invalid character was entered.");
        //if success state is reached , q9, print success message
        
        }//Print
        else if (state == q5){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x, y, pink );
        buf = "";
        }//Print ( a )
        else if (state == q11){
          int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+3, y-2, green);
        buf = "";
        }//Print ( " a " )
        else if (state == q18){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+3, y-2, yellow);
        buf = "";
        }//Print ( 1 + 1 )
        else if (state == q21){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+3, y-2, blue);
        buf = "";
        }//var 
        else if (state == q24){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x, y, pink);
        buf = "";
        }//var a
        else if (state == q26){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+1, y, green);
        buf = "";
        }//a
        else if (state == q27){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x, y, green);
        buf = "";
        }  //a
        else if (state == q28){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x, y, green);
        buf = "";
        }// = 
        else if (state == q29){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+1, y, magenta);
        buf = "";
        } //a = a
        else if (state == q31){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+1, y, green);
        buf = "";
        }//a = " string "
        else if (state == q36){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+1, y, yellow);
        buf = "";
        }// a = 0
        else if (state == q37){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x+1, y, blue);
        buf = "";
        }//*- Comments -*
        else if (state == q45){
        int x = this.bufferIndex - buf.length();
        int y = this.bufferIndex;
        highlight.addHighlight(x, y, grey);
        buf = "";
        }  
        }    
        }     
    }

//JFrame immutable variables
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JComboBox jComboBoxBackground;
    private javax.swing.JComboBox jComboBoxFont;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jResetButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JButton runButton;
    // End of variables declaration//GEN-END:variables

}

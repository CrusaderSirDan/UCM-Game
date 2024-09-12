/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nl.mu.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import nl.mu.model.Chapter;
import nl.mu.model.ChapterOne;
import nl.mu.model.ChapterTwo;
import nl.mu.model.ChapterZero;
import nl.mu.model.Game;
import nl.mu.model.Player;

/**
 *
 * @author Doos
 */
public class MainFrame extends javax.swing.JFrame {

    private Style userStyle;
    private Style tildeStyle;
    private final Style errorStyle;
    private Player player = new Player();
    private Game game = new Game();
    private Chapter currentChapter;
    private boolean userNamed = false;
    private String lastInput = "";

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.errorStyle = outputPane.addStyle("RED", null);
        StyleConstants.setForeground(errorStyle, Color.RED);
        getContentPane().setBackground(Color.BLACK);
        currentChapter = new ChapterZero();
//        player.setName("CrusaderSirDan");
//        currentChapter=new ChapterTwo(player);
        initGame();
        initOutputPane();
        initInputPane();
        currentChapter.play(outputPane, inputPane);
    }

    public void initGame() {
        try {
            game.addChoices("ChoicesFile.txt");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Chapter nextChapter() {
        switch (currentChapter.getChapter()) {
            case 0:
                return new ChapterOne(player);
            case 1:
                return new ChapterTwo(player);
            case 2:
//                return "ChapterThree";
//            case 3:
//                return "ChapterFour";
//            case 4:
//                return "ChapterFive";
//            case 5:
//                return "ChapterSix";
            default:
                return null;
        }
    }

    public void initOutputPane() {
        Style bannerStyle = outputPane.addStyle("Yellow", null);
        StyleConstants.setForeground(bannerStyle, Color.YELLOW);
        Style byLineStyle = outputPane.addStyle("Silver", null);
        StyleConstants.setForeground(byLineStyle, new Color(192, 192, 192));
        StyledDocument outputDoc = outputPane.getStyledDocument();
        try {
            outputDoc.insertString(outputDoc.getLength(),
                    /*--*/ "   ______ ___     ______ ______ ___     _   __ _  _____    ____   __  __ _   __ ______ ______ ____   _   __" + "\n"
                    /**/ + "  / ____//   |   / ____//_  __//   |   / | / /( )/ ___/   / __ \\ / / / // | / // ____// ____// __ \\ / | / /" + "\n"
                    /**/ + " / / __ / /| |  / __/    / /  / /| |  /  |/ / |/ \\__ \\   / / / // / / //  |/ // / __ / __/  / / / //  |/ / " + "\n"
                    /**/ + "/ /_/ // ___ | / /___   / /  / ___ | / /|  /    ___/ /  / /_/ // /_/ // /|  // /_/ // /___ / /_/ // /|  /  " + "\n"
                    /**/ + "\\____//_/  |_|/_____/  /_/  /_/  |_|/_/ |_/    /____/  /_____/ \\____//_/ |_/ \\____//_____/ \\____//_/ |_/   " + "\n", bannerStyle);
            outputDoc.insertString(outputDoc.getLength(), "By: Gaëtan Doos\n", byLineStyle);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void initInputPaneStyle() {
        userStyle = inputPane.addStyle("Green", null);
        StyleConstants.setForeground(userStyle, Color.GREEN);
        tildeStyle = inputPane.addStyle("Dodger Blue", null);
        StyleConstants.setForeground(tildeStyle, new Color(30, 144, 255));
    }

    public void initInputPane() {
        inputPane.requestFocusInWindow();
        initInputPaneStyle();
        StyledDocument inputDoc = inputPane.getStyledDocument();
        try {
            if (player == null || player.getName() == null) {
                inputDoc.insertString(inputDoc.getLength(), "admin@user", userStyle);
            } else {
                inputDoc.insertString(inputDoc.getLength(), "admin@" + player.getName(), userStyle);
            }
            inputDoc.insertString(inputDoc.getLength(), ":", null);
            inputDoc.insertString(inputDoc.getLength(), "~", tildeStyle);
            inputDoc.insertString(inputDoc.getLength(), "$ ", null);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public String getUserInput() {
        String playerInput;
        if (player == null || player.getName() == null) {
            playerInput = inputPane.getText().substring(14);
        } else {
            playerInput = inputPane.getText().substring(10 + player.getName().length());
        }
        if (playerInput == null) {
            playerInput = "";
        }
        return playerInput;
    }

    private void handleKeyEvent(KeyEvent evt, JTextPane pane, String nonInput) {
        try {
            int caretPosition = pane.getCaretPosition();
            String currentText = pane.getText();

            if (caretPosition <= nonInput.length()) {
                // The caret is within the nonInput part, prevent modification
                evt.consume();
                return;
            }

            String regex = "^" + Pattern.quote(nonInput) + ".*";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(currentText);

            if (!m.matches()) {
                evt.consume();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputPane = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputPane = new javax.swing.JTextPane();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terminal");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.black);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        outputPane.setEditable(false);
        outputPane.setBackground(new java.awt.Color(0, 0, 0));
        outputPane.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        outputPane.setForeground(new java.awt.Color(255, 255, 255));
        outputPane.setToolTipText("");
        outputPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        outputPane.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(outputPane);

        jScrollPane4.setBorder(null);

        inputPane.setBackground(new java.awt.Color(0, 0, 0));
        inputPane.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        inputPane.setForeground(new java.awt.Color(255, 255, 255));
        inputPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputPaneKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(inputPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPaneKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            evt.consume();
            StyledDocument inputDoc = inputPane.getStyledDocument();
            StyledDocument outputDoc = outputPane.getStyledDocument();
            String playerInput = getUserInput();
            lastInput = playerInput;

            try {
                //update outputPane
                int length = inputDoc.getLength();
                if (player == null || player.getName() == null) {
                    outputDoc.insertString(outputDoc.getLength(), "\n" + "admin@user", userStyle);
                } else {
                    outputDoc.insertString(outputDoc.getLength(), "\n" + "admin@" + player.getName(), userStyle);
                }
                outputDoc.insertString(outputDoc.getLength(), ":", null);
                outputDoc.insertString(outputDoc.getLength(), "~", tildeStyle);
                outputDoc.insertString(outputDoc.getLength(), "$ ", null);
                outputDoc.insertString(outputDoc.getLength(), playerInput, null);

                //check player choice
                currentChapter.processChoice(playerInput, outputPane);
                if ((currentChapter instanceof ChapterZero) && currentChapter.getChapterState() == 2) {
                    player.setName(currentChapter.getPlayer().getName());
                }
                if (currentChapter.isChapterCompleted()) {
                    currentChapter = nextChapter();
                    currentChapter.play(outputPane, inputPane);
                }

                inputPane.setText("");
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            initInputPane();
        } else if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_DELETE) {
            String nonInput;
            if (player == null || player.getName() == null) {
                nonInput = "admin@user:~$ ";
            } else {
                nonInput = "admin@" + player.getName() + ":~$ ";
            }
            handleKeyEvent(evt, inputPane, nonInput);
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            StyledDocument inputDoc = inputPane.getStyledDocument();
            try {
                inputDoc.insertString(inputDoc.getLength(), lastInput, null);
            } catch (BadLocationException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_inputPaneKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane inputPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane outputPane;
    // End of variables declaration//GEN-END:variables
}

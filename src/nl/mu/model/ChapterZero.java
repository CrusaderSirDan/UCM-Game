///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package nl.mu.model;
//
//import java.awt.Color;
//import javax.swing.JTextPane;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.Style;
//import javax.swing.text.StyleConstants;
//import javax.swing.text.StyledDocument;
//
///**
// *
// * @author mcsyt
// */
//public class ChapterZero extends Chapter {
//
//    public ChapterZero() {
//        super("chapter zero", 0, new Player());
//    }
//
//    @Override
//    public void startChapter(JTextPane outputPane) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void play(JTextPane outputPane, JTextPane inputPane) {
//        player.askName(outputPane);
//        chapterState++;
//    }
//
//    @Override
//    public void processChoice(String playerInput, JTextPane outputPane) {
//        //CREATE THE STYLES
//        StyledDocument outputDoc = outputPane.getStyledDocument();
//        Style errorStyle = outputPane.addStyle("ERROR", null);
//        StyleConstants.setForeground(errorStyle, Color.RED);
//        Style userStyle = outputPane.addStyle("user", null);
//        StyleConstants.setForeground(userStyle, Color.GREEN);
//        Style promptStyle = outputPane.addStyle("prompt", null);
//        StyleConstants.setForeground(promptStyle, Color.YELLOW);
//        Style conversationalStyle = outputPane.addStyle("conversation", null);
//        StyleConstants.setForeground(conversationalStyle, new Color(100, 149, 237));
//
//        try {
//            switch (chapterState) {
//                case 1:
//                    if (playerInput.equals("")) {
//                        outputDoc.insertString(outputDoc.getLength(), "\n" + "PLEASE ENTER A VALID USERNAME", errorStyle);
//                    } else {
//                        player.setName(playerInput);
//                        outputDoc.insertString(outputDoc.getLength(), "\nYou typed ", null);
//                        outputDoc.insertString(outputDoc.getLength(), player.getName(), userStyle);
//                        outputDoc.insertString(outputDoc.getLength(), ". ", null);
//                        outputDoc.insertString(outputDoc.getLength(), "Confirm?", promptStyle);
//                        outputDoc.insertString(outputDoc.getLength(), " (Y/n)", null);
//                        chapterState++;
//                    }
//                    break;
//                case 2:
//                    if (playerInput.equalsIgnoreCase("Y")) {
//                        outputDoc.insertString(outputDoc.getLength(), "\nHello ", null);
//                        outputDoc.insertString(outputDoc.getLength(), player.getName(), userStyle);
//                        outputDoc.insertString(outputDoc.getLength(), "! \n", null);
//                        outputDoc.insertString(outputDoc.getLength(), "Are you ready for an adventure?", conversationalStyle);
//                        outputDoc.insertString(outputDoc.getLength(), "  To START, type \"", null);
//                        outputDoc.insertString(outputDoc.getLength(), "START", promptStyle);
//                        outputDoc.insertString(outputDoc.getLength(), "\"", null);
//                        chapterState++;
//                    } else if (playerInput.equalsIgnoreCase("n")) {
//                        player.askName(outputPane);
//                        chapterState--;
//                    } else {
//                        outputDoc.insertString(outputDoc.getLength(), "\nYou typed ", null);
//                        outputDoc.insertString(outputDoc.getLength(), player.getName(), userStyle);
//                        outputDoc.insertString(outputDoc.getLength(), ". ", null);
//                        outputDoc.insertString(outputDoc.getLength(), "Confirm?", promptStyle);
//                        outputDoc.insertString(outputDoc.getLength(), " (Y/n)", null);
//                    }
//                    break;
//                case 3:
//                    if (playerInput.equalsIgnoreCase("START")) {
//                        chapterCompleted = true;
//                    } else {
//                        outputDoc.insertString(outputDoc.getLength(), "\nHello ", null);
//                        outputDoc.insertString(outputDoc.getLength(), player.getName(), userStyle);
//                        outputDoc.insertString(outputDoc.getLength(), "! \n", null);
//                        outputDoc.insertString(outputDoc.getLength(), "Are you ready for an adventure?", conversationalStyle);
//                        outputDoc.insertString(outputDoc.getLength(), "  To START, type \"", null);
//                        outputDoc.insertString(outputDoc.getLength(), "START", promptStyle);
//                        outputDoc.insertString(outputDoc.getLength(), "\"", null);
//                    }
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        } catch (BadLocationException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
package nl.mu.model;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author mcsyt
 */
public class ChapterZero extends Chapter {

    public ChapterZero(JTextPane outputPane) {
        super(/**/"   ______ ___     ______ ______ ___     _   __ _  _____    ____   __  __ _   __ ______ ______ ____   _   __" + "\n"
                + "  / ____//   |   / ____//_  __//   |   / | / /( )/ ___/   / __ \\ / / / // | / // ____// ____// __ \\ / | / /" + "\n"
                + " / / __ / /| |  / __/    / /  / /| |  /  |/ / |/ \\__ \\   / / / // / / //  |/ // / __ / __/  / / / //  |/ / " + "\n"
                + "/ /_/ // ___ | / /___   / /  / ___ | / /|  /    ___/ /  / /_/ // /_/ // /|  // /_/ // /___ / /_/ // /|  /  " + "\n"
                + "\\____//_/  |_|/_____/  /_/  /_/  |_|/_/ |_/    /____/  /_____/ \\____//_/ |_/ \\____//_____/ \\____//_/ |_/   " + "\n", 0, new Player(), outputPane);
    }

    @Override
    public void startChapter(JTextPane outputPane) {
        //        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        super.displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane) {
        displayTextLetterByLetter("\nWhat is your name?", null, outputPane);
        chapterState++;
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        // CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style errorStyle = outputPane.addStyle("ERROR", null);
        StyleConstants.setForeground(errorStyle, Color.RED);
        Style userStyle = outputPane.addStyle("user", null);
        StyleConstants.setForeground(userStyle, Color.GREEN);
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        Style conversationalStyle = outputPane.addStyle("conversation", null);
        StyleConstants.setForeground(conversationalStyle, new Color(100, 149, 237));

        switch (chapterState) {
            case 1:
                if (playerInput.equals("")) {
                    displayTextLetterByLetter("\nPLEASE ENTER A VALID USERNAME", errorStyle, outputPane);
                } else {
                    player.setName(playerInput);
                    displayTextLetterByLetter("\nYou typed ", null, outputPane);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane);
                    displayTextLetterByLetter(". Confirm?", promptStyle, outputPane);
                    displayTextLetterByLetter(" (Y/n)", null, outputPane);
                    chapterState++;
                }
                break;
            case 2:
                if (playerInput.equalsIgnoreCase("Y")) {
                    displayTextLetterByLetter("\nHello ", null, outputPane);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane);
                    displayTextLetterByLetter("! \nAre you ready for an adventure?", conversationalStyle, outputPane);
                    displayTextLetterByLetter("  To START, type \"", null, outputPane);
                    displayTextLetterByLetter("START", promptStyle, outputPane);
                    displayTextLetterByLetter("\"", null, outputPane);
                    chapterState++;
                } else if (playerInput.equalsIgnoreCase("n")) {
                    displayTextLetterByLetter("\nWhat is your name?", null, outputPane);
                    chapterState--;
                } else {
                    displayTextLetterByLetter("\nYou typed ", null, outputPane);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane);
                    displayTextLetterByLetter(". Confirm?", promptStyle, outputPane);
                    displayTextLetterByLetter(" (Y/n)", null, outputPane);
                }
                break;
            case 3:
                if (playerInput.equalsIgnoreCase("START")) {
                    chapterCompleted = true;
                } else {
                    displayTextLetterByLetter("\nHello ", null, outputPane);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane);
                    displayTextLetterByLetter("! \nAre you ready for an adventure?", conversationalStyle, outputPane);
                    displayTextLetterByLetter("  To START, type \"", null, outputPane);
                    displayTextLetterByLetter("START", promptStyle, outputPane);
                    displayTextLetterByLetter("\"", null, outputPane);
                }
                break;
            default:
                throw new AssertionError();
        }
    }

}

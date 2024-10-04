///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package nl.mu.model;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author mcsyt
 */
public class ChapterZero extends Chapter {

    public ChapterZero(JTextPane outputPane) {
        super("""
                   ______ ___     ______ ______ ___     _   __ _  _____    ____   __  __ _   __ ______ ______ ____   _   __
                  / ____//   |   / ____//_  __//   |   / | / /( )/ ___/   / __ \\ / / / // | / // ____// ____// __ \\ / | / /
                 / / __ / /| |  / __/    / /  / /| |  /  |/ / |/ \\__ \\   / / / // / / //  |/ // / __ / __/  / / / //  |/ / 
                / /_/ // ___ | / /___   / /  / ___ | / /|  /    ___/ /  / /_/ // /_/ // /|  // /_/ // /___ / /_/ // /|  /  
                \\____//_/  |_|/_____/  /_/  /_/  |_|/_/ |_/    /____/  /_____/ \\____//_/ |_/ \\____//_____/ \\____//_/ |_/   
                """,
                0, new Player(), outputPane, new LinkedList<>(), false);
    }

    @Override
    public void startChapter(JTextPane outputPane) {
        displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane) {
        displayTextLetterByLetter("\nWhat is your name?", null, outputPane, false);
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
                    displayTextLetterByLetter("\nPLEASE ENTER A VALID USERNAME", errorStyle, outputPane, false);
                } else {
                    player.setName(playerInput);
                    displayTextLetterByLetter("\nYou typed ", null, outputPane, false);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane, false);
                    displayTextLetterByLetter(". ", null, outputPane, false);
                    displayTextLetterByLetter("Confirm?", promptStyle, outputPane, false);
                    displayTextLetterByLetter(" (Y/n)", null, outputPane, false);
                    chapterState++;
                }
                break;
            case 2:
                if (playerInput.equalsIgnoreCase("Y")) {
                    displayTextLetterByLetter("\nHello ", null, outputPane, false);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane, false);
                    displayTextLetterByLetter("! ", null, outputPane, false);
                    displayTextLetterByLetter("\nAre you ready for an adventure?", conversationalStyle, outputPane, false);
                    displayTextLetterByLetter("  To START, type \"", null, outputPane, false);
                    displayTextLetterByLetter("START", promptStyle, outputPane, false);
                    displayTextLetterByLetter("\"", null, outputPane, false);
                    chapterState++;
                } else if (playerInput.equalsIgnoreCase("n")) {
                    displayTextLetterByLetter("\nWhat is your name?", null, outputPane, false);
                    chapterState--;
                } else {
                    displayTextLetterByLetter("\nYou typed ", null, outputPane, false);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane, false);
                    displayTextLetterByLetter(". Confirm?", promptStyle, outputPane, false);
                    displayTextLetterByLetter(" (Y/n)", null, outputPane, false);
                }
                break;
            case 3:
                if (playerInput.equalsIgnoreCase("START")) {
                    clearOutputPane(outputPane);
                    chapterCompleted = true;
                } else {
                    displayTextLetterByLetter("\nHello ", null, outputPane, false);
                    displayTextLetterByLetter(player.getName(), userStyle, outputPane, false);
                    displayTextLetterByLetter("! \nAre you ready for an adventure?", conversationalStyle, outputPane, false);
                    displayTextLetterByLetter("  To START, type \"", null, outputPane, false);
                    displayTextLetterByLetter("START", promptStyle, outputPane, false);
                    displayTextLetterByLetter("\"", null, outputPane, false);
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}

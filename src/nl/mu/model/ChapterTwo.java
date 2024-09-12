/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Doos
 */
public class ChapterTwo extends Chapter {

    public ChapterTwo(Player player) {
        super(/**/"   ______ __                   __                 ___                                                 \n"
                + "  / ____// /_   ____ _ ____   / /_ ___   _____   |__ \\  _                                             \n"
                + " / /    / __ \\ / __ `// __ \\ / __// _ \\ / ___/   __/ / (_)                                            \n"
                + "/ /___ / / / // /_/ // /_/ // /_ /  __// /      / __/ _                                               \n"
                + "\\____//_/ /_/ \\__,_// .___/ \\__/ \\___//_/      /____/(_)                                              \n"
                + "         ______ __ /_/         ______       __                           ____   __   _                \n"
                + "        /_  __// /_   ___     / ____/_____ / /_   ____   _____   ____   / __/  / /_ (_)____ ___   ___ \n"
                + "         / /  / __ \\ / _ \\   / __/  / ___// __ \\ / __ \\ / ___/  / __ \\ / /_   / __// // __ `__ \\ / _ \\\n"
                + "        / /  / / / //  __/  / /___ / /__ / / / // /_/ /(__  )  / /_/ // __/  / /_ / // / / / / //  __/\n"
                + "       /_/  /_/ /_/ \\___/  /_____/ \\___//_/ /_/ \\____//____/   \\____//_/     \\__//_//_/ /_/ /_/ \\___/ \n"
                + "                                                                                                      ", 2, player);
    }

    @Override
    public void startChapter(JTextPane outputPane) {
        super.displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane, JTextPane inputPane) {
        //CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style bannerStyle = outputPane.addStyle("Yellow", null);
        StyleConstants.setForeground(bannerStyle, Color.YELLOW);
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        //START CHAPTER
        try {
            outputDoc.insertString(outputDoc.getLength(), "\n" + chapterTitle + "\n", bannerStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nThe corridor stretches on, the shadows growing darker and the air heavier. "
                    + "The rhythmic ticking sound becomes more distinct, like a heartbeat echoing through the stone walls. "
                    + "You reach a junction where the corridor splits into two paths: one leading further into the darkness, "
                    + "and the other illuminated by a faint, eerie glow.\n", narationStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Take the right path. (", null);
            outputDoc.insertString(outputDoc.getLength(), "RIGHT", promptStyle);
            outputDoc.insertString(outputDoc.getLength(), ")\n   Take the left path. (", null);
            outputDoc.insertString(outputDoc.getLength(), "LEFT", promptStyle);
            outputDoc.insertString(outputDoc.getLength(), ")", null);
            chapterState++;
        } catch (BadLocationException ex) {
            Logger.getLogger(ChapterTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        try {
            switch (chapterState) {
                case 1:
                    if (playerInput.equalsIgnoreCase("RIGHT")) {
                        outputDoc.insertString(outputDoc.getLength(), "\nYou choose the path illuminated by the eerie glow. The light grows stronger as you proceed, "
                                + "revealing strange symbols etched into the walls. The symbols are similar to those on the cloth you found earlier, "
                                + "but more intricate and glowing faintly. As you walk, you come across a small pedestal with an ancient, "
                                + "dust-covered book resting on it.", narationStyle);
                        outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Examine the book. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "EXAMINE BOOK", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")\n   Continue down the corridor. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "CONTINUE", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")\n   Turn back. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "TURN BACK", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")", null);
                        chapterState++;
                    } else if (playerInput.equalsIgnoreCase("LEFT")) {

                        chapterState++;
                    } else {
                        outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Take the right path. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "RIGHT", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")\n   Take the left path. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "LEFT", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")", null);
                    }
                    break;
                case 2:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.awt.Color;
import java.util.LinkedList;
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

    public ChapterTwo(Player player, JTextPane outputPane, LinkedList<TextToDisplay> textQueue, boolean isDisplaying) {
        super(/**/"   ______ __                   __                 ___                                                 \n"
                + "  / ____// /_   ____ _ ____   / /_ ___   _____   |__ \\  _                                             \n"
                + " / /    / __ \\ / __ `// __ \\ / __// _ \\ / ___/   __/ / (_)                                            \n"
                + "/ /___ / / / // /_/ // /_/ // /_ /  __// /      / __/ _                                               \n"
                + "\\____//_/ /_/ \\__,_// .___/ \\__/ \\___//_/      /____/(_)                                              \n"
                + "         ______ __ /_/         ______       __                           ____   __   _                \n"
                + "        /_  __// /_   ___     / ____/_____ / /_   ____   _____   ____   / __/  / /_ (_)____ ___   ___ \n"
                + "         / /  / __ \\ / _ \\   / __/  / ___// __ \\ / __ \\ / ___/  / __ \\ / /_   / __// // __ `__ \\ / _ \\\n"
                + "        / /  / / / //  __/  / /___ / /__ / / / // /_/ /(__  )  / /_/ // __/  / /_ / // / / / / //  __/\n"
                + "       /_/  /_/ /_/ \\___/  /_____/ \\___//_/ /_/ \\____//____/   \\____//_/     \\__//_//_/ /_/ /_/ \\___/ \n",
                2, player, outputPane, textQueue, isDisplaying);
    }

    @Override
    public void startChapter(JTextPane outputPane) {
        super.displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane) {
        //CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        //START CHAPTER
        displayTextLetterByLetter("\nThe corridor stretches on, the shadows growing darker and the air heavier. "
                + "The rhythmic ticking sound becomes more distinct, like a heartbeat echoing through the stone walls. "
                + "You reach a junction where the corridor splits into two paths: one leading further into the darkness, "
                + "and the other illuminated by a faint, eerie glow.\n", narationStyle, outputPane, false);
        displayTextLetterByLetter("\nCommands:\n   Take the right path. (", null, outputPane, false);
        displayTextLetterByLetter("RIGHT", promptStyle, outputPane, false);
        displayTextLetterByLetter(")\n   Take the left path. (", null, outputPane, false);
        displayTextLetterByLetter("LEFT", promptStyle, outputPane, false);
        displayTextLetterByLetter(")", null, outputPane, false);
        chapterState++;
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        switch (chapterState) {
            case 1:
                if (playerInput.equalsIgnoreCase("RIGHT")) {
                    displayTextLetterByLetter("\nYou choose the path illuminated by the eerie glow. The light grows stronger as you proceed, "
                            + "revealing strange symbols etched into the walls. The symbols are similar to those on the cloth you found earlier, "
                            + "but more intricate and glowing faintly. As you walk, you come across a small pedestal with an ancient, "
                            + "dust-covered book resting on it.", narationStyle, outputPane, false);
                    displayTextLetterByLetter("\nCommands:\n   Examine the book. (", null, outputPane, false);
                    displayTextLetterByLetter("EXAMINE BOOK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Continue down the corridor. (", null, outputPane, false);
                    displayTextLetterByLetter("CONTINUE", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Turn back. (", null, outputPane, false);
                    displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")", null, outputPane, false);
                    chapterState++;
                } else if (playerInput.equalsIgnoreCase("LEFT")) {
                    
                    chapterState++;
                } else {
                    displayTextLetterByLetter("\nCommands:\n   Take the right path. (", null, outputPane, false);
                    displayTextLetterByLetter("RIGHT", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Take the left path. (", null, outputPane, false);
                    displayTextLetterByLetter("LEFT", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")", null, outputPane, false);
                }
                break;
            case 2:
                if (playerInput.equalsIgnoreCase("RIGHT")) {

                } else if (playerInput.equalsIgnoreCase("LEFT")) {

                } else if (playerInput.equalsIgnoreCase("TURN BACK")) {

                }
                break;
            default:
                throw new AssertionError();
        }
    }
}

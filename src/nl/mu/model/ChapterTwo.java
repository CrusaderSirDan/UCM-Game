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
        displayTitle(outputPane);
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
                    displayTextLetterByLetter("You choose the path leading deeper into the darkness. The air feels colder, "
                            + "and the shadows grow thicker. After a short distance, you find a door with a complex lock mechanism. "
                            + "It seems to require a specific sequence or combination to open.", narationStyle, outputPane, false);
                    displayTextLetterByLetter("\nCommands:\n   Examine the lock mechanism. (", null, outputPane, false);
                    displayTextLetterByLetter("EXAMINE LOCK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Return to the junction. (", null, outputPane, false);
                    displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")", null, outputPane, false);
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
                if (playerInput.equalsIgnoreCase("EXAMINE BOOK")) {
                    displayTextLetterByLetter("The book is bound in old, cracked leather, and the pages are yellowed with age. "
                            + "As you open it, you see that the pages are filled with more of the mysterious symbols, "
                            + "along with faded illustrations of the dungeon. One illustration shows a figure in a dark room, "
                            + "watching over what appears to be a time loop.", narationStyle, outputPane, false);
                    displayTextLetterByLetter("\nCommands:\n   Take the book. (", null, outputPane, false);
                    displayTextLetterByLetter("TAKE BOOK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Leave the book. (", null, outputPane, false);
                    displayTextLetterByLetter("LEAVE BOOK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")", null, outputPane, false);
                } else if (playerInput.equalsIgnoreCase("CONTINUE")) {

                } else if (playerInput.equalsIgnoreCase("TURN BACK")) {
                    
                } else if (playerInput.equalsIgnoreCase("EXAMINE LOCK")) {
                    displayTextLetterByLetter("The lock mechanism is a intricate puzzle with several rotating dials and symbols. "
                            + "It looks like it might be related to the symbols you saw earlier. There’s a small inscription next to it, "
                            + "barely readable but suggesting that the correct sequence is tied to understanding the dungeon's history.", 
                            narationStyle, outputPane, false);
                    displayTextLetterByLetter("\nCommands:\n   Attempt to solve the puzzle. (", null, outputPane, false);
                    displayTextLetterByLetter("SOLVE PUZZLE", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Return to the junction. (", null, outputPane, false);
                    displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")", null, outputPane, false);
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}

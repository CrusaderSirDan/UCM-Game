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
 * @author mcsyt
 */
public class ChapterOne extends Chapter {

    public ChapterOne(Player player) {
        super(/**/"   ______ __                   __                 ___                                   \n"
                + "  / ____// /_   ____ _ ____   / /_ ___   _____   <  /_                                  \n"
                + " / /    / __ \\ / __ `// __ \\ / __// _ \\ / ___/   / /(_)                                 \n"
                + "/ /___ / / / // /_/ // /_/ // /_ /  __// /      / /_                                    \n"
                + "\\____//_/ /_/ \\__,_// .___/ \\__/ \\___//_/      /_/(_)                                   \n"
                + "         ______ __ /_/         ___                    __                 _              \n"
                + "        /_  __// /_   ___     /   | _      __ ____ _ / /__ ___   ____   (_)____   ____ _\n"
                + "         / /  / __ \\ / _ \\   / /| || | /| / // __ `// //_// _ \\ / __ \\ / // __ \\ / __ `/\n"
                + "        / /  / / / //  __/  / ___ || |/ |/ // /_/ // ,<  /  __// / / // // / / // /_/ / \n"
                + "       /_/  /_/ /_/ \\___/  /_/  |_||__/|__/ \\__,_//_/|_| \\___//_/ /_//_//_/ /_/ \\__, /  \n"
                + "                                                                               /____/   ", 0, player);
    }

    public void startChapter(JTextPane outputPane) {
        super.displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane, JTextPane inputPane) {
        //CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style bannerStyle = outputPane.addStyle("Yellow", null);
        StyleConstants.setForeground(bannerStyle, Color.YELLOW);
        Style descriptionStyle = outputPane.addStyle("DescriptionStyle", null);
        StyleConstants.setForeground(descriptionStyle, new Color(70, 70, 70));
        StyleConstants.setItalic(descriptionStyle, true);
        Style questionsStyle = outputPane.addStyle("Questions", null);
        StyleConstants.setForeground(questionsStyle, new Color(44, 117, 255));
        StyleConstants.setBold(questionsStyle, true);
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style italicNarationStyle = outputPane.addStyle("ItalicNarationStyle", null);
        StyleConstants.setForeground(italicNarationStyle, new Color(47, 79, 79));
        StyleConstants.setItalic(italicNarationStyle, true);
        Style commandStyle = outputPane.addStyle("CommandStyle", null);
        StyleConstants.setForeground(commandStyle, new Color(70, 130, 180));
        StyleConstants.setBold(commandStyle, true);
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);

        try {
            outputDoc.insertString(outputDoc.getLength(), "\n" + chapterTitle + "\n", bannerStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nDarkness surrounds you. "
                    + "The air is cold, damp, and heavy with the scent of stone and moss. "
                    + "You feel the hard ground beneath you, rough and unforgiving, "
                    + "as if the earth itself rejects your presence.\n", descriptionStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nWhere am I?\n", questionsStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nThe thought echoes in your mind as you open your eyes, "
                    + "though the darkness offers no comfort, no answers. "
                    + "A faint dripping sound is the only noise that breaks the silence, "
                    + "a slow rhythmic tap that matches the beating of your heart.\n", narationStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nYou push yourself upright, your limbs sluggish as if you've been asleep for too long. "
                    + "Blinking into the blackness, your vision slowly adjusts. Dim light flickers from a torch, "
                    + "casting weak shadows on the walls of a narrow stone room. The walls are damp, covered in uneven patches of moss, "
                    + "and the floor is cold beneath your hands\n", narationStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nWho am I?\n", questionsStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nYour mind is blank. No memories, no identity. Just a sense of loss, of being ", narationStyle);
            outputDoc.insertString(outputDoc.getLength(), "stuck", italicNarationStyle);
            outputDoc.insertString(outputDoc.getLength(), ".\n\nA rusty iron door stands before you. It creaks softly, moving slightly as though inviting you to leave, "
                    + "but also warning you that what lies beyond may not be what you hope for. There are no windows, no exits except for the door, "
                    + "and the flickering light grows dimmer with each passing moment.\n", narationStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Examine the room. (", null);
            outputDoc.insertString(outputDoc.getLength(), "EXAMINE ROOM", promptStyle);
            outputDoc.insertString(outputDoc.getLength(), ")\n   Open the door. (", null);
            outputDoc.insertString(outputDoc.getLength(), "OPEN DOOR", promptStyle);
            outputDoc.insertString(outputDoc.getLength(), ")\n", null);
            chapterState++;
        } catch (BadLocationException ex) {
            Logger.getLogger(ChapterOne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        //CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style bannerStyle = outputPane.addStyle("Yellow", null);
        StyleConstants.setForeground(bannerStyle, Color.YELLOW);
        Style descriptionStyle = outputPane.addStyle("DescriptionStyle", null);
        StyleConstants.setForeground(descriptionStyle, new Color(70, 70, 70));
        StyleConstants.setItalic(descriptionStyle, true);
        Style questionsStyle = outputPane.addStyle("Questions", null);
        StyleConstants.setForeground(questionsStyle, new Color(44, 117, 255));
        StyleConstants.setBold(questionsStyle, true);
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style italicNarationStyle = outputPane.addStyle("ItalicNarationStyle", null);
        StyleConstants.setForeground(italicNarationStyle, new Color(47, 79, 79));
        StyleConstants.setItalic(italicNarationStyle, true);
        Style commandStyle = outputPane.addStyle("CommandStyle", null);
        StyleConstants.setForeground(commandStyle, new Color(70, 130, 180));
        StyleConstants.setBold(commandStyle, true);
        Style errorStyle = outputPane.addStyle("ERROR", null);
        StyleConstants.setForeground(errorStyle, Color.RED);
        Style userStyle = outputPane.addStyle("user", null);
        StyleConstants.setForeground(userStyle, Color.GREEN);
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        Style conversationalStyle = outputPane.addStyle("conversation", null);
        StyleConstants.setForeground(conversationalStyle, new Color(100, 149, 237));
        try {
            switch (chapterState) {
                case 1:
                    if (playerInput.equalsIgnoreCase("EXAMINE ROOM")) {
                        outputDoc.insertString(outputDoc.getLength(), "\nYou glance around the small stone chamber. "
                                + "The walls are bare, except for the patches of moss that cling to the stone like unwelcome guests. "
                                + "In the far corner, you notice a small object, half-hidden in shadow. It's a scrap of cloth, torn and dirty, "
                                + "but there is something strange about it.", narationStyle);
                    } else if (playerInput.equalsIgnoreCase("OPEN DOOR")) {

                        chapterState++;
                    } else {

                    }
                    break;
                case 2:
                    if (playerInput.equalsIgnoreCase("Y")) {

                        chapterState++;
                    } else if (playerInput.equalsIgnoreCase("n")) {

                        chapterState++;
                    } else {

                    }
                    break;
                case 3:
                    if (playerInput.equalsIgnoreCase("START")) {

                    } else {

                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}

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
                + "                                                                               /____/   ", 1, player);
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
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        //START CHAPTER
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
            outputDoc.insertString(outputDoc.getLength(), ".\n\nA rusty iron door stands before you. It creaks softly, "
                    + "moving slightly as though inviting you to leave, "
                    + "but also warning you that what lies beyond may not be what you hope for. There are no windows, no exits except for the door, "
                    + "and the flickering light grows dimmer with each passing moment.\n", narationStyle);
            outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Examine the room. (", null);
            outputDoc.insertString(outputDoc.getLength(), "EXAMINE ROOM", promptStyle);
            outputDoc.insertString(outputDoc.getLength(), ")\n   Open the door. (", null);
            outputDoc.insertString(outputDoc.getLength(), "OPEN DOOR", promptStyle);
            outputDoc.insertString(outputDoc.getLength(), ")", null);
            chapterState++;
        } catch (BadLocationException ex) {
            Logger.getLogger(ChapterOne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        //CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
        Style questionsStyle = outputPane.addStyle("Questions", null);
        StyleConstants.setForeground(questionsStyle, new Color(44, 117, 255));
        StyleConstants.setBold(questionsStyle, true);
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style boldNarationStyle = outputPane.addStyle("BoldNarationStyle", null);
        StyleConstants.setForeground(boldNarationStyle, new Color(47, 79, 79));
        StyleConstants.setBold(boldNarationStyle, true);
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
        Style dungeonStyle = outputPane.addStyle("haunted", null);
        StyleConstants.setForeground(dungeonStyle, new Color(173, 216, 230));
        StyleConstants.setItalic(dungeonStyle, true);
        //LIST THE CHOICES
        try {
            switch (chapterState) {
                case 1:
                    if (!cameBack) {
                        if (playerInput.equalsIgnoreCase("EXAMINE ROOM")) {
                            outputDoc.insertString(outputDoc.getLength(), "\nYou glance around the small stone chamber. "
                                    + "The walls are bare, except for the patches of moss that cling to the stone like unwelcome guests. "
                                    + "In the far corner, you notice a small object, half-hidden in shadow. It's a scrap of cloth, torn and dirty, "
                                    + "but there is something strange about it.\n", narationStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\nPick up the cloth\n", questionsStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\nYou reach down and feel the fabric between your fingers. "
                                    + "It’s rough, but as you hold it up to the light, you see faint, almost invisible markings—symbols, "
                                    + "scribbled hastily. They seem familiar, but you can't place them. "
                                    + "There’s nothing else of note in the room.\n", narationStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Open the door. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "OPEN DOOR", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")", null);
                            checkedRoom = true;
                        } else if (playerInput.equalsIgnoreCase("OPEN DOOR")) {
                            outputDoc.insertString(outputDoc.getLength(), "\nYou stand before the iron door, its surface pitted with rust and decay. "
                                    + "As you reach for the handle, you hesitate. Something about the air beyond the door feels… different. "
                                    + "A sense of unease washes over you, but there’s no other way forward. The room behind you offers no solace.\n"
                                    + "\nYou pull the door open slowly, the hinges groaning in protest. "
                                    + "Beyond the threshold, a long, narrow corridor stretches into the shadows, lit only by the occasional flickering torch. "
                                    + "The walls here are even more worn, as though time itself has been slowly eroding them. "
                                    + "The air feels heavier here.\n", narationStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\nAs you step into the corridor, "
                                    + "a voice echoes faintly from deep within the dungeon.\n", boldNarationStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\n\"You are not the first...\"\n", dungeonStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\nIt’s barely a whisper, too faint to be certain if it’s real or just your imagination, "
                                    + "but the words linger in your mind. They leave a sense of urgency, but also a strange comfort, "
                                    + "as if someone, somewhere, knows what you are going through.", narationStyle);
                            outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Follow the corridor. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "FOLLOW CORRIDOR", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")\n   Turn back. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "TURN BACK", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")", null);
                            chapterState++;
                        } else {
                            outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Examine the room. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "EXAMINE ROOM", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")\n   Open the door. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "OPEN DOOR", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")", null);
                        }
                    } else if (cameBack) {
                        if (!checkedRoom) {
                            if (playerInput.equalsIgnoreCase("EXAMINE ROOM")) {
                                outputDoc.insertString(outputDoc.getLength(), "\nYou glance around the small stone chamber. "
                                        + "The walls are bare, except for the patches of moss that cling to the stone like unwelcome guests. "
                                        + "In the far corner, you notice a small object, half-hidden in shadow. It's a scrap of cloth, torn and dirty, "
                                        + "but there is something strange about it.\n", narationStyle);
                                outputDoc.insertString(outputDoc.getLength(), "\nPick up the cloth\n", questionsStyle);
                                outputDoc.insertString(outputDoc.getLength(), "\nYou reach down and feel the fabric between your fingers. "
                                        + "It’s rough, but as you hold it up to the light, you see faint, almost invisible markings—symbols, "
                                        + "scribbled hastily. They seem familiar, but you can't place them. "
                                        + "There’s nothing else of note in the room.\n", narationStyle);
                                outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Reopen the door. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "REOPEN DOOR", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")", null);
                                checkedRoom = true;
                            } else if (playerInput.equalsIgnoreCase("REOPEN DOOR")) {
                                outputDoc.insertString(outputDoc.getLength(), "\nYou carefully open the door once more. "
                                        + "The corridor stretches out before you, just as you left it, "
                                        + "with the same eerie glow and rhythmic ticking echoing in the distance.", narationStyle);
                                outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Follow the corridor. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "FOLLOW CORRIDOR", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")\n   Turn back. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "TURN BACK", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")", null);
                                chapterState++;
                            } else {
                                outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Examine the room. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "EXAMINE ROOM", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")\n   Reopen the door. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "REOPEN DOOR", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")", null);
                            }
                        } else if (checkedRoom) {
                            if (playerInput.equalsIgnoreCase("REEXAMINE ROOM")) {
                                outputDoc.insertString(outputDoc.getLength(), "\nYou take another look around the room. "
                                        + "The stone walls and dim light seem unchanged, but you notice new details or "
                                        + "subtle differences that might have been missed before.", narationStyle);
                                outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Reopen the door. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "REOPEN DOOR", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")", null);
                            } else if (playerInput.equalsIgnoreCase("REOPEN DOOR")) {
                                outputDoc.insertString(outputDoc.getLength(), "\nYou carefully open the door once more. "
                                        + "The corridor stretches out before you, just as you left it, "
                                        + "with the same eerie glow and rhythmic ticking echoing in the distance.", narationStyle);
                                outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Follow the corridor. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "FOLLOW CORRIDOR", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")\n   Turn back. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "TURN BACK", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")", null);
                                chapterState++;
                            } else {
                                outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Reexamine the room. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "REEXAMINE ROOM", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")\n   Reopen the door. (", null);
                                outputDoc.insertString(outputDoc.getLength(), "REOPEN DOOR", promptStyle);
                                outputDoc.insertString(outputDoc.getLength(), ")", null);
                            }
                        }
                        cameBack = false;
                    }
                    break;

                case 2:
                    if (playerInput.equalsIgnoreCase("FOLLOW CORRIDOR")) {
                        outputDoc.insertString(outputDoc.getLength(), "\nYou press forward, the light from the torches casting faint shadows"
                                + " along the rough-hewn walls. The sound of your footsteps is swallowed by the silence, "
                                + "yet the presence of something—or someone—seems to linger just beyond the reach of your senses.\n"
                                + "\nAs you move deeper, the corridor begins to shift. The stone beneath your feet feels uneven, "
                                + "and the walls seem to close in slightly. In the distance, you hear a faint sound. It’s a slow, "
                                + "rhythmic ticking, like the sound of a clock, though no such device is visible.", narationStyle);
                        chapterCompleted = true;
                    } else if (playerInput.equalsIgnoreCase("TURN BACK")) {
                        outputDoc.insertString(outputDoc.getLength(), "\nYou hesitate at the entrance to the corridor, "
                                + "feeling the weight of the decision to retreat. As you turn around, the dim light from the torch flickers ominously. "
                                + "The small stone chamber behind you looks unchanged, but a shiver runs down your spine as you sense that the darkness "
                                + "beyond the door is no longer as inviting as it seemed.\n\nThe iron door creaks softly as you close it behind you, "
                                + "and you feel an unsettling quiet settle over the room. The rhythmic dripping of water is now the only sound, "
                                + "echoing off the cold stone walls. It feels as though the dungeon itself is waiting for you to reconsider, "
                                + "a silent pressure urging you to explore further.", narationStyle);
                        outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Reopen the door. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "REOPEN DOOR", promptStyle);
                        if (checkedRoom) {
                            outputDoc.insertString(outputDoc.getLength(), ")\n   Examine the room again. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "REEXAMINE ROOM", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")", null);
                        } else if (!checkedRoom) {
                            outputDoc.insertString(outputDoc.getLength(), ")\n   Examine the room. (", null);
                            outputDoc.insertString(outputDoc.getLength(), "EXAMINE ROOM", promptStyle);
                            outputDoc.insertString(outputDoc.getLength(), ")", null);
                        }
                        cameBack = true;
                        chapterState--;
                    } else {
                        outputDoc.insertString(outputDoc.getLength(), "\nCommands:\n   Follow the Corridor. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "FOLLOW CORRIDOR", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")\n   Turn back. (", null);
                        outputDoc.insertString(outputDoc.getLength(), "TURN BACK", promptStyle);
                        outputDoc.insertString(outputDoc.getLength(), ")", null);
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

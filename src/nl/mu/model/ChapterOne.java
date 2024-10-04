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
 * @author mcsyt
 */
public class ChapterOne extends Chapter {

    protected boolean checkedRoom = false;

    public ChapterOne(Player player, JTextPane outputPane, LinkedList<TextToDisplay> textQueue, boolean isDisplaying) {
        super("""
                   ______ __                   __                 ___                                   
                  / ____// /_   ____ _ ____   / /_ ___   _____   <  /_                                  
                 / /    / __ \\ / __ `// __ \\ / __// _ \\ / ___/   / /(_)                                 
                / /___ / / / // /_/ // /_/ // /_ /  __// /      / /_                                    
                \\____//_/ /_/ \\__,_// .___/ \\__/ \\___//_/      /_/(_)                                   
                         ______ __ /_/         ___                    __                 _              
                        /_  __// /_   ___     /   | _      __ ____ _ / /__ ___   ____   (_)____   ____ _
                         / /  / __ \\ / _ \\   / /| || | /| / // __ `// //_// _ \\ / __ \\ / // __ \\ / __ `/
                        / /  / / / //  __/  / ___ || |/ |/ // /_/ // ,<  /  __// / / // // / / // /_/ / 
                       /_/  /_/ /_/ \\___/  /_/  |_||__/|__/ \\__,_//_/|_| \\___//_/ /_//_//_/ /_/ \\__, /  
                                                                                               /____/   """,
                1, player, outputPane, textQueue, isDisplaying);
    }

    public void startChapter(JTextPane outputPane) {
        displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane) {
        //CREATE THE STYLES
        StyledDocument outputDoc = outputPane.getStyledDocument();
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
        displayTextLetterByLetter("\nDarkness surrounds you. The air is cold, damp, and heavy with the scent of stone and moss,"
                + " as if the very dungeon breathes. You feel the rough ground beneath you—cold, jagged, unforgiving. A distant,"
                + " faint dripping sound echoes through the chamber, like a clock counting the seconds you've been here.\n", descriptionStyle, outputPane, false);
        displayTextLetterByLetter("\nWhere am I?\n", questionsStyle, outputPane, false);
        displayTextLetterByLetter("\nThe thought echoes in your mind like a plea for understanding,"
                + " but the silence offers no answers. You blink, your eyes heavy and stinging, as you try to adjust to the darkness."
                + " Faint shadows dance in the weak light of a flickering torch, casting twisted figures along the stone walls."
                + " The walls, slick with moisture, seem to close in around you, suffocating in their silence.\n", narationStyle, outputPane, false);
        displayTextLetterByLetter("\nYou push yourself upright, your limbs sluggish as if you've been asleep for too long.\n", narationStyle, outputPane, false);
        displayTextLetterByLetter("\nWho am I?\n", questionsStyle, outputPane, false);
        displayTextLetterByLetter("\nYour mind is blank. No memories, no identity. Just a sense of loss, of being ", narationStyle, outputPane, false);
        displayTextLetterByLetter("stuck", italicNarationStyle, outputPane, false);
        displayTextLetterByLetter(".\n\nA rusty iron door stands before you. It creaks softly, "
                + "moving slightly as though inviting you to leave, "
                + "but also warning you that what lies beyond may not be what you hope for. There are no windows, no exits except for the door, "
                + "and the flickering light grows dimmer with each passing moment.\n", narationStyle, outputPane, false);
        displayTextLetterByLetter("\nCommands:\n   Examine the room. (", null, outputPane, false);
        displayTextLetterByLetter("EXAMINE ROOM", promptStyle, outputPane, false);
        displayTextLetterByLetter(")\n   Open the door. (", null, outputPane, false);
        displayTextLetterByLetter("OPEN DOOR", promptStyle, outputPane, false);
        displayTextLetterByLetter(")", null, outputPane, false);
        chapterState++;
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
        switch (chapterState) {
            case 1:
                if (!cameBack) {
                    if (playerInput.equalsIgnoreCase("EXAMINE ROOM")) {
                        examineRoom(playerInput, outputPane);
                        checkedRoom = true;
                    } else if (playerInput.equalsIgnoreCase("OPEN DOOR")) {
                        displayTextLetterByLetter("\nYou stand before the iron door, its surface pitted with rust and decay. "
                                + "As you reach for the handle, you hesitate. Something about the air beyond the door feels… different. "
                                + "A sense of unease washes over you, but there’s no other way forward. The room behind you offers no solace.\n"
                                + "\nYou pull the door open slowly, the hinges groaning in protest. "
                                + "Beyond the threshold, a long, narrow corridor stretches into the shadows, lit only by the occasional flickering torch. "
                                + "The walls here are even more worn, as though time itself has been slowly eroding them. "
                                + "The air feels heavier here.\n", narationStyle, outputPane, false);
                        displayTextLetterByLetter("\nAs you step into the corridor, "
                                + "a voice echoes faintly from deep within the dungeon.\n", boldNarationStyle, outputPane, false);
                        displayTextLetterByLetter("\n\"You are not the first...\"\n", dungeonStyle, outputPane, false);
                        displayTextLetterByLetter("\nIt’s barely a whisper, too faint to be certain if it’s real or just your imagination, "
                                + "but the words linger in your mind. They leave a sense of urgency, but also a strange comfort, "
                                + "as if someone, somewhere, knows what you are going through.", narationStyle, outputPane, false);
                        displayTextLetterByLetter("\nCommands:\n   Follow the corridor. (", null, outputPane, false);
                        displayTextLetterByLetter("FOLLOW CORRIDOR", promptStyle, outputPane, false);
                        displayTextLetterByLetter(")\n   Turn back. (", null, outputPane, false);
                        displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                        displayTextLetterByLetter(")", null, outputPane, false);
                        chapterState++;
                    } else {
                        displayTextLetterByLetter("\nCommands:\n   Examine the room. (", null, outputPane, false);
                        displayTextLetterByLetter("EXAMINE ROOM", promptStyle, outputPane, false);
                        displayTextLetterByLetter(")\n   Open the door. (", null, outputPane, false);
                        displayTextLetterByLetter("OPEN DOOR", promptStyle, outputPane, false);
                        displayTextLetterByLetter(")", null, outputPane, false);
                    }
                } else if (cameBack) {
                    if (!checkedRoom) {
                        if (playerInput.equalsIgnoreCase("EXAMINE ROOM")) {
                            examineRoom(playerInput, outputPane);
                            checkedRoom = true;
                        } else if (playerInput.equalsIgnoreCase("REOPEN DOOR")) {
                            displayTextLetterByLetter("\nYou carefully open the door once more. "
                                    + "The corridor stretches out before you, just as you left it, "
                                    + "with the same eerie glow and rhythmic ticking echoing in the distance.", narationStyle, outputPane, false);
                            displayTextLetterByLetter("\nCommands:\n   Follow the corridor. (", null, outputPane, false);
                            displayTextLetterByLetter("FOLLOW CORRIDOR", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")\n   Turn back. (", null, outputPane, false);
                            displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")", null, outputPane, false);
                            chapterState++;
                        } else {
                            displayTextLetterByLetter("\nCommands:\n   Examine the room. (", null, outputPane, false);
                            displayTextLetterByLetter("EXAMINE ROOM", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")\n   Reopen the door. (", null, outputPane, false);
                            displayTextLetterByLetter("REOPEN DOOR", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")", null, outputPane, false);
                        }
                    } else if (checkedRoom) {
                        if (playerInput.equalsIgnoreCase("REEXAMINE ROOM")) {
                            displayTextLetterByLetter("\nYou take another look around the room. "
                                    + "The stone walls and dim light seem unchanged, but you notice new details or "
                                    + "subtle differences that might have been missed before.", narationStyle, outputPane, false);
                            displayTextLetterByLetter("\nCommands:\n   Reopen the door. (", null, outputPane, false);
                            displayTextLetterByLetter("REOPEN DOOR", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")", null, outputPane, false);
                        } else if (playerInput.equalsIgnoreCase("REOPEN DOOR")) {
                            displayTextLetterByLetter("\nYou carefully open the door once more. "
                                    + "The corridor stretches out before you, just as you left it, "
                                    + "with the same eerie glow and rhythmic ticking echoing in the distance.", narationStyle, outputPane, false);
                            displayTextLetterByLetter("\nCommands:\n   Follow the corridor. (", null, outputPane, false);
                            displayTextLetterByLetter("FOLLOW CORRIDOR", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")\n   Turn back. (", null, outputPane, false);
                            displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")", null, outputPane, false);
                            chapterState++;
                        } else {
                            displayTextLetterByLetter("\nCommands:\n   Reexamine the room. (", null, outputPane, false);
                            displayTextLetterByLetter("REEXAMINE ROOM", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")\n   Reopen the door. (", null, outputPane, false);
                            displayTextLetterByLetter("REOPEN DOOR", promptStyle, outputPane, false);
                            displayTextLetterByLetter(")", null, outputPane, false);
                        }
                    }
                }
                break;
            case 2:
                if (playerInput.equalsIgnoreCase("FOLLOW CORRIDOR")) {
                    displayTextLetterByLetter("\nYou press forward, the light from the torches casting faint shadows"
                            + " along the rough-hewn walls. The sound of your footsteps is swallowed by the silence, "
                            + "yet the presence of something — or someone — seems to linger just beyond the reach of your senses.\n"
                            + "\nAs you move deeper, the corridor begins to shift. The stone beneath your feet feels uneven, "
                            + "and the walls seem to close in slightly. In the distance, you hear a faint sound. It’s a slow, "
                            + "rhythmic ticking, like the sound of a clock, though no such device is visible.", narationStyle, outputPane, false);
                    displayTextLetterByLetter("\n                   You have reached the end of Chapter One. Press ", null, outputPane, false);
                    displayTextLetterByLetter("ENTER", promptStyle, outputPane, false);
                    displayTextLetterByLetter(" to start Chapter Two", null, outputPane, false);
                    chapterState++;
                } else if (playerInput.equalsIgnoreCase("TURN BACK")) {
                    displayTextLetterByLetter("\nYou hesitate at the entrance to the corridor, "
                            + "feeling the weight of the decision to retreat. As you turn around, the dim light from the torch flickers ominously. "
                            + "The small stone chamber behind you looks unchanged, but a shiver runs down your spine as you sense that the darkness "
                            + "beyond the door is no longer as inviting as it seemed.\n\nThe iron door creaks softly as you close it behind you, "
                            + "and you feel an unsettling quiet settle over the room. The rhythmic dripping of water is now the only sound, "
                            + "echoing off the cold stone walls. It feels as though the dungeon itself is waiting for you to reconsider, "
                            + "a silent pressure urging you to explore further.", narationStyle, outputPane, false);
                    displayTextLetterByLetter("\nCommands:\n   Reopen the door. (", null, outputPane, false);
                    displayTextLetterByLetter("REOPEN DOOR", promptStyle, outputPane, false);
                    if (checkedRoom) {
                        displayTextLetterByLetter(")\n   Examine the room again. (", null, outputPane, false);
                        displayTextLetterByLetter("REEXAMINE ROOM", promptStyle, outputPane, false);
                        displayTextLetterByLetter(")", null, outputPane, false);
                    } else if (!checkedRoom) {
                        displayTextLetterByLetter(")\n   Examine the room. (", null, outputPane, false);
                        displayTextLetterByLetter("EXAMINE ROOM", promptStyle, outputPane, false);
                        displayTextLetterByLetter(")", null, outputPane, false);
                    }
                    cameBack = true;
                    chapterState--;
                } else {
                    displayTextLetterByLetter("\nCommands:\n   Follow the Corridor. (", null, outputPane, false);
                    displayTextLetterByLetter("FOLLOW CORRIDOR", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")\n   Turn back. (", null, outputPane, false);
                    displayTextLetterByLetter("TURN BACK", promptStyle, outputPane, false);
                    displayTextLetterByLetter(")", null, outputPane, false);
                }
                break;
            case 3:
                if (playerInput != null) {
                    chapterCompleted = true;
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    public void examineRoom(String playerInput, JTextPane outputPane) {
        Style questionsStyle = outputPane.addStyle("Questions", null);
        StyleConstants.setForeground(questionsStyle, new Color(44, 117, 255));
        StyleConstants.setBold(questionsStyle, true);
        Style narationStyle = outputPane.addStyle("NarationStyle", null);
        StyleConstants.setForeground(narationStyle, new Color(47, 79, 79));
        Style promptStyle = outputPane.addStyle("prompt", null);
        StyleConstants.setForeground(promptStyle, Color.YELLOW);
        displayTextLetterByLetter("\nYou glance around the small stone chamber. "
                + "The walls are bare, except for the patches of moss that cling to the stone like unwelcome guests. "
                + "In the far corner, you notice a small object, half-hidden in shadow. It's a scrap of cloth, torn and dirty, "
                + "but there is something strange about it.\n", narationStyle, outputPane, false);
        displayTextLetterByLetter("\nPick up the cloth\n", questionsStyle, outputPane, false);
        displayTextLetterByLetter("\nYou reach down and feel the fabric between your fingers. "
                + "It’s rough, but as you hold it up to the light, you see faint, almost invisible markings—symbols, "
                + "scribbled hastily. They seem familiar, but you can't place them. "
                + "There’s nothing else of note in the room.\n", narationStyle, outputPane, false);
        displayTextLetterByLetter("\nCommands:\n   Open the door. (", null, outputPane, false);
        displayTextLetterByLetter("OPEN DOOR", promptStyle, outputPane, false);
        displayTextLetterByLetter(")", null, outputPane, false);
    }
}

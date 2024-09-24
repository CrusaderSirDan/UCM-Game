/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Doos
 */
public class ChapterThree extends Chapter {

    public ChapterThree(Player player, JTextPane outputPane, LinkedList<TextToDisplay> textQueue, boolean isDisplaying) {
        super("""
                 ______ __                   __                 _____                                                                                  
                / ____// /_   ____ _ ____   / /_ ___   _____   |__  / _                                                                                
               / /    / __ \\ / __ `// __ \\ / __// _ \\ / ___/    /_ < (_)                                                                               
              / /___ / / / // /_/ // /_/ // /_ /  __// /      ___/ /_                                                                                  
              \\____//_/ /_/ \\__,_// .___/ \\__/ \\___//_/      /____/(_)                                                                                 
                       ______ __ /_/         ______ _                __   ______               ____                     __          __   _             
                      /_  __// /_   ___     / ____/(_)____   ____ _ / /  / ____/____   ____   / __/_____ ____   ____   / /_ ____ _ / /_ (_)____   ____ 
                       / /  / __ \\ / _ \\   / /_   / // __ \\ / __ `// /  / /    / __ \\ / __ \\ / /_ / ___// __ \\ / __ \\ / __// __ `// __// // __ \\ / __ \\
                      / /  / / / //  __/  / __/  / // / / // /_/ // /  / /___ / /_/ // / / // __// /   / /_/ // / / // /_ / /_/ // /_ / // /_/ // / / /
                     /_/  /_/ /_/ \\___/  /_/    /_//_/ /_/ \\__,_//_/   \\____/ \\____//_/ /_//_/  /_/    \\____//_/ /_/ \\__/ \\__,_/ \\__//_/ \\____//_/ /_/ 
                                                                                                                                                       """,
                3, player, outputPane, textQueue, isDisplaying);
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
        displayTextLetterByLetter("\n", null, outputPane, false);
        chapterState++;
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {

    }

}

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
        //START CHAPTER
        try {
            outputDoc.insertString(outputDoc.getLength(), "\n"+chapterTitle+"\n", bannerStyle);
            outputDoc.insertString(outputDoc.getLength(), "The corridor stretches on, the shadows growing darker and the air heavier. "
                    + "The rhythmic ticking sound becomes more distinct, like a heartbeat echoing through the stone walls. "
                    + "You reach a junction where the corridor splits into two paths: one leading further into the darkness, "
                    + "and the other illuminated by a faint, eerie glow.", narationStyle);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(ChapterTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

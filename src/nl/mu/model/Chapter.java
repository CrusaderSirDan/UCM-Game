/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author mcsyt
 */
public abstract class Chapter {

    protected String chapterTitle;

    public Chapter(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public abstract void startChapter();

    public void displayTitle(JTextPane outputPane) {
        try {
            outputPane.getStyledDocument().insertString(outputPane.getStyledDocument().getLength(),
                    "\nStarting next chapter: \n" + chapterTitle + "\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public abstract void play(JTextPane outputPane, JTextPane inputPane);
}

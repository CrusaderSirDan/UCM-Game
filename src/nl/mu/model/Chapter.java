/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author mcsyt
 */
public abstract class Chapter {
    protected int chapter;
    protected int chapterState=0;
    protected String chapterTitle;
    protected Player player;
    protected boolean chapterCompleted=false;

    public Chapter(String chapterTitle, int chapter, Player player) {
        this.chapterTitle = chapterTitle;
        this.chapter=chapter;
        this.player=player;
    }

    public abstract void startChapter(JTextPane outputPane);

    public void displayTitle(JTextPane outputPane) {
        try {
            outputPane.getStyledDocument().insertString(outputPane.getStyledDocument().getLength(),
                    "\nStarting next chapter: \n" + chapterTitle + "\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public abstract void play(JTextPane outputPane, JTextPane inputPane);
    
    public abstract void processChoice(String playerInput, JTextPane outputPane);

    public int getChapter() {
        return chapter;
    }

    public Player getPlayer() {
        return player;
    }

    public int getChapterState() {
        return chapterState;
    }

    public boolean isChapterCompleted() {
        return chapterCompleted;
    }

    public void setChapterCompleted(boolean chapterCompleted) {
        this.chapterCompleted = chapterCompleted;
    }
}

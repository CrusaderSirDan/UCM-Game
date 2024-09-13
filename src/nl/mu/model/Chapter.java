/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author mcsyt
 */
public abstract class Chapter {

    protected int chapter;
    protected int chapterState = 0;
    protected String chapterTitle;
    protected Player player;
    protected boolean chapterCompleted = false;
    protected boolean cameBack = false;
    protected boolean checkedRoom = false;
    protected boolean outputPrinted = false;
    protected Queue<Chapter.TextToDisplay> textQueue = new LinkedList<>(); // Queue to handle sequential text display
    protected boolean isDisplaying = false;
    private final String BYLINE = "By: Gaëtan D. E. A. Doos\n";

    public Chapter(String chapterTitle, int chapter, Player player, JTextPane outputPane) {
        this.chapterTitle = chapterTitle;
        this.chapter = chapter;
        this.player = player;
        startChapter(outputPane);
    }

    public abstract void startChapter(JTextPane outputPane);

    public void displayTitle(JTextPane outputPane) {
        if (this instanceof ChapterZero) {
            StyledDocument outputDoc = outputPane.getStyledDocument();
            Style bannerStyle = outputPane.addStyle("Yellow", null);
            StyleConstants.setForeground(bannerStyle, Color.YELLOW);
            Style byLineStyle = outputPane.addStyle("Silver", null);
            StyleConstants.setForeground(byLineStyle, new Color(192, 192, 192));
            displayBannerLineByLine("\n" + chapterTitle + "\n", bannerStyle, outputPane);
            displayTextLetterByLetter(BYLINE, byLineStyle, outputPane);
        } else {
            StyledDocument outputDoc = outputPane.getStyledDocument();
            Style bannerStyle = outputPane.addStyle("Yellow", null);
            StyleConstants.setForeground(bannerStyle, Color.YELLOW);
            displayBannerLineByLine("\n" + chapterTitle + "\n", bannerStyle, outputPane);
        }
    }

    public boolean isIsDisplaying() {
        return isDisplaying;
    }

    public abstract void play(JTextPane outputPane);

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

    // Method to display text letter by letter with a delay
    protected void displayTextLetterByLetter(String text, Style style, JTextPane outputPane) {
        textQueue.add(new TextToDisplay(text, style, outputPane, false)); // Queue the text to be displayed
        processNextText(); // Start processing if not already displaying
    }

    // Method to display banner char by char with a delay
    protected void displayBannerLineByLine(String banner, Style style, JTextPane outputPane) {
        textQueue.add(new TextToDisplay(banner, style, outputPane, true)); // Queue the text to be displayed
        processNextText(); // Start processing if not already displaying
    }

    // Helper method to process the next text in the queue
    private void processNextText() {
        if (isDisplaying || textQueue.isEmpty()) {
            return; // Don't process if something is already being displayed
        }

        TextToDisplay nextText = textQueue.poll();
        if (nextText != null && !nextText.isBanner) {
            StyledDocument outputDoc = nextText.outputPane.getStyledDocument();
            Timer timer = new Timer(50, null); // 50ms delay for each character

            ActionListener actionListener = new ActionListener() {
                private int index = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (index < nextText.text.length()) {
                            outputDoc.insertString(outputDoc.getLength(), String.valueOf(nextText.text.charAt(index)), nextText.style);
                            index++;
                        } else {
                            ((Timer) e.getSource()).stop(); // Stop the timer once text is fully displayed
                            isDisplaying = false; // Ready for the next text
                            processNextText(); // Process the next text in the queue
                        }
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            isDisplaying = true; // Mark as currently displaying text
            timer.addActionListener(actionListener);
            timer.start(); // Start the timer to display text letter by letter
        } else if (nextText != null && nextText.isBanner) {
            StyledDocument outputDoc = nextText.outputPane.getStyledDocument();
            String[] lines = nextText.text.split("\n"); // Split the text into lines
            Timer timer = new Timer(500, null); // 1000ms (1 second) delay between lines

            ActionListener actionListener = new ActionListener() {
                private int lineIndex = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (lineIndex < lines.length) {
                            // Insert the current line
                            outputDoc.insertString(outputDoc.getLength(), lines[lineIndex] + "\n", nextText.style);
                            lineIndex++;
                        } else {
                            ((Timer) e.getSource()).stop(); // Stop the timer once all lines are displayed
                            isDisplaying = false; // Ready for the next text
                            processNextText(); // Process the next text in the queue
                        }
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            isDisplaying = true; // Mark as currently displaying text
            timer.addActionListener(actionListener);
            timer.start(); // Start the timer to display lines one by one
        }
    }

    // Helper class to store text to display and its style
    private static class TextToDisplay {

        String text;
        Style style;
        JTextPane outputPane;
        boolean isBanner;

        public TextToDisplay(String text, Style style, JTextPane outputPane, boolean isBanner) {
            this.text = text;
            this.style = style;
            this.outputPane = outputPane;
            this.isBanner = isBanner;
        }
    }
}

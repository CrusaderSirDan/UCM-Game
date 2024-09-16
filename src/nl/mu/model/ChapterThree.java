/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.util.LinkedList;
import javax.swing.JTextPane;

/**
 *
 * @author Doos
 */
public class ChapterThree extends Chapter {

    public ChapterThree(Player player, JTextPane outputPane, LinkedList<TextToDisplay> textQueue, boolean isDisplaying) {
        super(/**/"   ______ __                   __                 _____                                                                                  \n"
                + "  / ____// /_   ____ _ ____   / /_ ___   _____   |__  / _                                                                                \n"
                + " / /    / __ \\ / __ `// __ \\ / __// _ \\ / ___/    /_ < (_)                                                                               \n"
                + "/ /___ / / / // /_/ // /_/ // /_ /  __// /      ___/ /_                                                                                  \n"
                + "\\____//_/ /_/ \\__,_// .___/ \\__/ \\___//_/      /____/(_)                                                                                 \n"
                + "         ______ __ /_/         ______ _                __   ______               ____                     __          __   _             \n"
                + "        /_  __// /_   ___     / ____/(_)____   ____ _ / /  / ____/____   ____   / __/_____ ____   ____   / /_ ____ _ / /_ (_)____   ____ \n"
                + "         / /  / __ \\ / _ \\   / /_   / // __ \\ / __ `// /  / /    / __ \\ / __ \\ / /_ / ___// __ \\ / __ \\ / __// __ `// __// // __ \\ / __ \\\n"
                + "        / /  / / / //  __/  / __/  / // / / // /_/ // /  / /___ / /_/ // / / // __// /   / /_/ // / / // /_ / /_/ // /_ / // /_/ // / / /\n"
                + "       /_/  /_/ /_/ \\___/  /_/    /_//_/ /_/ \\__,_//_/   \\____/ \\____//_/ /_//_/  /_/    \\____//_/ /_/ \\__/ \\__,_/ \\__//_/ \\____//_/ /_/ \n"
                + "                                                                                                                                         ", 
                3, player, outputPane, textQueue, isDisplaying);
    }

    @Override
    public void startChapter(JTextPane outputPane) {
        displayTitle(outputPane);
    }

    @Override
    public void play(JTextPane outputPane) {
        
    }

    @Override
    public void processChoice(String playerInput, JTextPane outputPane) {
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 *
 * @author Doos
 */
public class Game {
    private ChapterChoices chapterChoices=new ChapterChoices();

    public void addChoices(String fileName) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] help=line.split(";");
                int chapter=Integer.parseInt(help[0]);
                String choice=help[1];
                chapterChoices.addChoice(chapter, choice);
            }
        }
    }
    
    public String testCommand(){
        return "this is a test.";
    }

    public boolean isChoiceAvaiable(String choice, ChapterChoices chapterChoices, GameState gameState) {
        Set<String> availableCoices = chapterChoices.getChoices(gameState.getCurrentChapter());
        return availableCoices.contains(choice);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.util.Set;
import nl.mu.model.Choices.ChapterChoices;
import nl.mu.model.Choices.Choice;
import nl.mu.model.Choices.GameState;

/**
 *
 * @author Doos
 */
public class Game {
    
    
    public boolean isChoiceAvaiable(Choice choice, ChapterChoices chapterChoices, GameState gameState){
        Set<Choice> availableCoices=chapterChoices.getChoices(gameState.getCurrentChapter());
        return availableCoices.contains(choice);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 *
 * @author Doos
 */
public class ChapterChoices {
    private final String title="The Awakening";
    private Map<Integer, Set<String>> chapterChoices=new HashMap<>();
    
    public void addChoice(int chapter, String choice){
        chapterChoices.computeIfAbsent(chapter, k -> new HashSet<>()).add(choice);
    }
    
    public Set<String> getChoices(int chapter){
        return chapterChoices.getOrDefault(chapter, new HashSet<>());
    }
}

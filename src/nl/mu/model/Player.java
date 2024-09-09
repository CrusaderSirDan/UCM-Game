/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.mu.model;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Doos
 */
public class Player {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void askUsername(JTextPane outputPane) {
        try {
            outputPane.getStyledDocument().insertString(outputPane.getStyledDocument().getLength(),
                    "\nWhat is your username?", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}

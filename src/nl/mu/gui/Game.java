package nl.mu.gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mcsyt
 */
public class Game {

    private static Scanner scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        scanner = new Scanner(System.in);
        // ----- Write your code below
        System.out.println(
                /*---*/"   ______ ___     ______ ______ ___     _   __ _  _____    ____   __  __ _   __ ______ ______ ____   _   __" + "\n"
                /**/ + "  / ____//   |   / ____//_  __//   |   / | / /( )/ ___/   / __ \\ / / / // | / // ____// ____// __ \\ / | / /" + "\n"
                /**/ + " / / __ / /| |  / __/    / /  / /| |  /  |/ / |/ \\__ \\   / / / // / / //  |/ // / __ / __/  / / / //  |/ / " + "\n"
                /**/ + "/ /_/ // ___ | / /___   / /  / ___ | / /|  /    ___/ /  / /_/ // /_/ // /|  // /_/ // /___ / /_/ // /|  /  " + "\n"
                /**/ + "\\____//_/  |_|/_____/  /_/  /_/  |_|/_/ |_/    /____/  /_____/ \\____//_/ |_/ \\____//_____/ \\____//_/ |_/   " + "\n"
                /**/ + "By: Gaetan Doos");

        String username = null;
        String answer = "N/A";

        while (answer.equals("n") || username == null) {
            System.out.println("What is your username?");

            username = scanner.nextLine();
            System.out.println("You typed " + username + ". Confirm? (Y/n)");
            answer = scanner.nextLine();
        }

        System.out.println("Hello " + username + "! \n" + "What year  were you born?");
        int birthYear = -1;
        while (birthYear < 0) {
            try {
                birthYear = scanner.nextInt();
                if (birthYear < 0) {
                    System.out.println("Please enter a valid year (positive integer)");
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next();
            }
        }
        System.out.println("You are " + calculateAge(birthYear) + " years old.");
        // ----- Write your code above
    }

    public static int calculateAge(int birthYear) {
        int currentYear = Integer.parseInt("" + Year.now());
        return currentYear - birthYear;
    }
}

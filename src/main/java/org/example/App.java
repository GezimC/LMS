package org.example;

import org.example.ui.AuthorUI;
import org.example.ui.BookUI;
import org.example.ui.LoanUI;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> new AuthorUI().start();
                case 2 -> new BookUI().start();
                case 3 -> new LoanUI().start();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Application closed.");
    }

    private static void printMainMenu() {
        System.out.println("""
            === MAIN MENU ===
            1. Author Management
            2. Book Management
            3. Loan Management
            0. Exit
            Choose option:
            """);
    }
}

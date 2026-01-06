package org.example.ui;

import org.example.model.Author;
import org.example.service.AuthorService;

import java.util.List;
import java.util.Scanner;

public class AuthorUI {

    private final AuthorService authorService;
    private final Scanner scanner;

    public AuthorUI() {
        this.authorService = new AuthorService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== AUTHOR MANAGEMENT ===");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listAuthors();
                case 2 -> createAuthor();
                case 3 -> deleteAuthor();
                case 4 -> updateAuthor();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println("""
               1. List authors
               2. Create author
               3. Delete author
               4. Update author
               0. Exit
               Choose option:
               """);
    }

    private void listAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        authors.forEach(System.out::println);
    }

    private void deleteAuthor() {
        System.out.print("Id of author to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean result = authorService.deleteAuthor(id);
        System.out.println(result ? "Author deleted!" : "Author not found!");
    }

    private void updateAuthor() {
        System.out.print("Author ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New name: ");
        String name = scanner.nextLine();

        System.out.print("New lastname: ");
        String lastname = scanner.nextLine();

        boolean result = authorService.updateAuthor(id, name, lastname);
        System.out.println(result ? "Author updated!" : "Update failed!");
    }


    private void createAuthor() {
        System.out.print("Author name: ");
        String name = scanner.nextLine();

        System.out.print("Author lastname: ");
        String lastname = scanner.nextLine();

        boolean result = authorService.createAuthor(name, lastname);

        if (result) {
            System.out.println("Author created successfully!");
        } else {
            System.out.println("Failed to create author!");
        }
    }
}

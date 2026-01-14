package org.example.ui;

import org.example.model.Book;
import org.example.service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookUI {

    private final BookService bookService;
    private final Scanner scanner;

    public BookUI() {
        this.bookService = new BookService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== BOOK MANAGEMENT ===");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
//                case 1 -> listBooks();
                case 2 -> createBook();
//                case 3 -> deleteBook();
                case 4 -> updateBook();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println("""
               1. List books
               2. Create book
               3. Delete book
               4. Update book
               0. Exit
               Choose option:
               """);
    }

//    private void listBooks() {
//        List<Book> books = bookService.getAllBooks();
//        books.forEach(System.out::println);
//    }

//    private void deleteBook() {
//        System.out.print("Book ID to delete: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        boolean result = bookService.deleteBook(id);
//        System.out.println(result ? "Book deleted!" : "Book not found!");
//    }

    private void createBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author ID: ");
        int authorId = scanner.nextInt();

        System.out.print("Category ID: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Language ID: ");
        int langId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Publishing House: ");
        String publishingHouse = scanner.nextLine();

        System.out.print("Published Year: ");
        int publishedYear = scanner.nextInt();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        boolean result = bookService.createBook(
                title,
                authorId,
                categoryId,
                isbn,
                langId,
                publishingHouse,
                publishedYear,
                quantity
        );

        System.out.println(result ? "Book created!" : "Failed to create book!");
    }

    private void updateBook() {
        System.out.print("Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Leave field empty to keep current value");

        System.out.print("New title: ");
        String title = scanner.nextLine();
        title = title.isBlank() ? null : title;

        System.out.print("New author ID: ");
        String authorInput = scanner.nextLine();
        Integer authorId = authorInput.isBlank() ? null : Integer.parseInt(authorInput);

        System.out.print("New category ID: ");
        String categoryInput = scanner.nextLine();
        Integer categoryId = categoryInput.isBlank() ? null : Integer.parseInt(categoryInput);

        System.out.print("New ISBN: ");
        String isbn = scanner.nextLine();
        isbn = isbn.isBlank() ? null : isbn;

        System.out.print("New language ID: ");
        String langInput = scanner.nextLine();
        Integer langId = langInput.isBlank() ? null : Integer.parseInt(langInput);

        System.out.print("New publishing house: ");
        String publishingHouse = scanner.nextLine();
        publishingHouse = publishingHouse.isBlank() ? null : publishingHouse;

        System.out.print("New published year: ");
        String yearInput = scanner.nextLine();
        Integer publishedYear = yearInput.isBlank() ? null : Integer.parseInt(yearInput);

        System.out.print("New quantity: ");
        String qtyInput = scanner.nextLine();
        Integer quantity = qtyInput.isBlank() ? null : Integer.parseInt(qtyInput);

        boolean result = bookService.updateBook(
                id,
                title,
                authorId,
                categoryId,
                isbn,
                langId,
                publishingHouse,
                publishedYear,
                quantity
        );

        System.out.println(result ? "Book updated!" : "Update failed!");
    }
}

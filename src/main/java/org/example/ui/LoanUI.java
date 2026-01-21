package org.example.ui;

import org.example.model.Loan;
import org.example.service.LoanService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LoanUI {

    private final LoanService loanService;
    private final Scanner scanner;

    public LoanUI() {
        this.loanService = new LoanService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== LOAN MANAGEMENT ===");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> viewActiveLoansByMember();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println("""
               1. Borrow book
               2. Return book
               3. View active loans by member
               0. Exit
               Choose option:
               """);
    }

    /* ================= ACTIONS ================= */

    private void borrowBook() {
        System.out.print("Book ID: ");
        int bookId = scanner.nextInt();

        System.out.print("Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        LocalDate loanDate = LocalDate.now();

        boolean result = loanService.createLoan(bookId,memberId,loanDate);

        System.out.println(
                result ? "Book borrowed successfully!" : "Failed to borrow book!"
        );
    }

    private void returnBook() {
        System.out.print("Loan ID to return: ");
        int loanId = scanner.nextInt();
        scanner.nextLine();

        boolean result = loanService.returnLoan(loanId);

        System.out.println(
                result ? "Book returned successfully!" : "Return failed!"
        );
    }

    private void viewActiveLoansByMember() {
        System.out.print("Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        List<Loan> loans = loanService.getActiveLoansByMemberId(memberId);

        if (loans.isEmpty()) {
            System.out.println("No active loans found.");
            return;
        }

        loans.forEach(System.out::println);
    }
}

package org.example;
import org.example.model.Author;
import org.example.model.Loan;
import org.example.service.BookService;
import org.example.service.LoanService;
import org.example.ui.AuthorUI;
import org.example.ui.BookUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//
//        while (running) {
//            System.out.println("""
//                === MAIN MENU ===
//                1. Author Management
//                2. Book Management
//                0. Exit
//                Choose option:
//                """);
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1 -> new AuthorUI().start();
//                case 2 -> new BookUI().start();
//                case 0 -> running = false;
//                default -> System.out.println("Invalid option!");
//            }
//        }


        LoanService ls = new LoanService();

//        if (ls.createLoan(3, 1, LocalDate.now()))
//        {
//            System.out.println("Loan created");
//        }
//        else {
//            System.out.println("Failed!!!!");
//        }


//        if (ls.returnLoan(1))
//        {
//            System.out.println("Loan returned");
//        }
//        else  {
//            System.out.println("Failed!!!!");
//        }


        List<Loan> activeLoans =     ls.getActiveLoansByMemberId(1);
        activeLoans.forEach(System.out::println);
    }
}

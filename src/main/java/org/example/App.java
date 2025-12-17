package org.example;

import org.example.dao.AuthorDao;
import org.example.helper.DbConnection;
import org.example.model.Author;
import org.example.service.AuthorService;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        try (Connection connection = DbConnection.connect()) {
//            System.out.println("Connected to the database!");
//        } catch (Exception e) {
//            System.out.println("Failed to connect to the database!");
//            e.printStackTrace();
//        }

        AuthorService authorService = new AuthorService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of author: ");
        String name = scanner.nextLine();


        System.out.println("Lastname of author: ");
        String lastname = scanner.nextLine();


        boolean result =authorService.createAuthor(name, lastname);

        if (result)
        {
            System.out.println("Author created!");
        }
        else
        {
            System.out.println("Author not created!");
        }
    }
}

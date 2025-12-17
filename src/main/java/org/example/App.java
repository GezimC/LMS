package org.example;

import org.example.dao.AuthorDao;
import org.example.helper.DbConnection;
import org.example.model.Author;

import java.sql.Connection;

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

        AuthorDao authDao = new AuthorDao();

        boolean result =authDao.createAuthor(new Author("testabc", "abctest"));

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

package org.example;

import org.example.helper.DbConnection;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try (Connection connection = DbConnection.connect()) {
            System.out.println("Connected to the database!");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }
}

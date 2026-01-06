package org.example.dao;

import org.example.helper.DbConnection;
import org.example.model.Book;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BookDao {

    public boolean createBook(Book book)
    {
        String sql= "{Call dbo.usp_Book_Create (?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = DbConnection.connect();
             CallableStatement statement = connection.prepareCall(sql))
        {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthorId());
            statement.setInt(3, book.getCategoryId());
            statement.setString(4, book.getIsbn());
            statement.setInt(5, book.getLangId());
            statement.setString(6, book.getPublishingHouse());
            statement.setInt(7, book.getPublishedYear());
            statement.setInt(8, book.getQuantity());
            statement.setInt(9, 1);

            int rowsAffected =  statement.executeUpdate();

            if (rowsAffected > 0)
            {
                return true;
            }

            return  false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return  false;
        }
    }
}

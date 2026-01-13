package org.example.dao;

import org.example.helper.DbConnection;
import org.example.model.Author;
import org.example.model.Book;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

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


    public boolean doesBookExists (String isbn)
    {

        String sql= "{Call dbo.usp_Book_DoesExists (?,?)}";

        try (Connection connection = DbConnection.connect();
             CallableStatement statement = connection.prepareCall(sql))
        {
            statement.setString(1, isbn);
            statement.registerOutParameter(2, Types.BIT);

            // Execute SP
            statement.execute();

            // Read OUTPUT value
            return statement.getBoolean(2);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return  false;
        }
    }


    public boolean updateBook(Book book)
    {
        String sql = "{Call dbo.usp_Book_Update (?, ?, ?,?,?,?,?,?,?)}";

        try (
                Connection connection = DbConnection.connect();
                CallableStatement cstm = connection.prepareCall(sql);
        )
        {
            cstm.setInt(1, book.getId());
            cstm.setString(2, book.getTitle());
            cstm.setInt(3, book.getAuthorId());
            cstm.setInt(4, book.getCategoryId());
            cstm.setString(5, book.getIsbn());
            cstm.setInt(6, book.getLangId());
            cstm.setString(7, book.getPublishingHouse());
            cstm.setInt(8, book.getPublishedYear());
            cstm.setInt(9, book.getQuantity());


            int rowsAffected = cstm.executeUpdate();

            if (rowsAffected > 0)
            {
                return true;
            }

            return  false;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return  false;
        }

    }

}

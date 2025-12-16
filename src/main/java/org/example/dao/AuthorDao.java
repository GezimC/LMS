package org.example.dao;

import org.example.model.Author;
import org.example.helper.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AuthorDao {

    public boolean createAuthor(Author author)
    {
        String sql =  "INSERT INTO dbo.Authors (Name, Lastname) VALUES (?,?)";

        try (Connection connection = DbConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql))
        {

            statement.setString(1, author.getName());
            statement.setString(2, author.getLastname());

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

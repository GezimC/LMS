package org.example.dao;

import org.example.model.Author;
import org.example.helper.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;


public class AuthorDao {

    public boolean createAuthor(Author author)
    {
//        String sql =  "INSERT INTO dbo.Authors (Name, Lastname) VALUES (?,?)";
          String sql= "{Call dbo.usp_Author_Create (?,?,?)}";

        try (Connection connection = DbConnection.connect();
            CallableStatement statement = connection.prepareCall(sql))
        {
            statement.setString(1, author.getName());
            statement.setString(2, author.getLastname());
            statement.setInt(3, 1);

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


    public boolean updateAuthor(Author author)
    {
        String sql = "{Call dbo.usp_Author_Update (?, ?, ?)}";

        try (
                Connection connection = DbConnection.connect();
                CallableStatement cstm = connection.prepareCall(sql);
                )
        {
            cstm.setInt(1, author.getId());
            cstm.setString(2, author.getName());
            cstm.setString(3, author.getLastname());

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

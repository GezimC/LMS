package org.example.dao;

import org.example.helper.DbConnection;
import org.example.model.Author;
import org.example.model.Loan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class LoanDao {

    public boolean createLoan(Loan loan)
    {
        String sql= "{Call dbo.usp_Loan_Create (?,?,?,?)}";

        try (Connection connection = DbConnection.connect();
             CallableStatement statement = connection.prepareCall(sql))
        {
            statement.setInt(1, loan.getBookId());
            statement.setInt(2, loan.getMemberId());
            statement.setDate(3, java.sql.Date.valueOf(loan.getLoanDate()));
            statement.setDate(4, java.sql.Date.valueOf(loan.getDueDate()));


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

package org.example.dao;

import org.example.helper.DbConnection;
import org.example.model.Author;
import org.example.model.Loan;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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


    public boolean returnLoan(int loadId)
    {
        String sql= "{Call dbo.usp_Loan_Return (?)}";

        try (Connection connection = DbConnection.connect();
             CallableStatement statement = connection.prepareCall(sql))
        {
            statement.setInt(1, loadId);

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


    // return active loans for a memberId

    public List<Loan> getActiveLoansByMemberId(int memberId)
    {
        String sql = "{Call dbo.usp_Loans_GetActiveByMemberId (?)}";
        List<Loan> loans = new ArrayList<>();

        try (
                Connection connection = DbConnection.connect();
                CallableStatement cstm = connection.prepareCall(sql);
        )
        {
            cstm.setInt(1, memberId);

            ResultSet rs = cstm.executeQuery();

            while (rs.next())
            {
                Loan loan = new Loan();
                loan.setId(rs.getInt("Id"));
                loan.setBookId(rs.getInt("BookId"));
                loan.setMemberId(rs.getInt("MemberId"));
                loan.setLoanDate(rs.getDate("LoanDate").toLocalDate());
                loan.setDueDate(rs.getDate("DueDate").toLocalDate());
                loans.add(loan);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return loans;
    }

    // returned due date passed loans

    // return all loans




}

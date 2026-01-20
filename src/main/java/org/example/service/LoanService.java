package org.example.service;

import org.example.dao.LoanDao;
import org.example.model.Author;
import org.example.model.Loan;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class LoanService {

    LoanDao loanDao = new LoanDao();


    public boolean createLoan(int bookId, int memberId, LocalDate loanDate)
    {
        Loan loan = new Loan();

        // check quantity of book
        // check if member is active


        // if everything okay, contiue to fill loan
        loan.setBookId(bookId);
        loan.setMemberId(memberId);
        loan.setLoanDate(loanDate);
        loan.setDueDate(loanDate.plusDays(14));

        return loanDao.createLoan(loan);

    }


    public boolean returnLoan(int loadId)
    {
        // check if book is returned
        // check if book is late
        return loanDao.returnLoan(loadId);
    }


    public List<Loan> getActiveLoansByMemberId( int membmerId) {

        return loanDao.getActiveLoansByMemberId(membmerId);

    }
}

package org.example.model;

import java.time.LocalDate;
import java.util.Date;

public class Loan {
    private int id;
    private int bookId;
    private int memberId;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;

    private boolean isTurnedIn;

    public Loan ()
    {}

    public Loan(int bookId, int memberId, LocalDate loanDate, LocalDate dueDate, LocalDate returnedDate, boolean isTurnedIn) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
        this.isTurnedIn = isTurnedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public boolean isTurnedIn() {
        return isTurnedIn;
    }

    public void setTurnedIn(boolean turnedIn) {
        isTurnedIn = turnedIn;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returnedDate=" + returnedDate +
                ", isTurnedIn=" + isTurnedIn +
                '}';
    }
}

package com.librarymanagementsystem.bean;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookBean {

    private Date issueDate;
    private Date returnDate;

    public long calculateFine() {
        if (returnDate == null || issueDate == null) return 0;

        long diff = returnDate.getTime() - issueDate.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(diff);

        if (days > 7) {
            return (days - 7) * 5;
        }
        return 0;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}
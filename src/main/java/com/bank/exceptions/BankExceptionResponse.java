package com.bank.exceptions;

import java.util.Date;

public class BankExceptionResponse
{
    private Date timestamp;

    private String message;

    private String details;

    public BankExceptionResponse(Date timestamp, String message, String details)
    {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public String getDetails()
    {
        return details;
    }

    public String getMessage()
    {
        return message;
    }
}

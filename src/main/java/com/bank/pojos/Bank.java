package com.bank.pojos;

import javax.validation.constraints.NotEmpty;

public class Bank
{
    @NotEmpty
    private String bankName;

    private String city;

    public Bank()
    {

    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getBankName()
    {
        return bankName;
    }

    public String getCity()
    {
        return city;
    }

    @Override
    public String toString()
    {
        return getBankName()+" : "+getCity();
    }
}

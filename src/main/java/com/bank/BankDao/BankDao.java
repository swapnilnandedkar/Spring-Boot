package com.bank.BankDao;

import java.util.List;

import com.bank.pojos.Bank;

public interface BankDao
{
    public void saveBank(Bank bank);
    public Bank getBank(String bankName);
    public List<Bank> findAllBank();
}

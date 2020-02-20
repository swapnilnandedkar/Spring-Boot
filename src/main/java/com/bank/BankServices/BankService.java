package com.bank.BankServices;

import java.util.List;

import com.bank.pojos.Bank;

public interface BankService
{
    public void saveBank(Bank bank);
    public Bank getBank(String bankName);
    public List<Bank> findAllBank();
}

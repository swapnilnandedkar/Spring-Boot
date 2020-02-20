package com.bank.BankServices;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BankDao.BankDao;
import com.bank.pojos.Bank;

@Service
public class BankServiceImpl implements BankService
{
    @Autowired
    private BankDao bankDao;

    @Override
    public Bank getBank(String bankName)
    {
        System.out.println("get service => "+bankName);
       return bankDao.getBank(bankName);
    }

    @Override
    public void saveBank(Bank bank)
    {
        System.out.println("Service => "+bank);
        bankDao.saveBank(bank);
    }

    @Override
    public List<Bank> findAllBank()
    {
        return bankDao.findAllBank();
    }
}

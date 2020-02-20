package com.bank.BankDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.pojos.Bank;

@Repository
public class BankDaoImpl implements BankDao
{
   private List<Bank> bankList = new ArrayList();

    @Override
    public Bank getBank(String bankName)
    {
        System.out.println("get Dao => "+bankName);
        for (Bank b : bankList)
        {
            if(bankName.equals(b.getBankName()))
            {
                System.out.println("Find => "+b);
                return b;
            }
        }
        return null;

    }
    @Override
    public void saveBank(Bank bank)
    {
        System.out.println("Dao => "+bank);
        bankList.add(bank);
    }

    @Override
    public List<Bank> findAllBank()
    {
        return bankList;
    }
}

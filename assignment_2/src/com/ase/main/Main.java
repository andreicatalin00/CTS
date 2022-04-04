package com.ase.main;

import com.ase.exceptions.ValueException;
import com.ase.interfaces.AccountInterface;
import com.ase.models.Account;

public class Main {
    public static void main(String[] args) throws ValueException {
        AccountInterface account = new Account(1200, 12230);
        System.out.println(account);
        System.out.println(((Account) account).calculate());
        System.out.println(account.getMonthlyRate());

        //This throws a custom error ValueError
        //AccountInterface account2 = new Account(-12, 12230);

    }
}

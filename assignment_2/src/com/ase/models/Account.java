package com.ase.models;

import com.ase.exceptions.ValueException;
import com.ase.interfaces.AccountInterface;

public class Account implements AccountInterface {
    private double loanValue;
    private double rate;
    private int daysActive;
    private AccountType accountType;

    public Account(double loanValue, int daysActive) throws ValueException {
        this.daysActive = daysActive;
        this.setAccountType();
        this.setRate();
        this.setLoanValue(loanValue);
    }

    public double getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(double loanValue) throws ValueException {
        if(loanValue < 0)
            throw new ValueException();
        this.loanValue = loanValue;
    }

    public double getRate() {
        return rate;
    }

    public void setRate() {
        this.rate = this.accountType.getRate();
    }

    public int getDaysActive() {
        return daysActive;
    }

    public void setDaysActive(int daysActive) {
        this.daysActive = daysActive;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType() {
        if(this.daysActive < 30){
            this.accountType = AccountType.BUDGET;
        } else if(this.daysActive < 60){
            this.accountType = AccountType.STANDARD;
        } else if(this.daysActive < 90){
            this.accountType = AccountType.PREMIUM;
        } else{
            this.accountType = AccountType.SUPER_PREMIUM;
        }
    }

    @Override
    public double getMonthlyRate() {
        return this.calculate()/12;
    }

    @Override
    public String toString() {
        return "Account {" +
                "loanValue=" + loanValue +
                ", rate=" + rate +
                "%, daysActive=" + daysActive +
                ", accountType=" + accountType +
                '}';
    }

    public double calculate(){
        return this.loanValue * (100 + this.accountType.getRate()) / 100;
    }
}

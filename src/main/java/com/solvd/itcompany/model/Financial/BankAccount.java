package com.solvd.itcompany.model.Financial;

import com.solvd.itcompany.model.People.Client;
import com.solvd.itcompany.exceptions.InsufficientFundsException;
import java.util.Objects;

public class BankAccount {
    private String bankName;
    private int accountNumber;
    private double balance;
    private Client owner;

    public BankAccount(Client owner, int accountNumber, String user, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Transaction failed: Insufficient funds. Current balance: $" + balance);
        }
        this.balance -= amount;
    }

    public Client getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Bank name: " + bankName + ". " + "Account owner: " + owner.getName() + ". Account number: " + accountNumber + ". Balance: $" + balance + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, owner);
    }
}
package model;

public class Installment {
    public int month;
    public double emi, interest, principal, balance;

    public Installment(int month, double emi, double interest,
                       double principal, double balance) {
        this.month = month;
        this.emi = emi;
        this.interest = interest;
        this.principal = principal;
        this.balance = balance;
    }
}

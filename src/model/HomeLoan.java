package model;

public class HomeLoan extends Loan {

    public HomeLoan(double principal, int months) {
        this.principal = principal;
        this.months = months;
    }

    @Override
    public void generateSchedule(double annualRate) {
        double r = annualRate / 12 / 100;
        double emi = principal * r * Math.pow(1+r, months)
                   / (Math.pow(1+r, months) - 1);

        double balance = principal;

        for (int m = 1; m <= months; m++) {
            double interest = balance * r;
            double principalPaid = emi - interest;
            balance -= principalPaid;

            schedule.add(new Installment(
                m, emi, interest, principalPaid, Math.max(balance, 0)
            ));

            if (balance <= 0) break;
        }
    }
}

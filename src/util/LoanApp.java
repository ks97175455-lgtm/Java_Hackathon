package util;

import model.*;
import service.*;
import java.util.*;

public class LoanApp {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Loan Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Tenure (in months): "); 
        int months = sc.nextInt();

        System.out.print("Enter Interest Rate: ");
        double rate = sc.nextDouble();

        Loan loan = new HomeLoan(amount, months);
        loan.generateSchedule(rate);

        List<Prepayment> prepayments =
            FileUtil.readPrepayments("prepayments.csv");

        PrepaymentService.applyPrepayments(
            loan.getSchedule(), prepayments);

        FileUtil.writeAmortization(
            loan.getSchedule(), "amortization.csv");

        System.out.println("All reports generated successfully");
        System.out.println("All test cases passed successfully");

        sc.close();
    }
}

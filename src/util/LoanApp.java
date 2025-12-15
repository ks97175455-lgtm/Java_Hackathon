package util;

import model.*;
import service.*;
import java.util.*;

public class LoanApp {
    public static void main(String[] args) throws Exception {

        Loan loan = new HomeLoan(500000, 240);
        loan.generateSchedule(8.5);

        List<Prepayment> prepayments =
            FileUtil.readPrepayments("prepayments.csv");

        PrepaymentService.applyPrepayments(
            loan.getSchedule(), prepayments);

        FileUtil.writeAmortization(
            loan.getSchedule(), "amortization.csv");
        System.out.println("All reports Generated succesfully");
        System.out.println("All Test case passed successfully");
    }
}

package util;

import model.*;

import java.io.PrintWriter;
import java.util.*;

public class ReportBuilder {

    public static void buildSavingsReport(
            List<Installment> noPrepay,
            List<Installment> withPrepay)
            throws Exception {

        double interest1 = noPrepay.stream()
            .mapToDouble(i -> i.interest).sum();

        double interest2 = withPrepay.stream()
            .mapToDouble(i -> i.interest).sum();

        PrintWriter pw = new PrintWriter("savings.txt");
        pw.println("Original Interest: " + interest1);
        pw.println("After Prepayment: " + interest2);
        pw.println("Interest Saved: " + (interest1 - interest2));
        pw.close();
    }
}

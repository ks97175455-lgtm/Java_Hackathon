package util;

import model.*;
import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<Prepayment> readPrepayments(String file)
            throws Exception {

        List<Prepayment> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");
            list.add(new Prepayment(
                Integer.parseInt(p[0]),
                Double.parseDouble(p[1])
            ));
        }
        br.close();
        return list;
    }

    public static void writeAmortization(
            List<Installment> list, String file)
            throws Exception {

        PrintWriter pw = new PrintWriter(file);
        pw.println("Month,EMI,Interest,Principal,Balance");

        for (Installment i : list) {
            pw.println(i.month + "," + i.emi + "," +
                       i.interest + "," + i.principal + "," +
                       i.balance);
        }
        pw.close();
    }
}

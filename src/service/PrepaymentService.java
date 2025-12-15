package service;

import model.*;
import exception.*;

import java.util.*;

public class PrepaymentService {

    public static void applyPrepayments(
            List<Installment> schedule,
            List<Prepayment> prepayments)
            throws PrepaymentExceedsBalanceException {

        for (Prepayment p : prepayments) {
            Installment inst = schedule.get(p.month - 1);

            if (p.amount > inst.balance) {
                throw new PrepaymentExceedsBalanceException(
                    "Prepayment exceeds balance at month " + p.month
                );
            }

            inst.balance -= p.amount;
        }
    }
}

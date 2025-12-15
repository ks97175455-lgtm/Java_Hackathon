package model;

import java.util.*;

public abstract class Loan {
    protected double principal;
    protected int months;
    protected List<Installment> schedule = new ArrayList<>();

    public abstract void generateSchedule(double annualRate);

    public List<Installment> getSchedule() {
        return schedule;
    }
}

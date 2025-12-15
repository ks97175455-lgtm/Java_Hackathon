package policy;

public class FixedRatePolicy implements RatePolicy {
    public double monthlyRate(double annualRate) {
        return annualRate / 12 / 100;
    }
}

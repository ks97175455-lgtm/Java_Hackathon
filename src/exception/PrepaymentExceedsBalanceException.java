package exception;

public class PrepaymentExceedsBalanceException extends Exception {

    public PrepaymentExceedsBalanceException(String message) {
        super(message);
    }
}

package model.entities;

public class TimeDepositWithoutTopUp extends TimeDeposit {
    private static final boolean topUp = false;
    public TimeDepositWithoutTopUp(int percent, int month) {
        super(percent, month, topUp);
    }
}

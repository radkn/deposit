package model.entities;

public class TimeDepositWithTopUp extends TimeDeposit {
    private static final boolean topUp = true;
    public TimeDepositWithTopUp(int percent, int month) {
        super(percent, month, topUp);
    }
}

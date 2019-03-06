package model.entities;

public abstract class TimeDeposit extends Deposit {
    private final static boolean earlyWithdrawal = true;
    public TimeDeposit(int percent, int month, boolean topUp) {
        super(percent, month, earlyWithdrawal, topUp);
    }
}

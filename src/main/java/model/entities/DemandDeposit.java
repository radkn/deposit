package model.entities;

public abstract class DemandDeposit extends Deposit {

    private final static boolean earlyWithdrawal = true;

    public DemandDeposit(int percent, int month,  boolean topUp) {
        super(percent, month, earlyWithdrawal, topUp);
    }

    String getInfo() {
        return null;
    }
}

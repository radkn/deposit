package model.entities;

public class DemandDepositWithoutTopUp extends DemandDeposit {
    private static final boolean topUp = false;
    public DemandDepositWithoutTopUp(int percent, int month) {
        super(percent, month, topUp);
    }
}

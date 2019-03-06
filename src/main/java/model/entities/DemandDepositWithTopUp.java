package model.entities;

public class DemandDepositWithTopUp extends DemandDeposit {
    private static final boolean topUp = true;
    public DemandDepositWithTopUp(int percent, int month) {
        super(percent, month, topUp);
    }
}

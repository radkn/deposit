package model.entities;

public class AlphaBank extends Bank{
    private static final String NAME = "Alpha Bank";
    public AlphaBank() {
        super(NAME);
    }

    public DemandDeposit createDemandDeposit(int percent, int month) {
        return new DemandDepositWithTopUp(percent, month);
    }

    public TimeDeposit createTimeDeposit(int percent, int month) {
        return new TimeDepositWithTopUp(percent, month);
    }
}

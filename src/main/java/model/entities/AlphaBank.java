package model.entities;

public class AlphaBank extends Bank{
    private static final String NAME = "Alpha Bank";
    public AlphaBank() {
        super(NAME);
    }

    public Bank addTimeDeposit(int percent, int month) {
        return super.addDeposit(new TimeDepositWithoutTopUp(percent,month));
    }

    public Bank addDemandDeposit(int percent, int month) {
        return super.addDeposit(new DemandDepositWithoutTopUp(percent,month));
    }
}

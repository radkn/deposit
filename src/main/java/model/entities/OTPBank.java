package model.entities;

public class OTPBank extends Bank {
    private static final String NAME = "OTP Bank";
    public OTPBank() {
        super(NAME);
    }

    public Bank addTimeDeposit(int percent, int month) {
        return super.addDeposit(new TimeDepositWithTopUp(percent,month));
    }

    public Bank addDemandDeposit(int percent, int month) {
        return super.addDeposit(new DemandDepositWithTopUp(percent,month));
    }
}

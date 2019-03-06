package model.entities;

public class OTPBank extends Bank {
    private static final String NAME = "OTP Bank";
    public OTPBank() {
        super(NAME);
    }

    public DemandDeposit createDemandDeposit(int percent, int month) {
        return new DemandDepositWithoutTopUp(percent, month);
    }

    public TimeDeposit createTimeDeposit(int percent, int month) {
        return new TimeDepositWithoutTopUp(percent, month);
    }
}

package model.entities;

public interface DepositFactory {
    DemandDeposit createDemandDeposit(int percent, int month);
    TimeDeposit createTimeDeposit(int percent, int month);
}

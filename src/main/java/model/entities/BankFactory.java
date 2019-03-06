package model.entities;

public interface BankFactory {
    DemandDeposit createDemandDeposit(int percent, int month);
    TimeDeposit createTimeDeposit(int percent, int month);
}

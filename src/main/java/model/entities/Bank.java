package model.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Bank implements BankFactory {
    private String name;



    private List<Deposit> deposits = new ArrayList<Deposit>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Bank addTimeDeposit(int percent, int month){
        deposits.add(createTimeDeposit(percent,month));
        return this;
    }

    public Bank addDemandDeposit(int percent, int month){
        deposits.add(createDemandDeposit(percent,month));
        return this;
    }

    public List<Deposit> getAllDeposits(){
        return deposits;
    }
}

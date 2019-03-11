package model.entities;

import java.util.LinkedList;
import java.util.List;

public abstract class Bank {
    private int id;
    private String name;

    private List<Deposit> deposits = new LinkedList<Deposit>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected Bank addDeposit(Deposit deposit) {
        deposits.add(deposit);
        return this;
    }

    public abstract Bank addTimeDeposit(int percent, int month);

    public abstract Bank addDemandDeposit(int percent, int month);

    public List<Deposit> getDeposits() {
        return deposits;
    }
}

package service;

import model.entities.Deposit;

import java.util.List;

public abstract class Filter {

    private Filter nextFilter;

    public Filter getNextFilter() {
        return nextFilter;
    }

    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public abstract List<Deposit> filter(List<Deposit> deposits);
}

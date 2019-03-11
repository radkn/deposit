package service.sort;

import model.entities.Deposit;
import service.Sorter;

import java.util.Comparator;
import java.util.List;

public class TimeSorter implements Sorter {
    @Override
    public List<Deposit> sort(List<Deposit> deposits) {
        deposits.sort(Comparator.comparing(Deposit::getMonth));
        return deposits;
    }
}

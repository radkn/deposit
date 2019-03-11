package service.sort;

import model.entities.Deposit;
import service.Sorter;

import java.util.Comparator;
import java.util.List;

public class PercentSorter implements Sorter {
    @Override
    public List<Deposit> sort(List<Deposit> deposits) {
        deposits.sort(Comparator.comparing(Deposit::getPercent));
        return deposits;
    }
}

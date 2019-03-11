package service;

import model.entities.Deposit;
import service.sort.PercentSorter;
import service.sort.TimeSorter;

import java.util.List;

public class SortService {
    private final String PERCENT_SORTER = "by percent";
    private final String TIME_SORTER = "by time";
    public List<Deposit> doSort(List<Deposit> deposits, String sorterName){
        Sorter sorter;

        if(sorterName.equals(PERCENT_SORTER)){
            sorter = new PercentSorter();
        }else if(sorterName.equals(TIME_SORTER)){
            sorter = new TimeSorter();
        }else {
            throw new IllegalArgumentException("No find such sorter!");
        }

        return sorter.sort(deposits);
    }
}

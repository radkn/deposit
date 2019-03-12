package service;

import model.entities.Deposit;
import service.sort.PercentSorter;
import service.sort.TimeSorter;

import java.util.List;


public class SortService {

    public List<Deposit> doSort(List<Deposit> deposits, String sorterName){
        Sorter sorter;

        if(sorterName.equals(StrResource.PERCENT_SORTER)){
            sorter = new PercentSorter();
        }else if(sorterName.equals(StrResource.TIME_SORTER)){
            sorter = new TimeSorter();
        }else {
            throw new IllegalArgumentException(StrResource.SORTER_EXCEPTION);
        }

        return sorter.sort(deposits);
    }
}

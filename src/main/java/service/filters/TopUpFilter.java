package service.filters;

import model.entities.Deposit;
import service.Filter;

import java.util.List;
import java.util.stream.Collectors;

public class TopUpFilter extends Filter {

    private boolean topUp;

    public TopUpFilter(boolean topUp){
        this.topUp = topUp;
    }

    @Override
    public List<Deposit> filter(List<Deposit> deposits) {
        List<Deposit> dep = deposits.stream()
                .filter(d -> d.isTopUp()==topUp)
                .collect(Collectors.toList());
        if (getNextFilter()!=null){
            dep = getNextFilter().filter(dep);
        }
        return dep;

    }
}

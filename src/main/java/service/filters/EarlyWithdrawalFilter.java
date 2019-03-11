package service.filters;

import model.entities.Deposit;
import service.Filter;

import java.util.List;
import java.util.stream.Collectors;

public class EarlyWithdrawalFilter extends Filter {

    private boolean earlyWithdrawal;

    public EarlyWithdrawalFilter(boolean earlyWithdrawal){
        this.earlyWithdrawal = earlyWithdrawal;
    }

    @Override
    public List<Deposit> filter(List<Deposit> deposits) {
        List<Deposit> dep = deposits.stream()
                .filter(d -> d.isEarlyWithdrawal()==earlyWithdrawal)
                .collect(Collectors.toList());
        if (getNextFilter()!=null){
            dep = getNextFilter().filter(dep);
        }
        return dep;
    }
}

package service.filters;

import model.entities.Deposit;
import service.Boards;

import java.util.List;
import java.util.stream.Collectors;

public class PercentFilter extends NumbersFilter {

    public PercentFilter(int leftBoard, int rightBoard){
        super(leftBoard< Boards.MIN_PERCENT_BOARD? Boards.MIN_PERCENT_BOARD : leftBoard,
                rightBoard >Boards.MAX_PERCENT_BOARD ? Boards.MAX_PERCENT_BOARD : rightBoard);
    }

    @Override
    public List<Deposit> filter(List<Deposit> deposits) {
        List<Deposit> dep = deposits.stream()
                .filter(a -> a.getPercent() >= getLeftBoard() && a.getPercent() <= getRightBoard())
                .collect(Collectors.toList());

        if (getNextFilter()!=null){
            dep = getNextFilter().filter(dep);
        }

        return dep;
    }


}

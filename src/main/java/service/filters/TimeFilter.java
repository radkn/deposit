package service.filters;

import model.entities.Deposit;
import service.Boards;

import java.util.List;
import java.util.stream.Collectors;

public class TimeFilter extends NumbersFilter {

    public TimeFilter(int leftBoard, int rightBoard){
        super(leftBoard< Boards.MIN_TIME_BOARD? Boards.MIN_TIME_BOARD : leftBoard,
                rightBoard >Boards.MAX_TIME_BOARD ? Boards.MAX_TIME_BOARD : rightBoard);
    }

    @Override
    public List<Deposit> filter(List<Deposit> deposits) {
        List<Deposit> dep = deposits.stream()
                .filter(a -> a.getMonth() >= getLeftBoard() && a.getMonth() <= getRightBoard())
                .collect(Collectors.toList());

        if (getNextFilter()!=null){
            dep = getNextFilter().filter(dep);
        }

        return dep;
    }
}

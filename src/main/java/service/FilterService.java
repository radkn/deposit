package service;

import model.entities.Deposit;
import service.filters.EarlyWithdrawalFilter;
import service.filters.PercentFilter;
import service.filters.TimeFilter;
import service.filters.TopUpFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class FilterService {
    private final String PERCENT_LEFT_BOARD = "leftPercentBoard";
    private final String PERCENT_RIGHT_BOARD = "rightPercentBoard";
    private final String TIME_LEFT_BOARD = "leftTimeBoard";
    private final String TIME_RIGHT_BOARD = "rightTimeBoard";

    private final String EARLY_WITHDRAWAL = "earlyWithdrawal";
    private final String TOP_UP = "topUp";

    public List<Deposit> doFilter(HttpServletRequest req, List<Deposit> deposits){
        int percLeftBoard = Integer.valueOf(req.getParameter(PERCENT_LEFT_BOARD));
        int percRightBoard = Integer.valueOf(req.getParameter(PERCENT_RIGHT_BOARD));
        int timeLeftBoard = Integer.valueOf(req.getParameter(TIME_LEFT_BOARD));
        int timeRightBoard = Integer.valueOf(req.getParameter(TIME_RIGHT_BOARD));

        List<Filter> filters = new ArrayList<>();

        filters.add(new PercentFilter(percLeftBoard,percRightBoard));
        filters.add(new TimeFilter(timeLeftBoard,timeRightBoard));

        if(req.getParameter(EARLY_WITHDRAWAL).equals("yes")){
            filters.add(new EarlyWithdrawalFilter(true));
        }else if(req.getParameter(EARLY_WITHDRAWAL).equals("no")){
            filters.add(new EarlyWithdrawalFilter(false));
        }

        if(req.getParameter(TOP_UP).equals("yes")){
            filters.add(new TopUpFilter(true));
        }else if(req.getParameter(TOP_UP).equals("no")){
            filters.add(new TopUpFilter(false));
        }

        for(int i = 0; i < filters.size()-1; i++){
            filters.get(i).setNextFilter(filters.get(i+1));
        }

        return filters.get(0).filter(deposits);
    }

}

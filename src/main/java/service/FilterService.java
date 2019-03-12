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

    public List<Deposit> doFilter(HttpServletRequest req, List<Deposit> deposits){
        int percLeftBoard = Integer.valueOf(req.getParameter(StrResource.PERCENT_LEFT_BOARD));
        int percRightBoard = Integer.valueOf(req.getParameter(StrResource.PERCENT_RIGHT_BOARD));
        int timeLeftBoard = Integer.valueOf(req.getParameter(StrResource.TIME_LEFT_BOARD));
        int timeRightBoard = Integer.valueOf(req.getParameter(StrResource.TIME_RIGHT_BOARD));

        List<Filter> filters = new ArrayList<>();

        filters.add(new PercentFilter(percLeftBoard,percRightBoard));
        filters.add(new TimeFilter(timeLeftBoard,timeRightBoard));

        if(req.getParameter(StrResource.EARLY_WITHDRAWAL).equals(StrResource.YES)){
            filters.add(new EarlyWithdrawalFilter(true));
        }else if(req.getParameter(StrResource.EARLY_WITHDRAWAL).equals(StrResource.NO)){
            filters.add(new EarlyWithdrawalFilter(false));
        }

        if(req.getParameter(StrResource.TOP_UP).equals(StrResource.YES)){
            filters.add(new TopUpFilter(true));
        }else if(req.getParameter(StrResource.TOP_UP).equals(StrResource.NO)){
            filters.add(new TopUpFilter(false));
        }

        for(int i = 0; i < filters.size()-1; i++){
            filters.get(i).setNextFilter(filters.get(i+1));
        }

        return filters.get(0).filter(deposits);
    }

}

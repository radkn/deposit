package service;

import model.entities.AlphaBank;
import model.entities.Bank;
import model.entities.Deposit;
import model.entities.OTPBank;
import org.junit.Before;
import org.junit.Test;
import service.filters.*;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {

    private Bank alphaBank = new AlphaBank();
    private Bank otpBank = new OTPBank();
    @Before
    public void before(){
        alphaBank.addDemandDeposit(11, 9);
        alphaBank.addTimeDeposit(13, 6);
        alphaBank.addTimeDeposit(15, 12);
        otpBank.addDemandDeposit(12, 9);
        otpBank.addTimeDeposit(16,24);
    }

    @Test
    public void filterTest(){

        List<Deposit> deposits = new ArrayList<>();
        deposits.addAll(alphaBank.getDeposits());
        deposits.addAll(otpBank.getDeposits());

        List<Filter> filters = new ArrayList<>();
        filters.add(new PercentFilter(10,15));
        filters.add(new TimeFilter(6,12));
        filters.add(new TopUpFilter(false));
        filters.add(new EarlyWithdrawalFilter(false));

        for(int i = 0; i < filters.size()-1; i++){
            filters.get(i).setNextFilter(filters.get(i+1));
        }
        filters.get(0).filter(deposits).forEach(System.out::println);
    }
}

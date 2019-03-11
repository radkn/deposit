package service;

import model.entities.AlphaBank;
import model.entities.Bank;
import model.entities.Deposit;
import model.entities.OTPBank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.sort.PercentSorter;
import service.sort.TimeSorter;

import java.util.List;

public class SorterTest extends Assert {
    private Bank alphaBank = new AlphaBank();
    private Bank otpBank = new OTPBank();
    @Before
    public void before(){
        alphaBank.addDemandDeposit(10, 9);
        alphaBank.addTimeDeposit(13, 6);
        alphaBank.addTimeDeposit(14, 12);
        otpBank.addDemandDeposit(12, 9);
        otpBank.addTimeDeposit(16,24);
    }

    @Test
    public void sortByPercentTest() {
        Sorter sorter = new PercentSorter();
        List<Deposit> depositList = sorter.sort(alphaBank.getDeposits());

        depositList.forEach(System.out::println);

        System.out.println();

        sorter = new TimeSorter();
        depositList = sorter.sort(alphaBank.getDeposits());
        depositList.forEach(System.out::println);

    }
}
package controller;

import model.entities.AlphaBank;
import model.entities.Bank;
import model.entities.Deposit;
import model.entities.OTPBank;
import service.FilterService;
import service.SortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Bank> banks = createBankList();
        List<Deposit> deposits = new ArrayList<>();
        banks.forEach(d -> deposits.addAll(d.getDeposits()));

        req.setAttribute("deposits",deposits);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Bank> banks = createBankList();
        List<Deposit> deposits = new ArrayList<>();
        banks.stream().forEach(d -> deposits.addAll(d.getDeposits()));

        SortService ss = new SortService();
        FilterService fs = new FilterService();
        List<Deposit> dep;

        String str = req.getParameter("sort");
        dep = ss.doSort(deposits, str);

        dep = fs.doFilter(req,dep);

        req.setAttribute("deposits",dep);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    private List<Bank> createBankList(){
        AlphaBank alphaBank = new AlphaBank();
        alphaBank.addDemandDeposit(10, 6);
        alphaBank.addTimeDeposit(13, 6);
        alphaBank.addTimeDeposit(14, 12);

        Bank otpBank = new OTPBank();
        otpBank.addDemandDeposit(12, 9);
        otpBank.addTimeDeposit(16,24);
        List<Bank> banks = new ArrayList<Bank>();
        banks.add(alphaBank);
        banks.add(otpBank);
        return banks;
    }
}

package controller;

import model.entities.Deposit;
import service.DBService;
import service.FilterService;
import service.SortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
    private final String INDEX_JSP = "index.jsp";
    private final String DEPOSITS_ATTRIBUTE = "deposits";
    private final String SORT_PARAMETER = "sort";
    private DBService dbService;

    @Override
    public void init() throws ServletException {
        super.init();
        dbService = new DBService();
        dbService.setDriver();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Deposit> deposits = dbService.getDepositList();
        req.setAttribute(DEPOSITS_ATTRIBUTE,deposits);
        req.getRequestDispatcher(INDEX_JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Deposit> deposits = dbService.getDepositList();

        SortService ss = new SortService();
        FilterService fs = new FilterService();
        List<Deposit> dep;

        String str = req.getParameter(SORT_PARAMETER);

        dep = ss.doSort(deposits, str);
        dep = fs.doFilter(req,dep);

        req.setAttribute(DEPOSITS_ATTRIBUTE,dep);
        req.getRequestDispatcher(INDEX_JSP).forward(req,resp);
    }


}

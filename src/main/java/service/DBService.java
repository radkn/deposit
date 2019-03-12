package service;

import model.dao.DAOFactory;
import model.dao.GenericDAO;
import model.dao.MySqlDaoFactory;
import model.entities.Deposit;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    public List<Deposit> getDepositList(){

        List<Deposit> dep = new ArrayList<>();
        DAOFactory daoFactory = new MySqlDaoFactory();
        try(Connection con = daoFactory.getConnection()){
            GenericDAO dao = daoFactory.getDAO(con, Deposit.class);
            dep = dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return dep;
    }

    public void setDriver(){
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

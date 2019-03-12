package model.dao;

import model.entities.Bank;
import model.entities.Deposit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DAOFactory {

    private Map<Class, DaoCreator> creators;

    /**
     * create a list of possible database classes
     */
    public MySqlDaoFactory() {
        creators = new HashMap<>();
        creators.put(Bank.class, new DaoCreator<Connection>() {
            @Override
            public GenericDAO create(Connection connection) {
                return new MySqlBankDao(connection);
            }
        });

        creators.put(Deposit.class, new DaoCreator<Connection>() {
            @Override
            public GenericDAO create(Connection connection) {
                return new MySqlDepositDao(connection);
            }
        });

    }


    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBResource.DB_URL, DBResource.DB_USER, DBResource.DB_PASSWORD);
    }


    @Override
    public GenericDAO getDAO(Connection connection, Class dtoClass) throws Exception {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new Exception("Dao object " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }
}


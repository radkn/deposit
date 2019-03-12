package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory<Context>{



    interface DaoCreator<Context>{
        GenericDAO create(Context context);
    }

    /**
     * @return connection to the database
     * @throws SQLException
     */
    Connection getConnection () throws SQLException;

    /**
     *
     * @param connection connection to DB
     * @param dtoClass class corresponding to DB table
     * @return an object that contains a connection with the current state of the database at that particular moment
     * @throws Exception
     */
    GenericDAO getDAO(Connection connection, Class dtoClass) throws Exception;
}

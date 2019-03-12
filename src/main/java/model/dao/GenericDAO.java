package model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {


    /**
     * Creates a new record and its corresponding object
     *calling method persist
     * @param object object which need to write in DB
     * @return written object
     * @throws SQLException
     */
    T create(T object) throws SQLException;

    /**
     * Creates a new record corresponding to the object "object"
     * @param object object which need to write in DB
     * @return
     * @throws SQLException
     */
    T persist(T object) throws SQLException;

    /**
     * Returns an object corresponding to a record with a primary key "key" or null
     * @param key id of record you need
     * @return object corresponding to a record you need
     * @throws Exception
     */
    T getByPk(int key) throws Exception;


    /**
     * @return all objects of the selected table
     * @throws SQLException
     */
    List<T> getAll() throws SQLException;

    /**
     * Saves the state of the object in the database
     * @param object object which need to update in DB
     * @throws SQLException
     */
    void update(T object) throws SQLException;

    /**
     * Delete record about an object from the database
     * @param id id of record need to delete
     * @throws SQLException
     */
    void delete(int id) throws SQLException;

}

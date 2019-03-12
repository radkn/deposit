package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**implements similar methods of obtaining data from the database*/
public abstract class AbstractJDBCDao<T> implements GenericDAO<T>{

    public AbstractJDBCDao(Connection connection){
        this.connection = connection;
    }

    private Connection connection;

    /**
     * Return Query to get all records.
     * <p/>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * Return Query to create new record in Line table.
     * <p/>
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * Return Query to update record in Line table.
     * <p/>
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * Return Query to delete record by ID in table.
     * <p/>
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Disassembles the ResultSet and returns a list of objects corresponding to the contents of the ResultSet
     * @param rs
     * @return returns a list of objects T
     */
    protected abstract List<T> parseResultSet(ResultSet rs);

    /**
     * Sets the arguments of the insert request according to the value of the fields of the object.
     * @param statement connection with table
     * @param object object to insert
     * @throws Exception
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws Exception;

    /**
     * Sets the arguments of the update request according to the value of the fields of the object.
     * @param statement connection with table
     * @param object object to update
     * @throws Exception
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws Exception;

    /**
     * Create new record in DB Table
     * @param object determines table to create record
     * @return created record
     * @throws SQLException
     */
    @Override
    public T persist(T object) throws SQLException {
        T persistInstance = null;
        /**Add record*/
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On persist modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**Get just insert record*/
        sql = getSelectQuery() + " WHERE id = LAST_INSERT_ID();";// + lastId;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new Exception("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persistInstance;
    }

    /**
     * update record by ID object
     * @param object object of appropriate records
     */
    @Override
    public void update(T object) {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if(count != 1){
                throw new Exception("On update modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return  all records of the selected table as a list of objects
     */
    @Override
    public List<T> getAll(){
        List<T> list = new ArrayList<T>();
        String sql = getSelectQuery();
        try(PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            list = parseResultSet(rs);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * @param key ID of records
     * @return records of table
     * @throws Exception
     */
    @Override
    public T getByPk(int key) throws Exception {
        List<T> list = null;
        String sql = getSelectQuery() + "WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        if ((list == null) || (list.size() == 0)){
            throw new Exception("Record with PK = " + key + " not found.");
        }
        if (list.size()>1){
            throw new Exception("Received more than one record.");
        }
        return list.iterator().next();
    }

    /**
     * Delete record by ID
     * @param id ID of record
     */
    @Override
    public void delete(int id) {
        String sql = getDeleteQuery();
        try(PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1,id);
            int count = stm.executeUpdate();
            if(count != 1){
                throw new Exception("On delete modify more then 1 record: " + count);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

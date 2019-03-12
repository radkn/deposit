package model.dao;

import model.entities.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlBankDao extends AbstractJDBCDao<Bank> {

    public MySqlBankDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM bank";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO bank (name) VALUES (?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE bank SET name = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM bank WHERE id= ?";
    }

    @Override
    protected List<Bank> parseResultSet(ResultSet rs) {
        LinkedList<Bank> result = new LinkedList<Bank>();
        try {
            while (rs.next()){
                Bank bank = new Bank();
                bank.setId(rs.getInt(1));
                bank.setName(rs.getString(2));
                result.add(bank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Bank object) throws Exception {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Bank object) throws Exception {

    }

    @Override
    public Bank create(Bank object) throws SQLException {
        return null;
    }
}

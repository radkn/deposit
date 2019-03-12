package model.dao;

import model.entities.Deposit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlDepositDao extends AbstractJDBCDao<Deposit> {
    public MySqlDepositDao(Connection connection) {
        super(connection);

    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM deposit";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO deposit (bank_id, percent, month, earlyWithdrawal, topUp) VALUES (?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE deposit SET bank_id = ?, percent = ?, month = ?, earlyWithdrawal = ?, topUp = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM deposit WHERE id= ?";
    }

    @Override
    protected List<Deposit> parseResultSet(ResultSet rs) {
        LinkedList<Deposit> result = new LinkedList<Deposit>();
        try {
            while (rs.next()){
                Deposit deposit = new Deposit();
                deposit.setId(rs.getInt(1));
                deposit.setBank_id(rs.getInt(2));
                deposit.setPercent(rs.getInt(3));
                deposit.setMonth(rs.getInt(4));
                deposit.setEarlyWithdrawal(rs.getBoolean(5));
                deposit.setTopUp(rs.getBoolean(6));
                result.add(deposit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Deposit object) throws Exception {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Deposit object) throws Exception {

    }


    @Override
    public Deposit create(Deposit object) throws SQLException {
        return null;
    }
}

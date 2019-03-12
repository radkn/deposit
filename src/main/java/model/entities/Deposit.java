package model.entities;

public class Deposit implements Comparable{
    private int id;
    private int bank_id;
    private int percent;
    private int month;
    private boolean earlyWithdrawal;
    private boolean topUp;

    public Deposit() {
    }

   public Deposit(int percent, int month, boolean earlyWithdrawal, boolean topUp) {
        this.percent = percent;
        this.month = month;
        this.earlyWithdrawal = earlyWithdrawal;
        this.topUp = topUp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean isEarlyWithdrawal() {
        return earlyWithdrawal;
    }

    public void setEarlyWithdrawal(boolean earlyWithdrawal) {
        this.earlyWithdrawal = earlyWithdrawal;
    }

    public boolean isTopUp() {
        return topUp;
    }

    public void setTopUp(boolean topUp) {
        this.topUp = topUp;
    }

    public int compareTo(Object o) {
        return new Integer(percent).compareTo(((Deposit)o).getPercent());
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "percent=" + percent +
                ", month=" + month +
                ", earlyWithdrawal=" + earlyWithdrawal +
                ", topUp=" + topUp +
                '}';
    }
}

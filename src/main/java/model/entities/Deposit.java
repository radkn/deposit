package model.entities;

public class Deposit implements Comparable{
    private int id;
    private int bank_id;
    private int percent;
    private int month;
    private boolean earlyWithdrawal;
    private boolean topUp;

    Deposit(int percent, int month, boolean earlyWithdrawal, boolean topUp) {
        this.percent = percent;
        this.month = month;
        this.earlyWithdrawal = earlyWithdrawal;
        this.topUp = topUp;
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

    public boolean isTopUp() {
        return topUp;
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

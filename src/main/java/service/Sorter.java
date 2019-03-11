package service;

import model.entities.Deposit;

import java.util.List;

public interface Sorter {
    List<Deposit> sort(List<Deposit> deposits);
}

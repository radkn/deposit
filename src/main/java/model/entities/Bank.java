package model.entities;

import java.util.LinkedList;
import java.util.List;

public class Bank {
    private int id;
    private String name;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

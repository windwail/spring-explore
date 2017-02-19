package ru.windwail.business;

import java.math.BigDecimal;

/**
 * Created by icetusk on 19.02.17.
 */
public class Account {

    public Account() {
    }

    public Account(Integer id, String name, BigDecimal deposit) {
        this.name = name;
        this.deposit = deposit;
        this.id = id;
    }

    private Integer id;
    private String name;
    private BigDecimal deposit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

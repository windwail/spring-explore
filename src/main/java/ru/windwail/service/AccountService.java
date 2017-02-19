package ru.windwail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.windwail.business.Account;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by icetusk on 19.02.17.
 */
@Repository
public class AccountService {

    @Autowired
    JdbcTemplate template;

    public Account createAccount(String name, BigDecimal deposit) {
        Account acc = new Account(null, name,deposit);

        String sqlTxt = "insert into accounts (name, deposit) values (?,?)";
        template.update(sqlTxt, name, deposit);

        return acc;
    }


    public List<Account> getAccounts() {
        String sqlTxt = "select * from accounts";
        return template.query(sqlTxt, accountRowMapper);
    }

    public Integer count() {
        return template.queryForObject("select count(*) from accounts", Integer.class);
    }

    private RowMapper<Account> accountRowMapper = new RowMapper<Account>() {
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Account(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getBigDecimal("deposit"));
        }
    };
}

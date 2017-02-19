package ru.windwail;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by icetusk on 19.02.17.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class MyConfiguration {

  @Bean
  public JdbcTemplate template() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/bank");

    return  dataSource;
  }

}

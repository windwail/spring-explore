package ru.windwail;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.windwail.service.AccountService;

import java.math.BigDecimal;

/**
 * Created by icetusk on 19.02.17.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);

        AccountService service = context.getBean(AccountService.class);

        service.createAccount("Anotherone", new BigDecimal(300));
        System.out.println(service.getAccounts().size());
    }
}

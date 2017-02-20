package ru.windwail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.windwail.business.Account;
import ru.windwail.service.AccountService;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by icetusk on 19.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfiguration.class)
//@ActiveProfiles("test")
@Transactional
public class RepositoryTest {

    @Autowired
    AccountService service;

    @Test
    public void testCreation() throws Exception {
        List<Account> accounts = service.getAccounts();
        assertThat(accounts.size(), is(5));

    }


}

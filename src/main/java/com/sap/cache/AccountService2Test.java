package com.sap.cache;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import static org.junit.Assert.*;
 
public class AccountService2Test {
 
    private AccountService2 accountService2;
 
    private final Logger logger = LoggerFactory.getLogger(AccountService2Test.class);
 
    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cache.xml");
        accountService2 = context.getBean("accountService2", AccountService2.class);
    }
 
    @Test
    public void testInject(){
        assertNotNull(accountService2);
    }
 
    @Test
    public void testGetAccountByName() throws Exception {
        logger.info("first query... solution2");
        accountService2.getAccountByName("accountName");
 
        logger.info("second query...");
        Account account = accountService2.getAccountByName("accountName");
        logger.info("account got from Cache: {}", account.getName());
    }
}

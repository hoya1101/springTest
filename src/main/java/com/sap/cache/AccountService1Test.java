package com.sap.cache;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/*
 * Jerry 2016-12-25 13:15PM still works?
 * System.setProperty("log4j.configuration", "log4j.properties");
 */
public class AccountService1Test {
	
	static {

	    // System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
		// System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
	}
	
	private AccountService1 accountService1;
	 
    private final Logger logger = LoggerFactory.getLogger(AccountService1Test.class);
 
    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        accountService1 = context.getBean("accountService1", AccountService1.class);
    }
 
    @Test
    public void testInject(){
        assertNotNull(accountService1);
    }
 
    @Test
    public void testGetAccountByName() throws Exception {
        accountService1.getAccountByName("accountName");
        accountService1.getAccountByName("accountName");
 
        accountService1.reload();
        logger.info("after reload ....");
 
        accountService1.getAccountByName("accountName");
        accountService1.getAccountByName("accountName");
    }
}

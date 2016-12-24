package com.sap.cache;

import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountService1 {
	
	// 使用时只要把相应的jar包（只有一个）放到类路径上即可。
	private final Logger logger = LoggerFactory.getLogger(AccountService1.class);
    
	@Resource
    private CacheContext<Account> accountCacheContext;
 
    public Account getAccountByName(String accountName) {
        Account result = accountCacheContext.get(accountName);
        if (result != null) {
        	System.out.println("get from Cache: " + accountName);
            logger.info("get from cache... {}", accountName);
            return result;
        }
 
        Optional<Account> accountOptional = getFromDB(accountName);
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }
 
        Account account = accountOptional.get();
        accountCacheContext.addOrUpdateCache(accountName, account);
        return account;
    }
 
    public void reload() {
        accountCacheContext.evictCache();
    }
 
    private Optional<Account> getFromDB(String accountName) {
        logger.info("real querying db... {}", accountName);
        System.out.println("read querying db...: " + accountName);
        //Todo query data from database
        return Optional.ofNullable(new Account(accountName));
    }
}

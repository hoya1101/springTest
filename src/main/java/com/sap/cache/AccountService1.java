package com.sap.cache;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.commons.logging.LogFactory;



public class AccountService1 {
	private final Logger logger = (Logger) LogFactory.getLog(AccountService1.class);
	 
    @Resource
    private CacheContext<Account> accountCacheContext;
 
    public Account getAccountByName(String accountName) {
        Account result = accountCacheContext.get(accountName);
        if (result != null) {
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
        //Todo query data from database
        return Optional.fromNullable(new Account(accountName));
    }
}

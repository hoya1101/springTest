package com.sap.cache;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
@Service
public class AccountService2 {
 
    private final Logger logger = LoggerFactory.getLogger(AccountService2.class);

    @Cacheable(value="accountCache")
    public Account getAccountByName(String accountName) {
 
        logger.info("in method getAccountByName, querying account... {}", accountName);
        Optional<Account> accountOptional = getFromDB(accountName);
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }
 
        return accountOptional.get();
    }
 
    private Optional<Account> getFromDB(String accountName) {
        logger.info("real querying db... {}", accountName);
        return Optional.ofNullable(new Account(accountName));
    }
}

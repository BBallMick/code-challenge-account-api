package com.mhb.accountapi.domain.account.exception;

import com.mhb.accountapi.domain.shared.model.id.AccountId;

/**
 * ProjectNotFoundException
 */
public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(AccountId id) {
        super(String.format("Could not find account with Id: [%s] ", id.getValue()));
    }
}
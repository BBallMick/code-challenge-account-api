package com.mhb.accountapi.app.transfer.exception;

import com.mhb.accountapi.domain.shared.model.id.AccountId;

/**
 * ProjectNotFoundException
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(AccountId id) {
        super(String.format("Account [%s] has insufficient funds to complete the transfer", id.getValue()));
    }
}
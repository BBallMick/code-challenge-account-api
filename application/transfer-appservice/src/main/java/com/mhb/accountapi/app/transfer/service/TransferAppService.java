package com.mhb.accountapi.app.transfer.service;

import com.mhb.accountapi.app.transfer.exception.InsufficientFundsException;
import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.account.exception.AccountNotFoundException;
import com.mhb.accountapi.domain.account.service.AccountService;
import com.mhb.accountapi.domain.transfer.commands.TransferMoneyCommand;
import com.mhb.accountapi.domain.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferAppService {

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountService accountService;

    public void transferMoney(TransferMoneyCommand command) throws AccountNotFoundException, InsufficientFundsException {
        Optional<Account> optionalFromAccount = accountService.getAccount(command.getFromAccountId());
        Optional<Account> optionalToAccount = accountService.getAccount(command.getToAccountId());

        if (optionalFromAccount.isEmpty()) {
            throw new AccountNotFoundException(command.getFromAccountId());
        }
        if (optionalToAccount.isEmpty()) {
            throw new AccountNotFoundException(command.getToAccountId());
        }

        if (optionalFromAccount.get().getBalance().compareTo(command.getAmount()) < 0) {
            throw new InsufficientFundsException(optionalFromAccount.get().getAccountId());
        }

        //Given the nature of such an action, it could be implemented in an asynchronous way so that it merely sends
        // an event/message and returns and then an event handler would pick up the events as they come in.
        transferService.createTransfer(command);
    }
}

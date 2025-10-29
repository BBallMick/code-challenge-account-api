package com.mhb.accountapi.domain.account.service;

import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.account.commands.CreateAccountCommand;
import com.mhb.accountapi.domain.account.exception.AccountNotFoundException;
import com.mhb.accountapi.domain.account.repository.AccountRepository;
import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccounts(UserId userId) {
        return accountRepository.findAccountsByUserId(userId);
    }

    public Account createAccount(CreateAccountCommand command) {
        Account accountToSave = Account.builder()
                .name(command.getName())
                .createdDateTime(Instant.now().atOffset(ZoneOffset.UTC))
                .userId(command.getUserId()).build();
        return accountRepository.save(accountToSave);
    }

    public Optional<Account> getAccount(AccountId accountId) throws AccountNotFoundException {
        return accountRepository.getAccount(accountId);
    }
}

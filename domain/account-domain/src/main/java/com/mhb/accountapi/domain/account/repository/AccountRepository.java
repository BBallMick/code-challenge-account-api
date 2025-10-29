package com.mhb.accountapi.domain.account.repository;

import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.account.exception.AccountNotFoundException;
import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;

import java.util.List;
import java.util.Optional;

/**
 * ProjectRepository
 */
public interface AccountRepository {

    Optional<Account> getAccount(AccountId accountId);

    List<Account> findAccountsByUserId(UserId userId);

    Account save(Account account);

}
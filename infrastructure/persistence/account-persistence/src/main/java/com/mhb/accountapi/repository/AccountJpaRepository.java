package com.mhb.accountapi.repository;

import com.mhb.accountapi.AccountEntity;
import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.account.repository.AccountRepository;
import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import com.mhb.accountapi.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountJpaRepository implements AccountRepository {

    @Autowired
    SpringAccountRepository springAccountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Optional<Account> getAccount(AccountId accountId) {
        return Optional.ofNullable(springAccountRepository.findByAccountId(accountId.getValue()))
                .map(accountEntity -> accountMapper.toAccount(accountEntity));
    }

    @Override
    public List<Account> findAccountsByUserId(UserId userId) {
        return springAccountRepository.findAllByUserId(userId.getValue()).stream()
                .map(accountMapper::toAccount)
                .toList();
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = accountMapper.toAccountEntity(account);
        accountEntity = springAccountRepository.save(accountEntity);
        return accountMapper.toAccount(accountEntity);
    }
}

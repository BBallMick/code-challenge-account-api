package com.mhb.accountapi.repository;

import com.mhb.accountapi.AccountEntity;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringAccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByAccountId(String accountId);

    List<AccountEntity> findAllByUserId(String userId);
}

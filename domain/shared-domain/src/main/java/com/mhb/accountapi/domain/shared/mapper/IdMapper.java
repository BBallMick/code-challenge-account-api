package com.mhb.accountapi.domain.shared.mapper;

import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.TransferId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class IdMapper {

    public String toString(AccountId userId) {
        return userId != null ?  userId.getValue() : null;
    }

    public AccountId toAccountId(String accountId) {
        return accountId != null ? new AccountId(accountId) : null;
    }

    public String toString(TransferId transferId) {
        return transferId != null ?  transferId.getValue() : null;
    }

    public TransferId toTransferId(String userId) {
        return userId != null ? new TransferId(userId) : null;
    }

    public String toString(UserId userId) {
        return userId != null ?  userId.getValue() : null;
    }

    public UserId toUserId(String userId) {
        return userId != null ? new UserId(userId) : null;
    }
}

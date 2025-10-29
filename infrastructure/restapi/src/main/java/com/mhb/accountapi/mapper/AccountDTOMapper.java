package com.mhb.accountapi.mapper;

import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.model.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AccountDTOMapper {

    public abstract AccountDTO toAccountDTO(Account account);

    String toString(AccountId accountId) {
        return accountId != null ? accountId.getValue() : null;
    }


}

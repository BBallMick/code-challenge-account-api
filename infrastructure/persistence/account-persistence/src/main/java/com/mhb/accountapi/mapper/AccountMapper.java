package com.mhb.accountapi.mapper;

import com.mhb.accountapi.AccountEntity;
import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.shared.mapper.IdMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = IdMapper.class)
public interface AccountMapper {

    Account toAccount(AccountEntity accountEntity);

    AccountEntity toAccountEntity(Account account);


}

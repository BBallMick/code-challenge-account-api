package com.mhb.accountapi.domain.transfer.commands;

import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class TransferMoneyCommand {

    AccountId fromAccountId;

    AccountId toAccountId;

    UserId transferredBy;

    BigDecimal amount;
}

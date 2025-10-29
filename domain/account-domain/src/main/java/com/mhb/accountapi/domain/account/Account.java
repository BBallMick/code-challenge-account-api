package com.mhb.accountapi.domain.account;

import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Domain class for Project. This class acts as the aggregated root of IKA-WORK
 */
@Value
@Builder(toBuilder = true)
public class Account {

    AccountId accountId;

    OffsetDateTime createdDateTime;

    String name;

    UserId userId;

    BigDecimal balance;

}
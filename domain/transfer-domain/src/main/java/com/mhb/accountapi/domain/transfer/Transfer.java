package com.mhb.accountapi.domain.transfer;

import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.TransferId;
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
public class Transfer {

    TransferId transferId;

    OffsetDateTime createdDateTime;

    AccountId fromAccount;

    AccountId toAccount;

    BigDecimal amount;

    UserId transferredBy;

}
package com.mhb.accountapi.domain.account.commands;

import com.mhb.accountapi.domain.shared.model.id.UserId;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAccountCommand {

    String name;

    UserId userId;
}

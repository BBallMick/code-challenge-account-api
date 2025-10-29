package com.mhb.accountapi.controller;

import com.mhb.accountapi.api.AccountsApi;
import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.account.commands.CreateAccountCommand;
import com.mhb.accountapi.domain.account.service.AccountService;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import com.mhb.accountapi.mapper.AccountDTOMapper;
import com.mhb.accountapi.model.AccountDTO;
import com.mhb.accountapi.model.CreateAccountRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaskController
 */
@RestController
@RequestMapping("/accounts")
public class AccountController implements AccountsApi {

    @Autowired
    AccountService transferService;

    @Autowired
    AccountDTOMapper accountDTOMapper;

    @Override
    public ResponseEntity<AccountDTO> createAccount(CreateAccountRequestBody createAccountRequestBody) {
        CreateAccountCommand command = CreateAccountCommand.builder()
                .name(createAccountRequestBody.getName())
                .userId(new UserId(createAccountRequestBody.getUserId()))
                .build();
        Account createdAccount = transferService.createAccount(command);

        return ResponseEntity.ok().body(accountDTOMapper.toAccountDTO(createdAccount));
    }

}
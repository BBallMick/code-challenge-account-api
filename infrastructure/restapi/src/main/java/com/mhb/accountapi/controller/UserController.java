package com.mhb.accountapi.controller;

import com.mhb.accountapi.api.UsersApi;
import com.mhb.accountapi.domain.account.service.AccountService;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import com.mhb.accountapi.mapper.AccountDTOMapper;
import com.mhb.accountapi.model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController implements UsersApi {

    @Autowired
    AccountService transferService;

    @Autowired
    AccountDTOMapper accountDTOMapper;

    @Override
    public ResponseEntity<List<AccountDTO>> getAccounts(String userId) {
        List<AccountDTO> accountDTOs = transferService.getAccounts(new UserId(userId)).stream()
                .map(accountDTOMapper::toAccountDTO)
                .toList();
        return ResponseEntity.ok(accountDTOs);
    }
}
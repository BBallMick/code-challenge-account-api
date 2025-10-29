package com.mhb.accountapi.controller;

import com.mhb.accountapi.api.TransfersApi;
import com.mhb.accountapi.app.transfer.exception.InsufficientFundsException;
import com.mhb.accountapi.app.transfer.service.TransferAppService;
import com.mhb.accountapi.domain.account.exception.AccountNotFoundException;
import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import com.mhb.accountapi.domain.transfer.commands.TransferMoneyCommand;
import com.mhb.accountapi.model.TransferMoneyRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaskController
 */
@RestController
@RequestMapping("/transfers")
public class TransferController implements TransfersApi {

    @Autowired
    TransferAppService transferAppService;

    @Override
    public ResponseEntity<Void> transferMoney(TransferMoneyRequestBody body) {
        TransferMoneyCommand command = TransferMoneyCommand.builder()
                .toAccountId(new AccountId(body.getToAccountId()))
                .fromAccountId(new AccountId(body.getFromAccountId()))
                .transferredBy(new UserId(body.getTransferredBy()))
                .amount(body.getAmount())
                .build();
        try {
            transferAppService.transferMoney(command);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InsufficientFundsException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
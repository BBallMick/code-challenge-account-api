package com.mhb.accountapi.app.transfer.service;

import com.mhb.accountapi.domain.account.Account;
import com.mhb.accountapi.domain.account.exception.AccountNotFoundException;
import com.mhb.accountapi.domain.account.service.AccountService;
import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import com.mhb.accountapi.domain.transfer.commands.TransferMoneyCommand;
import com.mhb.accountapi.domain.transfer.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransferAppServiceTest {

    @Mock
    private Account accountMock;

    @Mock
    TransferService transferService;

    @Mock
    AccountService accountService;

    @InjectMocks
    TransferAppService transferAppService;

    @Test
    void givenEmptyFromAccount_whenTransferringMoney_ThenThrowException() throws Exception {
        //given
        AccountId accountId1 = new AccountId("1");
        AccountId accountId2 = new AccountId("2");
        when(accountService.getAccount(accountId1)).thenReturn(Optional.empty());
        when(accountService.getAccount(accountId2)).thenReturn(Optional.of(accountMock));

        //when + then
        TransferMoneyCommand command = TransferMoneyCommand.builder()
                .toAccountId(accountId1)
                .fromAccountId(accountId2)
                .transferredBy(new UserId("user1"))
                .amount(BigDecimal.TEN)
                .build();
        assertThrows(AccountNotFoundException.class, () -> transferAppService.transferMoney(command));
    }

    @Test
    void givenEmptyToAccount_whenTransferringMoney_ThenThrowException() throws Exception {
        //given
        AccountId accountId1 = new AccountId("1");
        AccountId accountId2 = new AccountId("2");
        when(accountService.getAccount(accountId1)).thenReturn(Optional.of(accountMock));
        when(accountService.getAccount(accountId2)).thenReturn(Optional.empty());

        //when + then
        TransferMoneyCommand command = TransferMoneyCommand.builder()
                .toAccountId(accountId1)
                .fromAccountId(accountId2)
                .transferredBy(new UserId("user1"))
                .amount(BigDecimal.TEN)
                .build();
        assertThrows(AccountNotFoundException.class, () -> transferAppService.transferMoney(command));
    }

    @Test
    void givenBalanceLessThanAmount_whenTransferringMoney_ThenThrowException() throws Exception {
        //given
        AccountId accountId1 = new AccountId("1");
        AccountId accountId2 = new AccountId("2");
        when(accountService.getAccount(accountId1)).thenReturn(Optional.of(accountMock));
        when(accountService.getAccount(accountId2)).thenReturn(Optional.empty());

        //when + then
        TransferMoneyCommand command = TransferMoneyCommand.builder()
                .toAccountId(accountId1)
                .fromAccountId(accountId2)
                .transferredBy(new UserId("user1"))
                .amount(BigDecimal.TEN)
                .build();
        assertThrows(AccountNotFoundException.class, () -> transferAppService.transferMoney(command));
    }

}
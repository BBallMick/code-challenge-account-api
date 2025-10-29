package com.mhb.accountapi.domain.transfer.service;

import com.mhb.accountapi.domain.shared.model.id.TransferId;
import com.mhb.accountapi.domain.transfer.Transfer;
import com.mhb.accountapi.domain.transfer.commands.TransferMoneyCommand;
import com.mhb.accountapi.domain.transfer.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepository;

    public Transfer createTransfer(TransferMoneyCommand command) {
        Transfer transferToSave = Transfer.builder()
                .fromAccount(command.getFromAccountId())
                .toAccount(command.getToAccountId())
                .transferredBy(command.getTransferredBy())
                .amount(command.getAmount())
                .createdDateTime(Instant.now().atOffset(ZoneOffset.UTC))
                .transferId(new TransferId(UUID.randomUUID().toString()))
                .build();
        return transferRepository.save(transferToSave);
    }
}

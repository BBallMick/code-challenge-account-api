package com.mhb.accountapi.persistence.transfer.repository;

import com.mhb.accountapi.domain.transfer.Transfer;
import com.mhb.accountapi.domain.transfer.repository.TransferRepository;
import com.mhb.accountapi.persistence.transfer.entity.TransferEntity;
import com.mhb.accountapi.persistence.transfer.mapper.TransferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferJpaRepository implements TransferRepository {

    @Autowired
    SpringTransferRepository springTransferRepository;

    @Autowired
    TransferMapper transferMapper;

    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity transferEntity = transferMapper.toTransferEntity(transfer);
        transferEntity = springTransferRepository.save(transferEntity);
        return transferMapper.toTransfer(transferEntity);
    }
}

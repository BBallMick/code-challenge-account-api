package com.mhb.accountapi.domain.transfer.repository;

import com.mhb.accountapi.domain.transfer.Transfer;

/**
 * ProjectRepository
 */
public interface TransferRepository {

    public Transfer save(Transfer transfer);

}
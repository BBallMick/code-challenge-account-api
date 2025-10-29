package com.mhb.accountapi.persistence.transfer.repository;

import com.mhb.accountapi.persistence.transfer.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringTransferRepository extends JpaRepository<TransferEntity, Long> {

}

package com.mhb.accountapi.persistence.transfer.mapper;

import com.mhb.accountapi.domain.shared.mapper.IdMapper;
import com.mhb.accountapi.domain.transfer.Transfer;
import com.mhb.accountapi.persistence.transfer.entity.TransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = IdMapper.class)
public interface TransferMapper {


    Transfer toTransfer(TransferEntity transferEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "transferredBy")
    TransferEntity toTransferEntity(Transfer account);


}

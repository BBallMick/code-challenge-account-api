package com.mhb.accountapi.persistence.transfer.entity;

import com.mhb.accountapi.domain.shared.model.id.AccountId;
import com.mhb.accountapi.domain.shared.model.id.UserId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TransferEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String transferId;

    private AccountId fromAccount;

    private AccountId toAccount;

    BigDecimal amount;

    private UserId userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public AccountId getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(AccountId fromAccount) {
        this.fromAccount = fromAccount;
    }

    public AccountId getToAccount() {
        return toAccount;
    }

    public void setToAccount(AccountId toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }
}
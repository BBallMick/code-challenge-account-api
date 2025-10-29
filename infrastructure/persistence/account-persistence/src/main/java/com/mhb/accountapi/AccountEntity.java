package com.mhb.accountapi;

import jakarta.persistence.*;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String accountId;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

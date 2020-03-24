package com.ibm.bank.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userId",
    "name",
    "bankAccount",
    "agency",
    "balance"
})
public class UserAccount {

    @JsonProperty("userId")
    private long userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("bankAccount")
    private String bankAccount;

    @JsonProperty("agency")
    private String agency;

    @JsonProperty("balance")
    private double balance;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public UserAccount() {
    }

    public UserAccount(long userId, String name, String bankAccount, String agency, double balance) {
        super();
        this.userId = userId;
        this.name = name;
        this.bankAccount = bankAccount;
        this.agency = agency;
        this.balance = balance;
    }

    @JsonProperty("userId")
    public long getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("bankAccount")
    public String getBankAccount() {
        return bankAccount;
    }

    @JsonProperty("bankAccount")
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @JsonProperty("agency")
    public String getAgency() {
        return agency;
    }

    @JsonProperty("agency")
    public void setAgency(String agency) {
        this.agency = agency;
    }

    @JsonProperty("balance")
    public double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
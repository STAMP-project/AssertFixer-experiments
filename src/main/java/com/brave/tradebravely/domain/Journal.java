package com.brave.tradebravely.domain;

import java.time.Instant;

public class Journal {

    private Instant date;
    private Double amount;
    private Double balance;
    private Long contextId;
    private String contextIdType;
    private String description;
    private Integer firstPartyId;
    private Integer secondPartyId;
    private Long id;
    private String reason;
    private String refType;
    private Double tax;
    private Integer taxReceiverId;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getContextId() {
        return contextId;
    }

    public void setContextId(Long contextId) {
        this.contextId = contextId;
    }

    public String getContextIdType() {
        return contextIdType;
    }

    public void setContextIdType(String contextIdType) {
        this.contextIdType = contextIdType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFirstPartyId() {
        return firstPartyId;
    }

    public void setFirstPartyId(Integer firstPartyId) {
        this.firstPartyId = firstPartyId;
    }

    public Integer getSecondPartyId() {
        return secondPartyId;
    }

    public void setSecondPartyId(Integer secondPartyId) {
        this.secondPartyId = secondPartyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getTaxReceiverId() {
        return taxReceiverId;
    }

    public void setTaxReceiverId(Integer taxReceiverId) {
        this.taxReceiverId = taxReceiverId;
    }
}

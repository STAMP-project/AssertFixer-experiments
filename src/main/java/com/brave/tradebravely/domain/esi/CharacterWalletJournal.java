package com.brave.tradebravely.domain.esi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterWalletJournal {

    @JsonProperty("date")
    private String date;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("context_id")
    private Long contextId;
    @JsonProperty("context_id_type")
    private String contextIdType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("first_party_id")
    private Integer firstPartyId;
    @JsonProperty("second_party_id")
    private Integer secondPartyId;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("ref_type")
    private String refType;
    @JsonProperty("tax")
    private Double tax;
    @JsonProperty("tax_receiver_id")
    private Integer taxReceiverId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

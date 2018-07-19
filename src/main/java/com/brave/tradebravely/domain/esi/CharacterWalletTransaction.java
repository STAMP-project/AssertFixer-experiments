package com.brave.tradebravely.domain.esi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterWalletTransaction {

    @JsonProperty("client_id")
    private Integer clientId;

    @JsonProperty("date")
    private String date;

    @JsonProperty("is_buy")
    private Boolean isBuy;

    @JsonProperty("journal_ref_id")
    private Long journalRefId;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("transaction_id")
    private Long transactionId;

    @JsonProperty("type_id")
    private Integer typeId;

    @JsonProperty("unit_price")
    private Double unitPrice;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getBuy() {
        return isBuy;
    }

    public void setBuy(Boolean buy) {
        isBuy = buy;
    }

    public Long getJournalRefId() {
        return journalRefId;
    }

    public void setJournalRefId(Long journalRefId) {
        this.journalRefId = journalRefId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

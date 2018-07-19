package com.brave.tradebravely.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Transaction.
 */
@Document(collection = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("character_id")
    private Integer characterId;

    @Field("date")
    private Instant date;

    @Field("transaction_id")
    private Long transactionId;

    @Field("contract_id")
    private Long contractId;

    @Field("type_id")
    private Integer typeId;

    @Field("type_name")
    private String typeName;

    @Field("amount")
    private Integer amount;

    @Field("price_per_unit")
    private Double pricePerUnit;

    @Field("other_party")
    private Integer otherParty;

    @Field("location_id")
    private Long locationId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public Transaction characterId(Integer characterId) {
        this.characterId = characterId;
        return this;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Instant getDate() {
        return date;
    }

    public Transaction date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Transaction transactionId(Long transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getContractId() {
        return contractId;
    }

    public Transaction contractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Transaction typeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public Transaction typeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getAmount() {
        return amount;
    }

    public Transaction amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public Transaction pricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        return this;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getOtherParty() {
        return otherParty;
    }

    public Transaction otherParty(Integer otherParty) {
        this.otherParty = otherParty;
        return this;
    }

    public void setOtherParty(Integer otherParty) {
        this.otherParty = otherParty;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Transaction locationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        if (transaction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transaction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + getId() +
            ", characterId=" + getCharacterId() +
            ", date='" + getDate() + "'" +
            ", transactionId=" + getTransactionId() +
            ", contractId=" + getContractId() +
            ", typeId=" + getTypeId() +
            ", typeName='" + getTypeName() + "'" +
            ", amount=" + getAmount() +
            ", pricePerUnit=" + getPricePerUnit() +
            ", otherParty=" + getOtherParty() +
            ", locationId=" + getLocationId() +
            "}";
    }
}

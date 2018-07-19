package com.brave.tradebravely.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Tax.
 */
@Document(collection = "tax")
public class Tax implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("character_id")
    private Integer characterId;

    @Field("date")
    private Instant date;

    @Field("amount")
    private Double amount;

    @Field("description")
    private String description;

    @Field("journal_id")
    private Long journalId;

    @Field("tax")
    private Double tax;

    @Field("tax_receiver_id")
    private Integer taxReceiverId;

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

    public Tax characterId(Integer characterId) {
        this.characterId = characterId;
        return this;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Instant getDate() {
        return date;
    }

    public Tax date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public Tax amount(Double amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public Tax description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getJournalId() {
        return journalId;
    }

    public Tax journalId(Long journalId) {
        this.journalId = journalId;
        return this;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public Double getTax() {
        return tax;
    }

    public Tax tax(Double tax) {
        this.tax = tax;
        return this;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getTaxReceiverId() {
        return taxReceiverId;
    }

    public Tax taxReceivedId(Integer taxReceivedId) {
        this.taxReceiverId = taxReceivedId;
        return this;
    }

    public void setTaxReceiverId(Integer taxReceiverId) {
        this.taxReceiverId = taxReceiverId;
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
        Tax tax = (Tax) o;
        if (tax.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tax.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tax{" +
            "id=" + getId() +
            ", characterId=" + getCharacterId() +
            ", date='" + getDate() + "'" +
            ", amount=" + getAmount() +
            ", description='" + getDescription() + "'" +
            ", journalId=" + getJournalId() +
            ", tax=" + getTax() +
            ", taxReceiverId=" + getTaxReceiverId() +
            "}";
    }
}

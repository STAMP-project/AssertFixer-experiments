package com.cryptoeagle.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@NamedQueries({
        @NamedQuery(name = Coin.GET_BY_ID, query = "SELECT c FROM Coin c WHERE c.id=:id"),
        @NamedQuery(name = Coin.GET_ALL, query = "SELECT c FROM Coin c"),
        @NamedQuery(name = Coin.GET_BY_SYMBOL, query = "SELECT c FROM Coin c WHERE c.symbol=:symbol"),
        @NamedQuery(name = Coin.GET_BY_SYMBOLS, query = "SELECT c FROM Coin c WHERE c.symbol in :symbols"),
        @NamedQuery(name = Coin.GET_TOP, query = "SELECT c FROM Coin c order by c.percent_change_7d desc "),
        @NamedQuery(name = Coin.GET_LOSER, query = "SELECT c FROM Coin c order by c.percent_change_7d asc "),
        @NamedQuery(name = Coin.UPDATE, query = "UPDATE Coin c Set c.rank=:rank, c.circulating_supply=:circulating_supply," +
                "c.price=:price, c.volume_24h=:volume_24h, c.market_cap=:market_cap, c.percent_change_1h=:percent_change_1h," +
                "c.percent_change_24h=:percent_change_24h,c.percent_change_7d=:percent_change_7d")
})
@Data
public class Coin extends BaseEntity {

    public static final String GET_BY_ID = "Coin.getById";
    public static final String GET_ALL = "Coin.getAll";
    public static final String GET_BY_SYMBOL = "Coin.getBySymbol";
    public static final String GET_BY_SYMBOLS = "Coin.getBySymbols";
    public static final String GET_TOP = "Coin.getTop";
    public static final String GET_LOSER = "Coin.getLoser";
    public static final String UPDATE = "Coin.update";

    @Column(unique = true)
    private String name;
    @Column
    private String image;
    @Column(unique = true)
    private String symbol;
    @NotNull
    private int rank;
    @NotNull
    private BigDecimal circulating_supply;
    @NotNull
    private double price;
    @NotNull
    private BigDecimal volume_24h;
    @NotNull
    private BigDecimal market_cap;
    @NotNull
    private double percent_change_1h;
    @NotNull
    private double percent_change_7d;
    @NotNull
    private double percent_change_24h;
    @NotNull
    private boolean dataAvailable;

}
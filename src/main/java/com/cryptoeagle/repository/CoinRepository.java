package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Coin;

import java.util.List;

public interface CoinRepository {


    Coin getBySymbol(String symbol);

    List<Coin> getBySymbols(List<String> symbols);

    void saveCoins(List<Coin> list);

    void deleteAll();

    List<Coin> getAllCoins();

    List<Coin> getTopGainCoins();

    List<Coin> getTopLoserCoins();

}

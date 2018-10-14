package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;

import java.util.List;

public interface CoinService {

    List<Coin> getCoins(String[] ids);

    Coin getBySymbol(String symbol);

    void updateCoins();

    boolean isAvailable(String symbol);

    List<Coin> getAllCoins();

    List<Coin> getTopGainCoins();

    List<Coin> getTopLoserCoins();


}

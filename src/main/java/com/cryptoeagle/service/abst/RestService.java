package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.entity.crypto.IcoData;

import java.util.List;

public interface RestService {

    List<Event> getEvents(int count);

    List<Chart> getChartCoin(String symbol);

    List<Coin> getCoins();

    List<Ico> getIcoByPage(int page);

    List<Ico> getIcoWithDataByPage(int page);

    IcoData getDataForIco(int id);
}

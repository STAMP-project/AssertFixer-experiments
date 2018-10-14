package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.entity.crypto.IcoData;
import com.cryptoeagle.service.abst.RestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;


public class RestServiceImplTest extends AbstractTest {

    @Autowired
    RestServiceImpl service;

    @Test
    public void getEvents() {
        List<Event> events = service.getEvents(10);
        assertTrue(events.size() == 10);
    }

    @Test
    public void getTokenOAUTH() {
        String s = service.getTokenOAUTH();
        assertTrue(86 == s.length());
    }

    @Test
    public void getChartCoin() {

        List<Chart> ETH = service.getChartCoin("ETH");
        List<Chart> ADA = service.getChartCoin("ADA");
        List<Chart> TRX = service.getChartCoin("TRX");
        List<Chart> IOTA = service.getChartCoin("IOTA");
        List<Chart> BNB = service.getChartCoin("BNB");

        assertTrue(ETH.size() > 5);
        assertTrue(ADA.size() > 5);
        assertTrue(TRX.size() > 5);
        assertTrue(IOTA.size() > 5);
        assertTrue(BNB.size() > 5);
    }

    @Test
    public void getDataForIco() {
        IcoData data = service.getDataForIco(36262);
        assertTrue(data != null);
    }

//    @Test
//    public void getIcoByPage() {
//        List<Ico> icoByPage1 = service.getIcoByPage(1);
//        List<Ico> icoByPage5 = service.getIcoByPage(5);
//        List<Ico> icoByPage25 = service.getIcoByPage(25);
//        assertTrue(icoByPage1.size() == 12);
//        assertTrue(icoByPage5.size() == 12);
//        assertTrue(icoByPage25.size() == 12);
//    }

    @Test
    public void getCoins() {
        List<Coin> coins = service.getCoins();
        assertTrue(coins.size() > 50);
    }

//    @Test
//    public void getIcoWithDataByPage() {
//        List<Ico> icos = null;
//
//        for (int i = 0; i < 3; i++) {
//            icos = service.getIcoWithDataByPage(i);
//        }
//
//        assertTrue(icos.size() > 5);
//        assertTrue(icos.get(0) != null);
//        assertTrue(icos.get(3) != null);
//    }

    @Test
    public void getPicCoins() {
        List<PictureCoin> picCoins = service.getPicCoins();
        assertTrue(picCoins.size() > 100);
    }



}
package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.WhiteList;

import java.util.ArrayList;
import java.util.List;

public interface WhiteListService {


    List<WhiteList> getWhiteList();

    void updateWhitelist();

}

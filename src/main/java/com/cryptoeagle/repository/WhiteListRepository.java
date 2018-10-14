package com.cryptoeagle.repository;

import com.cryptoeagle.entity.WhiteList;

import java.util.List;

public interface WhiteListRepository {

    List<WhiteList> getAll();

    void save(List<WhiteList> whiteLists);
}

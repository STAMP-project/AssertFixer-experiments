package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface ItemRepository {


    List<Item> getBySource(String source);

    List<Item> getAll();

    List<String> getSources();

}

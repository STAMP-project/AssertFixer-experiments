package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Item;

import javax.xml.transform.Source;
import java.io.File;
import java.util.List;

public interface RssService {


    List<Item> getItems(String url,String source);


}

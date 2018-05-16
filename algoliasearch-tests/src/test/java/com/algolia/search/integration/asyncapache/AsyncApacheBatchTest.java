package com.algolia.search.integration.asyncapache;

import com.algolia.search.AsyncAPIClient;
import com.algolia.search.AsyncHttpAPIClientBuilder;
import com.algolia.search.integration.common.async.AsyncBatchTest;

public class AsyncApacheBatchTest extends AsyncBatchTest {

  @Override
  public AsyncAPIClient createInstance(String appId, String apiKey) {
    return new AsyncHttpAPIClientBuilder(appId, apiKey).build();
  }
}

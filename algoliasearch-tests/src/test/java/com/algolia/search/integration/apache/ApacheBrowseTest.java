package com.algolia.search.integration.apache;

import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.integration.common.sync.SyncBrowseTest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApacheBrowseTest extends SyncBrowseTest {

  @Override
  public APIClient createInstance(String appId, String apiKey) {
    return new ApacheAPIClientBuilder(appId, apiKey).build();
  }

  @Override
  public APIClient createInstance(String appId, String apiKey, ObjectMapper objectMapper) {
    return new ApacheAPIClientBuilder(appId, apiKey).setObjectMapper(objectMapper).build();
  }
}

/**
 * Copyright (C) 2014-2018 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.linkedin.thirdeye.detection;

import com.linkedin.thirdeye.dataframe.DataFrame;
import com.linkedin.thirdeye.datalayer.bao.DAOTestBase;
import com.linkedin.thirdeye.datalayer.bao.DatasetConfigManager;
import com.linkedin.thirdeye.datalayer.bao.DetectionConfigManager;
import com.linkedin.thirdeye.datalayer.bao.MergedAnomalyResultManager;
import com.linkedin.thirdeye.datalayer.bao.MetricConfigManager;
import com.linkedin.thirdeye.datalayer.dto.DatasetConfigDTO;
import com.linkedin.thirdeye.datalayer.dto.DetectionConfigDTO;
import com.linkedin.thirdeye.datalayer.dto.MergedAnomalyResultDTO;
import com.linkedin.thirdeye.datalayer.dto.MetricConfigDTO;
import com.linkedin.thirdeye.datasource.DAORegistry;
import com.linkedin.thirdeye.datasource.ThirdEyeCacheRegistry;
import com.linkedin.thirdeye.datasource.ThirdEyeDataSource;
import com.linkedin.thirdeye.datasource.cache.QueryCache;
import com.linkedin.thirdeye.datasource.csv.CSVThirdEyeDataSource;
import com.linkedin.thirdeye.datasource.loader.AggregationLoader;
import com.linkedin.thirdeye.datasource.loader.DefaultAggregationLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CurrentAndBaselineLoaderTest {
  private static final String COLLECTION_VALUE = "test_dataset";
  private static final String DETECTION_NAME_VALUE = "test detection";
  private static final String METRIC_VALUE = "test_metric";

  private DAOTestBase testDAOProvider;
  private MergedAnomalyResultManager anomalyDAO;
  private DetectionConfigManager detectionDAO;
  private MetricConfigManager metricDAO;
  private DatasetConfigManager dataSetDAO;
  private Long detectionConfigId;
  private AggregationLoader aggregationLoader;
  private CurrentAndBaselineLoader currentAndBaselineLoader;

  @BeforeMethod
  public void beforeMethod() {
    this.testDAOProvider = DAOTestBase.getInstance();
    DAORegistry daoRegistry = DAORegistry.getInstance();
    this.anomalyDAO = daoRegistry.getMergedAnomalyResultDAO();
    this.detectionDAO = daoRegistry.getDetectionConfigManager();
    this.metricDAO = daoRegistry.getMetricConfigDAO();
    this.dataSetDAO = daoRegistry.getDatasetConfigDAO();

    MetricConfigDTO metricConfigDTO = new MetricConfigDTO();
    metricConfigDTO.setName(METRIC_VALUE);
    metricConfigDTO.setDataset(COLLECTION_VALUE);
    metricConfigDTO.setAlias("test");
    long metricId = this.metricDAO.save(metricConfigDTO);

    Map<String, ThirdEyeDataSource> dataSourceMap = new HashMap<>();

    DataFrame data = new DataFrame();
    data.addSeries("timestamp", 1526414678000L, 1527019478000L);
    data.addSeries("value", 100, 200);
    Map<String, DataFrame> datasets = new HashMap<>();
    datasets.put(COLLECTION_VALUE, data);

    Map<Long, String> id2name = new HashMap<>();
    id2name.put(metricId, "value");

    dataSourceMap.put("myDataSource", CSVThirdEyeDataSource.fromDataFrame(datasets, id2name));
    QueryCache cache = new QueryCache(dataSourceMap, Executors.newSingleThreadExecutor());
    ThirdEyeCacheRegistry.getInstance().registerQueryCache(cache);
    ThirdEyeCacheRegistry.initMetaDataCaches();

    DetectionConfigDTO detectionConfig = new DetectionConfigDTO();
    detectionConfig.setName(DETECTION_NAME_VALUE);
    this.detectionConfigId = this.detectionDAO.save(detectionConfig);

    MergedAnomalyResultDTO anomalyResultDTO = new MergedAnomalyResultDTO();
    anomalyResultDTO.setStartTime(1000L);
    anomalyResultDTO.setEndTime(2000L);
    anomalyResultDTO.setDetectionConfigId(this.detectionConfigId);
    anomalyResultDTO.setCollection(COLLECTION_VALUE);
    anomalyResultDTO.setMetric(METRIC_VALUE);
    this.anomalyDAO.save(anomalyResultDTO);

    DatasetConfigDTO datasetConfigDTO = new DatasetConfigDTO();
    datasetConfigDTO.setDataset(COLLECTION_VALUE);
    datasetConfigDTO.setDataSource("myDataSource");
    this.dataSetDAO.save(datasetConfigDTO);

    this.aggregationLoader = new DefaultAggregationLoader(this.metricDAO, this.dataSetDAO,
        ThirdEyeCacheRegistry.getInstance().getQueryCache(),
        ThirdEyeCacheRegistry.getInstance().getDatasetMaxDataTimeCache());

    this.currentAndBaselineLoader = new CurrentAndBaselineLoader(this.metricDAO, this.dataSetDAO, this.aggregationLoader);
  }

  @AfterMethod
  public void afterMethod() {
    this.testDAOProvider.cleanup();
  }

  @Test
  public void testfillInCurrentAndBaselineValue() throws Exception {
    List<MergedAnomalyResultDTO> anomalies = new ArrayList<>();
    MergedAnomalyResultDTO anomaly = new MergedAnomalyResultDTO();
    anomaly.setMetric(METRIC_VALUE);
    anomaly.setCollection(COLLECTION_VALUE);
    anomaly.setStartTime(1527019478000L);
    anomaly.setEndTime(1527023078000L);

    anomalies.add(anomaly);

    this.currentAndBaselineLoader.fillInCurrentAndBaselineValue(anomalies);

    Assert.assertEquals(anomaly.getAvgBaselineVal(), 100.0);
    Assert.assertEquals(anomaly.getAvgCurrentVal(), 200.0);

  }
}
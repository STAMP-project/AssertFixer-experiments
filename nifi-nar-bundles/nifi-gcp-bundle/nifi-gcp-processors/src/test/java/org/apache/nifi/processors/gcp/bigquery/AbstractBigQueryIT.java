package org.apache.nifi.processors.gcp.bigquery;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.processors.gcp.GCPIntegrationTests;
import org.apache.nifi.processors.gcp.credentials.service.GCPCredentialsControllerService;
import org.apache.nifi.reporting.InitializationException;
import org.apache.nifi.util.TestRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@Category(GCPIntegrationTests.class)
public abstract class AbstractBigQueryIT {

    private static final String SERVICE_ACCOUNT_JSON_FILE = System.getProperty("user.home") + "/gcp-credentials.json";
    static final String CONTROLLER_SERVICE = "GCPCredentialsService";
    static final String PUT_LARGE_PAYLOAD_TEST_TABLE_NAME = "put_large_payload_test";
    protected static BigQuery bigquery;
    protected static Dataset dataset;
    protected static TestRunner runner;

    @BeforeClass
    public static void beforeClass() throws IOException {
        dataset = null;
        BigQueryOptions bigQueryOptions = BigQueryOptions.newBuilder()
                .build();
        bigquery = bigQueryOptions.getService();

        // Prepare a new data set
        String datasetName = UUID.randomUUID().toString().replaceAll("-", "");
        DatasetInfo datasetInfo = DatasetInfo.newBuilder("1test0" + datasetName).build();
        dataset = bigquery.create(datasetInfo);
    }

    @AfterClass
    public static void afterClass() {
        bigquery.delete(dataset.getDatasetId(), BigQuery.DatasetDeleteOption.deleteContents());
    }

    protected static void validateServiceExceptionAttribute(FlowFile flowFile) {
        assertNotNull(flowFile.getAttribute(BigQueryAttributes.JOB_ERROR_MSG_ATTR));
        assertNotNull(flowFile.getAttribute(BigQueryAttributes.JOB_ERROR_REASON_ATTR));
        assertNotNull(flowFile.getAttribute(BigQueryAttributes.JOB_ERROR_LOCATION_ATTR));
    }

    protected TestRunner setCredentialsControllerService(TestRunner runner) throws InitializationException {
        final Map<String, String> propertiesMap = new HashMap<>();
        final GCPCredentialsControllerService credentialsControllerService = new GCPCredentialsControllerService();

        propertiesMap.put("application-default-credentials", "false");
        propertiesMap.put("compute-engine-credentials", "false");
        propertiesMap.put("service-account-json-file", SERVICE_ACCOUNT_JSON_FILE);

        runner.addControllerService(CONTROLLER_SERVICE, credentialsControllerService, propertiesMap);
        runner.enableControllerService(credentialsControllerService);
        runner.assertValid(credentialsControllerService);

        return runner;
    }
}

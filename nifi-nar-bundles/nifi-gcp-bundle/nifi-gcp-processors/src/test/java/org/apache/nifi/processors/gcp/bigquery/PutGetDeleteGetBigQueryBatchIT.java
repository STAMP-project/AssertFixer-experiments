package org.apache.nifi.processors.gcp.bigquery;

import com.google.cloud.bigquery.FormatOptions;
import org.apache.nifi.processors.gcp.AbstractGCPProcessor;
import org.apache.nifi.reporting.InitializationException;
import org.apache.nifi.util.TestRunners;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PutGetDeleteGetBigQueryBatchIT extends AbstractBigQueryIT {

    @BeforeClass
    public static void setup() {
        runner = TestRunners.newTestRunner(PutBigQueryBatch.class);
    }

    @Test
    public void largePayloadTest() throws InitializationException, IOException {
        runner = setCredentialsControllerService(runner);
        runner.setProperty(AbstractGCPProcessor.GCP_CREDENTIALS_PROVIDER_SERVICE, CONTROLLER_SERVICE);
        runner.setProperty(BigQueryAttributes.DATASET_ATTR, dataset.getDatasetId().getDataset());
        runner.setProperty(BigQueryAttributes.TABLE_NAME_ATTR, PUT_LARGE_PAYLOAD_TEST_TABLE_NAME);
        runner.setProperty(BigQueryAttributes.SOURCE_TYPE_ATTR, FormatOptions.json().getType());
        String schema = "[\n" +
                "  {\n" +
                "    \"description\": \"name\",\n" +
                "    \"mode\": \"NULLABLE\",\n" +
                "    \"name\": \"name\",\n" +
                "    \"type\": \"STRING\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"field 2\",\n" +
                "    \"mode\": \"NULLABLE\",\n" +
                "    \"name\": \"field_2\",\n" +
                "    \"type\": \"STRING\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"description\": \"field 3\",\n" +
                "    \"mode\": \"NULLABLE\",\n" +
                "    \"name\": \"field_3\",\n" +
                "    \"type\": \"STRING\"\n" +
                "  }\n" +
                "]";
        runner.setProperty(BigQueryAttributes.TABLE_SCHEMA_ATTR, schema);
        String str = "{\"name\":\"Bender Rodriguez\",\"field_2\":\"Daniel is great\",\"field_3\":\"“Here's to the crazy ones. The misfits.The rebels. The troublemakers." +
                " The round pegs in the square holes. The ones who see things differently.They're not fond of rules. And they have no respect" +
                " for the status quo. You can quote them, disagree with them,glorify or vilify them. About the only thing you can't do is ignore" +
                " them. Because they change things. They push the human race forward. And while some may see them as the crazy ones, we see genius." +
                " Because the people who are crazy enough to think they can change the world, are the ones who do.” –Rob Siltanen\"}\r\n";
        Path path = Paths.get(System.getProperty("java.io.tmpdir") + "/test");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (int i = 0; i < 5; i++) {
                for (int ii = 0; ii < 1_000_000; ii++) {
                    writer.write(str);
                }
                writer.flush();
            }
            writer.flush();
        }

        runner.enqueue(Files.newInputStream(path));
        runner.run(1);
        runner.assertAllFlowFilesTransferred(AbstractBigQueryProcessor.REL_SUCCESS, 1);
    }
}

package datawave.ingest.nyctlc;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import datawave.accumulo.inmemory.InMemoryInstance;
import datawave.data.type.LcNoDiacriticsType;
import datawave.ingest.csv.mr.input.CSVRecordReader;
import datawave.ingest.data.RawRecordContainer;
import datawave.ingest.data.TypeRegistry;
import datawave.ingest.data.config.DataTypeHelper;
import datawave.ingest.data.config.NormalizedContentInterface;
import datawave.ingest.data.config.ingest.BaseIngestHelper;
import datawave.ingest.data.config.ingest.CSVIngestHelper;
import datawave.ingest.data.config.ingest.CompositeIngest;
import datawave.ingest.mapreduce.handler.shard.ShardedDataTypeHandler;
import datawave.ingest.mapreduce.job.BulkIngestKey;
import datawave.policy.ExampleIngestPolicyEnforcer;
import datawave.query.metrics.MockStatusReporter;
import org.apache.accumulo.core.client.BatchWriter;
import org.apache.accumulo.core.client.BatchWriterConfig;
import org.apache.accumulo.core.client.Connector;
import org.apache.accumulo.core.client.admin.TableOperations;
import org.apache.accumulo.core.data.Mutation;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.security.Authorizations;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class NYCTLCDataTypeHandlerTest {
    
    private static final int NUM_SHARDS = 241;
    private static final String SHARD_TABLE_NAME = "shard";
    private static final String SHARD_INDEX_TABLE_NAME = "shardIndex";
    private static final String SHARD_REVERSE_INDEX_TABLE_NAME = "shardReverseIndex";
    private static final String METADATA_TABLE_NAME = "DatawaveMetadata";
    
    private static final String PASSWORD = "";
    private static final String AUTHS = "ALL";
    
    protected Configuration conf = null;
    protected InMemoryInstance instance = null;
    
    @Before
    public void before() {
        conf = new Configuration();
        conf.set("all" + DataTypeHelper.Properties.INGEST_POLICY_ENFORCER_CLASS, ExampleIngestPolicyEnforcer.class.getName());
        
        URL url = ClassLoader.getSystemResource("config/ingest/nyctlc-config.xml");
        Assert.assertNotNull("URL to nyctlc-config.xml was null", url);
        conf.addResource(url);
        
        url = ClassLoader.getSystemResource("config/ingest/metadata-config.xml");
        Assert.assertNotNull("URL to metadata-config.xml was null", url);
        conf.addResource(url);
        
        conf.setInt(ShardedDataTypeHandler.NUM_SHARDS, NUM_SHARDS);
        conf.set(ShardedDataTypeHandler.SHARD_TNAME, SHARD_TABLE_NAME);
        conf.set(ShardedDataTypeHandler.SHARD_GIDX_TNAME, SHARD_INDEX_TABLE_NAME);
        conf.set(ShardedDataTypeHandler.SHARD_GRIDX_TNAME, SHARD_REVERSE_INDEX_TABLE_NAME);
        conf.set(ShardedDataTypeHandler.METADATA_TABLE_NAME, METADATA_TABLE_NAME);
        conf.set(BaseIngestHelper.DEFAULT_TYPE, LcNoDiacriticsType.class.getName());
        
        TypeRegistry.reset();
        TypeRegistry.getInstance(conf);
    }
    
    @Test
    public void someTest() throws Exception {
        URL data = NYCTLCDataTypeHandlerTest.class.getResource("input/nyctlc.csv");
        if (data == null) {
            File fileObj = new File("input/nyctlc.csv");
            if (fileObj.exists()) {
                data = fileObj.toURI().toURL();
            }
        }
        assertNotNull("Did not find test resource", data);
        
        File dataFile = new File(data.toURI());
        Path p = new Path(dataFile.toURI().toString());
        
        TaskAttemptContext ctx = new TaskAttemptContextImpl(conf, new TaskAttemptID());
        
        CSVRecordReader reader = new CSVRecordReader();
        reader.initialize(new FileSplit(p, 0, dataFile.length(), null), ctx);
        
        reader.setInputDate(System.currentTimeMillis());
        
        NYCTLCDataTypeHandler handler = new NYCTLCDataTypeHandler();
        handler.setup(ctx);
        
        CSVIngestHelper helper = new CSVIngestHelper();
        helper.setup(conf);
        
        Multimap<BulkIngestKey,Value> keyValues = HashMultimap.create();
        while (reader.nextKeyValue()) {
            RawRecordContainer e = reader.getEvent();
            
            final Multimap<String,NormalizedContentInterface> fields = helper.getEventFields(e);
            if (helper instanceof CompositeIngest) {
                Multimap<String,NormalizedContentInterface> compositeFields = helper.getCompositeFields(fields);
                for (String fieldName : compositeFields.keySet()) {
                    // if this is an overloaded event field, we are replacing the existing data
                    if (helper.isOverloadedCompositeField(fieldName))
                        fields.removeAll(fieldName);
                    fields.putAll(fieldName, compositeFields.get(fieldName));
                }
            }
            
            Multimap kvPairs = handler.processBulk(new Text(), e, fields, new MockStatusReporter());
            
            keyValues.putAll(kvPairs);
            
            handler.getMetadata().addEvent(helper, e, fields);
        }
        keyValues.putAll(handler.getMetadata().getBulkMetadata());
        
        // write these values to their respective tables
        instance = new InMemoryInstance();
        Connector connector = instance.getConnector("root", PASSWORD);
        connector.securityOperations().changeUserAuthorizations("root", new Authorizations(AUTHS));
        
        writeKeyValues(connector, keyValues);
        
        System.out.println("done!");
    }
    
    private static void writeKeyValues(Connector connector, Multimap<BulkIngestKey,Value> keyValues) throws Exception {
        final TableOperations tops = connector.tableOperations();
        final Set<BulkIngestKey> biKeys = keyValues.keySet();
        for (final BulkIngestKey biKey : biKeys) {
            final String tableName = biKey.getTableName().toString();
            if (!tops.exists(tableName))
                tops.create(tableName);
            
            final BatchWriter writer = connector.createBatchWriter(tableName, new BatchWriterConfig());
            for (final Value val : keyValues.get(biKey)) {
                final Mutation mutation = new Mutation(biKey.getKey().getRow());
                mutation.put(biKey.getKey().getColumnFamily(), biKey.getKey().getColumnQualifier(), biKey.getKey().getColumnVisibilityParsed(), biKey.getKey()
                                .getTimestamp(), val);
                writer.addMutation(mutation);
            }
            writer.close();
        }
    }
}

package com.salesforce.dynamodbv2.mt.mappers;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.toList;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest;
import com.amazonaws.services.dynamodbv2.model.GetShardIteratorResult;
import com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;
import com.amazonaws.services.dynamodbv2.model.ListStreamsResult;
import com.amazonaws.services.dynamodbv2.model.Record;
import com.salesforce.dynamodbv2.mt.mappers.MtAmazonDynamoDb.MtRecord;
import com.salesforce.dynamodbv2.mt.util.ShardIterator;
import com.salesforce.dynamodbv2.mt.util.StreamArn;
import java.util.Optional;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class facilitates constructing multitenant records by encoding (physical) table name in shard iterators. Also
 * filters streams and records by current multitenant instance and context.
 */
public abstract class MtAmazonDynamoDbStreamsBase<T extends MtAmazonDynamoDbBase> extends
    DelegatingAmazonDynamoDbStreams implements MtAmazonDynamoDbStreams {

    private static final Logger LOG = LoggerFactory.getLogger(MtAmazonDynamoDbStreamsBase.class);


    protected final T mtDynamoDb;

    protected MtAmazonDynamoDbStreamsBase(AmazonDynamoDBStreams streams, T mtDynamoDb) {
        super(streams);
        this.mtDynamoDb = mtDynamoDb;
    }

    /**
     * Returns streams associated with the corresponding MT shared table instance.
     *
     * @param listStreamsRequest Stream request. Currently doesn't support filtering by table.
     * @return Result.
     */
    @Override
    public ListStreamsResult listStreams(ListStreamsRequest listStreamsRequest) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("listStreams request={}", listStreamsRequest);
        }

        checkArgument(!mtDynamoDb.getMtContext().getContextOpt().isPresent(),
            "listStreams currently does not support calling with tenant context");
        checkArgument(listStreamsRequest.getTableName() == null,
            "listStreams currently does not support filtering by table name");

        // filter to mt tables
        ListStreamsResult result = dynamoDbStreams.listStreams(listStreamsRequest);

        result.setStreams(result.getStreams().stream()
            .filter(stream -> mtDynamoDb.isMtTable(stream.getTableName()))
            .collect(toList()));

        if (LOG.isDebugEnabled()) {
            LOG.debug("listStreams #streams={}, lastEvaluatedStreamArn={}",
                result.getStreams().size(), result.getLastEvaluatedStreamArn());
        }
        return result;
    }

    /**
     * Translates between virtual and physical stream arns.
     *
     * @param describeStreamRequest Describe stream request.
     * @return Result
     */
    @Override
    public DescribeStreamResult describeStream(DescribeStreamRequest describeStreamRequest) {
        String arn = describeStreamRequest.getStreamArn();
        DescribeStreamRequest request = describeStreamRequest.clone().withStreamArn(getDynamoDbArn(arn));
        DescribeStreamResult result = dynamoDbStreams.describeStream(request);
        return result.withStreamDescription(result.getStreamDescription().withStreamArn(arn));
    }

    /**
     * Translates between virtual and physical stream arns.
     *
     * @param getShardIteratorRequest Shard iterator request.
     * @return Mt shard iterator.
     */
    @Override
    public GetShardIteratorResult getShardIterator(GetShardIteratorRequest getShardIteratorRequest) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getShardIterator request={}", getShardIteratorRequest);
        }

        String arn = getShardIteratorRequest.getStreamArn();
        String dynamoDbArn = getDynamoDbArn(arn);
        GetShardIteratorRequest request = getShardIteratorRequest.clone().withStreamArn(dynamoDbArn);
        GetShardIteratorResult result = dynamoDbStreams.getShardIterator(request);
        ShardIterator iterator = ShardIterator.fromString(result.getShardIterator());
        checkArgument(dynamoDbArn.equals(iterator.getArn()));
        result.setShardIterator(iterator.withArn(arn).toString());

        if (LOG.isDebugEnabled()) {
            LOG.debug("getShardIterator result={}", result);
        }
        return result;
    }

    /**
     * Returns records from the underlying stream for the given context.
     *
     * @param request Record request. Maybe with or without tenant context.
     * @return Records for current context for the given request.
     */
    @Override
    public GetRecordsResult getRecords(GetRecordsRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getRecords request={}", request);
        }

        ShardIterator iterator = ShardIterator.fromString(request.getShardIterator());
        StreamArn arn = parseStreamArn(iterator.getArn());

        GetRecordsResult result = getRecords(
            arn,
            getMtRecordMapper(arn.getTableName()),
            request.withShardIterator(iterator.withArn(arn.toDynamoDbArn()).toString()));

        Optional.ofNullable(result.getNextShardIterator())
            .map(ShardIterator::fromString)
            .map(i -> i.withArn(iterator.getArn()))
            .map(ShardIterator::toString)
            .ifPresent(result::setNextShardIterator);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getRecords response=(#records={}, iterator={})",
                result.getRecords().size(), result.getNextShardIterator());
        }
        return result;
    }

    protected GetRecordsResult getRecords(StreamArn arn, Function<Record, MtRecord> recordMapper,
        GetRecordsRequest getRecordsRequest) {
        return mapResult(arn, recordMapper, super.getRecords(getRecordsRequest));
    }

    protected GetRecordsResult mapResult(StreamArn arn, Function<Record, MtRecord> recordMapper,
        GetRecordsResult result) {
        return new GetRecordsResult()
            .withNextShardIterator(result.getNextShardIterator())
            .withRecords(result.getRecords().stream()
                .map(recordMapper)
                .filter(r -> accept(arn, r))
                .collect(toList()));
    }

    protected abstract Function<Record, MtRecord> getMtRecordMapper(String tableName);

    protected boolean accept(StreamArn arn, MtRecord mtRecord) {
        return arn.matches(mtRecord);
    }

    private StreamArn parseStreamArn(String arn) {
        StreamArn parsedArn = StreamArn.fromString(arn);
        checkArgument(parsedArn.getContextOpt().equals(mtDynamoDb.getMtContext().getContextOpt()),
            "Current context does not match arn context");
        return parsedArn;
    }

    private String getDynamoDbArn(String arn) {
        return parseStreamArn(arn).toDynamoDbArn();
    }

}

package net.mguenther.kafka.junit.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.mguenther.kafka.junit.KeyValue;
import net.mguenther.kafka.junit.KeyValueMetadata;
import net.mguenther.kafka.junit.ObserveKeyValues;
import net.mguenther.kafka.junit.ReadKeyValues;
import net.mguenther.kafka.junit.RecordConsumer;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class DefaultRecordConsumer implements RecordConsumer {

    private final String bootstrapServers;

    @Override
    public <V> List<V> readValues(final ReadKeyValues<String, V> readRequest) throws InterruptedException {
        final List<KeyValue<String, V>> kvs = read(readRequest);
        return Collections.unmodifiableList(kvs.stream().map(KeyValue::getValue).collect(Collectors.toList()));
    }

    @Override
    public <K, V> List<KeyValue<K, V>> read(final ReadKeyValues<K, V> readRequest) throws InterruptedException {
        final List<KeyValue<K, V>> consumedRecords = new ArrayList<>();
        final KafkaConsumer<K, V> consumer = new KafkaConsumer<>(effectiveConsumerProps(readRequest.getConsumerProps()));
        final int pollIntervalMillis = 100;
        final int limit = readRequest.getLimit();
        final Predicate<K> filterOnKeys = readRequest.getFilterOnKeys();
        final Predicate<V> filterOnValues = readRequest.getFilterOnValues();
        initializeConsumer(consumer, readRequest);
        int totalPollTimeMillis = 0;
        while (totalPollTimeMillis < readRequest.getMaxTotalPollTimeMillis() && continueConsuming(consumedRecords.size(), limit)) {
            final ConsumerRecords<K, V> records = consumer.poll(pollIntervalMillis);
            for (ConsumerRecord<K, V> record : records) {
                if (filterOnKeys.test(record.key()) && filterOnValues.test(record.value())) {
                    final KeyValue<K, V> kv = readRequest.isIncludeMetadata() ?
                            new KeyValue<>(record.key(), record.value(), record.headers(), new KeyValueMetadata(record.topic(), record.partition(), record.offset())) :
                            new KeyValue<>(record.key(), record.value(), record.headers());

                    consumedRecords.add(kv);
                }
            }
            totalPollTimeMillis += pollIntervalMillis;
        }
        consumer.commitSync();
        consumer.close();
        return Collections.unmodifiableList(consumedRecords);
    }

    private <K, V> void initializeConsumer(final KafkaConsumer<K, V> consumer, final ReadKeyValues<K, V> readRequest) throws InterruptedException {
        final List<TopicPartition> topicPartitions = readRequest
                .getSeekTo()
                .keySet()
                .stream()
                .map(partition -> new TopicPartition(readRequest.getTopic(), partition))
                .collect(Collectors.toList());
        final CountDownLatch latch = new CountDownLatch(topicPartitions.size());
        consumer.subscribe(Collections.singletonList(readRequest.getTopic()), new WaitForAssignmentListener(topicPartitions, latch));
        consumer.poll(0);
        if (!latch.await(5, TimeUnit.SECONDS)) {
            throw new RuntimeException(String.format("Waited for assignments on topic-partitions %s, while running into a timeout.", StringUtils.join(topicPartitions, ", ")));
        }
        topicPartitions
                .stream()
                .peek(topicPartition -> log.info("Seeking to offset {} of topic-partition {}.", readRequest.getSeekTo().get(topicPartition.partition()), topicPartition))
                .forEach(topicPartition -> consumer.seek(topicPartition, readRequest.getSeekTo().get(topicPartition.partition())));
    }

    private static boolean continueConsuming(final int messagesConsumed, final int maxMessages) {
        return maxMessages <= 0 || messagesConsumed < maxMessages;
    }

    @Override
    public <V> List<V> observeValues(final ObserveKeyValues<String, V> observeRequest) throws InterruptedException {
        final List<V> totalConsumedRecords = new ArrayList<>(observeRequest.getExpected());
        final long startNanos = System.nanoTime();
        final ReadKeyValues<String, V> initialReadRequest = withPartitionSeekForReadValues(observeRequest);
        final ReadKeyValues<String, V> subsequentReadRequests = withoutPartitionSeekForReadValues(observeRequest);
        boolean firstRequest = true;
        while (true) {
            final List<V> consumedRecords = firstRequest ?
                    readValues(initialReadRequest) :
                    readValues(subsequentReadRequests);
            totalConsumedRecords.addAll(consumedRecords);
            if (firstRequest) firstRequest = false;
            if (totalConsumedRecords.size() >= observeRequest.getExpected()) break;
            if (System.nanoTime() > startNanos + TimeUnit.MILLISECONDS.toNanos(observeRequest.getObservationTimeMillis())) {
                final String message = String.format("Expected %s records, but consumed only %s records before ran " +
                                "into timeout (%s ms).",
                        observeRequest.getExpected(),
                        totalConsumedRecords.size(),
                        observeRequest.getObservationTimeMillis());
                throw new AssertionError(message);
            }
            Thread.sleep(Math.min(observeRequest.getObservationTimeMillis(), 100));
        }
        return Collections.unmodifiableList(totalConsumedRecords);
    }

    private <V> ReadKeyValues<String, V> withPartitionSeekForReadValues(final ObserveKeyValues<String, V> observeRequest) {
        return toReadValuesRequest(observeRequest).seekTo(observeRequest.getSeekTo()).build();
    }

    private <V> ReadKeyValues<String, V> withoutPartitionSeekForReadValues(final ObserveKeyValues<String, V> observeRequest) {
        return toReadValuesRequest(observeRequest).build();
    }

    private <V> ReadKeyValues.ReadKeyValuesBuilder<String, V> toReadValuesRequest(final ObserveKeyValues<String, V> observeRequest) {
        return ReadKeyValues.from(observeRequest.getTopic(), observeRequest.getClazzOfV())
                .withAll(observeRequest.getConsumerProps())
                .withLimit(observeRequest.getExpected())
                .withMetadata(false)
                .filterOnKeys(observeRequest.getFilterOnKeys())
                .filterOnValues(observeRequest.getFilterOnValues())
                .with(ConsumerConfig.GROUP_ID_CONFIG, observeRequest.getConsumerProps().getProperty(ConsumerConfig.GROUP_ID_CONFIG));
    }

    @Override
    public <K, V> List<KeyValue<K, V>> observe(final ObserveKeyValues<K, V> observeRequest) throws InterruptedException {
        final List<KeyValue<K, V>> totalConsumedRecords = new ArrayList<>(observeRequest.getExpected());
        final long startNanos = System.nanoTime();
        final ReadKeyValues<K, V> initialReadRequest = withPartitionSeek(observeRequest);
        final ReadKeyValues<K, V> subsequentReadRequests = withoutPartitionSeek(observeRequest);
        boolean firstRequest = true;
        while (true) {
            final List<KeyValue<K, V>> consumedRecords = firstRequest ?
                    read(initialReadRequest) :
                    read(subsequentReadRequests);
            totalConsumedRecords.addAll(consumedRecords);
            if (firstRequest) firstRequest = false;
            if (totalConsumedRecords.size() >= observeRequest.getExpected()) break;
            if (System.nanoTime() > startNanos + TimeUnit.MILLISECONDS.toNanos(observeRequest.getObservationTimeMillis())) {
                final String message = String.format("Expected %s records, but consumed only %s records before ran " +
                                "into timeout (%s ms).",
                        observeRequest.getExpected(),
                        totalConsumedRecords.size(),
                        observeRequest.getObservationTimeMillis());
                throw new AssertionError(message);
            }
            Thread.sleep(Math.min(observeRequest.getObservationTimeMillis(), 100));
        }
        return Collections.unmodifiableList(totalConsumedRecords);
    }

    private <K, V> ReadKeyValues<K, V> withPartitionSeek(final ObserveKeyValues<K, V> observeRequest) {
        return toReadKeyValuesRequest(observeRequest).seekTo(observeRequest.getSeekTo()).build();
    }

    private <K, V> ReadKeyValues<K, V> withoutPartitionSeek(final ObserveKeyValues<K, V> observeRequest) {
        return toReadKeyValuesRequest(observeRequest).build();
    }

    private <K, V> ReadKeyValues.ReadKeyValuesBuilder<K, V> toReadKeyValuesRequest(final ObserveKeyValues<K, V> observeRequest) {
        return ReadKeyValues.from(observeRequest.getTopic(), observeRequest.getClazzOfK(), observeRequest.getClazzOfV())
                .withAll(observeRequest.getConsumerProps())
                .withLimit(observeRequest.getExpected())
                .withMetadata(observeRequest.isIncludeMetadata())
                .filterOnKeys(observeRequest.getFilterOnKeys())
                .filterOnValues(observeRequest.getFilterOnValues())
                .with(ConsumerConfig.GROUP_ID_CONFIG, observeRequest.getConsumerProps().getProperty(ConsumerConfig.GROUP_ID_CONFIG));
    }

    private Properties effectiveConsumerProps(final Properties originalConsumerProps) {
        final Properties effectiveConsumerProps = new Properties();
        effectiveConsumerProps.putAll(originalConsumerProps);
        effectiveConsumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return effectiveConsumerProps;
    }

    private static class WaitForAssignmentListener implements ConsumerRebalanceListener {

        private final List<Integer> waitForPartitions;
        private final CountDownLatch latch;

        WaitForAssignmentListener(final List<TopicPartition> waitForPartitions, final CountDownLatch latch) {
            this.waitForPartitions = new ArrayList<>(waitForPartitions.size());
            this.waitForPartitions.addAll(waitForPartitions.stream().map(TopicPartition::partition).collect(Collectors.toList()));
            this.latch = latch;
        }

        @Override
        public void onPartitionsRevoked(final Collection<TopicPartition> partitions) {
            // NO-OP
        }

        @Override
        public void onPartitionsAssigned(final Collection<TopicPartition> partitions) {
            final List<Integer> assignedPartitions = partitions
                    .stream()
                    .map(TopicPartition::partition)
                    .collect(Collectors.toList());
            for (Integer assignedPartition : assignedPartitions) {
                if (waitForPartitions.remove(assignedPartition)) {
                    latch.countDown();
                }
            }
        }
    }
}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nosan.embedded.cassandra.configuration;

import java.util.List;

/**
 * Configuration properties for Apache Cassandra.
 *
 * @author Dmytro Nosan
 * @see <a href="http://cassandra.apache.org/doc/latest/configuration/cassandra_config_file.html">See more...</a>
 * @see Config.Builder
 */
public interface Config {


	/**
	 * Triggers automatic allocation of num_tokens tokens for this node. The allocation algorithm attempts to choose
	 * tokens in a way that optimizes replicated load over the nodes in the datacenter for the replication strategy used
	 * by the specified keyspace.
	 *
	 * @return The value of the {@code allocateTokensForKeyspace} attribute
	 */
	String getAllocateTokensForKeyspace();

	/**
	 * JMX port.
	 *
	 * @return The value of the {@code jmxPort} attribute
	 */
	int getJmxPort();

	/**
	 * Enable or disable socket timeout for streaming operations. When a timeout occurs during streaming, streaming is
	 * retried from the start of the current file. Avoid setting this value too low, as it can result in a significant
	 * amount of data re-streaming.
	 *
	 * @return The value of the {@code streamingSocketTimeoutInMs} attribute
	 */
	Long getStreamingSocketTimeoutInMs();

	/**
	 * The name of the cluster. This is mainly used to prevent machines in
	 * one logical cluster from joining another.
	 *
	 * @return The value of the {@code clusterName} attribute
	 */
	String getClusterName();

	/**
	 * Authenticator, used to identify users.
	 *
	 * @return The value of the {@code authenticator} attribute
	 */
	String getAuthenticator();

	/**
	 * Authorizer, used to limit access/provide permissions.
	 *
	 * @return The value of the {@code authorizer} attribute
	 */
	String getAuthorizer();

	/**
	 * RoleManager, used to work with roles.
	 *
	 * @return The value of the {@code roleManager} attribute
	 */
	String getRoleManager();

	/**
	 * Validity period for permissions cache.
	 *
	 * @return The value of the {@code permissionsValidityInMs} attribute
	 */
	Long getPermissionsValidityInMs();

	/**
	 * Max entries of permissions cache.
	 *
	 * @return The value of the {@code permissionsCacheMaxEntries} attribute
	 */
	Integer getPermissionsCacheMaxEntries();

	/**
	 * Refresh interval for permissions cache (if enabled).
	 * After this interval, cache entries become eligible for refresh.
	 *
	 * @return The value of the {@code permissionsUpdateIntervalInMs} attribute
	 */
	Long getPermissionsUpdateIntervalInMs();

	/**
	 * Validity period for roles cache.
	 *
	 * @return The value of the {@code rolesValidityInMs} attribute
	 */
	Long getRolesValidityInMs();

	/**
	 * Max entries of roles cache.
	 *
	 * @return The value of the {@code rolesCacheMaxEntries} attribute
	 */
	Integer getRolesCacheMaxEntries();

	/**
	 * Refresh interval for roles cache (if enabled).
	 * After this interval, cache entries become eligible for refresh.
	 *
	 * @return The value of the {@code rolesUpdateIntervalInMs} attribute
	 */
	Long getRolesUpdateIntervalInMs();

	/**
	 * Validity period for credentials cache. This cache is tightly coupled to the provided PasswordAuthenticator
	 * implementation of IAuthenticator. If another IAuthenticator implementation is configured, this cache will not be
	 * automatically used and so the following settings will have no effect.
	 *
	 * @return The value of the {@code credentialsValidityInMs} attribute
	 */
	Long getCredentialsValidityInMs();

	/**
	 * Max entries of credentials cache.
	 *
	 * @return The value of the {@code credentialsCacheMaxEntries} attribute
	 */
	Integer getCredentialsCacheMaxEntries();

	/**
	 * Refresh interval for credentials cache (if enabled).
	 * After this interval, cache entries become eligible for refresh.
	 *
	 * @return The value of the {@code credentialsUpdateIntervalInMs} attribute
	 */
	Long getCredentialsUpdateIntervalInMs();

	/**
	 * The partitioner is responsible for distributing groups of rows (by partition key) across nodes in the cluster.
	 * <p>
	 * Besides Murmur3Partitioner, partitioner included for backwards compatibility include RandomPartitioner,
	 * ByteOrderedPartitioner, and OrderPreservingPartitioner.
	 *
	 * @return The value of the {@code partitioner} attribute
	 */
	String getPartitioner();

	/**
	 * This setting has been removed from default configuration. It makes new (non-seed) nodes automatically
	 * migrate the right data to themselves. When initializing a fresh cluster without data, add auto_bootstrap: false.
	 *
	 * @return The value of the {@code autoBootstrap} attribute
	 */
	Boolean getAutoBootstrap();

	/**
	 * Enables or disables hinted handoff. To enable per datacenter, add a list of datacenters. For example:
	 * hinted_handoff_enabled: DC1,DC2. A hint indicates that the write needs to be replayed to an unavailable node.
	 * Cassandra writes the hint to a hints file on the coordinator node.
	 *
	 * @return The value of the {@code hintedHandoffEnabled} attribute
	 */
	Boolean getHintedHandoffEnabled();

	/**
	 * A blacklist of datacenters that will not perform hinted handoffs. To disable hinted handoff on a certain
	 * datacenter, add its name to this list.
	 *
	 * @return The value of the {@code hintedHandoffDisabledDatacenters} attribute
	 */
	List<String> getHintedHandoffDisabledDatacenters();

	/**
	 * Maximum amount of time during which Cassandra generates hints for an unresponsive node. After this interval,
	 * Cassandra does not generate any new hints for the node until it is back up and responsive. If the node goes down
	 * again, Cassandra starts a new interval. This setting can prevent a sudden demand for resources when a node is
	 * brought back online and the rest of the cluster attempts to replay a large volume of hinted writes.
	 *
	 * @return The value of the {@code maxHintWindowInMs} attribute
	 */
	Long getMaxHintWindowInMs();

	/**
	 * Directory where Cassandra should store hints.
	 *
	 * @return The value of the {@code hintsDirectory} attribute
	 */
	String getHintsDirectory();

	/**
	 * The addresses of hosts designated as contact points in the cluster. A joining node contacts one of the nodes
	 * in the -seeds list to learn the topology of the ring.
	 *
	 * @return The value of the {@code seedProvider} attribute
	 */
	ParameterizedClass getSeedProvider();

	/**
	 * Policy for data disk failures.
	 *
	 * @return The value of the {@code diskFailurePolicy} attribute
	 */
	DiskFailurePolicy getDiskFailurePolicy();

	/**
	 * Policy for commit disk failures.
	 *
	 * @return The value of the {@code commitFailurePolicy} attribute
	 */
	CommitFailurePolicy getCommitFailurePolicy();

	/**
	 * Used in the single-node-per-token architecture, where a node owns exactly one contiguous range in the ring space.
	 * Setting this property overrides num_tokens.
	 *
	 * @return The value of the {@code initialToken} attribute
	 */
	String getInitialToken();

	/**
	 * Defines the number of tokens randomly assigned to this node on the ring when using virtual nodes (vnodes). The
	 * more tokens, relative to other nodes, the larger the proportion of data that the node stores. Generally all nodes
	 * should have the same number of tokens assuming equal hardware capability. The recommended value is 256.
	 *
	 * @return The value of the {@code numTokens} attribute
	 */
	Integer getNumTokens();

	/**
	 * When adding a vnode to an existing cluster or setting up nodes in a new datacenter, set to the target replication
	 * factor (RF) of keyspaces in the datacenter. Triggers algorithmic allocation for the RF and num_tokens for this
	 * node. The allocation algorithm attempts to choose tokens in a way that optimizes replicated load over the nodes
	 * in the datacenter for the specified RF. The load assigned to each node is close to proportional to the number of
	 * vnodes.
	 *
	 * @return The value of the {@code allocateTokensForLocalReplicationFactor} attribute
	 */
	String getAllocateTokensForLocalReplicationFactor();

	/**
	 * The default timeout for other, miscellaneous operations.
	 *
	 * @return The value of the {@code requestTimeoutInMs} attribute
	 */
	Long getRequestTimeoutInMs();

	/**
	 * How long the coordinator should wait for read operations to complete.
	 *
	 * @return The value of the {@code readRequestTimeoutInMs} attribute
	 */
	Long getReadRequestTimeoutInMs();

	/**
	 * How long the coordinator should wait for seq or index scans to complete.
	 *
	 * @return The value of the {@code rangeRequestTimeoutInMs} attribute
	 */
	Long getRangeRequestTimeoutInMs();

	/**
	 * How long the coordinator should wait for writes to complete.
	 *
	 * @return The value of the {@code writeRequestTimeoutInMs} attribute
	 */
	Long getWriteRequestTimeoutInMs();

	/**
	 * How long the coordinator should wait for counter writes to complete.
	 *
	 * @return The value of the {@code counterWriteRequestTimeoutInMs} attribute
	 */
	Long getCounterWriteRequestTimeoutInMs();

	/**
	 * How long a coordinator should continue to retry a CAS operation that contends with other proposals for the same
	 * row.
	 *
	 * @return The value of the {@code casContentionTimeoutInMs} attribute
	 */
	Long getCasContentionTimeoutInMs();

	/**
	 * How long the coordinator should wait for truncates to complete.
	 *
	 * @return The value of the {@code truncateRequestTimeoutInMs} attribute
	 */
	Long getTruncateRequestTimeoutInMs();

	/**
	 * Set keep-alive period for streaming This node will send a keep-alive message periodically with this period. If
	 * the node does not receive a keep-alive message from the peer for 2 keep-alive cycles the stream session times out
	 * and fail Default value is 300s (5 minutes), which means stalled stream times out in 10 minutes by default.
	 *
	 * @return The value of the {@code streamingKeepAlivePeriodInSecs} attribute
	 */
	Long getStreamingKeepAlivePeriodInSecs();

	/**
	 * Enable operation timeout information exchange between nodes to accurately measure request timeouts. If disabled,
	 * replicas will assume that requests were forwarded to them instantly by the coordinator, which means that under
	 * overload conditions we will waste that much extra time processing already-timed-out requests.
	 *
	 * @return The value of the {@code crossNodeTimeout} attribute
	 */
	Boolean getCrossNodeTimeout();

	/**
	 * How long before a node logs slow queries. Select queries that take longer than this timeout to execute, will
	 * generate an aggregated log message, so that slow queries can be identified. Set this value to zero to disable
	 * slow query logging.
	 *
	 * @return The value of the {@code slowQueryLogTimeoutInMs} attribute
	 */
	Long getSlowQueryLogTimeoutInMs();

	/**
	 * Adjusts the sensitivity of the failure detector on an exponential scale. Generally this setting never needs
	 * adjusting.
	 *
	 * @return The value of the {@code phiConvictThreshold} attribute
	 */
	Double getPhiConvictThreshold();

	/**
	 * For workloads with more data than can fit in memory, the bottleneck is reads fetching data from disk. Setting to
	 * (16 × number_of_drives) allows operations to queue low enough in the stack so that the OS and drives can reorder
	 * them. The default setting applies to both logical volume managed (LVM) and RAID drive.
	 *
	 * @return The value of the {@code concurrentReads} attribute
	 */
	Integer getConcurrentReads();

	/**
	 * Writes in Cassandra are rarely I/O bound, so the ideal number of concurrent writes depends on the number of CPU
	 * cores in your system. The recommended value is 8 × number_of_cpu_cores.
	 *
	 * @return The value of the {@code concurrentWrites} attribute
	 */
	Integer getConcurrentWrites();

	/**
	 * Counter writes read the current values before incrementing and writing them back. The recommended value is (16
	 * × number_of_drives).
	 *
	 * @return The value of the {@code concurrentCounterWrites} attribute
	 */
	Integer getConcurrentCounterWrites();

	/**
	 * For materialized view writes, as there is a read involved, so this should be limited by the less of concurrent
	 * reads or concurrent writes.
	 *
	 * @return The value of the {@code concurrentMaterializedViewWrites} attribute
	 */
	Integer getConcurrentMaterializedViewWrites();

	/**
	 * the number of memtable flush writer threads. These threads are blocked by disk I/O, and each one holds a
	 * memtable in memory while blocked. If your data directories are backed by SSD, increase this setting to the number
	 * of cores.
	 *
	 * @return The value of the {@code memtableFlushWriters} attribute
	 */
	Integer getMemtableFlushWriters();

	/**
	 * Total permitted memory to use for memtables. Cassandra will stop accepting writes when the limit is exceeded
	 * until a flush completes, and will trigger a flush based on memtable_cleanup_threshold If omitted, Cassandra will
	 * set both to 1/4 the size of the heap.
	 *
	 * @return The value of the {@code memtableHeapSpaceInMb} attribute
	 */
	Integer getMemtableHeapSpaceInMb();

	/**
	 * A threshold for automatic memtable flush.
	 *
	 * @return The value of the {@code memtableOffheapSpaceInMb} attribute
	 */
	Integer getMemtableOffheapSpaceInMb();

	/**
	 * Ratio used for automatic memtable flush. Casssandra adds memtable_heap_space_in_mb to
	 * memtable_offheap_space_in_mb and multiplies the total by memtable_cleanup_threshold to get a space amount in MB.
	 * When the total amount of memory being used by all non-flushing memtables exceeds this amount, Casandra flushes
	 * the largest memtable to disk.
	 *
	 * @return The value of the {@code memtableCleanupThreshold} attribute
	 */
	Double getMemtableCleanupThreshold();

	/**
	 * The port for inter-node communication.
	 *
	 * @return The value of the {@code storagePort} attribute
	 */
	int getStoragePort();

	/**
	 * SSL port, for encrypted communication. Unused unless enabled in encryption_options For security reasons, you
	 * should not expose this port to the internet. Firewall it if needed.
	 *
	 * @return The value of the {@code sslStoragePort} attribute
	 */
	int getSslStoragePort();

	/**
	 * Address or interface to bind to and tell other Cassandra nodes to connect to.
	 * Set listenAddress OR listenInterface, not both.
	 *
	 * @return The value of the {@code listenAddress} attribute
	 */
	String getListenAddress();

	/**
	 * Listen Interface must correspond to a single address, IP aliasing is not supported.
	 *
	 * @return The value of the {@code listenInterface} attribute
	 */
	String getListenInterface();

	/**
	 * If you choose to specify the interface by name and the interface has an ipv4 and an ipv6 address you can specify
	 * which should be chosen using listen_interface_prefer_ipv6. If false the first ipv4 address will be used. If true
	 * the first ipv6 address will be used. Defaults to false preferring ipv4. If there is only one address it will be
	 * selected regardless of ipv4/ipv6.
	 *
	 * @return The value of the {@code listenInterfacePreferIpv6} attribute
	 */
	Boolean getListenInterfacePreferIpv6();

	/**
	 * The IP address a node tells other nodes in the cluster to contact it by. It allows public and private address to
	 * be different. For example, use the broadcast_address parameter in topologies where not all nodes have access to
	 * other nodes by their private IP addresses.
	 *
	 * @return The value of the {@code broadcastAddress} attribute
	 */
	String getBroadcastAddress();

	/**
	 * When using multiple physical network interfaces, set this to true to listen on broadcast_address in addition to
	 * the listen_address, allowing nodes to communicate in both interfaces. Ignore this property if the network
	 * configuration automatically routes between the public and private networks such as EC2.
	 *
	 * @return The value of the {@code listenOnBroadcastAddress} attribute
	 */
	Boolean getListenOnBroadcastAddress();

	/**
	 * Internode authentication, used to allow/disallow connections from peer nodes.
	 *
	 * @return The value of the {@code internodeAuthenticator} attribute
	 */
	String getInternodeAuthenticator();

	/**
	 * The address or interface to bind the native transport server to.
	 *
	 * @return The value of the {@code rpcAddress} attribute
	 */
	String getRpcAddress();

	/**
	 * RPC interfaces must correspond to a single address, IP aliasing is not supported.
	 *
	 * @return The value of the {@code rpcInterface} attribute
	 */
	String getRpcInterface();

	/**
	 * If you choose to specify the interface by name and the interface has an ipv4 and an ipv6 address you can specify
	 * which should be chosen using rpc_interface_prefer_ipv6. If false the first ipv4 address will be used. If true the
	 * first ipv6 address will be used. Defaults to false preferring ipv4. If there is only one address it will be
	 * selected regardless of ipv4/ipv6.
	 *
	 * @return The value of the {@code rpcInterfacePreferIpv6} attribute
	 */
	Boolean getRpcInterfacePreferIpv6();

	/**
	 * RPC address to broadcast to drivers and other Cassandra nodes. This cannot be set to 0.0.0.0. If left blank, this
	 * will be set to the value of rpc_address. If rpc_address is set to 0.0.0.0, broadcast_rpc_address must be set.
	 *
	 * @return The value of the {@code broadcastRpcAddress} attribute
	 */
	String getBroadcastRpcAddress();

	/**
	 * Enable or disable keepalive on rpc/native connections.
	 *
	 * @return The value of the {@code rpcKeepalive} attribute
	 */
	Boolean getRpcKeepalive();

	/**
	 * Socket buffer size for internode communication.
	 *
	 * @return The value of the {@code internodeSendBuffSizeInBytes} attribute
	 */
	Integer getInternodeSendBuffSizeInBytes();

	/**
	 * Socket buffer size for internode communication.
	 *
	 * @return The value of the {@code internodeRecvBuffSizeInBytes} attribute
	 */
	Integer getInternodeRecvBuffSizeInBytes();

	/**
	 * Start the native transport or not.
	 *
	 * @return The value of the {@code startNativeTransport} attribute
	 */
	Boolean getStartNativeTransport();

	/**
	 * Port for the CQL native transport to listen for clients on.
	 *
	 * @return The value of the {@code nativeTransportPort} attribute
	 */
	int getNativeTransportPort();

	/**
	 * Enabling native transport encryption.
	 *
	 * @return The value of the {@code nativeTransportPortSsl} attribute
	 */
	Integer getNativeTransportPortSsl();

	/**
	 * The maximum threads for handling requests.
	 *
	 * @return The value of the {@code nativeTransportMaxThreads} attribute
	 */
	Integer getNativeTransportMaxThreads();

	/**
	 * The maximum size of allowed frame. Frame (requests) larger than this will be rejected as invalid.
	 *
	 * @return The value of the {@code nativeTransportMaxFrameSizeInMb} attribute
	 */
	Integer getNativeTransportMaxFrameSizeInMb();

	/**
	 * The maximum number of concurrent client connections.
	 *
	 * @return The value of the {@code nativeTransportMaxConcurrentConnections} attribute
	 */
	Integer getNativeTransportMaxConcurrentConnections();

	/**
	 * The maximum number of concurrent client connections per source ip.
	 *
	 * @return The value of the {@code nativeTransportMaxConcurrentConnectionsPerIp} attribute
	 */
	Integer getNativeTransportMaxConcurrentConnectionsPerIp();

	/**
	 * Maximum size of any value in SSTables. Safety measure to detect SSTable corruption early. Any value size larger
	 * than this threshold will result into marking an SSTable as corrupted.
	 *
	 * @return The value of the {@code maxValueSizeInMb} attribute
	 */
	Integer getMaxValueSizeInMb();

	/**
	 * Enable or disable taking a snapshot before each compaction. This option is useful to back up data when there is a
	 * data format change. Be careful using this option because Cassandra does not clean up older snapshots
	 * automatically.
	 *
	 * @return The value of the {@code snapshotBeforeCompaction} attribute
	 */
	Boolean getSnapshotBeforeCompaction();

	/**
	 * Enable or disable whether a snapshot is taken of the data before keyspace truncation or dropping of tables. To
	 * prevent data loss, using the default setting is strongly advised. If you set to false, you will lose data on
	 * truncation or drop.
	 *
	 * @return The value of the {@code autoSnapshot} attribute
	 */
	Boolean getAutoSnapshot();

	/**
	 * Granularity of the collation index of rows within a partition. Increase if your rows are large, or if you have a
	 * very large number of rows per partition.
	 *
	 * @return The value of the {@code columnIndexSizeInKb} attribute
	 */
	Integer getColumnIndexSizeInKb();

	/**
	 * Granularity of the index of rows within a partition. For huge rows, decrease this setting to improve seek time.
	 * If you use key cache, be careful not to make this setting too large because key cache will be overwhelmed. If
	 * you're unsure of the size of the rows, it's best to use the default setting.
	 *
	 * @return The value of the {@code columnIndexCacheSizeInKb} attribute
	 */
	Integer getColumnIndexCacheSizeInKb();

	/**
	 * Log WARN on any batch size exceeding this value in kilobytes. Caution should be taken on increasing the size of
	 * this threshold as it can lead to node instability.
	 *
	 * @return The value of the {@code batchSizeWarnThresholdInKb} attribute
	 */
	Integer getBatchSizeWarnThresholdInKb();

	/**
	 * Fail any multiple-partition batch exceeding this value.
	 *
	 * @return The value of the {@code batchSizeFailThresholdInKb} attribute
	 */
	Integer getBatchSizeFailThresholdInKb();

	/**
	 * Log WARN on any batches not of type LOGGED than span across more partitions than this limit.
	 *
	 * @return The value of the {@code unloggedBatchAcrossPartitionsWarnThreshold} attribute
	 */
	Integer getUnloggedBatchAcrossPartitionsWarnThreshold();

	/**
	 * the number of concurrent compaction processes allowed to run simultaneously on a node, not including
	 * validation compactions for anti-entropy repair. Simultaneous compactions help preserve read performance in a
	 * mixed read-write workload by mitigating the tendency of small SSTables to accumulate during a single long-running
	 * compaction. If your data directories are backed by SSD, increase this value to the number of cores. If compaction
	 * running too slowly or too fast, adjust compaction_throughput_mb_per_sec first.
	 *
	 * @return The value of the {@code concurrentCompactors} attribute
	 */
	Integer getConcurrentCompactors();

	/**
	 * Throttles compaction to the given total throughput across the entire system. The faster you insert data, the
	 * faster you need to compact in order to keep the sstable count down, but in general, setting this to 16 to 32
	 * times the rate you are inserting data is more than sufficient. Setting this to 0 disables throttling. Note that
	 * this account for all types of compaction, including validation compaction.
	 *
	 * @return The value of the {@code compactionThroughputMbPerSec} attribute
	 */
	Integer getCompactionThroughputMbPerSec();

	/**
	 * Log a warning when compacting partitions larger than this value.
	 *
	 * @return The value of the {@code compactionLargePartitionWarningThresholdMb} attribute
	 */
	Integer getCompactionLargePartitionWarningThresholdMb();

	/**
	 * Throttles all outbound streaming file transfers on a node to the specified throughput. Cassandra does mostly
	 * sequential I/O when streaming data during bootstrap or repair, which can lead to saturating the network
	 * connection and degrading client (RPC) performance.
	 *
	 * @return The value of the {@code streamThroughputOutboundMegabitsPerSec} attribute
	 */
	Integer getStreamThroughputOutboundMegabitsPerSec();

	/**
	 * Throttles all streaming file transfer between the datacenters. This setting allows throttles streaming throughput
	 * betweens data centers in addition to throttling all network stream traffic as configured with
	 * stream_throughput_outbound_megabits_per_sec.
	 *
	 * @return The value of the {@code interDcStreamThroughputOutboundMegabitsPerSec} attribute
	 */
	Integer getInterDcStreamThroughputOutboundMegabitsPerSec();

	/**
	 * Directories where Cassandra should store data on disk.
	 *
	 * @return The value of the {@code dataFileDirectories} attribute
	 */
	List<String> getDataFileDirectories();

	/**
	 * The directory location where table key and row caches are stored.
	 *
	 * @return The value of the {@code savedCachesDirectory} attribute
	 */
	String getSavedCachesDirectory();

	/**
	 * The directory where the commit log is stored.
	 *
	 * @return The value of the {@code commitlogDirectory} attribute
	 */
	String getCommitlogDirectory();

	/**
	 * Total space used for commitlogs. If the used space goes above this value, Cassandra rounds up to the next nearest
	 * segment multiple and flushes memtables to disk for the oldest commitlog segments, removing those log segments.
	 * This reduces the amount of data to replay on start-up, and prevents infrequently-updated tables from indefinitely
	 * keeping commitlog segments. A small total commitlog space tends to cause more flush activity on less-active
	 * tables.
	 *
	 * @return The value of the {@code commitlogTotalSpaceInMb} attribute
	 */
	Integer getCommitlogTotalSpaceInMb();

	/**
	 * Policy for commit log sync.
	 *
	 * @return The value of the {@code commitlogSync} attribute
	 */
	CommitLogSync getCommitlogSync();

	/**
	 * When in batch mode, Cassandra won’t ack writes until the commit log has been fsynced to disk.
	 * It will wait  {@code getCommitlogSyncBatchWindowInMs} between fsyncs.
	 *
	 * @return The value of the {@code commitlogSyncBatchWindowInMs} attribute
	 */
	Double getCommitlogSyncBatchWindowInMs();

	/**
	 * When in periodic mode, the CommitLog is simply synced every {@code getCommitlogSyncPeriodInMs}.
	 *
	 * @return The value of the {@code commitlogSyncPeriodInMs} attribute
	 */
	Long getCommitlogSyncPeriodInMs();

	/**
	 * the size of the individual commitlog file segments. A commitlog segment may be archived, deleted, or
	 * recycled after all its data has been flushed to SSTables. This amount of data can potentially include commitlog
	 * segments from every table in the system. The default size is usually suitable for most commitlog archiving, but
	 * if you want a finer granularity, 8 or 16 MB is reasonable.
	 * This property determines the maximum mutation size, defined as half the segment size. If a mutation's size
	 * exceeds the maximum mutation size, the mutation is rejected. Before increasing the commitlog segment size of the
	 * commitlog segments, investigate why the mutations are larger than expected. Look for underlying issues with
	 * access patterns and data model, because increasing the commitlog segment size is a limited fix.
	 *
	 * @return The value of the {@code commitlogSegmentSizeInMb} attribute
	 */
	Long getCommitlogSegmentSizeInMb();

	/**
	 * Compression to apply to the commit log. If omitted, the commit log will be written uncompressed.
	 *
	 * @return The value of the {@code commitlogCompression} attribute
	 */
	ParameterizedClass getCommitlogCompression();

	/**
	 * Enables encrypting data at-rest (on disk).
	 *
	 * @return The value of the {@code transparentDataEncryptionOptions} attribute
	 */
	TransparentDataEncryptionOptions getTransparentDataEncryptionOptions();

	/**
	 * If a mutation's size exceeds this value, the mutation is rejected. Before increasing the commitlog segment size
	 * of the commitlog segments, investigate why the mutations are larger than expected. Look for underlying issues
	 * with access patterns and data model, because increasing the commitlog segment size is a limited fix.
	 *
	 * @return The value of the {@code maxMutationSizeInKb} attribute
	 */
	Integer getMaxMutationSizeInKb();

	/**
	 * Enable / disable CDC functionality on a per-node basis.
	 *
	 * @return The value of the {@code cdcEnabled} attribute
	 */
	Boolean getCdcEnabled();

	/**
	 * The directory where the CDC log is stored.
	 *
	 * @return The value of the {@code cdcRawDirectory} attribute
	 */
	String getCdcRawDirectory();

	/**
	 * Total space to use for change-data-capture logs on disk.
	 *
	 * @return The value of the {@code cdcTotalSpaceInMb} attribute
	 */
	Integer getCdcTotalSpaceInMb();

	/**
	 * When we hit our cdc_raw limit and the CDCCompactor is either running behind or experiencing backpressure, we
	 * check at the following interval to see if any new space for cdc-tracked tables has been made available.
	 *
	 * @return The value of the {@code cdcFreeSpaceCheckIntervalMs} attribute
	 */
	Long getCdcFreeSpaceCheckIntervalMs();

	/**
	 * Set to a class that implements the IEndpointSnitch interface. Cassandra uses the snitch to locate nodes and
	 * route requests.
	 *
	 * @return The value of the {@code endpointSnitch} attribute
	 */
	String getEndpointSnitch();

	/**
	 * The number of milliseconds between Cassandra's calculation of node scores. Because score calculation is CPU
	 * intensive, be careful when reducing this interval.
	 *
	 * @return The value of the {@code dynamicSnitchUpdateIntervalInMs} attribute
	 */
	Long getDynamicSnitchUpdateIntervalInMs();

	/**
	 * Time interval after which Cassandra resets all node scores. This allows a bad node to recover.
	 *
	 * @return The value of the {@code dynamicSnitchResetIntervalInMs} attribute
	 */
	Long getDynamicSnitchResetIntervalInMs();

	/**
	 * The performance threshold for dynamically routing client requests away from a poorly performing node.
	 *
	 * @return The value of the {@code dynamicSnitchBadnessThreshold} attribute
	 */
	Double getDynamicSnitchBadnessThreshold();

	/**
	 * Defines a scheduler to handle incoming client requests according to a defined policy. This scheduler is useful
	 * for throttling client requests in single clusters containing multiple keyspaces. This parameter is specifically
	 * for requests from the client and does not affect inter-node communication.
	 *
	 * @return The value of the {@code requestScheduler} attribute
	 */
	String getRequestScheduler();

	/**
	 * Policy for request scheduler id.
	 *
	 * @return The value of the {@code requestSchedulerId} attribute
	 */
	RequestSchedulerId getRequestSchedulerId();

	/**
	 * A list of properties that define configuration options for request_scheduler.
	 *
	 * @return The value of the {@code requestSchedulerOptions} attribute
	 * @see RequestSchedulerOptions
	 */
	RequestSchedulerOptions getRequestSchedulerOptions();

	/**
	 * Enables or disables inter-node encryption.
	 *
	 * @return The value of the {@code serverEncryptionOptions} attribute
	 * @see ServerEncryptionOptions
	 */
	ServerEncryptionOptions getServerEncryptionOptions();

	/**
	 * Enables or disables client-to-node encryption.
	 *
	 * @return The value of the {@code clientEncryptionOptions} attribute
	 * @see ClientEncryptionOptions
	 */
	ClientEncryptionOptions getClientEncryptionOptions();

	/**
	 * Compression controls whether traffic between nodes is compressed.
	 *
	 * @return The value of the {@code internodeCompression} attribute
	 */
	InternodeCompression getInternodeCompression();

	/**
	 * Maximum amount of traffic per delivery thread in kilobytes per second. This rate reduces proportionally to the
	 * number of nodes in the cluster. For example, if there are two nodes in the cluster, each delivery thread uses the
	 * maximum rate. If there are three, each node throttles to half of the maximum, since the two nodes are expected to
	 * deliver hints simultaneously.
	 *
	 * @return The value of the {@code hintedHandoffThrottleInKb} attribute
	 */
	Integer getHintedHandoffThrottleInKb();

	/**
	 * Total maximum throttle for replaying hints. Throttling is reduced proportionally to the number of nodes in the
	 * cluster.
	 *
	 * @return The value of the {@code batchlogReplayThrottleInKb} attribute
	 */
	Integer getBatchlogReplayThrottleInKb();

	/**
	 * Number of threads Cassandra uses to deliver hints. In multiple data-center deployments, consider increasing this
	 * number because cross data-center handoff is generally slower.
	 *
	 * @return The value of the {@code maxHintsDeliveryThreads} attribute
	 */
	Integer getMaxHintsDeliveryThreads();

	/**
	 * The number of milliseconds Cassandra waits before flushing hints from internal buffers to disk.
	 *
	 * @return The value of the {@code hintsFlushPeriodInMs} attribute
	 */
	Long getHintsFlushPeriodInMs();

	/**
	 * The maximum size for a single hints file, in megabytes.
	 *
	 * @return The value of the {@code maxHintsFileSizeInMb} attribute
	 */
	Integer getMaxHintsFileSizeInMb();

	/**
	 * Compression to apply to the hint files. If omitted, hints files will be written uncompressed.
	 *
	 * @return The value of the {@code hintsCompression} attribute
	 */
	ParameterizedClass getHintsCompression();

	/**
	 * When compacting, the replacement opens SSTables before they are completely written and uses in place of the prior
	 * SSTables for any range previously written. This setting helps to smoothly transfer reads between the SSTables by
	 * reducing page cache churn and keeps hot rows hot.
	 *
	 * @return The value of the {@code sstablePreemptiveOpenIntervalInMb} attribute
	 */
	Integer getSstablePreemptiveOpenIntervalInMb();

	/**
	 * Backs up data updated since the last snapshot was taken. When enabled, Cassandra creates a hard link to each
	 * SSTable flushed or streamed locally in a backups/ subdirectory of the keyspace data. Removing these links is the
	 * operator's responsibility.
	 *
	 * @return The value of the {@code incrementalBackups} attribute
	 */
	Boolean getIncrementalBackups();

	/**
	 * When doing sequential writing, enabling this option tells fsync to force the operating system to flush the dirty
	 * buffers at a set interval trickle_fsync_interval_in_kb. Enable this parameter to avoid sudden dirty buffer
	 * flushing from impacting read latencies. Recommended to use on SSDs, but not on HDDs.
	 *
	 * @return The value of the {@code trickleFsync} attribute
	 */
	Boolean getTrickleFsync();

	/**
	 * Size  of the fsync in kilobytes.
	 *
	 * @return The value of the {@code trickleFsyncIntervalInKb} attribute
	 */
	Integer getTrickleFsyncIntervalInKb();

	/**
	 * A global cache setting for tables. It is the maximum size of the key cache in memory. When no value is set, the
	 * cache is set to the smaller of 5% of the available heap, or 100MB. To disable set to 0.
	 *
	 * @return The value of the {@code keyCacheSizeInMb} attribute
	 */
	Integer getKeyCacheSizeInMb();

	/**
	 * Duration in seconds that keys are saved in cache. Caches are saved to saved_caches_directory. Saved caches
	 * greatly improve cold-start speeds and has relatively little effect on I/O.
	 *
	 * @return The value of the {@code keyCacheSavePeriod} attribute
	 */
	Long getKeyCacheSavePeriod();

	/**
	 * Number of keys from the key cache to save.
	 *
	 * @return The value of the {@code keyCacheKeysToSave} attribute
	 */
	Integer getKeyCacheKeysToSave();

	/**
	 * The classname of the row cache provider to use.
	 *
	 * @return The value of the {@code rowCacheClassName} attribute
	 */
	String getRowCacheClassName();

	/**
	 * Maximum size of the row cache in memory. Row cache can save more time than key_cache_size_in_mb, but is
	 * space-intensive because it contains the entire row. Use the row cache only for hot rows or static rows. If you
	 * reduce the size, you may not get you hottest keys loaded on start up.
	 *
	 * @return The value of the {@code rowCacheSizeInMb} attribute
	 */
	Integer getRowCacheSizeInMb();

	/**
	 * Duration in seconds that rows are saved in cache. Caches are saved to saved_caches_directory. This setting has
	 * limited use as described in row_cache_size_in_mb.
	 *
	 * @return The value of the {@code rowCacheSavePeriod} attribute
	 */
	Long getRowCacheSavePeriod();

	/**
	 * Number of keys from the row cache to save.
	 *
	 * @return The value of the {@code rowCacheKeysToSave} attribute
	 */
	Integer getRowCacheKeysToSave();

	/**
	 * When no value is specified a minimum of 2.5% of Heap or 50MB. If you perform counter deletes and rely on low
	 * gc_grace_seconds, you should disable the counter cache. To disable, set to 0.
	 *
	 * @return The value of the {@code counterCacheSizeInMb} attribute
	 */
	Integer getCounterCacheSizeInMb();

	/**
	 * Duration after which Cassandra should save the counter cache (keys only). Caches are saved to
	 * saved_caches_directory.
	 *
	 * @return The value of the {@code counterCacheSavePeriod} attribute
	 */
	Long getCounterCacheSavePeriod();

	/**
	 * Number of keys from the counter cache to save. When disabled all keys are saved.
	 *
	 * @return The value of the {@code counterCacheKeysToSave} attribute
	 */
	Integer getCounterCacheKeysToSave();

	/**
	 * Total memory to use for SSTable-reading buffers.
	 *
	 * @return The value of the {@code fileCacheSizeInMb} attribute
	 */
	Integer getFileCacheSizeInMb();

	/**
	 * ﻿Indicates whether Cassandra allocates allocate on-heap or off-heap memory when the SSTable buffer pool is
	 * exhausted (when the buffer pool has exceeded the maximum memory file_cache_size_in_mb), beyond this amount,
	 * Cassandra stops caching buffers, but allocates on request.
	 *
	 * @return The value of the {@code bufferPoolUseHeapIfExhausted} attribute
	 */
	Boolean getBufferPoolUseHeapIfExhausted();

	/**
	 * The strategy for optimizing disk read.
	 *
	 * @return The value of the {@code diskOptimizationStrategy} attribute
	 */
	DiskOptimizationStrategy getDiskOptimizationStrategy();

	/**
	 * Enable or disable tcp_nodelay for inter-dc communication.
	 *
	 * @return The value of the {@code interDcTcpNodelay} attribute
	 */
	Boolean getInterDcTcpNodelay();

	/**
	 * The maximum number of tombstones a query can scan before warning.
	 *
	 * @return The value of the {@code tombstoneWarnThreshold} attribute
	 */
	Integer getTombstoneWarnThreshold();

	/**
	 * The maximum number of tombstones a query can scan before aborting.
	 *
	 * @return The value of the {@code tombstoneFailureThreshold} attribute
	 */
	Integer getTombstoneFailureThreshold();

	/**
	 * Fixed memory pool size in MB for SSTable index summaries. If the memory usage of all index summaries exceeds this
	 * limit, any SSTables with low read rates shrink their index summaries to meet this limit. This is a best-effort
	 * process. In extreme conditions, Cassandra may need to use more than this amount of memory.
	 *
	 * @return The value of the {@code indexSummaryCapacityInMb} attribute
	 */
	Integer getIndexSummaryCapacityInMb();

	/**
	 * How frequently index summaries should be re-sampled. This is done periodically to redistribute memory from the
	 * fixed-size pool to SSTables proportional their recent read rates. To disable, set to -1. This leaves existing
	 * index summaries at their current sampling level.
	 *
	 * @return The value of the {@code indexSummaryResizeIntervalInMinutes} attribute
	 */
	Integer getIndexSummaryResizeIntervalInMinutes();

	/**
	 * GC Pauses greater than 200 ms will be logged at INFO level This threshold can be adjusted to minimize logging
	 * if necessary.
	 *
	 * @return The value of the {@code gcLogThresholdInMs} attribute
	 */
	Long getGcLogThresholdInMs();

	/**
	 * GC Pauses greater than gc_warn_threshold_in_ms will be logged at WARN level Adjust the threshold based on your
	 * application throughput requirement. Setting to 0 will deactivate the feature.
	 *
	 * @return The value of the {@code gcWarnThresholdInMs} attribute
	 */
	Long getGcWarnThresholdInMs();

	/**
	 * Policy for memory table allocation type.
	 *
	 * @return The value of the {@code memtableAllocationType} attribute
	 */
	MemtableAllocationType getMemtableAllocationType();

	/**
	 * TTL for different trace types used during logging of the repair process.
	 *
	 * @return The value of the {@code tracetypeQueryTtl} attribute
	 */
	Long getTracetypeQueryTtl();

	/**
	 * TTL for different trace types used during logging of the repair process.
	 *
	 * @return The value of the {@code tracetypeRepairTtl} attribute
	 */
	Long getTracetypeRepairTtl();

	/**
	 * Strategy to use for coalescing messages in OutboundTcpConnection.
	 *
	 * @return The value of the {@code otcCoalescingStrategy} attribute
	 */
	String getOtcCoalescingStrategy();

	/**
	 * How many microseconds to wait for coalescing.
	 *
	 * @return The value of the {@code otcCoalescingWindowUs} attribute
	 */
	Long getOtcCoalescingWindowUs();

	/**
	 * Do not try to coalesce messages if we already got that many messages. This should be more than 2 and less than
	 * 128.
	 *
	 * @return The value of the {@code otcCoalescingEnoughCoalescedMessages} attribute
	 */
	Integer getOtcCoalescingEnoughCoalescedMessages();

	/**
	 * How many milliseconds to wait between two expiration runs on the backlog (queue) of the OutboundTcpConnection.
	 *
	 * @return The value of the {@code otcBacklogExpirationIntervalMs} attribute
	 */
	Long getOtcBacklogExpirationIntervalMs();

	/**
	 * The default Windows kernel timer and scheduling resolution is 15.6ms for power conservation. Lowering this value
	 * on Windows can provide much tighter latency and better throughput, however some virtualized environments may see
	 * a negative performance impact from changing this setting below their system default. The sysinternals ‘clockres’
	 * tool can confirm your system’s default setting.
	 *
	 * @return The value of the {@code windowsTimerInterval} attribute
	 */
	Integer getWindowsTimerInterval();

	/**
	 * Maximum size of the native protocol prepared statement cache.
	 *
	 * @return The value of the {@code preparedStatementsCacheSizeMb} attribute
	 */
	Integer getPreparedStatementsCacheSizeMb();

	/**
	 * If unset, all GC Pauses greater than gc_log_threshold_in_ms will log at INFO level UDFs (user defined functions)
	 * are disabled by default. As of Cassandra 3.0 there is a sandbox in place that should prevent execution of evil
	 * code.
	 *
	 * @return The value of the {@code enableUserDefinedFunctions} attribute
	 */
	Boolean getEnableUserDefinedFunctions();

	/**
	 * Enables scripted UDFs (JavaScript UDFs). Java UDFs are always enabled, if enable_user_defined_functions is true.
	 * Enable this option to be able to use UDFs with “language javascript” or any custom JSR-223 provider. This option
	 * has no effect, if enable_user_defined_functions is false.
	 *
	 * @return The value of the {@code enableScriptedUserDefinedFunctions} attribute
	 */
	Boolean getEnableScriptedUserDefinedFunctions();

	/**
	 * Back-pressure settings (If enabled) the coordinator will apply the back-pressure strategy specified below to
	 * each mutation sent to replicas, with the aim of reducing pressure on overloaded replicas.
	 *
	 * @return The value of the {@code backPressureEnabled} attribute
	 */
	Boolean getBackPressureEnabled();

	/**
	 * The backpressure strategy.
	 *
	 * @return The value of the {@code backPressureStrategy} attribute
	 */
	ParameterizedClass getBackPressureStrategy();

	/**
	 * Policy for data disk access mode.
	 *
	 * @return The value of the {@code diskAccessMode} attribute
	 */
	DiskAccessMode getDiskAccessMode();

	static Builder builder() {
		return new ConfigBuilder();
	}


	/**
	 * Builds instances of type {@link Config Config}. Initialize attributes and then invoke the {@link #build()} method
	 * to create an instance.
	 * <p><em>{@code ConfigBuilder} is not thread-safe and generally should not be stored in a field or collection,
	 * but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link Config#getJmxPort() jmxPort} attribute.
		 *
		 * @param jmxPort The value for jmxPort
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setJmxPort(int jmxPort);

		/**
		 * Initializes the value for the {@link Config#getStreamingSocketTimeoutInMs() streamingSocketTimeoutInMs}
		 * attribute.
		 *
		 * @param streamingSocketTimeoutInMs The value for streamingSocketTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setStreamingSocketTimeoutInMs(Long streamingSocketTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getClusterName() clusterName} attribute.
		 *
		 * @param clusterName The value for clusterName (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setClusterName(String clusterName);

		/**
		 * Initializes the value for the {@link Config#getAuthenticator() authenticator} attribute.
		 *
		 * @param authenticator The value for authenticator (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAuthenticator(String authenticator);

		/**
		 * Initializes the value for the {@link Config#getAuthorizer() authorizer} attribute.
		 *
		 * @param authorizer The value for authorizer (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAuthorizer(String authorizer);

		/**
		 * Initializes the value for the {@link Config#getRoleManager() roleManager} attribute.
		 *
		 * @param roleManager The value for roleManager (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRoleManager(String roleManager);

		/**
		 * Initializes the value for the {@link Config#getPermissionsValidityInMs() permissionsValidityInMs} attribute.
		 *
		 * @param permissionsValidityInMs The value for permissionsValidityInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setPermissionsValidityInMs(Long permissionsValidityInMs);

		/**
		 * Initializes the value for the {@link Config#getPermissionsCacheMaxEntries() permissionsCacheMaxEntries}
		 * attribute.
		 *
		 * @param permissionsCacheMaxEntries The value for permissionsCacheMaxEntries (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setPermissionsCacheMaxEntries(Integer permissionsCacheMaxEntries);

		/**
		 * Initializes the value for the {@link Config#getPermissionsUpdateIntervalInMs() permissionsUpdateIntervalInMs}
		 * attribute.
		 *
		 * @param permissionsUpdateIntervalInMs The value for permissionsUpdateIntervalInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setPermissionsUpdateIntervalInMs(Long permissionsUpdateIntervalInMs);

		/**
		 * Initializes the value for the {@link Config#getRolesValidityInMs() rolesValidityInMs} attribute.
		 *
		 * @param rolesValidityInMs The value for rolesValidityInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRolesValidityInMs(Long rolesValidityInMs);

		/**
		 * Initializes the value for the {@link Config#getRolesCacheMaxEntries() rolesCacheMaxEntries} attribute.
		 *
		 * @param rolesCacheMaxEntries The value for rolesCacheMaxEntries (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRolesCacheMaxEntries(Integer rolesCacheMaxEntries);

		/**
		 * Initializes the value for the {@link Config#getRolesUpdateIntervalInMs() rolesUpdateIntervalInMs} attribute.
		 *
		 * @param rolesUpdateIntervalInMs The value for rolesUpdateIntervalInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRolesUpdateIntervalInMs(Long rolesUpdateIntervalInMs);

		/**
		 * Initializes the value for the {@link Config#getCredentialsValidityInMs() credentialsValidityInMs} attribute.
		 *
		 * @param credentialsValidityInMs The value for credentialsValidityInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCredentialsValidityInMs(Long credentialsValidityInMs);

		/**
		 * Initializes the value for the {@link Config#getCredentialsCacheMaxEntries() credentialsCacheMaxEntries}
		 * attribute.
		 *
		 * @param credentialsCacheMaxEntries The value for credentialsCacheMaxEntries (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCredentialsCacheMaxEntries(Integer credentialsCacheMaxEntries);

		/**
		 * Initializes the value for the {@link Config#getCredentialsUpdateIntervalInMs() credentialsUpdateIntervalInMs}
		 * attribute.
		 *
		 * @param credentialsUpdateIntervalInMs The value for credentialsUpdateIntervalInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCredentialsUpdateIntervalInMs(Long credentialsUpdateIntervalInMs);

		/**
		 * Initializes the value for the {@link Config#getPartitioner() partitioner} attribute.
		 *
		 * @param partitioner The value for partitioner (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setPartitioner(String partitioner);

		/**
		 * Initializes the value for the {@link Config#getAutoBootstrap() autoBootstrap} attribute.
		 *
		 * @param autoBootstrap The value for autoBootstrap
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAutoBootstrap(Boolean autoBootstrap);

		/**
		 * Initializes the value for the {@link Config#getHintedHandoffEnabled() hintedHandoffEnabled} attribute.
		 *
		 * @param hintedHandoffEnabled The value for hintedHandoffEnabled
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setHintedHandoffEnabled(Boolean hintedHandoffEnabled);

		/**
		 * Adds one element to {@link Config#getHintedHandoffDisabledDatacenters() hintedHandoffDisabledDatacenters}
		 * list.
		 *
		 * @param element A hintedHandoffDisabledDatacenters element
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addHintedHandoffDisabledDatacenters(String element);

		/**
		 * Adds elements to {@link Config#getHintedHandoffDisabledDatacenters() hintedHandoffDisabledDatacenters} list.
		 *
		 * @param elements An array of hintedHandoffDisabledDatacenters elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addHintedHandoffDisabledDatacenters(String... elements);


		/**
		 * Sets or replaces all elements for {@link Config#getHintedHandoffDisabledDatacenters()
		 * hintedHandoffDisabledDatacenters} list.
		 *
		 * @param elements An iterable of hintedHandoffDisabledDatacenters elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setHintedHandoffDisabledDatacenters(Iterable<String> elements);

		/**
		 * Adds elements to {@link Config#getHintedHandoffDisabledDatacenters() hintedHandoffDisabledDatacenters} list.
		 *
		 * @param elements An iterable of hintedHandoffDisabledDatacenters elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addHintedHandoffDisabledDatacenters(Iterable<String> elements);

		/**
		 * Initializes the value for the {@link Config#getMaxHintWindowInMs() maxHintWindowInMs} attribute.
		 *
		 * @param maxHintWindowInMs The value for maxHintWindowInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMaxHintWindowInMs(Long maxHintWindowInMs);

		/**
		 * Initializes the value for the {@link Config#getHintsDirectory() hintsDirectory} attribute.
		 *
		 * @param hintsDirectory The value for hintsDirectory (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setHintsDirectory(String hintsDirectory);

		/**
		 * Initializes the value for the {@link Config#getSeedProvider() seedProvider} attribute.
		 *
		 * @param seedProvider The value for seedProvider (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setSeedProvider(ParameterizedClass seedProvider);

		/**
		 * Initializes the value for the {@link Config#getDiskFailurePolicy() diskFailurePolicy} attribute.
		 *
		 * @param diskFailurePolicy The value for diskFailurePolicy (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDiskFailurePolicy(DiskFailurePolicy diskFailurePolicy);

		/**
		 * Initializes the value for the {@link Config#getCommitFailurePolicy() commitFailurePolicy} attribute.
		 *
		 * @param commitFailurePolicy The value for commitFailurePolicy (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitFailurePolicy(CommitFailurePolicy commitFailurePolicy);

		/**
		 * Initializes the value for the {@link Config#getInitialToken() initialToken} attribute.
		 *
		 * @param initialToken The value for initialToken (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInitialToken(String initialToken);

		/**
		 * Initializes the value for the {@link Config#getNumTokens() numTokens} attribute.
		 *
		 * @param numTokens The value for numTokens (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNumTokens(Integer numTokens);

		/**
		 * Initializes the value for the {@link Config#getAllocateTokensForLocalReplicationFactor()
		 * allocateTokensForKeyspace}
		 * attribute.
		 *
		 * @param allocateTokensForLocalReplicationFactor The value for allocateTokensForLocalReplicationFactor (can be
		 * {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAllocateTokensForLocalReplicationFactor(
				String allocateTokensForLocalReplicationFactor);

		/**
		 * Initializes the value for the {@link Config#getAllocateTokensForKeyspace()} ()
		 * allocateTokensForKeyspace}
		 * attribute.
		 *
		 * @param allocateTokensForKeyspace The value for allocateTokensForKeyspace (can be
		 * {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAllocateTokensForKeyspace(String allocateTokensForKeyspace);

		/**
		 * Initializes the value for the {@link Config#getRequestTimeoutInMs() requestTimeoutInMs} attribute.
		 *
		 * @param requestTimeoutInMs The value for requestTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRequestTimeoutInMs(Long requestTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getReadRequestTimeoutInMs() readRequestTimeoutInMs} attribute.
		 *
		 * @param readRequestTimeoutInMs The value for readRequestTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setReadRequestTimeoutInMs(Long readRequestTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getRangeRequestTimeoutInMs() rangeRequestTimeoutInMs} attribute.
		 *
		 * @param rangeRequestTimeoutInMs The value for rangeRequestTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRangeRequestTimeoutInMs(Long rangeRequestTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getWriteRequestTimeoutInMs() writeRequestTimeoutInMs} attribute.
		 *
		 * @param writeRequestTimeoutInMs The value for writeRequestTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setWriteRequestTimeoutInMs(Long writeRequestTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getCounterWriteRequestTimeoutInMs()
		 * counterWriteRequestTimeoutInMs} attribute.
		 *
		 * @param counterWriteRequestTimeoutInMs The value for counterWriteRequestTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCounterWriteRequestTimeoutInMs(Long counterWriteRequestTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getCasContentionTimeoutInMs() casContentionTimeoutInMs}
		 * attribute.
		 *
		 * @param casContentionTimeoutInMs The value for casContentionTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCasContentionTimeoutInMs(Long casContentionTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getTruncateRequestTimeoutInMs() truncateRequestTimeoutInMs}
		 * attribute.
		 *
		 * @param truncateRequestTimeoutInMs The value for truncateRequestTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTruncateRequestTimeoutInMs(Long truncateRequestTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getStreamingKeepAlivePeriodInSecs()
		 * streamingKeepAlivePeriodInSecs} attribute.
		 *
		 * @param streamingKeepAlivePeriodInSecs The value for streamingKeepAlivePeriodInSecs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setStreamingKeepAlivePeriodInSecs(Long streamingKeepAlivePeriodInSecs);

		/**
		 * Initializes the value for the {@link Config#getCrossNodeTimeout() crossNodeTimeout} attribute.
		 *
		 * @param crossNodeTimeout The value for crossNodeTimeout
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCrossNodeTimeout(Boolean crossNodeTimeout);

		/**
		 * Initializes the value for the {@link Config#getSlowQueryLogTimeoutInMs() slowQueryLogTimeoutInMs} attribute.
		 *
		 * @param slowQueryLogTimeoutInMs The value for slowQueryLogTimeoutInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setSlowQueryLogTimeoutInMs(Long slowQueryLogTimeoutInMs);

		/**
		 * Initializes the value for the {@link Config#getPhiConvictThreshold() phiConvictThreshold} attribute.
		 *
		 * @param phiConvictThreshold The value for phiConvictThreshold (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setPhiConvictThreshold(Double phiConvictThreshold);

		/**
		 * Initializes the value for the {@link Config#getConcurrentReads() concurrentReads} attribute.
		 *
		 * @param concurrentReads The value for concurrentReads (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setConcurrentReads(Integer concurrentReads);

		/**
		 * Initializes the value for the {@link Config#getConcurrentWrites() concurrentWrites} attribute.
		 *
		 * @param concurrentWrites The value for concurrentWrites (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setConcurrentWrites(Integer concurrentWrites);

		/**
		 * Initializes the value for the {@link Config#getConcurrentCounterWrites() concurrentCounterWrites} attribute.
		 *
		 * @param concurrentCounterWrites The value for concurrentCounterWrites (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setConcurrentCounterWrites(Integer concurrentCounterWrites);

		/**
		 * Initializes the value for the {@link Config#getConcurrentMaterializedViewWrites()
		 * concurrentMaterializedViewWrites} attribute.
		 *
		 * @param concurrentMaterializedViewWrites The value for concurrentMaterializedViewWrites (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setConcurrentMaterializedViewWrites(
				Integer concurrentMaterializedViewWrites);

		/**
		 * Initializes the value for the {@link Config#getMemtableFlushWriters() memtableFlushWriters} attribute.
		 *
		 * @param memtableFlushWriters The value for memtableFlushWriters (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMemtableFlushWriters(Integer memtableFlushWriters);

		/**
		 * Initializes the value for the {@link Config#getMemtableHeapSpaceInMb() memtableHeapSpaceInMb} attribute.
		 *
		 * @param memtableHeapSpaceInMb The value for memtableHeapSpaceInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMemtableHeapSpaceInMb(Integer memtableHeapSpaceInMb);

		/**
		 * Initializes the value for the {@link Config#getMemtableOffheapSpaceInMb() memtableOffheapSpaceInMb}
		 * attribute.
		 *
		 * @param memtableOffheapSpaceInMb The value for memtableOffheapSpaceInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMemtableOffheapSpaceInMb(Integer memtableOffheapSpaceInMb);

		/**
		 * Initializes the value for the {@link Config#getMemtableCleanupThreshold() memtableCleanupThreshold}
		 * attribute.
		 *
		 * @param memtableCleanupThreshold The value for memtableCleanupThreshold (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMemtableCleanupThreshold(Double memtableCleanupThreshold);

		/**
		 * Initializes the value for the {@link Config#getStoragePort() storagePort} attribute.
		 *
		 * @param storagePort The value for storagePort
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setStoragePort(int storagePort);

		/**
		 * Initializes the value for the {@link Config#getSslStoragePort() sslStoragePort} attribute.
		 *
		 * @param sslStoragePort The value for sslStoragePort
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setSslStoragePort(int sslStoragePort);

		/**
		 * Initializes the value for the {@link Config#getListenAddress() listenAddress} attribute.
		 *
		 * @param listenAddress The value for listenAddress (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setListenAddress(String listenAddress);

		/**
		 * Initializes the value for the {@link Config#getListenInterface() listenInterface} attribute.
		 *
		 * @param listenInterface The value for listenInterface (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setListenInterface(String listenInterface);

		/**
		 * Initializes the value for the {@link Config#getListenInterfacePreferIpv6() listenInterfacePreferIpv6}
		 * attribute.
		 *
		 * @param listenInterfacePreferIpv6 The value for listenInterfacePreferIpv6
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setListenInterfacePreferIpv6(Boolean listenInterfacePreferIpv6);

		/**
		 * Initializes the value for the {@link Config#getBroadcastAddress() broadcastAddress} attribute.
		 *
		 * @param broadcastAddress The value for broadcastAddress (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBroadcastAddress(String broadcastAddress);

		/**
		 * Initializes the value for the {@link Config#getListenOnBroadcastAddress() listenOnBroadcastAddress}
		 * attribute.
		 *
		 * @param listenOnBroadcastAddress The value for listenOnBroadcastAddress
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setListenOnBroadcastAddress(Boolean listenOnBroadcastAddress);

		/**
		 * Initializes the value for the {@link Config#getInternodeAuthenticator() internodeAuthenticator} attribute.
		 *
		 * @param internodeAuthenticator The value for internodeAuthenticator (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInternodeAuthenticator(String internodeAuthenticator);


		/**
		 * Initializes the value for the {@link Config#getRpcAddress() rpcAddress} attribute.
		 *
		 * @param rpcAddress The value for rpcAddress (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRpcAddress(String rpcAddress);

		/**
		 * Initializes the value for the {@link Config#getRpcInterface() rpcInterface} attribute.
		 *
		 * @param rpcInterface The value for rpcInterface (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRpcInterface(String rpcInterface);

		/**
		 * Initializes the value for the {@link Config#getRpcInterfacePreferIpv6() rpcInterfacePreferIpv6} attribute.
		 *
		 * @param rpcInterfacePreferIpv6 The value for rpcInterfacePreferIpv6
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRpcInterfacePreferIpv6(Boolean rpcInterfacePreferIpv6);

		/**
		 * Initializes the value for the {@link Config#getBroadcastRpcAddress() broadcastRpcAddress} attribute.
		 *
		 * @param broadcastRpcAddress The value for broadcastRpcAddress (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBroadcastRpcAddress(String broadcastRpcAddress);


		/**
		 * Initializes the value for the {@link Config#getRpcKeepalive() rpcKeepalive} attribute.
		 *
		 * @param rpcKeepalive The value for rpcKeepalive
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRpcKeepalive(Boolean rpcKeepalive);

		/**
		 * Initializes the value for the {@link Config#getInternodeSendBuffSizeInBytes() internodeSendBuffSizeInBytes}
		 * attribute.
		 *
		 * @param internodeSendBuffSizeInBytes The value for internodeSendBuffSizeInBytes (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInternodeSendBuffSizeInBytes(Integer internodeSendBuffSizeInBytes);

		/**
		 * Initializes the value for the {@link Config#getInternodeRecvBuffSizeInBytes() internodeRecvBuffSizeInBytes}
		 * attribute.
		 *
		 * @param internodeRecvBuffSizeInBytes The value for internodeRecvBuffSizeInBytes (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInternodeRecvBuffSizeInBytes(Integer internodeRecvBuffSizeInBytes);

		/**
		 * Initializes the value for the {@link Config#getStartNativeTransport() startNativeTransport} attribute.
		 *
		 * @param startNativeTransport The value for startNativeTransport
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setStartNativeTransport(Boolean startNativeTransport);

		/**
		 * Initializes the value for the {@link Config#getNativeTransportPort() nativeTransportPort} attribute.
		 *
		 * @param nativeTransportPort The value for nativeTransportPort
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNativeTransportPort(int nativeTransportPort);

		/**
		 * Initializes the value for the {@link Config#getNativeTransportPortSsl() nativeTransportPortSsl} attribute.
		 *
		 * @param nativeTransportPortSsl The value for nativeTransportPortSsl (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNativeTransportPortSsl(Integer nativeTransportPortSsl);

		/**
		 * Initializes the value for the {@link Config#getNativeTransportMaxThreads() nativeTransportMaxThreads}
		 * attribute.
		 *
		 * @param nativeTransportMaxThreads The value for nativeTransportMaxThreads (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNativeTransportMaxThreads(Integer nativeTransportMaxThreads);

		/**
		 * Initializes the value for the {@link Config#getNativeTransportMaxFrameSizeInMb()
		 * nativeTransportMaxFrameSizeInMb} attribute.
		 *
		 * @param nativeTransportMaxFrameSizeInMb The value for nativeTransportMaxFrameSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNativeTransportMaxFrameSizeInMb(
				Integer nativeTransportMaxFrameSizeInMb);

		/**
		 * Initializes the value for the {@link Config#getNativeTransportMaxConcurrentConnections()
		 * nativeTransportMaxConcurrentConnections} attribute.
		 *
		 * @param nativeTransportMaxConcurrentConnections The value for nativeTransportMaxConcurrentConnections (can be
		 * {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNativeTransportMaxConcurrentConnections(
				Integer nativeTransportMaxConcurrentConnections);

		/**
		 * Initializes the value for the {@link Config#getNativeTransportMaxConcurrentConnectionsPerIp()
		 * nativeTransportMaxConcurrentConnectionsPerIp} attribute.
		 *
		 * @param nativeTransportMaxConcurrentConnectionsPerIp The value for
		 * nativeTransportMaxConcurrentConnectionsPerIp (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setNativeTransportMaxConcurrentConnectionsPerIp(
				Integer nativeTransportMaxConcurrentConnectionsPerIp);

		/**
		 * Initializes the value for the {@link Config#getMaxValueSizeInMb() maxValueSizeInMb} attribute.
		 *
		 * @param maxValueSizeInMb The value for maxValueSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMaxValueSizeInMb(Integer maxValueSizeInMb);


		/**
		 * Initializes the value for the {@link Config#getSnapshotBeforeCompaction() snapshotBeforeCompaction}
		 * attribute.
		 *
		 * @param snapshotBeforeCompaction The value for snapshotBeforeCompaction
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setSnapshotBeforeCompaction(Boolean snapshotBeforeCompaction);

		/**
		 * Initializes the value for the {@link Config#getAutoSnapshot() autoSnapshot} attribute.
		 *
		 * @param autoSnapshot The value for autoSnapshot
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAutoSnapshot(Boolean autoSnapshot);

		/**
		 * Initializes the value for the {@link Config#getColumnIndexSizeInKb() columnIndexSizeInKb} attribute.
		 *
		 * @param columnIndexSizeInKb The value for columnIndexSizeInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setColumnIndexSizeInKb(Integer columnIndexSizeInKb);

		/**
		 * Initializes the value for the {@link Config#getColumnIndexCacheSizeInKb() columnIndexCacheSizeInKb}
		 * attribute.
		 *
		 * @param columnIndexCacheSizeInKb The value for columnIndexCacheSizeInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setColumnIndexCacheSizeInKb(Integer columnIndexCacheSizeInKb);

		/**
		 * Initializes the value for the {@link Config#getBatchSizeWarnThresholdInKb() batchSizeWarnThresholdInKb}
		 * attribute.
		 *
		 * @param batchSizeWarnThresholdInKb The value for batchSizeWarnThresholdInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBatchSizeWarnThresholdInKb(Integer batchSizeWarnThresholdInKb);

		/**
		 * Initializes the value for the {@link Config#getBatchSizeFailThresholdInKb() batchSizeFailThresholdInKb}
		 * attribute.
		 *
		 * @param batchSizeFailThresholdInKb The value for batchSizeFailThresholdInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBatchSizeFailThresholdInKb(Integer batchSizeFailThresholdInKb);

		/**
		 * Initializes the value for the {@link Config#getUnloggedBatchAcrossPartitionsWarnThreshold()
		 * unloggedBatchAcrossPartitionsWarnThreshold} attribute.
		 *
		 * @param unloggedBatchAcrossPartitionsWarnThreshold The value for unloggedBatchAcrossPartitionsWarnThreshold
		 * (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setUnloggedBatchAcrossPartitionsWarnThreshold(
				Integer unloggedBatchAcrossPartitionsWarnThreshold);

		/**
		 * Initializes the value for the {@link Config#getConcurrentCompactors() concurrentCompactors} attribute.
		 *
		 * @param concurrentCompactors The value for concurrentCompactors (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setConcurrentCompactors(Integer concurrentCompactors);

		/**
		 * Initializes the value for the {@link Config#getCompactionThroughputMbPerSec() compactionThroughputMbPerSec}
		 * attribute.
		 *
		 * @param compactionThroughputMbPerSec The value for compactionThroughputMbPerSec (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCompactionThroughputMbPerSec(Integer compactionThroughputMbPerSec);

		/**
		 * Initializes the value for the {@link Config#getCompactionLargePartitionWarningThresholdMb()
		 * compactionLargePartitionWarningThresholdMb} attribute.
		 *
		 * @param compactionLargePartitionWarningThresholdMb The value for compactionLargePartitionWarningThresholdMb
		 * (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCompactionLargePartitionWarningThresholdMb(
				Integer compactionLargePartitionWarningThresholdMb);


		/**
		 * Initializes the value for the {@link Config#getStreamThroughputOutboundMegabitsPerSec()
		 * streamThroughputOutboundMegabitsPerSec} attribute.
		 *
		 * @param streamThroughputOutboundMegabitsPerSec The value for streamThroughputOutboundMegabitsPerSec (can be
		 * {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setStreamThroughputOutboundMegabitsPerSec(
				Integer streamThroughputOutboundMegabitsPerSec);

		/**
		 * Initializes the value for the {@link Config#getInterDcStreamThroughputOutboundMegabitsPerSec()
		 * interDcStreamThroughputOutboundMegabitsPerSec} attribute.
		 *
		 * @param interDcStreamThroughputOutboundMegabitsPerSec The value for
		 * interDcStreamThroughputOutboundMegabitsPerSec (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInterDcStreamThroughputOutboundMegabitsPerSec(
				Integer interDcStreamThroughputOutboundMegabitsPerSec);

		/**
		 * Adds one element to {@link Config#getDataFileDirectories() dataFileDirectories} list.
		 *
		 * @param element A dataFileDirectories element
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addDataFileDirectories(String element);

		/**
		 * Adds elements to {@link Config#getDataFileDirectories() dataFileDirectories} list.
		 *
		 * @param elements An array of dataFileDirectories elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addDataFileDirectories(String... elements);


		/**
		 * Sets or replaces all elements for {@link Config#getDataFileDirectories() dataFileDirectories} list.
		 *
		 * @param elements An iterable of dataFileDirectories elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDataFileDirectories(Iterable<String> elements);

		/**
		 * Adds elements to {@link Config#getDataFileDirectories() dataFileDirectories} list.
		 *
		 * @param elements An iterable of dataFileDirectories elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addDataFileDirectories(Iterable<String> elements);

		/**
		 * Initializes the value for the {@link Config#getSavedCachesDirectory() savedCachesDirectory} attribute.
		 *
		 * @param savedCachesDirectory The value for savedCachesDirectory (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setSavedCachesDirectory(String savedCachesDirectory);

		/**
		 * Initializes the value for the {@link Config#getCommitlogDirectory() commitlogDirectory} attribute.
		 *
		 * @param commitlogDirectory The value for commitlogDirectory (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogDirectory(String commitlogDirectory);

		/**
		 * Initializes the value for the {@link Config#getCommitlogTotalSpaceInMb() commitlogTotalSpaceInMb} attribute.
		 *
		 * @param commitlogTotalSpaceInMb The value for commitlogTotalSpaceInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogTotalSpaceInMb(Integer commitlogTotalSpaceInMb);

		/**
		 * Initializes the value for the {@link Config#getCommitlogSync() commitlogSync} attribute.
		 *
		 * @param commitlogSync The value for commitlogSync (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogSync(CommitLogSync commitlogSync);

		/**
		 * Initializes the value for the {@link Config#getCommitlogSyncBatchWindowInMs() commitlogSyncBatchWindowInMs}
		 * attribute.
		 *
		 * @param commitlogSyncBatchWindowInMs The value for commitlogSyncBatchWindowInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogSyncBatchWindowInMs(Double commitlogSyncBatchWindowInMs);

		/**
		 * Initializes the value for the {@link Config#getCommitlogSyncPeriodInMs() commitlogSyncPeriodInMs} attribute.
		 *
		 * @param commitlogSyncPeriodInMs The value for commitlogSyncPeriodInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogSyncPeriodInMs(Long commitlogSyncPeriodInMs);

		/**
		 * Initializes the value for the {@link Config#getCommitlogSegmentSizeInMb() commitlogSegmentSizeInMb}
		 * attribute.
		 *
		 * @param commitlogSegmentSizeInMb The value for commitlogSegmentSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogSegmentSizeInMb(Long commitlogSegmentSizeInMb);

		/**
		 * Initializes the value for the {@link Config#getCommitlogCompression() commitlogCompression} attribute.
		 *
		 * @param commitlogCompression The value for commitlogCompression (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCommitlogCompression(ParameterizedClass commitlogCompression);


		/**
		 * Initializes the value for the {@link Config#getTransparentDataEncryptionOptions()
		 * transparentDataEncryptionOptions} attribute.
		 *
		 * @param transparentDataEncryptionOptions The value for transparentDataEncryptionOptions (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTransparentDataEncryptionOptions(
				TransparentDataEncryptionOptions transparentDataEncryptionOptions);

		/**
		 * Initializes the value for the {@link Config#getMaxMutationSizeInKb() maxMutationSizeInKb} attribute.
		 *
		 * @param maxMutationSizeInKb The value for maxMutationSizeInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMaxMutationSizeInKb(Integer maxMutationSizeInKb);

		/**
		 * Initializes the value for the {@link Config#getCdcEnabled() cdcEnabled} attribute.
		 *
		 * @param cdcEnabled The value for cdcEnabled
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCdcEnabled(Boolean cdcEnabled);

		/**
		 * Initializes the value for the {@link Config#getCdcRawDirectory() cdcRawDirectory} attribute.
		 *
		 * @param cdcRawDirectory The value for cdcRawDirectory (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCdcRawDirectory(String cdcRawDirectory);

		/**
		 * Initializes the value for the {@link Config#getCdcTotalSpaceInMb() cdcTotalSpaceInMb} attribute.
		 *
		 * @param cdcTotalSpaceInMb The value for cdcTotalSpaceInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCdcTotalSpaceInMb(Integer cdcTotalSpaceInMb);

		/**
		 * Initializes the value for the {@link Config#getCdcFreeSpaceCheckIntervalMs() cdcFreeSpaceCheckIntervalMs}
		 * attribute.
		 *
		 * @param cdcFreeSpaceCheckIntervalMs The value for cdcFreeSpaceCheckIntervalMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCdcFreeSpaceCheckIntervalMs(Long cdcFreeSpaceCheckIntervalMs);

		/**
		 * Initializes the value for the {@link Config#getEndpointSnitch() endpointSnitch} attribute.
		 *
		 * @param endpointSnitch The value for endpointSnitch (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setEndpointSnitch(String endpointSnitch);


		/**
		 * Initializes the value for the {@link Config#getDynamicSnitchUpdateIntervalInMs()
		 * dynamicSnitchUpdateIntervalInMs} attribute.
		 *
		 * @param dynamicSnitchUpdateIntervalInMs The value for dynamicSnitchUpdateIntervalInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDynamicSnitchUpdateIntervalInMs(Long dynamicSnitchUpdateIntervalInMs);

		/**
		 * Initializes the value for the {@link Config#getDynamicSnitchResetIntervalInMs()
		 * dynamicSnitchResetIntervalInMs} attribute.
		 *
		 * @param dynamicSnitchResetIntervalInMs The value for dynamicSnitchResetIntervalInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDynamicSnitchResetIntervalInMs(Long dynamicSnitchResetIntervalInMs);

		/**
		 * Initializes the value for the {@link Config#getDynamicSnitchBadnessThreshold() dynamicSnitchBadnessThreshold}
		 * attribute.
		 *
		 * @param dynamicSnitchBadnessThreshold The value for dynamicSnitchBadnessThreshold (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDynamicSnitchBadnessThreshold(Double dynamicSnitchBadnessThreshold);

		/**
		 * Initializes the value for the {@link Config#getRequestScheduler() requestScheduler} attribute.
		 *
		 * @param requestScheduler The value for requestScheduler (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRequestScheduler(String requestScheduler);

		/**
		 * Initializes the value for the {@link Config#getRequestSchedulerId() requestSchedulerId} attribute.
		 *
		 * @param requestSchedulerId The value for requestSchedulerId (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRequestSchedulerId(RequestSchedulerId requestSchedulerId);

		/**
		 * Initializes the value for the {@link Config#getRequestSchedulerOptions() requestSchedulerOptions} attribute.
		 *
		 * @param requestSchedulerOptions The value for requestSchedulerOptions (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRequestSchedulerOptions(
				RequestSchedulerOptions requestSchedulerOptions);

		/**
		 * Initializes the value for the {@link Config#getServerEncryptionOptions() serverEncryptionOptions} attribute.
		 *
		 * @param serverEncryptionOptions The value for serverEncryptionOptions (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setServerEncryptionOptions(
				ServerEncryptionOptions serverEncryptionOptions);

		/**
		 * Initializes the value for the {@link Config#getClientEncryptionOptions() clientEncryptionOptions} attribute.
		 *
		 * @param clientEncryptionOptions The value for clientEncryptionOptions (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setClientEncryptionOptions(
				ClientEncryptionOptions clientEncryptionOptions);

		/**
		 * Initializes the value for the {@link Config#getInternodeCompression() internodeCompression} attribute.
		 *
		 * @param internodeCompression The value for internodeCompression (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInternodeCompression(InternodeCompression internodeCompression);

		/**
		 * Initializes the value for the {@link Config#getHintedHandoffThrottleInKb() hintedHandoffThrottleInKb}
		 * attribute.
		 *
		 * @param hintedHandoffThrottleInKb The value for hintedHandoffThrottleInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setHintedHandoffThrottleInKb(Integer hintedHandoffThrottleInKb);

		/**
		 * Initializes the value for the {@link Config#getBatchlogReplayThrottleInKb() batchlogReplayThrottleInKb}
		 * attribute.
		 *
		 * @param batchlogReplayThrottleInKb The value for batchlogReplayThrottleInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBatchlogReplayThrottleInKb(Integer batchlogReplayThrottleInKb);

		/**
		 * Initializes the value for the {@link Config#getMaxHintsDeliveryThreads() maxHintsDeliveryThreads} attribute.
		 *
		 * @param maxHintsDeliveryThreads The value for maxHintsDeliveryThreads (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMaxHintsDeliveryThreads(Integer maxHintsDeliveryThreads);

		/**
		 * Initializes the value for the {@link Config#getHintsFlushPeriodInMs() hintsFlushPeriodInMs} attribute.
		 *
		 * @param hintsFlushPeriodInMs The value for hintsFlushPeriodInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setHintsFlushPeriodInMs(Long hintsFlushPeriodInMs);

		/**
		 * Initializes the value for the {@link Config#getMaxHintsFileSizeInMb() maxHintsFileSizeInMb} attribute.
		 *
		 * @param maxHintsFileSizeInMb The value for maxHintsFileSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMaxHintsFileSizeInMb(Integer maxHintsFileSizeInMb);

		/**
		 * Initializes the value for the {@link Config#getHintsCompression() hintsCompression} attribute.
		 *
		 * @param hintsCompression The value for hintsCompression (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setHintsCompression(ParameterizedClass hintsCompression);

		/**
		 * Initializes the value for the {@link Config#getSstablePreemptiveOpenIntervalInMb()
		 * sstablePreemptiveOpenIntervalInMb} attribute.
		 *
		 * @param sstablePreemptiveOpenIntervalInMb The value for sstablePreemptiveOpenIntervalInMb (can be {@code
		 * null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setSstablePreemptiveOpenIntervalInMb(
				Integer sstablePreemptiveOpenIntervalInMb);

		/**
		 * Initializes the value for the {@link Config#getIncrementalBackups() incrementalBackups} attribute.
		 *
		 * @param incrementalBackups The value for incrementalBackups
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setIncrementalBackups(Boolean incrementalBackups);

		/**
		 * Initializes the value for the {@link Config#getTrickleFsync() trickleFsync} attribute.
		 *
		 * @param trickleFsync The value for trickleFsync
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTrickleFsync(Boolean trickleFsync);

		/**
		 * Initializes the value for the {@link Config#getTrickleFsyncIntervalInKb() trickleFsyncIntervalInKb}
		 * attribute.
		 *
		 * @param trickleFsyncIntervalInKb The value for trickleFsyncIntervalInKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTrickleFsyncIntervalInKb(Integer trickleFsyncIntervalInKb);

		/**
		 * Initializes the value for the {@link Config#getKeyCacheSizeInMb() keyCacheSizeInMb} attribute.
		 *
		 * @param keyCacheSizeInMb The value for keyCacheSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeyCacheSizeInMb(Integer keyCacheSizeInMb);

		/**
		 * Initializes the value for the {@link Config#getKeyCacheSavePeriod() keyCacheSavePeriod} attribute.
		 *
		 * @param keyCacheSavePeriod The value for keyCacheSavePeriod (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeyCacheSavePeriod(Long keyCacheSavePeriod);

		/**
		 * Initializes the value for the {@link Config#getKeyCacheKeysToSave() keyCacheKeysToSave} attribute.
		 *
		 * @param keyCacheKeysToSave The value for keyCacheKeysToSave (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeyCacheKeysToSave(Integer keyCacheKeysToSave);

		/**
		 * Initializes the value for the {@link Config#getRowCacheClassName() rowCacheClassName} attribute.
		 *
		 * @param rowCacheClassName The value for rowCacheClassName (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRowCacheClassName(String rowCacheClassName);

		/**
		 * Initializes the value for the {@link Config#getRowCacheSizeInMb() rowCacheSizeInMb} attribute.
		 *
		 * @param rowCacheSizeInMb The value for rowCacheSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRowCacheSizeInMb(Integer rowCacheSizeInMb);

		/**
		 * Initializes the value for the {@link Config#getRowCacheSavePeriod() rowCacheSavePeriod} attribute.
		 *
		 * @param rowCacheSavePeriod The value for rowCacheSavePeriod (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRowCacheSavePeriod(Long rowCacheSavePeriod);

		/**
		 * Initializes the value for the {@link Config#getRowCacheKeysToSave() rowCacheKeysToSave} attribute.
		 *
		 * @param rowCacheKeysToSave The value for rowCacheKeysToSave (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRowCacheKeysToSave(Integer rowCacheKeysToSave);

		/**
		 * Initializes the value for the {@link Config#getCounterCacheSizeInMb() counterCacheSizeInMb} attribute.
		 *
		 * @param counterCacheSizeInMb The value for counterCacheSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCounterCacheSizeInMb(Integer counterCacheSizeInMb);

		/**
		 * Initializes the value for the {@link Config#getCounterCacheSavePeriod() counterCacheSavePeriod} attribute.
		 *
		 * @param counterCacheSavePeriod The value for counterCacheSavePeriod (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCounterCacheSavePeriod(Long counterCacheSavePeriod);

		/**
		 * Initializes the value for the {@link Config#getCounterCacheKeysToSave() counterCacheKeysToSave} attribute.
		 *
		 * @param counterCacheKeysToSave The value for counterCacheKeysToSave (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCounterCacheKeysToSave(Integer counterCacheKeysToSave);

		/**
		 * Initializes the value for the {@link Config#getFileCacheSizeInMb() fileCacheSizeInMb} attribute.
		 *
		 * @param fileCacheSizeInMb The value for fileCacheSizeInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setFileCacheSizeInMb(Integer fileCacheSizeInMb);


		/**
		 * Initializes the value for the {@link Config#getBufferPoolUseHeapIfExhausted() bufferPoolUseHeapIfExhausted}
		 * attribute.
		 *
		 * @param bufferPoolUseHeapIfExhausted The value for bufferPoolUseHeapIfExhausted
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBufferPoolUseHeapIfExhausted(Boolean bufferPoolUseHeapIfExhausted);

		/**
		 * Initializes the value for the {@link Config#getDiskOptimizationStrategy() diskOptimizationStrategy}
		 * attribute.
		 *
		 * @param diskOptimizationStrategy The value for diskOptimizationStrategy (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDiskOptimizationStrategy(
				DiskOptimizationStrategy diskOptimizationStrategy);


		/**
		 * Initializes the value for the {@link Config#getInterDcTcpNodelay() interDcTcpNodelay} attribute.
		 *
		 * @param interDcTcpNodelay The value for interDcTcpNodelay
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setInterDcTcpNodelay(Boolean interDcTcpNodelay);

		/**
		 * Initializes the value for the {@link Config#getTombstoneWarnThreshold() tombstoneWarnThreshold} attribute.
		 *
		 * @param tombstoneWarnThreshold The value for tombstoneWarnThreshold (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTombstoneWarnThreshold(Integer tombstoneWarnThreshold);

		/**
		 * Initializes the value for the {@link Config#getTombstoneFailureThreshold() tombstoneFailureThreshold}
		 * attribute.
		 *
		 * @param tombstoneFailureThreshold The value for tombstoneFailureThreshold (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTombstoneFailureThreshold(Integer tombstoneFailureThreshold);

		/**
		 * Initializes the value for the {@link Config#getIndexSummaryCapacityInMb() indexSummaryCapacityInMb}
		 * attribute.
		 *
		 * @param indexSummaryCapacityInMb The value for indexSummaryCapacityInMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setIndexSummaryCapacityInMb(Integer indexSummaryCapacityInMb);

		/**
		 * Initializes the value for the {@link Config#getIndexSummaryResizeIntervalInMinutes()
		 * indexSummaryResizeIntervalInMinutes} attribute.
		 *
		 * @param indexSummaryResizeIntervalInMinutes The value for indexSummaryResizeIntervalInMinutes (can be {@code
		 * null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setIndexSummaryResizeIntervalInMinutes(
				Integer indexSummaryResizeIntervalInMinutes);

		/**
		 * Initializes the value for the {@link Config#getGcLogThresholdInMs() gcLogThresholdInMs} attribute.
		 *
		 * @param gcLogThresholdInMs The value for gcLogThresholdInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setGcLogThresholdInMs(Long gcLogThresholdInMs);

		/**
		 * Initializes the value for the {@link Config#getGcWarnThresholdInMs() gcWarnThresholdInMs} attribute.
		 *
		 * @param gcWarnThresholdInMs The value for gcWarnThresholdInMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setGcWarnThresholdInMs(Long gcWarnThresholdInMs);

		/**
		 * Initializes the value for the {@link Config#getMemtableAllocationType() memtableAllocationType} attribute.
		 *
		 * @param memtableAllocationType The value for memtableAllocationType (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setMemtableAllocationType(MemtableAllocationType memtableAllocationType);

		/**
		 * Initializes the value for the {@link Config#getTracetypeQueryTtl() tracetypeQueryTtl} attribute.
		 *
		 * @param tracetypeQueryTtl The value for tracetypeQueryTtl (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTracetypeQueryTtl(Long tracetypeQueryTtl);

		/**
		 * Initializes the value for the {@link Config#getTracetypeRepairTtl() tracetypeRepairTtl} attribute.
		 *
		 * @param tracetypeRepairTtl The value for tracetypeRepairTtl (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTracetypeRepairTtl(Long tracetypeRepairTtl);

		/**
		 * Initializes the value for the {@link Config#getOtcCoalescingStrategy() otcCoalescingStrategy} attribute.
		 *
		 * @param otcCoalescingStrategy The value for otcCoalescingStrategy (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setOtcCoalescingStrategy(String otcCoalescingStrategy);

		/**
		 * Initializes the value for the {@link Config#getOtcCoalescingWindowUs() otcCoalescingWindowUs} attribute.
		 *
		 * @param otcCoalescingWindowUs The value for otcCoalescingWindowUs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setOtcCoalescingWindowUs(Long otcCoalescingWindowUs);

		/**
		 * Initializes the value for the {@link Config#getOtcCoalescingEnoughCoalescedMessages()
		 * otcCoalescingEnoughCoalescedMessages} attribute.
		 *
		 * @param otcCoalescingEnoughCoalescedMessages The value for otcCoalescingEnoughCoalescedMessages (can be {@code
		 * null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setOtcCoalescingEnoughCoalescedMessages(
				Integer otcCoalescingEnoughCoalescedMessages);

		/**
		 * Initializes the value for the {@link Config#getOtcBacklogExpirationIntervalMs()
		 * otcBacklogExpirationIntervalMs} attribute.
		 *
		 * @param otcBacklogExpirationIntervalMs The value for otcBacklogExpirationIntervalMs (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setOtcBacklogExpirationIntervalMs(Long otcBacklogExpirationIntervalMs);

		/**
		 * Initializes the value for the {@link Config#getWindowsTimerInterval() windowsTimerInterval} attribute.
		 *
		 * @param windowsTimerInterval The value for windowsTimerInterval (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setWindowsTimerInterval(Integer windowsTimerInterval);

		/**
		 * Initializes the value for the {@link Config#getPreparedStatementsCacheSizeMb() preparedStatementsCacheSizeMb}
		 * attribute.
		 *
		 * @param preparedStatementsCacheSizeMb The value for preparedStatementsCacheSizeMb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setPreparedStatementsCacheSizeMb(Integer preparedStatementsCacheSizeMb);


		/**
		 * Initializes the value for the {@link Config#getEnableUserDefinedFunctions() enableUserDefinedFunctions}
		 * attribute.
		 *
		 * @param enableUserDefinedFunctions The value for enableUserDefinedFunctions
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setEnableUserDefinedFunctions(Boolean enableUserDefinedFunctions);

		/**
		 * Initializes the value for the {@link Config#getEnableScriptedUserDefinedFunctions()
		 * enableScriptedUserDefinedFunctions} attribute.
		 *
		 * @param enableScriptedUserDefinedFunctions The value for enableScriptedUserDefinedFunctions
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setEnableScriptedUserDefinedFunctions(
				Boolean enableScriptedUserDefinedFunctions);


		/**
		 * Initializes the value for the {@link Config#getBackPressureEnabled() backPressureEnabled} attribute.
		 *
		 * @param backPressureEnabled The value for backPressureEnabled
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBackPressureEnabled(Boolean backPressureEnabled);

		/**
		 * Initializes the value for the {@link Config#getBackPressureStrategy() backPressureStrategy} attribute.
		 *
		 * @param backPressureStrategy The value for backPressureStrategy (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setBackPressureStrategy(ParameterizedClass backPressureStrategy);

		/**
		 * Initializes the value for the {@link Config#getDiskAccessMode() diskAccessMode} attribute.
		 *
		 * @param diskAccessMode The value for diskAccessMode (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDiskAccessMode(DiskAccessMode diskAccessMode);

		/**
		 * Builds a new {@link Config Config}.
		 *
		 * @return An instance of Config
		 */
		Config build();

	}
}

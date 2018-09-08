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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Simple implementation of {@link Config.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ConfigBuilder implements Config.Builder {

	private String allocateTokensForKeyspace;

	private int jmxPort;

	private Long streamingSocketTimeoutInMs;

	private String clusterName;

	private String authenticator;

	private String authorizer;

	private String roleManager;

	private Long permissionsValidityInMs;

	private Integer permissionsCacheMaxEntries;

	private Long permissionsUpdateIntervalInMs;

	private Long rolesValidityInMs;

	private Integer rolesCacheMaxEntries;

	private Long rolesUpdateIntervalInMs;

	private Long credentialsValidityInMs;

	private Integer credentialsCacheMaxEntries;

	private Long credentialsUpdateIntervalInMs;

	private String partitioner;

	private Boolean autoBootstrap;

	private Boolean hintedHandoffEnabled;

	private List<String> hintedHandoffDisabledDatacenters = new ArrayList<>();

	private Long maxHintWindowInMs;

	private String hintsDirectory;

	private ParameterizedClass seedProvider;

	private DiskFailurePolicy diskFailurePolicy;

	private CommitFailurePolicy commitFailurePolicy;

	private String initialToken;

	private Integer numTokens;

	private String allocateTokensForLocalReplicationFactor;

	private Long requestTimeoutInMs;

	private Long readRequestTimeoutInMs;

	private Long rangeRequestTimeoutInMs;

	private Long writeRequestTimeoutInMs;

	private Long counterWriteRequestTimeoutInMs;

	private Long casContentionTimeoutInMs;

	private Long truncateRequestTimeoutInMs;

	private Long streamingKeepAlivePeriodInSecs;

	private Boolean crossNodeTimeout;

	private Long slowQueryLogTimeoutInMs;

	private Double phiConvictThreshold;

	private Integer concurrentReads;

	private Integer concurrentWrites;

	private Integer concurrentCounterWrites;

	private Integer concurrentMaterializedViewWrites;

	private Integer memtableFlushWriters;

	private Integer memtableHeapSpaceInMb;

	private Integer memtableOffheapSpaceInMb;

	private Double memtableCleanupThreshold;

	private int storagePort;

	private int sslStoragePort;

	private String listenAddress;

	private String listenInterface;

	private Boolean listenInterfacePreferIpv6;

	private String broadcastAddress;

	private Boolean listenOnBroadcastAddress;

	private String internodeAuthenticator;


	private String rpcAddress;

	private String rpcInterface;

	private Boolean rpcInterfacePreferIpv6;

	private String broadcastRpcAddress;


	private Boolean rpcKeepalive;


	private Integer internodeSendBuffSizeInBytes;

	private Integer internodeRecvBuffSizeInBytes;

	private Boolean startNativeTransport;

	private int nativeTransportPort;

	private Integer nativeTransportPortSsl;

	private Integer nativeTransportMaxThreads;

	private Integer nativeTransportMaxFrameSizeInMb;

	private Integer nativeTransportMaxConcurrentConnections;

	private Integer nativeTransportMaxConcurrentConnectionsPerIp;

	private Integer maxValueSizeInMb;


	private Boolean snapshotBeforeCompaction;

	private Boolean autoSnapshot;

	private Integer columnIndexSizeInKb;

	private Integer columnIndexCacheSizeInKb;

	private Integer batchSizeWarnThresholdInKb;

	private Integer batchSizeFailThresholdInKb;

	private Integer unloggedBatchAcrossPartitionsWarnThreshold;

	private Integer concurrentCompactors;

	private Integer compactionThroughputMbPerSec;

	private Integer compactionLargePartitionWarningThresholdMb;


	private Integer streamThroughputOutboundMegabitsPerSec;

	private Integer interDcStreamThroughputOutboundMegabitsPerSec;

	private List<String> dataFileDirectories = new ArrayList<>();

	private String savedCachesDirectory;

	private String commitlogDirectory;

	private Integer commitlogTotalSpaceInMb;

	private CommitLogSync commitlogSync;

	private Double commitlogSyncBatchWindowInMs;

	private Long commitlogSyncPeriodInMs;

	private Long commitlogSegmentSizeInMb;

	private ParameterizedClass commitlogCompression;


	private TransparentDataEncryptionOptions transparentDataEncryptionOptions;

	private Integer maxMutationSizeInKb;

	private Boolean cdcEnabled;

	private String cdcRawDirectory;

	private Integer cdcTotalSpaceInMb;

	private Long cdcFreeSpaceCheckIntervalMs;

	private String endpointSnitch;


	private Long dynamicSnitchUpdateIntervalInMs;

	private Long dynamicSnitchResetIntervalInMs;

	private Double dynamicSnitchBadnessThreshold;

	private String requestScheduler;

	private RequestSchedulerId requestSchedulerId;

	private RequestSchedulerOptions requestSchedulerOptions;

	private ServerEncryptionOptions serverEncryptionOptions;

	private ClientEncryptionOptions clientEncryptionOptions;

	private InternodeCompression internodeCompression;

	private Integer hintedHandoffThrottleInKb;

	private Integer batchlogReplayThrottleInKb;

	private Integer maxHintsDeliveryThreads;

	private Long hintsFlushPeriodInMs;

	private Integer maxHintsFileSizeInMb;

	private ParameterizedClass hintsCompression;

	private Integer sstablePreemptiveOpenIntervalInMb;

	private Boolean incrementalBackups;

	private Boolean trickleFsync;

	private Integer trickleFsyncIntervalInKb;

	private Integer keyCacheSizeInMb;

	private Long keyCacheSavePeriod;

	private Integer keyCacheKeysToSave;

	private String rowCacheClassName;

	private Integer rowCacheSizeInMb;

	private Long rowCacheSavePeriod;

	private Integer rowCacheKeysToSave;

	private Integer counterCacheSizeInMb;

	private Long counterCacheSavePeriod;

	private Integer counterCacheKeysToSave;

	private Integer fileCacheSizeInMb;


	private Boolean bufferPoolUseHeapIfExhausted;

	private DiskOptimizationStrategy diskOptimizationStrategy;


	private Boolean interDcTcpNodelay;

	private Integer tombstoneWarnThreshold;

	private Integer tombstoneFailureThreshold;

	private Integer indexSummaryCapacityInMb;

	private Integer indexSummaryResizeIntervalInMinutes;

	private Long gcLogThresholdInMs;

	private Long gcWarnThresholdInMs;

	private MemtableAllocationType memtableAllocationType;

	private Long tracetypeQueryTtl;

	private Long tracetypeRepairTtl;

	private String otcCoalescingStrategy;

	private Long otcCoalescingWindowUs;

	private Integer otcCoalescingEnoughCoalescedMessages;

	private Long otcBacklogExpirationIntervalMs;

	private Integer windowsTimerInterval;

	private Integer preparedStatementsCacheSizeMb;


	private Boolean enableUserDefinedFunctions;

	private Boolean enableScriptedUserDefinedFunctions;


	private Boolean backPressureEnabled;

	private ParameterizedClass backPressureStrategy;

	private DiskAccessMode diskAccessMode;


	@Override
	public Config.Builder setJmxPort(int jmxPort) {
		this.jmxPort = jmxPort;
		return this;
	}


	@Override
	public Config.Builder setStreamingSocketTimeoutInMs(Long streamingSocketTimeoutInMs) {
		this.streamingSocketTimeoutInMs = streamingSocketTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setClusterName(String clusterName) {
		this.clusterName = clusterName;
		return this;
	}

	@Override
	public Config.Builder setAuthenticator(String authenticator) {
		this.authenticator = authenticator;
		return this;
	}

	@Override
	public Config.Builder setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
		return this;
	}

	@Override
	public Config.Builder setRoleManager(String roleManager) {
		this.roleManager = roleManager;
		return this;
	}

	@Override
	public Config.Builder setPermissionsValidityInMs(Long permissionsValidityInMs) {
		this.permissionsValidityInMs = permissionsValidityInMs;
		return this;
	}

	@Override
	public Config.Builder setPermissionsCacheMaxEntries(
			Integer permissionsCacheMaxEntries) {
		this.permissionsCacheMaxEntries = permissionsCacheMaxEntries;
		return this;
	}

	@Override
	public Config.Builder setPermissionsUpdateIntervalInMs(
			Long permissionsUpdateIntervalInMs) {
		this.permissionsUpdateIntervalInMs = permissionsUpdateIntervalInMs;
		return this;
	}

	@Override
	public Config.Builder setRolesValidityInMs(Long rolesValidityInMs) {
		this.rolesValidityInMs = rolesValidityInMs;
		return this;
	}

	@Override
	public Config.Builder setRolesCacheMaxEntries(Integer rolesCacheMaxEntries) {
		this.rolesCacheMaxEntries = rolesCacheMaxEntries;
		return this;
	}

	@Override
	public Config.Builder setRolesUpdateIntervalInMs(Long rolesUpdateIntervalInMs) {
		this.rolesUpdateIntervalInMs = rolesUpdateIntervalInMs;
		return this;
	}

	@Override
	public Config.Builder setCredentialsValidityInMs(Long credentialsValidityInMs) {
		this.credentialsValidityInMs = credentialsValidityInMs;
		return this;
	}

	@Override
	public Config.Builder setCredentialsCacheMaxEntries(
			Integer credentialsCacheMaxEntries) {
		this.credentialsCacheMaxEntries = credentialsCacheMaxEntries;
		return this;
	}

	@Override
	public Config.Builder setCredentialsUpdateIntervalInMs(
			Long credentialsUpdateIntervalInMs) {
		this.credentialsUpdateIntervalInMs = credentialsUpdateIntervalInMs;
		return this;
	}

	@Override
	public Config.Builder setPartitioner(String partitioner) {
		this.partitioner = partitioner;
		return this;
	}

	@Override
	public Config.Builder setAutoBootstrap(Boolean autoBootstrap) {
		this.autoBootstrap = autoBootstrap;
		return this;
	}

	@Override
	public Config.Builder setHintedHandoffEnabled(Boolean hintedHandoffEnabled) {
		this.hintedHandoffEnabled = hintedHandoffEnabled;
		return this;
	}

	@Override
	public Config.Builder addHintedHandoffDisabledDatacenters(String element) {
		this.hintedHandoffDisabledDatacenters.add(element);
		return this;
	}

	@Override
	public Config.Builder addHintedHandoffDisabledDatacenters(String... elements) {
		addHintedHandoffDisabledDatacenters(Arrays.asList(elements));
		return this;
	}


	@Override
	public Config.Builder setHintedHandoffDisabledDatacenters(Iterable<String> elements) {
		this.hintedHandoffDisabledDatacenters.clear();
		return addHintedHandoffDisabledDatacenters(elements);
	}

	@Override
	public Config.Builder addHintedHandoffDisabledDatacenters(Iterable<String> elements) {
		for (String element : elements) {
			this.hintedHandoffDisabledDatacenters.add(element);
		}
		return this;
	}

	@Override
	public Config.Builder setMaxHintWindowInMs(Long maxHintWindowInMs) {
		this.maxHintWindowInMs = maxHintWindowInMs;
		return this;
	}

	@Override
	public Config.Builder setHintsDirectory(String hintsDirectory) {
		this.hintsDirectory = hintsDirectory;
		return this;
	}

	@Override
	public Config.Builder setSeedProvider(ParameterizedClass seedProvider) {
		this.seedProvider = seedProvider;
		return this;
	}

	@Override
	public Config.Builder setDiskFailurePolicy(DiskFailurePolicy diskFailurePolicy) {
		this.diskFailurePolicy = diskFailurePolicy;
		return this;
	}

	@Override
	public Config.Builder setCommitFailurePolicy(
			CommitFailurePolicy commitFailurePolicy) {
		this.commitFailurePolicy = commitFailurePolicy;
		return this;
	}

	@Override
	public Config.Builder setInitialToken(String initialToken) {
		this.initialToken = initialToken;
		return this;
	}

	@Override
	public Config.Builder setNumTokens(Integer numTokens) {
		this.numTokens = numTokens;
		return this;
	}

	@Override
	public Config.Builder setAllocateTokensForLocalReplicationFactor(
			String allocateTokensForKeyspace) {
		this.allocateTokensForLocalReplicationFactor = allocateTokensForKeyspace;
		return this;
	}

	@Override
	public Config.Builder setAllocateTokensForKeyspace(String allocateTokensForKeyspace) {
		this.allocateTokensForKeyspace = allocateTokensForKeyspace;
		return this;
	}

	@Override
	public Config.Builder setRequestTimeoutInMs(Long requestTimeoutInMs) {
		this.requestTimeoutInMs = requestTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setReadRequestTimeoutInMs(Long readRequestTimeoutInMs) {
		this.readRequestTimeoutInMs = readRequestTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setRangeRequestTimeoutInMs(Long rangeRequestTimeoutInMs) {
		this.rangeRequestTimeoutInMs = rangeRequestTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setWriteRequestTimeoutInMs(Long writeRequestTimeoutInMs) {
		this.writeRequestTimeoutInMs = writeRequestTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setCounterWriteRequestTimeoutInMs(
			Long counterWriteRequestTimeoutInMs) {
		this.counterWriteRequestTimeoutInMs = counterWriteRequestTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setCasContentionTimeoutInMs(Long casContentionTimeoutInMs) {
		this.casContentionTimeoutInMs = casContentionTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setTruncateRequestTimeoutInMs(Long truncateRequestTimeoutInMs) {
		this.truncateRequestTimeoutInMs = truncateRequestTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setStreamingKeepAlivePeriodInSecs(
			Long streamingKeepAlivePeriodInSecs) {
		this.streamingKeepAlivePeriodInSecs = streamingKeepAlivePeriodInSecs;
		return this;
	}

	@Override
	public Config.Builder setCrossNodeTimeout(Boolean crossNodeTimeout) {
		this.crossNodeTimeout = crossNodeTimeout;
		return this;
	}

	@Override
	public Config.Builder setSlowQueryLogTimeoutInMs(Long slowQueryLogTimeoutInMs) {
		this.slowQueryLogTimeoutInMs = slowQueryLogTimeoutInMs;
		return this;
	}

	@Override
	public Config.Builder setPhiConvictThreshold(Double phiConvictThreshold) {
		this.phiConvictThreshold = phiConvictThreshold;
		return this;
	}

	@Override
	public Config.Builder setConcurrentReads(Integer concurrentReads) {
		this.concurrentReads = concurrentReads;
		return this;
	}

	@Override
	public Config.Builder setConcurrentWrites(Integer concurrentWrites) {
		this.concurrentWrites = concurrentWrites;
		return this;
	}

	@Override
	public Config.Builder setConcurrentCounterWrites(Integer concurrentCounterWrites) {
		this.concurrentCounterWrites = concurrentCounterWrites;
		return this;
	}

	@Override
	public Config.Builder setConcurrentMaterializedViewWrites(
			Integer concurrentMaterializedViewWrites) {
		this.concurrentMaterializedViewWrites = concurrentMaterializedViewWrites;
		return this;
	}

	@Override
	public Config.Builder setMemtableFlushWriters(Integer memtableFlushWriters) {
		this.memtableFlushWriters = memtableFlushWriters;
		return this;
	}

	@Override
	public Config.Builder setMemtableHeapSpaceInMb(Integer memtableHeapSpaceInMb) {
		this.memtableHeapSpaceInMb = memtableHeapSpaceInMb;
		return this;
	}

	@Override
	public Config.Builder setMemtableOffheapSpaceInMb(Integer memtableOffheapSpaceInMb) {
		this.memtableOffheapSpaceInMb = memtableOffheapSpaceInMb;
		return this;
	}


	@Override
	public Config.Builder setMemtableCleanupThreshold(Double memtableCleanupThreshold) {
		this.memtableCleanupThreshold = memtableCleanupThreshold;
		return this;
	}

	@Override
	public Config.Builder setStoragePort(int storagePort) {
		this.storagePort = storagePort;
		return this;
	}

	@Override
	public Config.Builder setSslStoragePort(int sslStoragePort) {
		this.sslStoragePort = sslStoragePort;
		return this;
	}

	@Override
	public Config.Builder setListenAddress(String listenAddress) {
		this.listenAddress = listenAddress;
		return this;
	}

	@Override
	public Config.Builder setListenInterface(String listenInterface) {
		this.listenInterface = listenInterface;
		return this;
	}

	@Override
	public Config.Builder setListenInterfacePreferIpv6(
			Boolean listenInterfacePreferIpv6) {
		this.listenInterfacePreferIpv6 = listenInterfacePreferIpv6;
		return this;
	}

	@Override
	public Config.Builder setBroadcastAddress(String broadcastAddress) {
		this.broadcastAddress = broadcastAddress;
		return this;
	}

	@Override
	public Config.Builder setListenOnBroadcastAddress(Boolean listenOnBroadcastAddress) {
		this.listenOnBroadcastAddress = listenOnBroadcastAddress;
		return this;
	}

	@Override
	public Config.Builder setInternodeAuthenticator(String internodeAuthenticator) {
		this.internodeAuthenticator = internodeAuthenticator;
		return this;
	}


	@Override
	public Config.Builder setRpcAddress(String rpcAddress) {
		this.rpcAddress = rpcAddress;
		return this;
	}

	@Override
	public Config.Builder setRpcInterface(String rpcInterface) {
		this.rpcInterface = rpcInterface;
		return this;
	}

	@Override
	public Config.Builder setRpcInterfacePreferIpv6(Boolean rpcInterfacePreferIpv6) {
		this.rpcInterfacePreferIpv6 = rpcInterfacePreferIpv6;
		return this;
	}

	@Override
	public Config.Builder setBroadcastRpcAddress(String broadcastRpcAddress) {
		this.broadcastRpcAddress = broadcastRpcAddress;
		return this;
	}


	@Override
	public Config.Builder setRpcKeepalive(Boolean rpcKeepalive) {
		this.rpcKeepalive = rpcKeepalive;
		return this;
	}


	@Override
	public Config.Builder setInternodeSendBuffSizeInBytes(
			Integer internodeSendBuffSizeInBytes) {
		this.internodeSendBuffSizeInBytes = internodeSendBuffSizeInBytes;
		return this;
	}

	@Override
	public Config.Builder setInternodeRecvBuffSizeInBytes(
			Integer internodeRecvBuffSizeInBytes) {
		this.internodeRecvBuffSizeInBytes = internodeRecvBuffSizeInBytes;
		return this;
	}

	@Override
	public Config.Builder setStartNativeTransport(Boolean startNativeTransport) {
		this.startNativeTransport = startNativeTransport;
		return this;
	}

	@Override
	public Config.Builder setNativeTransportPort(int nativeTransportPort) {
		this.nativeTransportPort = nativeTransportPort;
		return this;
	}

	@Override
	public Config.Builder setNativeTransportPortSsl(Integer nativeTransportPortSsl) {
		this.nativeTransportPortSsl = nativeTransportPortSsl;
		return this;
	}

	@Override
	public Config.Builder setNativeTransportMaxThreads(
			Integer nativeTransportMaxThreads) {
		this.nativeTransportMaxThreads = nativeTransportMaxThreads;
		return this;
	}

	@Override
	public Config.Builder setNativeTransportMaxFrameSizeInMb(
			Integer nativeTransportMaxFrameSizeInMb) {
		this.nativeTransportMaxFrameSizeInMb = nativeTransportMaxFrameSizeInMb;
		return this;
	}

	@Override
	public Config.Builder setNativeTransportMaxConcurrentConnections(
			Integer nativeTransportMaxConcurrentConnections) {
		this.nativeTransportMaxConcurrentConnections = nativeTransportMaxConcurrentConnections;
		return this;
	}

	@Override
	public Config.Builder setNativeTransportMaxConcurrentConnectionsPerIp(
			Integer nativeTransportMaxConcurrentConnectionsPerIp) {
		this.nativeTransportMaxConcurrentConnectionsPerIp = nativeTransportMaxConcurrentConnectionsPerIp;
		return this;
	}

	@Override
	public Config.Builder setMaxValueSizeInMb(Integer maxValueSizeInMb) {
		this.maxValueSizeInMb = maxValueSizeInMb;
		return this;
	}


	@Override
	public Config.Builder setSnapshotBeforeCompaction(Boolean snapshotBeforeCompaction) {
		this.snapshotBeforeCompaction = snapshotBeforeCompaction;
		return this;
	}

	@Override
	public Config.Builder setAutoSnapshot(Boolean autoSnapshot) {
		this.autoSnapshot = autoSnapshot;
		return this;
	}

	@Override
	public Config.Builder setColumnIndexSizeInKb(Integer columnIndexSizeInKb) {
		this.columnIndexSizeInKb = columnIndexSizeInKb;
		return this;
	}

	@Override
	public Config.Builder setColumnIndexCacheSizeInKb(Integer columnIndexCacheSizeInKb) {
		this.columnIndexCacheSizeInKb = columnIndexCacheSizeInKb;
		return this;
	}

	@Override
	public Config.Builder setBatchSizeWarnThresholdInKb(
			Integer batchSizeWarnThresholdInKb) {
		this.batchSizeWarnThresholdInKb = batchSizeWarnThresholdInKb;
		return this;
	}

	@Override
	public Config.Builder setBatchSizeFailThresholdInKb(
			Integer batchSizeFailThresholdInKb) {
		this.batchSizeFailThresholdInKb = batchSizeFailThresholdInKb;
		return this;
	}

	@Override
	public Config.Builder setUnloggedBatchAcrossPartitionsWarnThreshold(
			Integer unloggedBatchAcrossPartitionsWarnThreshold) {
		this.unloggedBatchAcrossPartitionsWarnThreshold = unloggedBatchAcrossPartitionsWarnThreshold;
		return this;
	}

	@Override
	public Config.Builder setConcurrentCompactors(Integer concurrentCompactors) {
		this.concurrentCompactors = concurrentCompactors;
		return this;
	}

	@Override
	public Config.Builder setCompactionThroughputMbPerSec(
			Integer compactionThroughputMbPerSec) {
		this.compactionThroughputMbPerSec = compactionThroughputMbPerSec;
		return this;
	}

	@Override
	public Config.Builder setCompactionLargePartitionWarningThresholdMb(
			Integer compactionLargePartitionWarningThresholdMb) {
		this.compactionLargePartitionWarningThresholdMb = compactionLargePartitionWarningThresholdMb;
		return this;
	}


	@Override
	public Config.Builder setStreamThroughputOutboundMegabitsPerSec(
			Integer streamThroughputOutboundMegabitsPerSec) {
		this.streamThroughputOutboundMegabitsPerSec = streamThroughputOutboundMegabitsPerSec;
		return this;
	}

	@Override
	public Config.Builder setInterDcStreamThroughputOutboundMegabitsPerSec(
			Integer interDcStreamThroughputOutboundMegabitsPerSec) {
		this.interDcStreamThroughputOutboundMegabitsPerSec = interDcStreamThroughputOutboundMegabitsPerSec;
		return this;
	}

	@Override
	public Config.Builder addDataFileDirectories(String element) {
		this.dataFileDirectories.add(element);
		return this;
	}

	@Override
	public Config.Builder addDataFileDirectories(String... elements) {
		addDataFileDirectories(Arrays.asList(elements));
		return this;
	}


	@Override
	public Config.Builder setDataFileDirectories(Iterable<String> elements) {
		this.dataFileDirectories.clear();
		return addDataFileDirectories(elements);
	}

	@Override
	public Config.Builder addDataFileDirectories(Iterable<String> elements) {
		for (String element : elements) {
			this.dataFileDirectories.add(element);
		}
		return this;
	}

	@Override
	public Config.Builder setSavedCachesDirectory(String savedCachesDirectory) {
		this.savedCachesDirectory = savedCachesDirectory;
		return this;
	}

	@Override
	public Config.Builder setCommitlogDirectory(String commitlogDirectory) {
		this.commitlogDirectory = commitlogDirectory;
		return this;
	}

	@Override
	public Config.Builder setCommitlogTotalSpaceInMb(Integer commitlogTotalSpaceInMb) {
		this.commitlogTotalSpaceInMb = commitlogTotalSpaceInMb;
		return this;
	}

	@Override
	public Config.Builder setCommitlogSync(CommitLogSync commitlogSync) {
		this.commitlogSync = commitlogSync;
		return this;
	}

	@Override
	public Config.Builder setCommitlogSyncBatchWindowInMs(
			Double commitlogSyncBatchWindowInMs) {
		this.commitlogSyncBatchWindowInMs = commitlogSyncBatchWindowInMs;
		return this;
	}

	@Override
	public Config.Builder setCommitlogSyncPeriodInMs(Long commitlogSyncPeriodInMs) {
		this.commitlogSyncPeriodInMs = commitlogSyncPeriodInMs;
		return this;
	}

	@Override
	public Config.Builder setCommitlogSegmentSizeInMb(Long commitlogSegmentSizeInMb) {
		this.commitlogSegmentSizeInMb = commitlogSegmentSizeInMb;
		return this;
	}

	@Override
	public Config.Builder setCommitlogCompression(
			ParameterizedClass commitlogCompression) {
		this.commitlogCompression = commitlogCompression;
		return this;
	}


	@Override
	public Config.Builder setTransparentDataEncryptionOptions(
			TransparentDataEncryptionOptions transparentDataEncryptionOptions) {
		this.transparentDataEncryptionOptions = transparentDataEncryptionOptions;
		return this;
	}

	@Override
	public Config.Builder setMaxMutationSizeInKb(Integer maxMutationSizeInKb) {
		this.maxMutationSizeInKb = maxMutationSizeInKb;
		return this;
	}

	@Override
	public Config.Builder setCdcEnabled(Boolean cdcEnabled) {
		this.cdcEnabled = cdcEnabled;
		return this;
	}

	@Override
	public Config.Builder setCdcRawDirectory(String cdcRawDirectory) {
		this.cdcRawDirectory = cdcRawDirectory;
		return this;
	}

	@Override
	public Config.Builder setCdcTotalSpaceInMb(Integer cdcTotalSpaceInMb) {
		this.cdcTotalSpaceInMb = cdcTotalSpaceInMb;
		return this;
	}

	@Override
	public Config.Builder setCdcFreeSpaceCheckIntervalMs(
			Long cdcFreeSpaceCheckIntervalMs) {
		this.cdcFreeSpaceCheckIntervalMs = cdcFreeSpaceCheckIntervalMs;
		return this;
	}

	@Override
	public Config.Builder setEndpointSnitch(String endpointSnitch) {
		this.endpointSnitch = endpointSnitch;
		return this;
	}


	@Override
	public Config.Builder setDynamicSnitchUpdateIntervalInMs(
			Long dynamicSnitchUpdateIntervalInMs) {
		this.dynamicSnitchUpdateIntervalInMs = dynamicSnitchUpdateIntervalInMs;
		return this;
	}

	@Override
	public Config.Builder setDynamicSnitchResetIntervalInMs(
			Long dynamicSnitchResetIntervalInMs) {
		this.dynamicSnitchResetIntervalInMs = dynamicSnitchResetIntervalInMs;
		return this;
	}

	@Override
	public Config.Builder setDynamicSnitchBadnessThreshold(
			Double dynamicSnitchBadnessThreshold) {
		this.dynamicSnitchBadnessThreshold = dynamicSnitchBadnessThreshold;
		return this;
	}

	@Override
	public Config.Builder setRequestScheduler(String requestScheduler) {
		this.requestScheduler = requestScheduler;
		return this;
	}

	@Override
	public Config.Builder setRequestSchedulerId(RequestSchedulerId requestSchedulerId) {
		this.requestSchedulerId = requestSchedulerId;
		return this;
	}

	@Override
	public Config.Builder setRequestSchedulerOptions(
			RequestSchedulerOptions requestSchedulerOptions) {
		this.requestSchedulerOptions = requestSchedulerOptions;
		return this;
	}

	@Override
	public Config.Builder setServerEncryptionOptions(
			ServerEncryptionOptions serverEncryptionOptions) {
		this.serverEncryptionOptions = serverEncryptionOptions;
		return this;
	}

	@Override
	public Config.Builder setClientEncryptionOptions(
			ClientEncryptionOptions clientEncryptionOptions) {
		this.clientEncryptionOptions = clientEncryptionOptions;
		return this;
	}

	@Override
	public Config.Builder setInternodeCompression(
			InternodeCompression internodeCompression) {
		this.internodeCompression = internodeCompression;
		return this;
	}

	@Override
	public Config.Builder setHintedHandoffThrottleInKb(
			Integer hintedHandoffThrottleInKb) {
		this.hintedHandoffThrottleInKb = hintedHandoffThrottleInKb;
		return this;
	}

	@Override
	public Config.Builder setBatchlogReplayThrottleInKb(
			Integer batchlogReplayThrottleInKb) {
		this.batchlogReplayThrottleInKb = batchlogReplayThrottleInKb;
		return this;
	}

	@Override
	public Config.Builder setMaxHintsDeliveryThreads(Integer maxHintsDeliveryThreads) {
		this.maxHintsDeliveryThreads = maxHintsDeliveryThreads;
		return this;
	}

	@Override
	public Config.Builder setHintsFlushPeriodInMs(Long hintsFlushPeriodInMs) {
		this.hintsFlushPeriodInMs = hintsFlushPeriodInMs;
		return this;
	}

	@Override
	public Config.Builder setMaxHintsFileSizeInMb(Integer maxHintsFileSizeInMb) {
		this.maxHintsFileSizeInMb = maxHintsFileSizeInMb;
		return this;
	}

	@Override
	public Config.Builder setHintsCompression(ParameterizedClass hintsCompression) {
		this.hintsCompression = hintsCompression;
		return this;
	}

	@Override
	public Config.Builder setSstablePreemptiveOpenIntervalInMb(
			Integer sstablePreemptiveOpenIntervalInMb) {
		this.sstablePreemptiveOpenIntervalInMb = sstablePreemptiveOpenIntervalInMb;
		return this;
	}

	@Override
	public Config.Builder setIncrementalBackups(Boolean incrementalBackups) {
		this.incrementalBackups = incrementalBackups;
		return this;
	}

	@Override
	public Config.Builder setTrickleFsync(Boolean trickleFsync) {
		this.trickleFsync = trickleFsync;
		return this;
	}

	@Override
	public Config.Builder setTrickleFsyncIntervalInKb(Integer trickleFsyncIntervalInKb) {
		this.trickleFsyncIntervalInKb = trickleFsyncIntervalInKb;
		return this;
	}

	@Override
	public Config.Builder setKeyCacheSizeInMb(Integer keyCacheSizeInMb) {
		this.keyCacheSizeInMb = keyCacheSizeInMb;
		return this;
	}

	@Override
	public Config.Builder setKeyCacheSavePeriod(Long keyCacheSavePeriod) {
		this.keyCacheSavePeriod = keyCacheSavePeriod;
		return this;
	}

	@Override
	public Config.Builder setKeyCacheKeysToSave(Integer keyCacheKeysToSave) {
		this.keyCacheKeysToSave = keyCacheKeysToSave;
		return this;
	}

	@Override
	public Config.Builder setRowCacheClassName(String rowCacheClassName) {
		this.rowCacheClassName = rowCacheClassName;
		return this;
	}

	@Override
	public Config.Builder setRowCacheSizeInMb(Integer rowCacheSizeInMb) {
		this.rowCacheSizeInMb = rowCacheSizeInMb;
		return this;
	}

	@Override
	public Config.Builder setRowCacheSavePeriod(Long rowCacheSavePeriod) {
		this.rowCacheSavePeriod = rowCacheSavePeriod;
		return this;
	}

	@Override
	public Config.Builder setRowCacheKeysToSave(Integer rowCacheKeysToSave) {
		this.rowCacheKeysToSave = rowCacheKeysToSave;
		return this;
	}

	@Override
	public Config.Builder setCounterCacheSizeInMb(Integer counterCacheSizeInMb) {
		this.counterCacheSizeInMb = counterCacheSizeInMb;
		return this;
	}

	@Override
	public Config.Builder setCounterCacheSavePeriod(Long counterCacheSavePeriod) {
		this.counterCacheSavePeriod = counterCacheSavePeriod;
		return this;
	}

	@Override
	public Config.Builder setCounterCacheKeysToSave(Integer counterCacheKeysToSave) {
		this.counterCacheKeysToSave = counterCacheKeysToSave;
		return this;
	}

	@Override
	public Config.Builder setFileCacheSizeInMb(Integer fileCacheSizeInMb) {
		this.fileCacheSizeInMb = fileCacheSizeInMb;
		return this;
	}


	@Override
	public Config.Builder setBufferPoolUseHeapIfExhausted(
			Boolean bufferPoolUseHeapIfExhausted) {
		this.bufferPoolUseHeapIfExhausted = bufferPoolUseHeapIfExhausted;
		return this;
	}

	@Override
	public Config.Builder setDiskOptimizationStrategy(
			DiskOptimizationStrategy diskOptimizationStrategy) {
		this.diskOptimizationStrategy = diskOptimizationStrategy;
		return this;
	}


	@Override
	public Config.Builder setInterDcTcpNodelay(Boolean interDcTcpNodelay) {
		this.interDcTcpNodelay = interDcTcpNodelay;
		return this;
	}

	@Override
	public Config.Builder setTombstoneWarnThreshold(Integer tombstoneWarnThreshold) {
		this.tombstoneWarnThreshold = tombstoneWarnThreshold;
		return this;
	}

	@Override
	public Config.Builder setTombstoneFailureThreshold(
			Integer tombstoneFailureThreshold) {
		this.tombstoneFailureThreshold = tombstoneFailureThreshold;
		return this;
	}

	@Override
	public Config.Builder setIndexSummaryCapacityInMb(Integer indexSummaryCapacityInMb) {
		this.indexSummaryCapacityInMb = indexSummaryCapacityInMb;
		return this;
	}

	@Override
	public Config.Builder setIndexSummaryResizeIntervalInMinutes(
			Integer indexSummaryResizeIntervalInMinutes) {
		this.indexSummaryResizeIntervalInMinutes = indexSummaryResizeIntervalInMinutes;
		return this;
	}

	@Override
	public Config.Builder setGcLogThresholdInMs(Long gcLogThresholdInMs) {
		this.gcLogThresholdInMs = gcLogThresholdInMs;
		return this;
	}

	@Override
	public Config.Builder setGcWarnThresholdInMs(Long gcWarnThresholdInMs) {
		this.gcWarnThresholdInMs = gcWarnThresholdInMs;
		return this;
	}

	@Override
	public Config.Builder setMemtableAllocationType(
			MemtableAllocationType memtableAllocationType) {
		this.memtableAllocationType = memtableAllocationType;
		return this;
	}

	@Override
	public Config.Builder setTracetypeQueryTtl(Long tracetypeQueryTtl) {
		this.tracetypeQueryTtl = tracetypeQueryTtl;
		return this;
	}

	@Override
	public Config.Builder setTracetypeRepairTtl(Long tracetypeRepairTtl) {
		this.tracetypeRepairTtl = tracetypeRepairTtl;
		return this;
	}

	@Override
	public Config.Builder setOtcCoalescingStrategy(String otcCoalescingStrategy) {
		this.otcCoalescingStrategy = otcCoalescingStrategy;
		return this;
	}

	@Override
	public Config.Builder setOtcCoalescingWindowUs(Long otcCoalescingWindowUs) {
		this.otcCoalescingWindowUs = otcCoalescingWindowUs;
		return this;
	}

	@Override
	public Config.Builder setOtcCoalescingEnoughCoalescedMessages(
			Integer otcCoalescingEnoughCoalescedMessages) {
		this.otcCoalescingEnoughCoalescedMessages = otcCoalescingEnoughCoalescedMessages;
		return this;
	}

	@Override
	public Config.Builder setOtcBacklogExpirationIntervalMs(
			Long otcBacklogExpirationIntervalMs) {
		this.otcBacklogExpirationIntervalMs = otcBacklogExpirationIntervalMs;
		return this;
	}

	@Override
	public Config.Builder setWindowsTimerInterval(Integer windowsTimerInterval) {
		this.windowsTimerInterval = windowsTimerInterval;
		return this;
	}

	@Override
	public Config.Builder setPreparedStatementsCacheSizeMb(
			Integer preparedStatementsCacheSizeMb) {
		this.preparedStatementsCacheSizeMb = preparedStatementsCacheSizeMb;
		return this;
	}


	@Override
	public Config.Builder setEnableUserDefinedFunctions(
			Boolean enableUserDefinedFunctions) {
		this.enableUserDefinedFunctions = enableUserDefinedFunctions;
		return this;
	}

	@Override
	public Config.Builder setEnableScriptedUserDefinedFunctions(
			Boolean enableScriptedUserDefinedFunctions) {
		this.enableScriptedUserDefinedFunctions = enableScriptedUserDefinedFunctions;
		return this;
	}


	@Override
	public Config.Builder setBackPressureEnabled(Boolean backPressureEnabled) {
		this.backPressureEnabled = backPressureEnabled;
		return this;
	}

	@Override
	public Config.Builder setBackPressureStrategy(
			ParameterizedClass backPressureStrategy) {
		this.backPressureStrategy = backPressureStrategy;
		return this;
	}

	@Override
	public Config.Builder setDiskAccessMode(DiskAccessMode diskAccessMode) {
		this.diskAccessMode = diskAccessMode;
		return this;
	}

	@Override
	public Config build() {
		return new ImmutableConfig(this);
	}


	/**
	 * Immutable implementation of {@link Config}.
	 */
	static final class ImmutableConfig implements Config {
		private final int jmxPort;


		private final Long streamingSocketTimeoutInMs;

		private final String clusterName;

		private final String authenticator;

		private final String authorizer;

		private final String roleManager;

		private final Long permissionsValidityInMs;

		private final Integer permissionsCacheMaxEntries;

		private final Long permissionsUpdateIntervalInMs;

		private final Long rolesValidityInMs;

		private final Integer rolesCacheMaxEntries;

		private final Long rolesUpdateIntervalInMs;

		private final Long credentialsValidityInMs;

		private final Integer credentialsCacheMaxEntries;

		private final Long credentialsUpdateIntervalInMs;

		private final String partitioner;

		private final Boolean autoBootstrap;

		private final Boolean hintedHandoffEnabled;

		private final List<String> hintedHandoffDisabledDatacenters;

		private final Long maxHintWindowInMs;

		private final String hintsDirectory;

		private final ParameterizedClass seedProvider;

		private final DiskFailurePolicy diskFailurePolicy;

		private final CommitFailurePolicy commitFailurePolicy;

		private final String initialToken;

		private final Integer numTokens;

		private final String allocateTokensForLocalReplicationFactor;

		private final Long requestTimeoutInMs;

		private final Long readRequestTimeoutInMs;

		private final Long rangeRequestTimeoutInMs;

		private final Long writeRequestTimeoutInMs;

		private final Long counterWriteRequestTimeoutInMs;

		private final Long casContentionTimeoutInMs;

		private final Long truncateRequestTimeoutInMs;

		private final Long streamingKeepAlivePeriodInSecs;

		private final Boolean crossNodeTimeout;

		private final Long slowQueryLogTimeoutInMs;

		private final Double phiConvictThreshold;

		private final Integer concurrentReads;

		private final Integer concurrentWrites;

		private final Integer concurrentCounterWrites;

		private final Integer concurrentMaterializedViewWrites;

		private final Integer memtableFlushWriters;

		private final Integer memtableHeapSpaceInMb;

		private final Integer memtableOffheapSpaceInMb;

		private final Double memtableCleanupThreshold;

		private final int storagePort;

		private final int sslStoragePort;

		private final String listenAddress;

		private final String listenInterface;

		private final Boolean listenInterfacePreferIpv6;

		private final String broadcastAddress;

		private final Boolean listenOnBroadcastAddress;

		private final String internodeAuthenticator;


		private final String rpcAddress;

		private final String rpcInterface;

		private final Boolean rpcInterfacePreferIpv6;

		private final String broadcastRpcAddress;


		private final Boolean rpcKeepalive;


		private final Integer internodeSendBuffSizeInBytes;

		private final Integer internodeRecvBuffSizeInBytes;

		private final Boolean startNativeTransport;

		private final int nativeTransportPort;

		private final Integer nativeTransportPortSsl;

		private final Integer nativeTransportMaxThreads;

		private final Integer nativeTransportMaxFrameSizeInMb;

		private final Integer nativeTransportMaxConcurrentConnections;

		private final Integer nativeTransportMaxConcurrentConnectionsPerIp;

		private final Integer maxValueSizeInMb;


		private final Boolean snapshotBeforeCompaction;

		private final Boolean autoSnapshot;

		private final Integer columnIndexSizeInKb;

		private final Integer columnIndexCacheSizeInKb;

		private final Integer batchSizeWarnThresholdInKb;

		private final Integer batchSizeFailThresholdInKb;

		private final Integer unloggedBatchAcrossPartitionsWarnThreshold;

		private final Integer concurrentCompactors;

		private final Integer compactionThroughputMbPerSec;

		private final Integer compactionLargePartitionWarningThresholdMb;


		private final Integer streamThroughputOutboundMegabitsPerSec;

		private final Integer interDcStreamThroughputOutboundMegabitsPerSec;

		private final List<String> dataFileDirectories;

		private final String savedCachesDirectory;

		private final String commitlogDirectory;

		private final Integer commitlogTotalSpaceInMb;

		private final CommitLogSync commitlogSync;

		private final Double commitlogSyncBatchWindowInMs;

		private final Long commitlogSyncPeriodInMs;

		private final Long commitlogSegmentSizeInMb;

		private final ParameterizedClass commitlogCompression;


		private final TransparentDataEncryptionOptions transparentDataEncryptionOptions;

		private final Integer maxMutationSizeInKb;

		private final Boolean cdcEnabled;

		private final String cdcRawDirectory;

		private final Integer cdcTotalSpaceInMb;

		private final Long cdcFreeSpaceCheckIntervalMs;

		private final String endpointSnitch;


		private final Long dynamicSnitchUpdateIntervalInMs;

		private final Long dynamicSnitchResetIntervalInMs;

		private final Double dynamicSnitchBadnessThreshold;

		private final String requestScheduler;

		private final RequestSchedulerId requestSchedulerId;

		private final RequestSchedulerOptions requestSchedulerOptions;

		private final ServerEncryptionOptions serverEncryptionOptions;

		private final ClientEncryptionOptions clientEncryptionOptions;

		private final InternodeCompression internodeCompression;

		private final Integer hintedHandoffThrottleInKb;

		private final Integer batchlogReplayThrottleInKb;

		private final Integer maxHintsDeliveryThreads;

		private final Long hintsFlushPeriodInMs;

		private final Integer maxHintsFileSizeInMb;

		private final ParameterizedClass hintsCompression;

		private final Integer sstablePreemptiveOpenIntervalInMb;

		private final Boolean incrementalBackups;

		private final Boolean trickleFsync;

		private final Integer trickleFsyncIntervalInKb;

		private final Integer keyCacheSizeInMb;

		private final Long keyCacheSavePeriod;

		private final Integer keyCacheKeysToSave;

		private final String rowCacheClassName;

		private final Integer rowCacheSizeInMb;

		private final Long rowCacheSavePeriod;

		private final Integer rowCacheKeysToSave;

		private final Integer counterCacheSizeInMb;

		private final Long counterCacheSavePeriod;

		private final Integer counterCacheKeysToSave;

		private final Integer fileCacheSizeInMb;


		private final Boolean bufferPoolUseHeapIfExhausted;

		private final DiskOptimizationStrategy diskOptimizationStrategy;


		private final Boolean interDcTcpNodelay;

		private final Integer tombstoneWarnThreshold;

		private final Integer tombstoneFailureThreshold;

		private final Integer indexSummaryCapacityInMb;

		private final Integer indexSummaryResizeIntervalInMinutes;

		private final Long gcLogThresholdInMs;

		private final Long gcWarnThresholdInMs;

		private final MemtableAllocationType memtableAllocationType;

		private final Long tracetypeQueryTtl;

		private final Long tracetypeRepairTtl;

		private final String otcCoalescingStrategy;

		private final Long otcCoalescingWindowUs;

		private final Integer otcCoalescingEnoughCoalescedMessages;

		private final Long otcBacklogExpirationIntervalMs;

		private final Integer windowsTimerInterval;

		private final Integer preparedStatementsCacheSizeMb;


		private final Boolean enableUserDefinedFunctions;

		private final Boolean enableScriptedUserDefinedFunctions;


		private final Boolean backPressureEnabled;

		private final ParameterizedClass backPressureStrategy;

		private final DiskAccessMode diskAccessMode;

		private final String allocateTokensForKeyspace;


		private ImmutableConfig(ConfigBuilder builder) {
			this.jmxPort = builder.jmxPort;
			this.streamingSocketTimeoutInMs = builder.streamingSocketTimeoutInMs;
			this.clusterName = builder.clusterName;
			this.authenticator = builder.authenticator;
			this.authorizer = builder.authorizer;
			this.roleManager = builder.roleManager;
			this.permissionsValidityInMs = builder.permissionsValidityInMs;
			this.permissionsCacheMaxEntries = builder.permissionsCacheMaxEntries;
			this.permissionsUpdateIntervalInMs = builder.permissionsUpdateIntervalInMs;
			this.rolesValidityInMs = builder.rolesValidityInMs;
			this.rolesCacheMaxEntries = builder.rolesCacheMaxEntries;
			this.rolesUpdateIntervalInMs = builder.rolesUpdateIntervalInMs;
			this.credentialsValidityInMs = builder.credentialsValidityInMs;
			this.credentialsCacheMaxEntries = builder.credentialsCacheMaxEntries;
			this.credentialsUpdateIntervalInMs = builder.credentialsUpdateIntervalInMs;
			this.partitioner = builder.partitioner;
			this.autoBootstrap = builder.autoBootstrap;
			this.hintedHandoffEnabled = builder.hintedHandoffEnabled;
			this.hintedHandoffDisabledDatacenters =
					Collections
							.unmodifiableList(builder.hintedHandoffDisabledDatacenters);
			this.maxHintWindowInMs = builder.maxHintWindowInMs;
			this.hintsDirectory = builder.hintsDirectory;
			this.seedProvider = builder.seedProvider;
			this.diskFailurePolicy = builder.diskFailurePolicy;
			this.commitFailurePolicy = builder.commitFailurePolicy;
			this.initialToken = builder.initialToken;
			this.numTokens = builder.numTokens;
			this.allocateTokensForLocalReplicationFactor = builder.allocateTokensForLocalReplicationFactor;
			this.requestTimeoutInMs = builder.requestTimeoutInMs;
			this.readRequestTimeoutInMs = builder.readRequestTimeoutInMs;
			this.rangeRequestTimeoutInMs = builder.rangeRequestTimeoutInMs;
			this.writeRequestTimeoutInMs = builder.writeRequestTimeoutInMs;
			this.counterWriteRequestTimeoutInMs = builder.counterWriteRequestTimeoutInMs;
			this.casContentionTimeoutInMs = builder.casContentionTimeoutInMs;
			this.truncateRequestTimeoutInMs = builder.truncateRequestTimeoutInMs;
			this.streamingKeepAlivePeriodInSecs = builder.streamingKeepAlivePeriodInSecs;
			this.crossNodeTimeout = builder.crossNodeTimeout;
			this.slowQueryLogTimeoutInMs = builder.slowQueryLogTimeoutInMs;
			this.phiConvictThreshold = builder.phiConvictThreshold;
			this.concurrentReads = builder.concurrentReads;
			this.concurrentWrites = builder.concurrentWrites;
			this.concurrentCounterWrites = builder.concurrentCounterWrites;
			this.concurrentMaterializedViewWrites = builder.concurrentMaterializedViewWrites;
			this.memtableFlushWriters = builder.memtableFlushWriters;
			this.memtableHeapSpaceInMb = builder.memtableHeapSpaceInMb;
			this.memtableOffheapSpaceInMb = builder.memtableOffheapSpaceInMb;
			this.storagePort = builder.storagePort;
			this.sslStoragePort = builder.sslStoragePort;
			this.listenAddress = builder.listenAddress;
			this.listenInterface = builder.listenInterface;
			this.listenInterfacePreferIpv6 = builder.listenInterfacePreferIpv6;
			this.broadcastAddress = builder.broadcastAddress;
			this.listenOnBroadcastAddress = builder.listenOnBroadcastAddress;
			this.internodeAuthenticator = builder.internodeAuthenticator;
			this.rpcAddress = builder.rpcAddress;
			this.rpcInterface = builder.rpcInterface;
			this.rpcInterfacePreferIpv6 = builder.rpcInterfacePreferIpv6;
			this.broadcastRpcAddress = builder.broadcastRpcAddress;
			this.rpcKeepalive = builder.rpcKeepalive;
			this.internodeSendBuffSizeInBytes = builder.internodeSendBuffSizeInBytes;
			this.internodeRecvBuffSizeInBytes = builder.internodeRecvBuffSizeInBytes;
			this.startNativeTransport = builder.startNativeTransport;
			this.nativeTransportPort = builder.nativeTransportPort;
			this.nativeTransportPortSsl = builder.nativeTransportPortSsl;
			this.nativeTransportMaxThreads = builder.nativeTransportMaxThreads;
			this.nativeTransportMaxFrameSizeInMb = builder.nativeTransportMaxFrameSizeInMb;
			this.nativeTransportMaxConcurrentConnections = builder.nativeTransportMaxConcurrentConnections;
			this.nativeTransportMaxConcurrentConnectionsPerIp = builder.nativeTransportMaxConcurrentConnectionsPerIp;
			this.maxValueSizeInMb = builder.maxValueSizeInMb;
			this.snapshotBeforeCompaction = builder.snapshotBeforeCompaction;
			this.autoSnapshot = builder.autoSnapshot;
			this.columnIndexSizeInKb = builder.columnIndexSizeInKb;
			this.columnIndexCacheSizeInKb = builder.columnIndexCacheSizeInKb;
			this.batchSizeWarnThresholdInKb = builder.batchSizeWarnThresholdInKb;
			this.batchSizeFailThresholdInKb = builder.batchSizeFailThresholdInKb;
			this.unloggedBatchAcrossPartitionsWarnThreshold = builder.unloggedBatchAcrossPartitionsWarnThreshold;
			this.concurrentCompactors = builder.concurrentCompactors;
			this.compactionThroughputMbPerSec = builder.compactionThroughputMbPerSec;
			this.compactionLargePartitionWarningThresholdMb = builder.compactionLargePartitionWarningThresholdMb;
			this.streamThroughputOutboundMegabitsPerSec = builder.streamThroughputOutboundMegabitsPerSec;
			this.interDcStreamThroughputOutboundMegabitsPerSec = builder.interDcStreamThroughputOutboundMegabitsPerSec;
			this.dataFileDirectories = Collections
					.unmodifiableList(builder.dataFileDirectories);
			this.savedCachesDirectory = builder.savedCachesDirectory;
			this.commitlogDirectory = builder.commitlogDirectory;
			this.commitlogTotalSpaceInMb = builder.commitlogTotalSpaceInMb;
			this.commitlogSync = builder.commitlogSync;
			this.commitlogSyncBatchWindowInMs = builder.commitlogSyncBatchWindowInMs;
			this.commitlogSyncPeriodInMs = builder.commitlogSyncPeriodInMs;
			this.commitlogSegmentSizeInMb = builder.commitlogSegmentSizeInMb;
			this.commitlogCompression = builder.commitlogCompression;
			this.transparentDataEncryptionOptions = builder.transparentDataEncryptionOptions;
			this.maxMutationSizeInKb = builder.maxMutationSizeInKb;
			this.cdcEnabled = builder.cdcEnabled;
			this.cdcRawDirectory = builder.cdcRawDirectory;
			this.cdcTotalSpaceInMb = builder.cdcTotalSpaceInMb;
			this.cdcFreeSpaceCheckIntervalMs = builder.cdcFreeSpaceCheckIntervalMs;
			this.endpointSnitch = builder.endpointSnitch;
			this.dynamicSnitchUpdateIntervalInMs = builder.dynamicSnitchUpdateIntervalInMs;
			this.dynamicSnitchResetIntervalInMs = builder.dynamicSnitchResetIntervalInMs;
			this.dynamicSnitchBadnessThreshold = builder.dynamicSnitchBadnessThreshold;
			this.requestScheduler = builder.requestScheduler;
			this.requestSchedulerId = builder.requestSchedulerId;
			this.requestSchedulerOptions = builder.requestSchedulerOptions;
			this.serverEncryptionOptions = builder.serverEncryptionOptions;
			this.clientEncryptionOptions = builder.clientEncryptionOptions;
			this.internodeCompression = builder.internodeCompression;
			this.hintedHandoffThrottleInKb = builder.hintedHandoffThrottleInKb;
			this.batchlogReplayThrottleInKb = builder.batchlogReplayThrottleInKb;
			this.maxHintsDeliveryThreads = builder.maxHintsDeliveryThreads;
			this.hintsFlushPeriodInMs = builder.hintsFlushPeriodInMs;
			this.maxHintsFileSizeInMb = builder.maxHintsFileSizeInMb;
			this.hintsCompression = builder.hintsCompression;
			this.sstablePreemptiveOpenIntervalInMb = builder.sstablePreemptiveOpenIntervalInMb;
			this.incrementalBackups = builder.incrementalBackups;
			this.trickleFsync = builder.trickleFsync;
			this.trickleFsyncIntervalInKb = builder.trickleFsyncIntervalInKb;
			this.keyCacheSizeInMb = builder.keyCacheSizeInMb;
			this.keyCacheSavePeriod = builder.keyCacheSavePeriod;
			this.keyCacheKeysToSave = builder.keyCacheKeysToSave;
			this.rowCacheClassName = builder.rowCacheClassName;
			this.rowCacheSizeInMb = builder.rowCacheSizeInMb;
			this.rowCacheSavePeriod = builder.rowCacheSavePeriod;
			this.rowCacheKeysToSave = builder.rowCacheKeysToSave;
			this.counterCacheSizeInMb = builder.counterCacheSizeInMb;
			this.counterCacheSavePeriod = builder.counterCacheSavePeriod;
			this.counterCacheKeysToSave = builder.counterCacheKeysToSave;
			this.fileCacheSizeInMb = builder.fileCacheSizeInMb;
			this.bufferPoolUseHeapIfExhausted = builder.bufferPoolUseHeapIfExhausted;
			this.diskOptimizationStrategy = builder.diskOptimizationStrategy;
			this.interDcTcpNodelay = builder.interDcTcpNodelay;
			this.tombstoneWarnThreshold = builder.tombstoneWarnThreshold;
			this.tombstoneFailureThreshold = builder.tombstoneFailureThreshold;
			this.indexSummaryCapacityInMb = builder.indexSummaryCapacityInMb;
			this.indexSummaryResizeIntervalInMinutes = builder.indexSummaryResizeIntervalInMinutes;
			this.gcLogThresholdInMs = builder.gcLogThresholdInMs;
			this.gcWarnThresholdInMs = builder.gcWarnThresholdInMs;
			this.memtableAllocationType = builder.memtableAllocationType;
			this.tracetypeQueryTtl = builder.tracetypeQueryTtl;
			this.tracetypeRepairTtl = builder.tracetypeRepairTtl;
			this.otcCoalescingStrategy = builder.otcCoalescingStrategy;
			this.otcCoalescingWindowUs = builder.otcCoalescingWindowUs;
			this.otcCoalescingEnoughCoalescedMessages = builder.otcCoalescingEnoughCoalescedMessages;
			this.otcBacklogExpirationIntervalMs = builder.otcBacklogExpirationIntervalMs;
			this.windowsTimerInterval = builder.windowsTimerInterval;
			this.preparedStatementsCacheSizeMb = builder.preparedStatementsCacheSizeMb;
			this.enableUserDefinedFunctions = builder.enableUserDefinedFunctions;
			this.enableScriptedUserDefinedFunctions = builder.enableScriptedUserDefinedFunctions;
			this.backPressureEnabled = builder.backPressureEnabled;
			this.backPressureStrategy = builder.backPressureStrategy;
			this.diskAccessMode = builder.diskAccessMode;
			this.memtableCleanupThreshold = builder.memtableCleanupThreshold;
			this.allocateTokensForKeyspace = builder.allocateTokensForKeyspace;
		}

		@Override
		public String getAllocateTokensForKeyspace() {
			return this.allocateTokensForKeyspace;
		}

		@Override
		public int getJmxPort() {
			return this.jmxPort;
		}

		@Override
		public Long getStreamingSocketTimeoutInMs() {
			return this.streamingSocketTimeoutInMs;
		}

		@Override
		public String getClusterName() {
			return this.clusterName;
		}

		@Override
		public String getAuthenticator() {
			return this.authenticator;
		}

		@Override
		public String getAuthorizer() {
			return this.authorizer;
		}

		@Override
		public String getRoleManager() {
			return this.roleManager;
		}

		@Override
		public Long getPermissionsValidityInMs() {
			return this.permissionsValidityInMs;
		}

		@Override
		public Integer getPermissionsCacheMaxEntries() {
			return this.permissionsCacheMaxEntries;
		}

		@Override
		public Long getPermissionsUpdateIntervalInMs() {
			return this.permissionsUpdateIntervalInMs;
		}

		@Override
		public Long getRolesValidityInMs() {
			return this.rolesValidityInMs;
		}

		@Override
		public Integer getRolesCacheMaxEntries() {
			return this.rolesCacheMaxEntries;
		}

		@Override
		public Long getRolesUpdateIntervalInMs() {
			return this.rolesUpdateIntervalInMs;
		}

		@Override
		public Long getCredentialsValidityInMs() {
			return this.credentialsValidityInMs;
		}

		@Override
		public Integer getCredentialsCacheMaxEntries() {
			return this.credentialsCacheMaxEntries;
		}

		@Override
		public Long getCredentialsUpdateIntervalInMs() {
			return this.credentialsUpdateIntervalInMs;
		}

		@Override
		public String getPartitioner() {
			return this.partitioner;
		}

		@Override
		public Boolean getAutoBootstrap() {
			return this.autoBootstrap;
		}

		@Override
		public Boolean getHintedHandoffEnabled() {
			return this.hintedHandoffEnabled;
		}

		@Override
		public List<String> getHintedHandoffDisabledDatacenters() {
			return this.hintedHandoffDisabledDatacenters;
		}

		@Override
		public Long getMaxHintWindowInMs() {
			return this.maxHintWindowInMs;
		}

		@Override
		public String getHintsDirectory() {
			return this.hintsDirectory;
		}

		@Override
		public ParameterizedClass getSeedProvider() {
			return this.seedProvider;
		}

		@Override
		public DiskFailurePolicy getDiskFailurePolicy() {
			return this.diskFailurePolicy;
		}

		@Override
		public CommitFailurePolicy getCommitFailurePolicy() {
			return this.commitFailurePolicy;
		}

		@Override
		public String getInitialToken() {
			return this.initialToken;
		}

		@Override
		public Integer getNumTokens() {
			return this.numTokens;
		}

		@Override
		public String getAllocateTokensForLocalReplicationFactor() {
			return this.allocateTokensForLocalReplicationFactor;
		}

		@Override
		public Long getRequestTimeoutInMs() {
			return this.requestTimeoutInMs;
		}

		@Override
		public Long getReadRequestTimeoutInMs() {
			return this.readRequestTimeoutInMs;
		}

		@Override
		public Long getRangeRequestTimeoutInMs() {
			return this.rangeRequestTimeoutInMs;
		}

		@Override
		public Long getWriteRequestTimeoutInMs() {
			return this.writeRequestTimeoutInMs;
		}

		@Override
		public Long getCounterWriteRequestTimeoutInMs() {
			return this.counterWriteRequestTimeoutInMs;
		}

		@Override
		public Long getCasContentionTimeoutInMs() {
			return this.casContentionTimeoutInMs;
		}

		@Override
		public Long getTruncateRequestTimeoutInMs() {
			return this.truncateRequestTimeoutInMs;
		}

		@Override
		public Long getStreamingKeepAlivePeriodInSecs() {
			return this.streamingKeepAlivePeriodInSecs;
		}

		@Override
		public Boolean getCrossNodeTimeout() {
			return this.crossNodeTimeout;
		}

		@Override
		public Long getSlowQueryLogTimeoutInMs() {
			return this.slowQueryLogTimeoutInMs;
		}

		@Override
		public Double getPhiConvictThreshold() {
			return this.phiConvictThreshold;
		}

		@Override
		public Integer getConcurrentReads() {
			return this.concurrentReads;
		}

		@Override
		public Integer getConcurrentWrites() {
			return this.concurrentWrites;
		}

		@Override
		public Integer getConcurrentCounterWrites() {
			return this.concurrentCounterWrites;
		}

		@Override
		public Integer getConcurrentMaterializedViewWrites() {
			return this.concurrentMaterializedViewWrites;
		}

		@Override
		public Integer getMemtableFlushWriters() {
			return this.memtableFlushWriters;
		}

		@Override
		public Integer getMemtableHeapSpaceInMb() {
			return this.memtableHeapSpaceInMb;
		}

		@Override
		public Integer getMemtableOffheapSpaceInMb() {
			return this.memtableOffheapSpaceInMb;
		}

		@Override
		public Double getMemtableCleanupThreshold() {
			return this.memtableCleanupThreshold;
		}

		@Override
		public int getStoragePort() {
			return this.storagePort;
		}

		@Override
		public int getSslStoragePort() {
			return this.sslStoragePort;
		}

		@Override
		public String getListenAddress() {
			return this.listenAddress;
		}

		@Override
		public String getListenInterface() {
			return this.listenInterface;
		}

		@Override
		public Boolean getListenInterfacePreferIpv6() {
			return this.listenInterfacePreferIpv6;
		}

		@Override
		public String getBroadcastAddress() {
			return this.broadcastAddress;
		}

		@Override
		public Boolean getListenOnBroadcastAddress() {
			return this.listenOnBroadcastAddress;
		}

		@Override
		public String getInternodeAuthenticator() {
			return this.internodeAuthenticator;
		}

		@Override
		public String getRpcAddress() {
			return this.rpcAddress;
		}

		@Override
		public String getRpcInterface() {
			return this.rpcInterface;
		}

		@Override
		public Boolean getRpcInterfacePreferIpv6() {
			return this.rpcInterfacePreferIpv6;
		}

		@Override
		public String getBroadcastRpcAddress() {
			return this.broadcastRpcAddress;
		}

		@Override
		public Boolean getRpcKeepalive() {
			return this.rpcKeepalive;
		}

		@Override
		public Integer getInternodeSendBuffSizeInBytes() {
			return this.internodeSendBuffSizeInBytes;
		}

		@Override
		public Integer getInternodeRecvBuffSizeInBytes() {
			return this.internodeRecvBuffSizeInBytes;
		}

		@Override
		public Boolean getStartNativeTransport() {
			return this.startNativeTransport;
		}

		@Override
		public int getNativeTransportPort() {
			return this.nativeTransportPort;
		}

		@Override
		public Integer getNativeTransportPortSsl() {
			return this.nativeTransportPortSsl;
		}

		@Override
		public Integer getNativeTransportMaxThreads() {
			return this.nativeTransportMaxThreads;
		}

		@Override
		public Integer getNativeTransportMaxFrameSizeInMb() {
			return this.nativeTransportMaxFrameSizeInMb;
		}

		@Override
		public Integer getNativeTransportMaxConcurrentConnections() {
			return this.nativeTransportMaxConcurrentConnections;
		}

		@Override
		public Integer getNativeTransportMaxConcurrentConnectionsPerIp() {
			return this.nativeTransportMaxConcurrentConnectionsPerIp;
		}

		@Override
		public Integer getMaxValueSizeInMb() {
			return this.maxValueSizeInMb;
		}

		@Override
		public Boolean getSnapshotBeforeCompaction() {
			return this.snapshotBeforeCompaction;
		}

		@Override
		public Boolean getAutoSnapshot() {
			return this.autoSnapshot;
		}

		@Override
		public Integer getColumnIndexSizeInKb() {
			return this.columnIndexSizeInKb;
		}

		@Override
		public Integer getColumnIndexCacheSizeInKb() {
			return this.columnIndexCacheSizeInKb;
		}

		@Override
		public Integer getBatchSizeWarnThresholdInKb() {
			return this.batchSizeWarnThresholdInKb;
		}

		@Override
		public Integer getBatchSizeFailThresholdInKb() {
			return this.batchSizeFailThresholdInKb;
		}

		@Override
		public Integer getUnloggedBatchAcrossPartitionsWarnThreshold() {
			return this.unloggedBatchAcrossPartitionsWarnThreshold;
		}

		@Override
		public Integer getConcurrentCompactors() {
			return this.concurrentCompactors;
		}

		@Override
		public Integer getCompactionThroughputMbPerSec() {
			return this.compactionThroughputMbPerSec;
		}

		@Override
		public Integer getCompactionLargePartitionWarningThresholdMb() {
			return this.compactionLargePartitionWarningThresholdMb;
		}

		@Override
		public Integer getStreamThroughputOutboundMegabitsPerSec() {
			return this.streamThroughputOutboundMegabitsPerSec;
		}

		@Override
		public Integer getInterDcStreamThroughputOutboundMegabitsPerSec() {
			return this.interDcStreamThroughputOutboundMegabitsPerSec;
		}

		@Override
		public List<String> getDataFileDirectories() {
			return this.dataFileDirectories;
		}

		@Override
		public String getSavedCachesDirectory() {
			return this.savedCachesDirectory;
		}

		@Override
		public String getCommitlogDirectory() {
			return this.commitlogDirectory;
		}

		@Override
		public Integer getCommitlogTotalSpaceInMb() {
			return this.commitlogTotalSpaceInMb;
		}

		@Override
		public CommitLogSync getCommitlogSync() {
			return this.commitlogSync;
		}

		@Override
		public Double getCommitlogSyncBatchWindowInMs() {
			return this.commitlogSyncBatchWindowInMs;
		}

		@Override
		public Long getCommitlogSyncPeriodInMs() {
			return this.commitlogSyncPeriodInMs;
		}

		@Override
		public Long getCommitlogSegmentSizeInMb() {
			return this.commitlogSegmentSizeInMb;
		}

		@Override
		public ParameterizedClass getCommitlogCompression() {
			return this.commitlogCompression;
		}

		@Override
		public TransparentDataEncryptionOptions getTransparentDataEncryptionOptions() {
			return this.transparentDataEncryptionOptions;
		}

		@Override
		public Integer getMaxMutationSizeInKb() {
			return this.maxMutationSizeInKb;
		}

		@Override
		public Boolean getCdcEnabled() {
			return this.cdcEnabled;
		}

		@Override
		public String getCdcRawDirectory() {
			return this.cdcRawDirectory;
		}

		@Override
		public Integer getCdcTotalSpaceInMb() {
			return this.cdcTotalSpaceInMb;
		}

		@Override
		public Long getCdcFreeSpaceCheckIntervalMs() {
			return this.cdcFreeSpaceCheckIntervalMs;
		}

		@Override
		public String getEndpointSnitch() {
			return this.endpointSnitch;
		}

		@Override
		public Long getDynamicSnitchUpdateIntervalInMs() {
			return this.dynamicSnitchUpdateIntervalInMs;
		}

		@Override
		public Long getDynamicSnitchResetIntervalInMs() {
			return this.dynamicSnitchResetIntervalInMs;
		}

		@Override
		public Double getDynamicSnitchBadnessThreshold() {
			return this.dynamicSnitchBadnessThreshold;
		}

		@Override
		public String getRequestScheduler() {
			return this.requestScheduler;
		}

		@Override
		public RequestSchedulerId getRequestSchedulerId() {
			return this.requestSchedulerId;
		}

		@Override
		public RequestSchedulerOptions getRequestSchedulerOptions() {
			return this.requestSchedulerOptions;
		}

		@Override
		public ServerEncryptionOptions getServerEncryptionOptions() {
			return this.serverEncryptionOptions;
		}

		@Override
		public ClientEncryptionOptions getClientEncryptionOptions() {
			return this.clientEncryptionOptions;
		}

		@Override
		public InternodeCompression getInternodeCompression() {
			return this.internodeCompression;
		}

		@Override
		public Integer getHintedHandoffThrottleInKb() {
			return this.hintedHandoffThrottleInKb;
		}

		@Override
		public Integer getBatchlogReplayThrottleInKb() {
			return this.batchlogReplayThrottleInKb;
		}

		@Override
		public Integer getMaxHintsDeliveryThreads() {
			return this.maxHintsDeliveryThreads;
		}

		@Override
		public Long getHintsFlushPeriodInMs() {
			return this.hintsFlushPeriodInMs;
		}

		@Override
		public Integer getMaxHintsFileSizeInMb() {
			return this.maxHintsFileSizeInMb;
		}

		@Override
		public ParameterizedClass getHintsCompression() {
			return this.hintsCompression;
		}

		@Override
		public Integer getSstablePreemptiveOpenIntervalInMb() {
			return this.sstablePreemptiveOpenIntervalInMb;
		}

		@Override
		public Boolean getIncrementalBackups() {
			return this.incrementalBackups;
		}

		@Override
		public Boolean getTrickleFsync() {
			return this.trickleFsync;
		}

		@Override
		public Integer getTrickleFsyncIntervalInKb() {
			return this.trickleFsyncIntervalInKb;
		}

		@Override
		public Integer getKeyCacheSizeInMb() {
			return this.keyCacheSizeInMb;
		}

		@Override
		public Long getKeyCacheSavePeriod() {
			return this.keyCacheSavePeriod;
		}

		@Override
		public Integer getKeyCacheKeysToSave() {
			return this.keyCacheKeysToSave;
		}

		@Override
		public String getRowCacheClassName() {
			return this.rowCacheClassName;
		}

		@Override
		public Integer getRowCacheSizeInMb() {
			return this.rowCacheSizeInMb;
		}

		@Override
		public Long getRowCacheSavePeriod() {
			return this.rowCacheSavePeriod;
		}

		@Override
		public Integer getRowCacheKeysToSave() {
			return this.rowCacheKeysToSave;
		}

		@Override
		public Integer getCounterCacheSizeInMb() {
			return this.counterCacheSizeInMb;
		}

		@Override
		public Long getCounterCacheSavePeriod() {
			return this.counterCacheSavePeriod;
		}

		@Override
		public Integer getCounterCacheKeysToSave() {
			return this.counterCacheKeysToSave;
		}

		@Override
		public Integer getFileCacheSizeInMb() {
			return this.fileCacheSizeInMb;
		}

		@Override
		public Boolean getBufferPoolUseHeapIfExhausted() {
			return this.bufferPoolUseHeapIfExhausted;
		}

		@Override
		public DiskOptimizationStrategy getDiskOptimizationStrategy() {
			return this.diskOptimizationStrategy;
		}

		@Override
		public Boolean getInterDcTcpNodelay() {
			return this.interDcTcpNodelay;
		}

		@Override
		public Integer getTombstoneWarnThreshold() {
			return this.tombstoneWarnThreshold;
		}

		@Override
		public Integer getTombstoneFailureThreshold() {
			return this.tombstoneFailureThreshold;
		}

		@Override
		public Integer getIndexSummaryCapacityInMb() {
			return this.indexSummaryCapacityInMb;
		}

		@Override
		public Integer getIndexSummaryResizeIntervalInMinutes() {
			return this.indexSummaryResizeIntervalInMinutes;
		}

		@Override
		public Long getGcLogThresholdInMs() {
			return this.gcLogThresholdInMs;
		}

		@Override
		public Long getGcWarnThresholdInMs() {
			return this.gcWarnThresholdInMs;
		}

		@Override
		public MemtableAllocationType getMemtableAllocationType() {
			return this.memtableAllocationType;
		}

		@Override
		public Long getTracetypeQueryTtl() {
			return this.tracetypeQueryTtl;
		}

		@Override
		public Long getTracetypeRepairTtl() {
			return this.tracetypeRepairTtl;
		}

		@Override
		public String getOtcCoalescingStrategy() {
			return this.otcCoalescingStrategy;
		}

		@Override
		public Long getOtcCoalescingWindowUs() {
			return this.otcCoalescingWindowUs;
		}

		@Override
		public Integer getOtcCoalescingEnoughCoalescedMessages() {
			return this.otcCoalescingEnoughCoalescedMessages;
		}

		@Override
		public Long getOtcBacklogExpirationIntervalMs() {
			return this.otcBacklogExpirationIntervalMs;
		}

		@Override
		public Integer getWindowsTimerInterval() {
			return this.windowsTimerInterval;
		}

		@Override
		public Integer getPreparedStatementsCacheSizeMb() {
			return this.preparedStatementsCacheSizeMb;
		}

		@Override
		public Boolean getEnableUserDefinedFunctions() {
			return this.enableUserDefinedFunctions;
		}

		@Override
		public Boolean getEnableScriptedUserDefinedFunctions() {
			return this.enableScriptedUserDefinedFunctions;
		}

		@Override
		public Boolean getBackPressureEnabled() {
			return this.backPressureEnabled;
		}

		@Override
		public ParameterizedClass getBackPressureStrategy() {
			return this.backPressureStrategy;
		}

		@Override
		public DiskAccessMode getDiskAccessMode() {
			return this.diskAccessMode;
		}

	}
}

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

import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Simple implementation of {@link Config.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ConfigBuilder implements Config.Builder {

	@Nullable
	private String allocateTokensForKeyspace;

	private int jmxPort;

	@Nullable
	private Long streamingSocketTimeoutInMs;

	@Nullable
	private String clusterName;

	@Nullable
	private String authenticator;

	@Nullable
	private String authorizer;

	@Nullable
	private String roleManager;

	@Nullable
	private Long permissionsValidityInMs;

	@Nullable
	private Integer permissionsCacheMaxEntries;

	@Nullable
	private Long permissionsUpdateIntervalInMs;

	@Nullable
	private Long rolesValidityInMs;

	@Nullable
	private Integer rolesCacheMaxEntries;

	@Nullable
	private Long rolesUpdateIntervalInMs;

	@Nullable
	private Long credentialsValidityInMs;

	@Nullable
	private Integer credentialsCacheMaxEntries;

	@Nullable
	private Long credentialsUpdateIntervalInMs;

	@Nullable
	private String partitioner = "org.apache.cassandra.dht.Murmur3Partitioner";

	@Nullable
	private Boolean autoBootstrap;

	@Nullable
	private Boolean hintedHandoffEnabled;

	@Nullable
	private Collection<String> hintedHandoffDisabledDatacenters;

	@Nullable
	private Long maxHintWindowInMs;

	@Nullable
	private String hintsDirectory;

	@Nullable
	private ParameterizedClass seedProvider = ParameterizedClass.builder()
			.setClassName("org.apache.cassandra.locator.SimpleSeedProvider")
			.putParameters("seeds", "localhost")
			.build();

	@Nullable
	private DiskFailurePolicy diskFailurePolicy;

	@Nullable
	private CommitFailurePolicy commitFailurePolicy;

	@Nullable
	private String initialToken;

	@Nullable
	private Integer numTokens;

	@Nullable
	private String allocateTokensForLocalReplicationFactor;

	@Nullable
	private Long requestTimeoutInMs;

	@Nullable
	private Long readRequestTimeoutInMs;

	@Nullable
	private Long rangeRequestTimeoutInMs;

	@Nullable
	private Long writeRequestTimeoutInMs;

	@Nullable
	private Long counterWriteRequestTimeoutInMs;

	@Nullable
	private Long casContentionTimeoutInMs;

	@Nullable
	private Long truncateRequestTimeoutInMs;

	@Nullable
	private Long streamingKeepAlivePeriodInSecs;

	@Nullable
	private Boolean crossNodeTimeout;

	@Nullable
	private Long slowQueryLogTimeoutInMs;

	@Nullable
	private Double phiConvictThreshold;

	@Nullable
	private Integer concurrentReads;

	@Nullable
	private Integer concurrentWrites;

	@Nullable
	private Integer concurrentCounterWrites;

	@Nullable
	private Integer concurrentMaterializedViewWrites;

	@Nullable
	private Integer memtableFlushWriters;

	@Nullable
	private Integer memtableHeapSpaceInMb;

	@Nullable
	private Integer memtableOffheapSpaceInMb;

	@Nullable
	private Double memtableCleanupThreshold;

	private int storagePort;

	private int sslStoragePort;

	@Nullable
	private String listenAddress = "localhost";

	@Nullable
	private String listenInterface;

	@Nullable
	private Boolean listenInterfacePreferIpv6;

	@Nullable
	private String broadcastAddress;

	@Nullable
	private Boolean listenOnBroadcastAddress;

	@Nullable
	private String internodeAuthenticator;

	@Nullable
	private String rpcAddress = "localhost";

	@Nullable
	private String rpcInterface;

	@Nullable
	private Boolean rpcInterfacePreferIpv6;

	@Nullable
	private String broadcastRpcAddress;

	@Nullable
	private Boolean rpcKeepalive;

	@Nullable
	private Integer internodeSendBuffSizeInBytes;

	@Nullable
	private Integer internodeRecvBuffSizeInBytes;

	@Nullable
	private Boolean startNativeTransport = true;

	private int nativeTransportPort;

	@Nullable
	private Integer nativeTransportPortSsl;

	@Nullable
	private Integer nativeTransportMaxThreads;

	@Nullable
	private Integer nativeTransportMaxFrameSizeInMb;

	@Nullable
	private Integer nativeTransportMaxConcurrentConnections;

	@Nullable
	private Integer nativeTransportMaxConcurrentConnectionsPerIp;

	@Nullable
	private Integer maxValueSizeInMb;

	@Nullable
	private Boolean snapshotBeforeCompaction;

	@Nullable
	private Boolean autoSnapshot;

	@Nullable
	private Integer columnIndexSizeInKb;

	@Nullable
	private Integer columnIndexCacheSizeInKb;

	@Nullable
	private Integer batchSizeWarnThresholdInKb;

	@Nullable
	private Integer batchSizeFailThresholdInKb;

	@Nullable
	private Integer unloggedBatchAcrossPartitionsWarnThreshold;

	@Nullable
	private Integer concurrentCompactors;

	@Nullable
	private Integer compactionThroughputMbPerSec;

	@Nullable
	private Integer compactionLargePartitionWarningThresholdMb;

	@Nullable
	private Integer streamThroughputOutboundMegabitsPerSec;

	@Nullable
	private Integer interDcStreamThroughputOutboundMegabitsPerSec;

	@Nullable
	private Collection<String> dataFileDirectories;

	@Nullable
	private String savedCachesDirectory;

	@Nullable
	private String commitlogDirectory;

	@Nullable
	private Integer commitlogTotalSpaceInMb;

	@Nullable
	private CommitLogSync commitlogSync = CommitLogSync.periodic;

	@Nullable
	private Double commitlogSyncBatchWindowInMs;

	@Nullable
	private Long commitlogSyncPeriodInMs = Duration.ofSeconds(10).toMillis();

	@Nullable
	private Long commitlogSegmentSizeInMb;

	@Nullable
	private ParameterizedClass commitlogCompression;

	@Nullable
	private TransparentDataEncryptionOptions transparentDataEncryptionOptions;

	@Nullable
	private Integer maxMutationSizeInKb;

	@Nullable
	private Boolean cdcEnabled;

	@Nullable
	private String cdcRawDirectory;

	@Nullable
	private Integer cdcTotalSpaceInMb;

	@Nullable
	private Long cdcFreeSpaceCheckIntervalMs;

	@Nullable
	private String endpointSnitch;

	@Nullable
	private Long dynamicSnitchUpdateIntervalInMs;

	@Nullable
	private Long dynamicSnitchResetIntervalInMs;

	@Nullable
	private Double dynamicSnitchBadnessThreshold;

	@Nullable
	private String requestScheduler;

	@Nullable
	private RequestSchedulerId requestSchedulerId;

	@Nullable
	private RequestSchedulerOptions requestSchedulerOptions;

	@Nullable
	private ServerEncryptionOptions serverEncryptionOptions;

	@Nullable
	private ClientEncryptionOptions clientEncryptionOptions;

	@Nullable
	private InternodeCompression internodeCompression;

	@Nullable
	private Integer hintedHandoffThrottleInKb;

	@Nullable
	private Integer batchlogReplayThrottleInKb;

	@Nullable
	private Integer maxHintsDeliveryThreads;

	@Nullable
	private Long hintsFlushPeriodInMs;

	@Nullable
	private Integer maxHintsFileSizeInMb;

	@Nullable
	private ParameterizedClass hintsCompression;

	@Nullable
	private Integer sstablePreemptiveOpenIntervalInMb;

	@Nullable
	private Boolean incrementalBackups;

	@Nullable
	private Boolean trickleFsync;

	@Nullable
	private Integer trickleFsyncIntervalInKb;

	@Nullable
	private Integer keyCacheSizeInMb;

	@Nullable
	private Long keyCacheSavePeriod;

	@Nullable
	private Integer keyCacheKeysToSave;

	@Nullable
	private String rowCacheClassName;

	@Nullable
	private Integer rowCacheSizeInMb;

	@Nullable
	private Long rowCacheSavePeriod;

	@Nullable
	private Integer rowCacheKeysToSave;

	@Nullable
	private Integer counterCacheSizeInMb;

	@Nullable
	private Long counterCacheSavePeriod;

	@Nullable
	private Integer counterCacheKeysToSave;

	@Nullable
	private Integer fileCacheSizeInMb;

	@Nullable
	private Boolean bufferPoolUseHeapIfExhausted;

	@Nullable
	private DiskOptimizationStrategy diskOptimizationStrategy;

	@Nullable
	private Boolean interDcTcpNodelay;

	@Nullable
	private Integer tombstoneWarnThreshold;

	@Nullable
	private Integer tombstoneFailureThreshold;

	@Nullable
	private Integer indexSummaryCapacityInMb;

	@Nullable
	private Integer indexSummaryResizeIntervalInMinutes;

	@Nullable
	private Long gcLogThresholdInMs;

	@Nullable
	private Long gcWarnThresholdInMs;

	@Nullable
	private MemtableAllocationType memtableAllocationType;

	@Nullable
	private Long tracetypeQueryTtl;

	@Nullable
	private Long tracetypeRepairTtl;

	@Nullable
	private String otcCoalescingStrategy;

	@Nullable
	private Long otcCoalescingWindowUs;

	@Nullable
	private Integer otcCoalescingEnoughCoalescedMessages;

	@Nullable
	private Long otcBacklogExpirationIntervalMs;

	@Nullable
	private Integer windowsTimerInterval;

	@Nullable
	private Integer preparedStatementsCacheSizeMb;

	@Nullable
	private Boolean enableUserDefinedFunctions;

	@Nullable
	private Boolean enableScriptedUserDefinedFunctions;

	@Nullable
	private Boolean backPressureEnabled;

	@Nullable
	private ParameterizedClass backPressureStrategy;

	@Nullable
	private DiskAccessMode diskAccessMode;

	@Nonnull
	@Override
	public Config.Builder setJmxPort(int jmxPort) {
		this.jmxPort = jmxPort;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setStreamingSocketTimeoutInMs(@Nullable Long streamingSocketTimeoutInMs) {
		this.streamingSocketTimeoutInMs = streamingSocketTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setClusterName(@Nullable String clusterName) {
		this.clusterName = clusterName;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setAuthenticator(@Nullable String authenticator) {
		this.authenticator = authenticator;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setAuthorizer(@Nullable String authorizer) {
		this.authorizer = authorizer;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRoleManager(@Nullable String roleManager) {
		this.roleManager = roleManager;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setPermissionsValidityInMs(@Nullable Long permissionsValidityInMs) {
		this.permissionsValidityInMs = permissionsValidityInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setPermissionsCacheMaxEntries(@Nullable
			Integer permissionsCacheMaxEntries) {
		this.permissionsCacheMaxEntries = permissionsCacheMaxEntries;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setPermissionsUpdateIntervalInMs(@Nullable
			Long permissionsUpdateIntervalInMs) {
		this.permissionsUpdateIntervalInMs = permissionsUpdateIntervalInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRolesValidityInMs(@Nullable Long rolesValidityInMs) {
		this.rolesValidityInMs = rolesValidityInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRolesCacheMaxEntries(@Nullable Integer rolesCacheMaxEntries) {
		this.rolesCacheMaxEntries = rolesCacheMaxEntries;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRolesUpdateIntervalInMs(@Nullable Long rolesUpdateIntervalInMs) {
		this.rolesUpdateIntervalInMs = rolesUpdateIntervalInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCredentialsValidityInMs(@Nullable Long credentialsValidityInMs) {
		this.credentialsValidityInMs = credentialsValidityInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCredentialsCacheMaxEntries(@Nullable
			Integer credentialsCacheMaxEntries) {
		this.credentialsCacheMaxEntries = credentialsCacheMaxEntries;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCredentialsUpdateIntervalInMs(@Nullable
			Long credentialsUpdateIntervalInMs) {
		this.credentialsUpdateIntervalInMs = credentialsUpdateIntervalInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setPartitioner(@Nullable String partitioner) {
		this.partitioner = partitioner;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setAutoBootstrap(@Nullable Boolean autoBootstrap) {
		this.autoBootstrap = autoBootstrap;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setHintedHandoffEnabled(@Nullable Boolean hintedHandoffEnabled) {
		this.hintedHandoffEnabled = hintedHandoffEnabled;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder addHintedHandoffDisabledDatacenters(@Nullable String... datacenters) {
		if (datacenters == null) {
			return this;
		}
		addHintedHandoffDisabledDatacenters(Arrays.asList(datacenters));
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setHintedHandoffDisabledDatacenters(@Nullable Collection<String> datacenters) {
		this.hintedHandoffDisabledDatacenters = datacenters;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder addHintedHandoffDisabledDatacenters(@Nullable Collection<String> datacenters) {
		if (datacenters == null) {
			return this;
		}
		if (this.hintedHandoffDisabledDatacenters == null) {
			this.hintedHandoffDisabledDatacenters = datacenters;
		}
		else {
			this.hintedHandoffDisabledDatacenters.addAll(datacenters);
		}
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMaxHintWindowInMs(@Nullable Long maxHintWindowInMs) {
		this.maxHintWindowInMs = maxHintWindowInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setHintsDirectory(@Nullable String hintsDirectory) {
		this.hintsDirectory = hintsDirectory;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setSeedProvider(@Nullable ParameterizedClass seedProvider) {
		this.seedProvider = seedProvider;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDiskFailurePolicy(@Nullable DiskFailurePolicy diskFailurePolicy) {
		this.diskFailurePolicy = diskFailurePolicy;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitFailurePolicy(@Nullable
			CommitFailurePolicy commitFailurePolicy) {
		this.commitFailurePolicy = commitFailurePolicy;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInitialToken(@Nullable String initialToken) {
		this.initialToken = initialToken;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNumTokens(@Nullable Integer numTokens) {
		this.numTokens = numTokens;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setAllocateTokensForLocalReplicationFactor(@Nullable
			String allocateTokensForKeyspace) {
		this.allocateTokensForLocalReplicationFactor = allocateTokensForKeyspace;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setAllocateTokensForKeyspace(@Nullable String allocateTokensForKeyspace) {
		this.allocateTokensForKeyspace = allocateTokensForKeyspace;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRequestTimeoutInMs(@Nullable Long requestTimeoutInMs) {
		this.requestTimeoutInMs = requestTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setReadRequestTimeoutInMs(@Nullable Long readRequestTimeoutInMs) {
		this.readRequestTimeoutInMs = readRequestTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRangeRequestTimeoutInMs(@Nullable Long rangeRequestTimeoutInMs) {
		this.rangeRequestTimeoutInMs = rangeRequestTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setWriteRequestTimeoutInMs(@Nullable Long writeRequestTimeoutInMs) {
		this.writeRequestTimeoutInMs = writeRequestTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCounterWriteRequestTimeoutInMs(@Nullable
			Long counterWriteRequestTimeoutInMs) {
		this.counterWriteRequestTimeoutInMs = counterWriteRequestTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCasContentionTimeoutInMs(@Nullable Long casContentionTimeoutInMs) {
		this.casContentionTimeoutInMs = casContentionTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTruncateRequestTimeoutInMs(@Nullable Long truncateRequestTimeoutInMs) {
		this.truncateRequestTimeoutInMs = truncateRequestTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setStreamingKeepAlivePeriodInSecs(@Nullable
			Long streamingKeepAlivePeriodInSecs) {
		this.streamingKeepAlivePeriodInSecs = streamingKeepAlivePeriodInSecs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCrossNodeTimeout(@Nullable Boolean crossNodeTimeout) {
		this.crossNodeTimeout = crossNodeTimeout;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setSlowQueryLogTimeoutInMs(@Nullable Long slowQueryLogTimeoutInMs) {
		this.slowQueryLogTimeoutInMs = slowQueryLogTimeoutInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setPhiConvictThreshold(@Nullable Double phiConvictThreshold) {
		this.phiConvictThreshold = phiConvictThreshold;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setConcurrentReads(@Nullable Integer concurrentReads) {
		this.concurrentReads = concurrentReads;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setConcurrentWrites(@Nullable Integer concurrentWrites) {
		this.concurrentWrites = concurrentWrites;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setConcurrentCounterWrites(@Nullable Integer concurrentCounterWrites) {
		this.concurrentCounterWrites = concurrentCounterWrites;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setConcurrentMaterializedViewWrites(@Nullable
			Integer concurrentMaterializedViewWrites) {
		this.concurrentMaterializedViewWrites = concurrentMaterializedViewWrites;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMemtableFlushWriters(@Nullable Integer memtableFlushWriters) {
		this.memtableFlushWriters = memtableFlushWriters;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMemtableHeapSpaceInMb(@Nullable Integer memtableHeapSpaceInMb) {
		this.memtableHeapSpaceInMb = memtableHeapSpaceInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMemtableOffheapSpaceInMb(@Nullable Integer memtableOffheapSpaceInMb) {
		this.memtableOffheapSpaceInMb = memtableOffheapSpaceInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMemtableCleanupThreshold(@Nullable Double memtableCleanupThreshold) {
		this.memtableCleanupThreshold = memtableCleanupThreshold;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setStoragePort(int storagePort) {
		this.storagePort = storagePort;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setSslStoragePort(int sslStoragePort) {
		this.sslStoragePort = sslStoragePort;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setListenAddress(@Nullable String listenAddress) {
		this.listenAddress = listenAddress;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setListenInterface(@Nullable String listenInterface) {
		this.listenInterface = listenInterface;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setListenInterfacePreferIpv6(@Nullable
			Boolean listenInterfacePreferIpv6) {
		this.listenInterfacePreferIpv6 = listenInterfacePreferIpv6;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBroadcastAddress(@Nullable String broadcastAddress) {
		this.broadcastAddress = broadcastAddress;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setListenOnBroadcastAddress(@Nullable Boolean listenOnBroadcastAddress) {
		this.listenOnBroadcastAddress = listenOnBroadcastAddress;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInternodeAuthenticator(@Nullable String internodeAuthenticator) {
		this.internodeAuthenticator = internodeAuthenticator;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRpcAddress(@Nullable String rpcAddress) {
		this.rpcAddress = rpcAddress;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRpcInterface(@Nullable String rpcInterface) {
		this.rpcInterface = rpcInterface;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRpcInterfacePreferIpv6(@Nullable Boolean rpcInterfacePreferIpv6) {
		this.rpcInterfacePreferIpv6 = rpcInterfacePreferIpv6;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBroadcastRpcAddress(@Nullable String broadcastRpcAddress) {
		this.broadcastRpcAddress = broadcastRpcAddress;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRpcKeepalive(@Nullable Boolean rpcKeepalive) {
		this.rpcKeepalive = rpcKeepalive;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInternodeSendBuffSizeInBytes(@Nullable
			Integer internodeSendBuffSizeInBytes) {
		this.internodeSendBuffSizeInBytes = internodeSendBuffSizeInBytes;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInternodeRecvBuffSizeInBytes(@Nullable
			Integer internodeRecvBuffSizeInBytes) {
		this.internodeRecvBuffSizeInBytes = internodeRecvBuffSizeInBytes;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setStartNativeTransport(@Nullable Boolean startNativeTransport) {
		this.startNativeTransport = startNativeTransport;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNativeTransportPort(int nativeTransportPort) {
		this.nativeTransportPort = nativeTransportPort;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNativeTransportPortSsl(@Nullable Integer nativeTransportPortSsl) {
		this.nativeTransportPortSsl = nativeTransportPortSsl;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNativeTransportMaxThreads(@Nullable
			Integer nativeTransportMaxThreads) {
		this.nativeTransportMaxThreads = nativeTransportMaxThreads;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNativeTransportMaxFrameSizeInMb(@Nullable
			Integer nativeTransportMaxFrameSizeInMb) {
		this.nativeTransportMaxFrameSizeInMb = nativeTransportMaxFrameSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNativeTransportMaxConcurrentConnections(@Nullable
			Integer nativeTransportMaxConcurrentConnections) {
		this.nativeTransportMaxConcurrentConnections = nativeTransportMaxConcurrentConnections;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setNativeTransportMaxConcurrentConnectionsPerIp(@Nullable
			Integer nativeTransportMaxConcurrentConnectionsPerIp) {
		this.nativeTransportMaxConcurrentConnectionsPerIp = nativeTransportMaxConcurrentConnectionsPerIp;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMaxValueSizeInMb(@Nullable Integer maxValueSizeInMb) {
		this.maxValueSizeInMb = maxValueSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setSnapshotBeforeCompaction(@Nullable Boolean snapshotBeforeCompaction) {
		this.snapshotBeforeCompaction = snapshotBeforeCompaction;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setAutoSnapshot(@Nullable Boolean autoSnapshot) {
		this.autoSnapshot = autoSnapshot;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setColumnIndexSizeInKb(@Nullable Integer columnIndexSizeInKb) {
		this.columnIndexSizeInKb = columnIndexSizeInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setColumnIndexCacheSizeInKb(@Nullable Integer columnIndexCacheSizeInKb) {
		this.columnIndexCacheSizeInKb = columnIndexCacheSizeInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBatchSizeWarnThresholdInKb(@Nullable
			Integer batchSizeWarnThresholdInKb) {
		this.batchSizeWarnThresholdInKb = batchSizeWarnThresholdInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBatchSizeFailThresholdInKb(@Nullable
			Integer batchSizeFailThresholdInKb) {
		this.batchSizeFailThresholdInKb = batchSizeFailThresholdInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setUnloggedBatchAcrossPartitionsWarnThreshold(@Nullable
			Integer unloggedBatchAcrossPartitionsWarnThreshold) {
		this.unloggedBatchAcrossPartitionsWarnThreshold = unloggedBatchAcrossPartitionsWarnThreshold;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setConcurrentCompactors(@Nullable Integer concurrentCompactors) {
		this.concurrentCompactors = concurrentCompactors;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCompactionThroughputMbPerSec(@Nullable
			Integer compactionThroughputMbPerSec) {
		this.compactionThroughputMbPerSec = compactionThroughputMbPerSec;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCompactionLargePartitionWarningThresholdMb(@Nullable
			Integer compactionLargePartitionWarningThresholdMb) {
		this.compactionLargePartitionWarningThresholdMb = compactionLargePartitionWarningThresholdMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setStreamThroughputOutboundMegabitsPerSec(@Nullable
			Integer streamThroughputOutboundMegabitsPerSec) {
		this.streamThroughputOutboundMegabitsPerSec = streamThroughputOutboundMegabitsPerSec;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInterDcStreamThroughputOutboundMegabitsPerSec(@Nullable
			Integer interDcStreamThroughputOutboundMegabitsPerSec) {
		this.interDcStreamThroughputOutboundMegabitsPerSec = interDcStreamThroughputOutboundMegabitsPerSec;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder addDataFileDirectories(@Nullable String... directories) {
		if (directories == null) {
			return this;
		}
		addDataFileDirectories(Arrays.asList(directories));
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDataFileDirectories(@Nullable Collection<String> directories) {
		this.dataFileDirectories = directories;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder addDataFileDirectories(@Nullable Collection<String> directories) {
		if (directories == null) {
			return this;
		}
		if (this.dataFileDirectories == null) {
			this.dataFileDirectories = directories;
		}
		else {
			this.dataFileDirectories.addAll(directories);
		}
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setSavedCachesDirectory(@Nullable String savedCachesDirectory) {
		this.savedCachesDirectory = savedCachesDirectory;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogDirectory(@Nullable String commitlogDirectory) {
		this.commitlogDirectory = commitlogDirectory;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogTotalSpaceInMb(@Nullable Integer commitlogTotalSpaceInMb) {
		this.commitlogTotalSpaceInMb = commitlogTotalSpaceInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogSync(@Nullable CommitLogSync commitlogSync) {
		this.commitlogSync = commitlogSync;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogSyncBatchWindowInMs(@Nullable
			Double commitlogSyncBatchWindowInMs) {
		this.commitlogSyncBatchWindowInMs = commitlogSyncBatchWindowInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogSyncPeriodInMs(@Nullable Long commitlogSyncPeriodInMs) {
		this.commitlogSyncPeriodInMs = commitlogSyncPeriodInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogSegmentSizeInMb(@Nullable Long commitlogSegmentSizeInMb) {
		this.commitlogSegmentSizeInMb = commitlogSegmentSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCommitlogCompression(@Nullable
			ParameterizedClass commitlogCompression) {
		this.commitlogCompression = commitlogCompression;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTransparentDataEncryptionOptions(@Nullable
			TransparentDataEncryptionOptions transparentDataEncryptionOptions) {
		this.transparentDataEncryptionOptions = transparentDataEncryptionOptions;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMaxMutationSizeInKb(@Nullable Integer maxMutationSizeInKb) {
		this.maxMutationSizeInKb = maxMutationSizeInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCdcEnabled(@Nullable Boolean cdcEnabled) {
		this.cdcEnabled = cdcEnabled;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCdcRawDirectory(@Nullable String cdcRawDirectory) {
		this.cdcRawDirectory = cdcRawDirectory;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCdcTotalSpaceInMb(@Nullable Integer cdcTotalSpaceInMb) {
		this.cdcTotalSpaceInMb = cdcTotalSpaceInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCdcFreeSpaceCheckIntervalMs(@Nullable
			Long cdcFreeSpaceCheckIntervalMs) {
		this.cdcFreeSpaceCheckIntervalMs = cdcFreeSpaceCheckIntervalMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setEndpointSnitch(@Nullable String endpointSnitch) {
		this.endpointSnitch = endpointSnitch;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDynamicSnitchUpdateIntervalInMs(@Nullable
			Long dynamicSnitchUpdateIntervalInMs) {
		this.dynamicSnitchUpdateIntervalInMs = dynamicSnitchUpdateIntervalInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDynamicSnitchResetIntervalInMs(@Nullable
			Long dynamicSnitchResetIntervalInMs) {
		this.dynamicSnitchResetIntervalInMs = dynamicSnitchResetIntervalInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDynamicSnitchBadnessThreshold(@Nullable
			Double dynamicSnitchBadnessThreshold) {
		this.dynamicSnitchBadnessThreshold = dynamicSnitchBadnessThreshold;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRequestScheduler(@Nullable String requestScheduler) {
		this.requestScheduler = requestScheduler;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRequestSchedulerId(@Nullable RequestSchedulerId requestSchedulerId) {
		this.requestSchedulerId = requestSchedulerId;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRequestSchedulerOptions(@Nullable
			RequestSchedulerOptions requestSchedulerOptions) {
		this.requestSchedulerOptions = requestSchedulerOptions;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setServerEncryptionOptions(@Nullable
			ServerEncryptionOptions serverEncryptionOptions) {
		this.serverEncryptionOptions = serverEncryptionOptions;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setClientEncryptionOptions(@Nullable
			ClientEncryptionOptions clientEncryptionOptions) {
		this.clientEncryptionOptions = clientEncryptionOptions;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInternodeCompression(@Nullable
			InternodeCompression internodeCompression) {
		this.internodeCompression = internodeCompression;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setHintedHandoffThrottleInKb(@Nullable
			Integer hintedHandoffThrottleInKb) {
		this.hintedHandoffThrottleInKb = hintedHandoffThrottleInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBatchlogReplayThrottleInKb(@Nullable
			Integer batchlogReplayThrottleInKb) {
		this.batchlogReplayThrottleInKb = batchlogReplayThrottleInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMaxHintsDeliveryThreads(@Nullable Integer maxHintsDeliveryThreads) {
		this.maxHintsDeliveryThreads = maxHintsDeliveryThreads;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setHintsFlushPeriodInMs(@Nullable Long hintsFlushPeriodInMs) {
		this.hintsFlushPeriodInMs = hintsFlushPeriodInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMaxHintsFileSizeInMb(@Nullable Integer maxHintsFileSizeInMb) {
		this.maxHintsFileSizeInMb = maxHintsFileSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setHintsCompression(@Nullable ParameterizedClass hintsCompression) {
		this.hintsCompression = hintsCompression;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setSstablePreemptiveOpenIntervalInMb(@Nullable
			Integer sstablePreemptiveOpenIntervalInMb) {
		this.sstablePreemptiveOpenIntervalInMb = sstablePreemptiveOpenIntervalInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setIncrementalBackups(@Nullable Boolean incrementalBackups) {
		this.incrementalBackups = incrementalBackups;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTrickleFsync(@Nullable Boolean trickleFsync) {
		this.trickleFsync = trickleFsync;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTrickleFsyncIntervalInKb(@Nullable Integer trickleFsyncIntervalInKb) {
		this.trickleFsyncIntervalInKb = trickleFsyncIntervalInKb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setKeyCacheSizeInMb(@Nullable Integer keyCacheSizeInMb) {
		this.keyCacheSizeInMb = keyCacheSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setKeyCacheSavePeriod(@Nullable Long keyCacheSavePeriod) {
		this.keyCacheSavePeriod = keyCacheSavePeriod;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setKeyCacheKeysToSave(@Nullable Integer keyCacheKeysToSave) {
		this.keyCacheKeysToSave = keyCacheKeysToSave;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRowCacheClassName(@Nullable String rowCacheClassName) {
		this.rowCacheClassName = rowCacheClassName;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRowCacheSizeInMb(@Nullable Integer rowCacheSizeInMb) {
		this.rowCacheSizeInMb = rowCacheSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRowCacheSavePeriod(@Nullable Long rowCacheSavePeriod) {
		this.rowCacheSavePeriod = rowCacheSavePeriod;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setRowCacheKeysToSave(@Nullable Integer rowCacheKeysToSave) {
		this.rowCacheKeysToSave = rowCacheKeysToSave;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCounterCacheSizeInMb(@Nullable Integer counterCacheSizeInMb) {
		this.counterCacheSizeInMb = counterCacheSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCounterCacheSavePeriod(@Nullable Long counterCacheSavePeriod) {
		this.counterCacheSavePeriod = counterCacheSavePeriod;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setCounterCacheKeysToSave(@Nullable Integer counterCacheKeysToSave) {
		this.counterCacheKeysToSave = counterCacheKeysToSave;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setFileCacheSizeInMb(@Nullable Integer fileCacheSizeInMb) {
		this.fileCacheSizeInMb = fileCacheSizeInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBufferPoolUseHeapIfExhausted(@Nullable
			Boolean bufferPoolUseHeapIfExhausted) {
		this.bufferPoolUseHeapIfExhausted = bufferPoolUseHeapIfExhausted;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDiskOptimizationStrategy(@Nullable
			DiskOptimizationStrategy diskOptimizationStrategy) {
		this.diskOptimizationStrategy = diskOptimizationStrategy;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setInterDcTcpNodelay(@Nullable Boolean interDcTcpNodelay) {
		this.interDcTcpNodelay = interDcTcpNodelay;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTombstoneWarnThreshold(@Nullable Integer tombstoneWarnThreshold) {
		this.tombstoneWarnThreshold = tombstoneWarnThreshold;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTombstoneFailureThreshold(@Nullable
			Integer tombstoneFailureThreshold) {
		this.tombstoneFailureThreshold = tombstoneFailureThreshold;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setIndexSummaryCapacityInMb(@Nullable Integer indexSummaryCapacityInMb) {
		this.indexSummaryCapacityInMb = indexSummaryCapacityInMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setIndexSummaryResizeIntervalInMinutes(@Nullable
			Integer indexSummaryResizeIntervalInMinutes) {
		this.indexSummaryResizeIntervalInMinutes = indexSummaryResizeIntervalInMinutes;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setGcLogThresholdInMs(@Nullable Long gcLogThresholdInMs) {
		this.gcLogThresholdInMs = gcLogThresholdInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setGcWarnThresholdInMs(@Nullable Long gcWarnThresholdInMs) {
		this.gcWarnThresholdInMs = gcWarnThresholdInMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setMemtableAllocationType(@Nullable
			MemtableAllocationType memtableAllocationType) {
		this.memtableAllocationType = memtableAllocationType;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTracetypeQueryTtl(@Nullable Long tracetypeQueryTtl) {
		this.tracetypeQueryTtl = tracetypeQueryTtl;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setTracetypeRepairTtl(@Nullable Long tracetypeRepairTtl) {
		this.tracetypeRepairTtl = tracetypeRepairTtl;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setOtcCoalescingStrategy(@Nullable String otcCoalescingStrategy) {
		this.otcCoalescingStrategy = otcCoalescingStrategy;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setOtcCoalescingWindowUs(@Nullable Long otcCoalescingWindowUs) {
		this.otcCoalescingWindowUs = otcCoalescingWindowUs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setOtcCoalescingEnoughCoalescedMessages(@Nullable
			Integer otcCoalescingEnoughCoalescedMessages) {
		this.otcCoalescingEnoughCoalescedMessages = otcCoalescingEnoughCoalescedMessages;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setOtcBacklogExpirationIntervalMs(@Nullable
			Long otcBacklogExpirationIntervalMs) {
		this.otcBacklogExpirationIntervalMs = otcBacklogExpirationIntervalMs;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setWindowsTimerInterval(@Nullable Integer windowsTimerInterval) {
		this.windowsTimerInterval = windowsTimerInterval;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setPreparedStatementsCacheSizeMb(@Nullable
			Integer preparedStatementsCacheSizeMb) {
		this.preparedStatementsCacheSizeMb = preparedStatementsCacheSizeMb;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setEnableUserDefinedFunctions(@Nullable
			Boolean enableUserDefinedFunctions) {
		this.enableUserDefinedFunctions = enableUserDefinedFunctions;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setEnableScriptedUserDefinedFunctions(@Nullable
			Boolean enableScriptedUserDefinedFunctions) {
		this.enableScriptedUserDefinedFunctions = enableScriptedUserDefinedFunctions;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBackPressureEnabled(@Nullable Boolean backPressureEnabled) {
		this.backPressureEnabled = backPressureEnabled;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setBackPressureStrategy(@Nullable
			ParameterizedClass backPressureStrategy) {
		this.backPressureStrategy = backPressureStrategy;
		return this;
	}

	@Nonnull
	@Override
	public Config.Builder setDiskAccessMode(@Nullable DiskAccessMode diskAccessMode) {
		this.diskAccessMode = diskAccessMode;
		return this;
	}

	@Nonnull
	@Override
	public Config build() {
		return new ImmutableConfig(this);
	}


	/**
	 * Immutable implementation of {@link Config}.
	 */
	private static final class ImmutableConfig implements Config {
		private final Port jmxPort;

		@Nullable
		private final Long streamingSocketTimeoutInMs;

		@Nullable
		private final String clusterName;

		@Nullable
		private final String authenticator;

		@Nullable
		private final String authorizer;

		@Nullable
		private final String roleManager;

		@Nullable
		private final Long permissionsValidityInMs;

		@Nullable
		private final Integer permissionsCacheMaxEntries;

		@Nullable
		private final Long permissionsUpdateIntervalInMs;

		@Nullable
		private final Long rolesValidityInMs;

		@Nullable
		private final Integer rolesCacheMaxEntries;

		@Nullable
		private final Long rolesUpdateIntervalInMs;

		@Nullable
		private final Long credentialsValidityInMs;

		@Nullable
		private final Integer credentialsCacheMaxEntries;

		@Nullable
		private final Long credentialsUpdateIntervalInMs;

		@Nullable
		private final String partitioner;

		@Nullable
		private final Boolean autoBootstrap;

		@Nullable
		private final Boolean hintedHandoffEnabled;

		@Nullable
		private final Collection<String> hintedHandoffDisabledDatacenters;

		@Nullable
		private final Long maxHintWindowInMs;

		@Nullable
		private final String hintsDirectory;

		@Nullable
		private final ParameterizedClass seedProvider;

		@Nullable
		private final DiskFailurePolicy diskFailurePolicy;

		@Nullable
		private final CommitFailurePolicy commitFailurePolicy;

		@Nullable
		private final String initialToken;

		@Nullable
		private final Integer numTokens;

		@Nullable
		private final String allocateTokensForLocalReplicationFactor;

		@Nullable
		private final Long requestTimeoutInMs;

		@Nullable
		private final Long readRequestTimeoutInMs;

		@Nullable
		private final Long rangeRequestTimeoutInMs;

		@Nullable
		private final Long writeRequestTimeoutInMs;

		@Nullable
		private final Long counterWriteRequestTimeoutInMs;

		@Nullable
		private final Long casContentionTimeoutInMs;

		@Nullable
		private final Long truncateRequestTimeoutInMs;

		@Nullable
		private final Long streamingKeepAlivePeriodInSecs;

		@Nullable
		private final Boolean crossNodeTimeout;

		@Nullable
		private final Long slowQueryLogTimeoutInMs;

		@Nullable
		private final Double phiConvictThreshold;

		@Nullable
		private final Integer concurrentReads;

		@Nullable
		private final Integer concurrentWrites;

		@Nullable
		private final Integer concurrentCounterWrites;

		@Nullable
		private final Integer concurrentMaterializedViewWrites;

		@Nullable
		private final Integer memtableFlushWriters;

		@Nullable
		private final Integer memtableHeapSpaceInMb;

		@Nullable
		private final Integer memtableOffheapSpaceInMb;

		@Nullable
		private final Double memtableCleanupThreshold;

		private final Port storagePort;

		private final Port sslStoragePort;

		@Nullable
		private final String listenAddress;

		@Nullable
		private final String listenInterface;

		@Nullable
		private final Boolean listenInterfacePreferIpv6;

		@Nullable
		private final String broadcastAddress;

		@Nullable
		private final Boolean listenOnBroadcastAddress;

		@Nullable
		private final String internodeAuthenticator;

		@Nullable
		private final String rpcAddress;

		@Nullable
		private final String rpcInterface;

		@Nullable
		private final Boolean rpcInterfacePreferIpv6;

		@Nullable
		private final String broadcastRpcAddress;

		@Nullable
		private final Boolean rpcKeepalive;

		@Nullable
		private final Integer internodeSendBuffSizeInBytes;

		@Nullable
		private final Integer internodeRecvBuffSizeInBytes;

		@Nullable
		private final Boolean startNativeTransport;

		private final Port nativeTransportPort;

		@Nullable
		private final Port nativeTransportPortSsl;

		@Nullable
		private final Integer nativeTransportMaxThreads;

		@Nullable
		private final Integer nativeTransportMaxFrameSizeInMb;

		@Nullable
		private final Integer nativeTransportMaxConcurrentConnections;

		@Nullable
		private final Integer nativeTransportMaxConcurrentConnectionsPerIp;

		@Nullable
		private final Integer maxValueSizeInMb;

		@Nullable
		private final Boolean snapshotBeforeCompaction;

		@Nullable
		private final Boolean autoSnapshot;

		@Nullable
		private final Integer columnIndexSizeInKb;

		@Nullable
		private final Integer columnIndexCacheSizeInKb;

		@Nullable
		private final Integer batchSizeWarnThresholdInKb;

		@Nullable
		private final Integer batchSizeFailThresholdInKb;

		@Nullable
		private final Integer unloggedBatchAcrossPartitionsWarnThreshold;

		@Nullable
		private final Integer concurrentCompactors;

		@Nullable
		private final Integer compactionThroughputMbPerSec;

		@Nullable
		private final Integer compactionLargePartitionWarningThresholdMb;

		@Nullable
		private final Integer streamThroughputOutboundMegabitsPerSec;

		@Nullable
		private final Integer interDcStreamThroughputOutboundMegabitsPerSec;

		@Nullable
		private final Collection<String> dataFileDirectories;

		@Nullable
		private final String savedCachesDirectory;

		@Nullable
		private final String commitlogDirectory;

		@Nullable
		private final Integer commitlogTotalSpaceInMb;

		@Nullable
		private final CommitLogSync commitlogSync;

		@Nullable
		private final Double commitlogSyncBatchWindowInMs;

		@Nullable
		private final Long commitlogSyncPeriodInMs;

		@Nullable
		private final Long commitlogSegmentSizeInMb;

		@Nullable
		private final ParameterizedClass commitlogCompression;

		@Nullable
		private final TransparentDataEncryptionOptions transparentDataEncryptionOptions;

		@Nullable
		private final Integer maxMutationSizeInKb;

		@Nullable
		private final Boolean cdcEnabled;

		@Nullable
		private final String cdcRawDirectory;

		@Nullable
		private final Integer cdcTotalSpaceInMb;

		@Nullable
		private final Long cdcFreeSpaceCheckIntervalMs;

		@Nullable
		private final String endpointSnitch;

		@Nullable
		private final Long dynamicSnitchUpdateIntervalInMs;

		@Nullable
		private final Long dynamicSnitchResetIntervalInMs;

		@Nullable
		private final Double dynamicSnitchBadnessThreshold;

		@Nullable
		private final String requestScheduler;

		@Nullable
		private final RequestSchedulerId requestSchedulerId;

		@Nullable
		private final RequestSchedulerOptions requestSchedulerOptions;

		@Nullable
		private final ServerEncryptionOptions serverEncryptionOptions;

		@Nullable
		private final ClientEncryptionOptions clientEncryptionOptions;

		@Nullable
		private final InternodeCompression internodeCompression;

		@Nullable
		private final Integer hintedHandoffThrottleInKb;

		@Nullable
		private final Integer batchlogReplayThrottleInKb;

		@Nullable
		private final Integer maxHintsDeliveryThreads;

		@Nullable
		private final Long hintsFlushPeriodInMs;

		@Nullable
		private final Integer maxHintsFileSizeInMb;

		@Nullable
		private final ParameterizedClass hintsCompression;

		@Nullable
		private final Integer sstablePreemptiveOpenIntervalInMb;

		@Nullable
		private final Boolean incrementalBackups;

		@Nullable
		private final Boolean trickleFsync;

		@Nullable
		private final Integer trickleFsyncIntervalInKb;

		@Nullable
		private final Integer keyCacheSizeInMb;

		@Nullable
		private final Long keyCacheSavePeriod;

		@Nullable
		private final Integer keyCacheKeysToSave;

		@Nullable
		private final String rowCacheClassName;

		@Nullable
		private final Integer rowCacheSizeInMb;

		@Nullable
		private final Long rowCacheSavePeriod;

		@Nullable
		private final Integer rowCacheKeysToSave;

		@Nullable
		private final Integer counterCacheSizeInMb;

		@Nullable
		private final Long counterCacheSavePeriod;

		@Nullable
		private final Integer counterCacheKeysToSave;

		@Nullable
		private final Integer fileCacheSizeInMb;

		@Nullable
		private final Boolean bufferPoolUseHeapIfExhausted;

		@Nullable
		private final DiskOptimizationStrategy diskOptimizationStrategy;

		@Nullable
		private final Boolean interDcTcpNodelay;

		@Nullable
		private final Integer tombstoneWarnThreshold;

		@Nullable
		private final Integer tombstoneFailureThreshold;

		@Nullable
		private final Integer indexSummaryCapacityInMb;

		@Nullable
		private final Integer indexSummaryResizeIntervalInMinutes;

		@Nullable
		private final Long gcLogThresholdInMs;

		@Nullable
		private final Long gcWarnThresholdInMs;

		@Nullable
		private final MemtableAllocationType memtableAllocationType;

		@Nullable
		private final Long tracetypeQueryTtl;

		@Nullable
		private final Long tracetypeRepairTtl;

		@Nullable
		private final String otcCoalescingStrategy;

		@Nullable
		private final Long otcCoalescingWindowUs;

		@Nullable
		private final Integer otcCoalescingEnoughCoalescedMessages;

		@Nullable
		private final Long otcBacklogExpirationIntervalMs;

		@Nullable
		private final Integer windowsTimerInterval;

		@Nullable
		private final Integer preparedStatementsCacheSizeMb;

		@Nullable
		private final Boolean enableUserDefinedFunctions;

		@Nullable
		private final Boolean enableScriptedUserDefinedFunctions;

		@Nullable
		private final Boolean backPressureEnabled;

		@Nullable
		private final ParameterizedClass backPressureStrategy;

		@Nullable
		private final DiskAccessMode diskAccessMode;

		@Nullable
		private final String allocateTokensForKeyspace;

		private ImmutableConfig(@Nonnull ConfigBuilder builder) {
			this.jmxPort = new Port(builder.jmxPort);
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
			this.hintedHandoffDisabledDatacenters = (builder.hintedHandoffDisabledDatacenters != null) ? Collections
					.unmodifiableCollection(builder.hintedHandoffDisabledDatacenters) : null;
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
			this.storagePort = new Port(builder.storagePort);
			this.sslStoragePort = new Port(builder.sslStoragePort);
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
			this.nativeTransportPort = new Port(builder.nativeTransportPort);
			this.nativeTransportPortSsl = (builder.nativeTransportPortSsl != null) ? new Port(builder
					.nativeTransportPortSsl) : null;
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
			this.dataFileDirectories =
					(builder.dataFileDirectories != null) ? Collections.unmodifiableCollection(builder
							.dataFileDirectories) : null;
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

		@Nullable
		@Override
		public String getAllocateTokensForKeyspace() {
			return this.allocateTokensForKeyspace;
		}

		@Override
		public int getJmxPort() {
			return this.jmxPort.getPort();
		}

		@Nullable
		@Override
		public Long getStreamingSocketTimeoutInMs() {
			return this.streamingSocketTimeoutInMs;
		}

		@Nullable
		@Override
		public String getClusterName() {
			return this.clusterName;
		}

		@Nullable
		@Override
		public String getAuthenticator() {
			return this.authenticator;
		}

		@Nullable
		@Override
		public String getAuthorizer() {
			return this.authorizer;
		}

		@Nullable
		@Override
		public String getRoleManager() {
			return this.roleManager;
		}

		@Nullable
		@Override
		public Long getPermissionsValidityInMs() {
			return this.permissionsValidityInMs;
		}

		@Nullable
		@Override
		public Integer getPermissionsCacheMaxEntries() {
			return this.permissionsCacheMaxEntries;
		}

		@Nullable
		@Override
		public Long getPermissionsUpdateIntervalInMs() {
			return this.permissionsUpdateIntervalInMs;
		}

		@Nullable
		@Override
		public Long getRolesValidityInMs() {
			return this.rolesValidityInMs;
		}

		@Nullable
		@Override
		public Integer getRolesCacheMaxEntries() {
			return this.rolesCacheMaxEntries;
		}

		@Nullable
		@Override
		public Long getRolesUpdateIntervalInMs() {
			return this.rolesUpdateIntervalInMs;
		}

		@Nullable
		@Override
		public Long getCredentialsValidityInMs() {
			return this.credentialsValidityInMs;
		}

		@Nullable
		@Override
		public Integer getCredentialsCacheMaxEntries() {
			return this.credentialsCacheMaxEntries;
		}

		@Nullable
		@Override
		public Long getCredentialsUpdateIntervalInMs() {
			return this.credentialsUpdateIntervalInMs;
		}

		@Nullable
		@Override
		public String getPartitioner() {
			return this.partitioner;
		}

		@Nullable
		@Override
		public Boolean getAutoBootstrap() {
			return this.autoBootstrap;
		}

		@Nullable
		@Override
		public Boolean getHintedHandoffEnabled() {
			return this.hintedHandoffEnabled;
		}

		@Nullable
		@Override
		public Collection<String> getHintedHandoffDisabledDatacenters() {
			return this.hintedHandoffDisabledDatacenters;
		}

		@Nullable
		@Override
		public Long getMaxHintWindowInMs() {
			return this.maxHintWindowInMs;
		}

		@Nullable
		@Override
		public String getHintsDirectory() {
			return this.hintsDirectory;
		}

		@Nullable
		@Override
		public ParameterizedClass getSeedProvider() {
			return this.seedProvider;
		}

		@Nullable
		@Override
		public DiskFailurePolicy getDiskFailurePolicy() {
			return this.diskFailurePolicy;
		}

		@Nullable
		@Override
		public CommitFailurePolicy getCommitFailurePolicy() {
			return this.commitFailurePolicy;
		}

		@Nullable
		@Override
		public String getInitialToken() {
			return this.initialToken;
		}

		@Nullable
		@Override
		public Integer getNumTokens() {
			return this.numTokens;
		}

		@Nullable
		@Override
		public String getAllocateTokensForLocalReplicationFactor() {
			return this.allocateTokensForLocalReplicationFactor;
		}

		@Nullable
		@Override
		public Long getRequestTimeoutInMs() {
			return this.requestTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getReadRequestTimeoutInMs() {
			return this.readRequestTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getRangeRequestTimeoutInMs() {
			return this.rangeRequestTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getWriteRequestTimeoutInMs() {
			return this.writeRequestTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getCounterWriteRequestTimeoutInMs() {
			return this.counterWriteRequestTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getCasContentionTimeoutInMs() {
			return this.casContentionTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getTruncateRequestTimeoutInMs() {
			return this.truncateRequestTimeoutInMs;
		}

		@Nullable
		@Override
		public Long getStreamingKeepAlivePeriodInSecs() {
			return this.streamingKeepAlivePeriodInSecs;
		}

		@Nullable
		@Override
		public Boolean getCrossNodeTimeout() {
			return this.crossNodeTimeout;
		}

		@Nullable
		@Override
		public Long getSlowQueryLogTimeoutInMs() {
			return this.slowQueryLogTimeoutInMs;
		}

		@Nullable
		@Override
		public Double getPhiConvictThreshold() {
			return this.phiConvictThreshold;
		}

		@Nullable
		@Override
		public Integer getConcurrentReads() {
			return this.concurrentReads;
		}

		@Nullable
		@Override
		public Integer getConcurrentWrites() {
			return this.concurrentWrites;
		}

		@Nullable
		@Override
		public Integer getConcurrentCounterWrites() {
			return this.concurrentCounterWrites;
		}

		@Nullable
		@Override
		public Integer getConcurrentMaterializedViewWrites() {
			return this.concurrentMaterializedViewWrites;
		}

		@Nullable
		@Override
		public Integer getMemtableFlushWriters() {
			return this.memtableFlushWriters;
		}

		@Nullable
		@Override
		public Integer getMemtableHeapSpaceInMb() {
			return this.memtableHeapSpaceInMb;
		}

		@Nullable
		@Override
		public Integer getMemtableOffheapSpaceInMb() {
			return this.memtableOffheapSpaceInMb;
		}

		@Nullable
		@Override
		public Double getMemtableCleanupThreshold() {
			return this.memtableCleanupThreshold;
		}

		@Override
		public int getStoragePort() {
			return this.storagePort.getPort();
		}

		@Override
		public int getSslStoragePort() {
			return this.sslStoragePort.getPort();
		}

		@Nullable
		@Override
		public String getListenAddress() {
			return this.listenAddress;
		}

		@Nullable
		@Override
		public String getListenInterface() {
			return this.listenInterface;
		}

		@Nullable
		@Override
		public Boolean getListenInterfacePreferIpv6() {
			return this.listenInterfacePreferIpv6;
		}

		@Nullable
		@Override
		public String getBroadcastAddress() {
			return this.broadcastAddress;
		}

		@Nullable
		@Override
		public Boolean getListenOnBroadcastAddress() {
			return this.listenOnBroadcastAddress;
		}

		@Nullable
		@Override
		public String getInternodeAuthenticator() {
			return this.internodeAuthenticator;
		}

		@Nullable
		@Override
		public String getRpcAddress() {
			return this.rpcAddress;
		}

		@Nullable
		@Override
		public String getRpcInterface() {
			return this.rpcInterface;
		}

		@Nullable
		@Override
		public Boolean getRpcInterfacePreferIpv6() {
			return this.rpcInterfacePreferIpv6;
		}

		@Nullable
		@Override
		public String getBroadcastRpcAddress() {
			return this.broadcastRpcAddress;
		}

		@Nullable
		@Override
		public Boolean getRpcKeepalive() {
			return this.rpcKeepalive;
		}

		@Nullable
		@Override
		public Integer getInternodeSendBuffSizeInBytes() {
			return this.internodeSendBuffSizeInBytes;
		}

		@Nullable
		@Override
		public Integer getInternodeRecvBuffSizeInBytes() {
			return this.internodeRecvBuffSizeInBytes;
		}

		@Nullable
		@Override
		public Boolean getStartNativeTransport() {
			return this.startNativeTransport;
		}

		@Override
		public int getNativeTransportPort() {
			return this.nativeTransportPort.getPort();
		}

		@Nullable
		@Override
		public Integer getNativeTransportPortSsl() {
			return (this.nativeTransportPortSsl != null) ? this.nativeTransportPortSsl.getPort() : null;
		}

		@Nullable
		@Override
		public Integer getNativeTransportMaxThreads() {
			return this.nativeTransportMaxThreads;
		}

		@Nullable
		@Override
		public Integer getNativeTransportMaxFrameSizeInMb() {
			return this.nativeTransportMaxFrameSizeInMb;
		}

		@Nullable
		@Override
		public Integer getNativeTransportMaxConcurrentConnections() {
			return this.nativeTransportMaxConcurrentConnections;
		}

		@Nullable
		@Override
		public Integer getNativeTransportMaxConcurrentConnectionsPerIp() {
			return this.nativeTransportMaxConcurrentConnectionsPerIp;
		}

		@Nullable
		@Override
		public Integer getMaxValueSizeInMb() {
			return this.maxValueSizeInMb;
		}

		@Nullable
		@Override
		public Boolean getSnapshotBeforeCompaction() {
			return this.snapshotBeforeCompaction;
		}

		@Nullable
		@Override
		public Boolean getAutoSnapshot() {
			return this.autoSnapshot;
		}

		@Nullable
		@Override
		public Integer getColumnIndexSizeInKb() {
			return this.columnIndexSizeInKb;
		}

		@Nullable
		@Override
		public Integer getColumnIndexCacheSizeInKb() {
			return this.columnIndexCacheSizeInKb;
		}

		@Nullable
		@Override
		public Integer getBatchSizeWarnThresholdInKb() {
			return this.batchSizeWarnThresholdInKb;
		}

		@Nullable
		@Override
		public Integer getBatchSizeFailThresholdInKb() {
			return this.batchSizeFailThresholdInKb;
		}

		@Nullable
		@Override
		public Integer getUnloggedBatchAcrossPartitionsWarnThreshold() {
			return this.unloggedBatchAcrossPartitionsWarnThreshold;
		}

		@Nullable
		@Override
		public Integer getConcurrentCompactors() {
			return this.concurrentCompactors;
		}

		@Nullable
		@Override
		public Integer getCompactionThroughputMbPerSec() {
			return this.compactionThroughputMbPerSec;
		}

		@Nullable
		@Override
		public Integer getCompactionLargePartitionWarningThresholdMb() {
			return this.compactionLargePartitionWarningThresholdMb;
		}

		@Nullable
		@Override
		public Integer getStreamThroughputOutboundMegabitsPerSec() {
			return this.streamThroughputOutboundMegabitsPerSec;
		}

		@Nullable
		@Override
		public Integer getInterDcStreamThroughputOutboundMegabitsPerSec() {
			return this.interDcStreamThroughputOutboundMegabitsPerSec;
		}

		@Nullable
		@Override
		public Collection<String> getDataFileDirectories() {
			return this.dataFileDirectories;
		}

		@Nullable
		@Override
		public String getSavedCachesDirectory() {
			return this.savedCachesDirectory;
		}

		@Nullable
		@Override
		public String getCommitlogDirectory() {
			return this.commitlogDirectory;
		}

		@Nullable
		@Override
		public Integer getCommitlogTotalSpaceInMb() {
			return this.commitlogTotalSpaceInMb;
		}

		@Nullable
		@Override
		public CommitLogSync getCommitlogSync() {
			return this.commitlogSync;
		}

		@Nullable
		@Override
		public Double getCommitlogSyncBatchWindowInMs() {
			return this.commitlogSyncBatchWindowInMs;
		}

		@Nullable
		@Override
		public Long getCommitlogSyncPeriodInMs() {
			return this.commitlogSyncPeriodInMs;
		}

		@Nullable
		@Override
		public Long getCommitlogSegmentSizeInMb() {
			return this.commitlogSegmentSizeInMb;
		}

		@Nullable
		@Override
		public ParameterizedClass getCommitlogCompression() {
			return this.commitlogCompression;
		}

		@Nullable
		@Override
		public TransparentDataEncryptionOptions getTransparentDataEncryptionOptions() {
			return this.transparentDataEncryptionOptions;
		}

		@Nullable
		@Override
		public Integer getMaxMutationSizeInKb() {
			return this.maxMutationSizeInKb;
		}

		@Nullable
		@Override
		public Boolean getCdcEnabled() {
			return this.cdcEnabled;
		}

		@Nullable
		@Override
		public String getCdcRawDirectory() {
			return this.cdcRawDirectory;
		}

		@Nullable
		@Override
		public Integer getCdcTotalSpaceInMb() {
			return this.cdcTotalSpaceInMb;
		}

		@Nullable
		@Override
		public Long getCdcFreeSpaceCheckIntervalMs() {
			return this.cdcFreeSpaceCheckIntervalMs;
		}

		@Nullable
		@Override
		public String getEndpointSnitch() {
			return this.endpointSnitch;
		}

		@Nullable
		@Override
		public Long getDynamicSnitchUpdateIntervalInMs() {
			return this.dynamicSnitchUpdateIntervalInMs;
		}

		@Nullable
		@Override
		public Long getDynamicSnitchResetIntervalInMs() {
			return this.dynamicSnitchResetIntervalInMs;
		}

		@Nullable
		@Override
		public Double getDynamicSnitchBadnessThreshold() {
			return this.dynamicSnitchBadnessThreshold;
		}

		@Nullable
		@Override
		public String getRequestScheduler() {
			return this.requestScheduler;
		}

		@Nullable
		@Override
		public RequestSchedulerId getRequestSchedulerId() {
			return this.requestSchedulerId;
		}

		@Nullable
		@Override
		public RequestSchedulerOptions getRequestSchedulerOptions() {
			return this.requestSchedulerOptions;
		}

		@Nullable
		@Override
		public ServerEncryptionOptions getServerEncryptionOptions() {
			return this.serverEncryptionOptions;
		}

		@Nullable
		@Override
		public ClientEncryptionOptions getClientEncryptionOptions() {
			return this.clientEncryptionOptions;
		}

		@Nullable
		@Override
		public InternodeCompression getInternodeCompression() {
			return this.internodeCompression;
		}

		@Nullable
		@Override
		public Integer getHintedHandoffThrottleInKb() {
			return this.hintedHandoffThrottleInKb;
		}

		@Nullable
		@Override
		public Integer getBatchlogReplayThrottleInKb() {
			return this.batchlogReplayThrottleInKb;
		}

		@Nullable
		@Override
		public Integer getMaxHintsDeliveryThreads() {
			return this.maxHintsDeliveryThreads;
		}

		@Nullable
		@Override
		public Long getHintsFlushPeriodInMs() {
			return this.hintsFlushPeriodInMs;
		}

		@Nullable
		@Override
		public Integer getMaxHintsFileSizeInMb() {
			return this.maxHintsFileSizeInMb;
		}

		@Nullable
		@Override
		public ParameterizedClass getHintsCompression() {
			return this.hintsCompression;
		}

		@Nullable
		@Override
		public Integer getSstablePreemptiveOpenIntervalInMb() {
			return this.sstablePreemptiveOpenIntervalInMb;
		}

		@Nullable
		@Override
		public Boolean getIncrementalBackups() {
			return this.incrementalBackups;
		}

		@Nullable
		@Override
		public Boolean getTrickleFsync() {
			return this.trickleFsync;
		}

		@Nullable
		@Override
		public Integer getTrickleFsyncIntervalInKb() {
			return this.trickleFsyncIntervalInKb;
		}

		@Nullable
		@Override
		public Integer getKeyCacheSizeInMb() {
			return this.keyCacheSizeInMb;
		}

		@Nullable
		@Override
		public Long getKeyCacheSavePeriod() {
			return this.keyCacheSavePeriod;
		}

		@Nullable
		@Override
		public Integer getKeyCacheKeysToSave() {
			return this.keyCacheKeysToSave;
		}

		@Nullable
		@Override
		public String getRowCacheClassName() {
			return this.rowCacheClassName;
		}

		@Nullable
		@Override
		public Integer getRowCacheSizeInMb() {
			return this.rowCacheSizeInMb;
		}

		@Nullable
		@Override
		public Long getRowCacheSavePeriod() {
			return this.rowCacheSavePeriod;
		}

		@Nullable
		@Override
		public Integer getRowCacheKeysToSave() {
			return this.rowCacheKeysToSave;
		}

		@Nullable
		@Override
		public Integer getCounterCacheSizeInMb() {
			return this.counterCacheSizeInMb;
		}

		@Nullable
		@Override
		public Long getCounterCacheSavePeriod() {
			return this.counterCacheSavePeriod;
		}

		@Nullable
		@Override
		public Integer getCounterCacheKeysToSave() {
			return this.counterCacheKeysToSave;
		}

		@Nullable
		@Override
		public Integer getFileCacheSizeInMb() {
			return this.fileCacheSizeInMb;
		}

		@Nullable
		@Override
		public Boolean getBufferPoolUseHeapIfExhausted() {
			return this.bufferPoolUseHeapIfExhausted;
		}

		@Nullable
		@Override
		public DiskOptimizationStrategy getDiskOptimizationStrategy() {
			return this.diskOptimizationStrategy;
		}

		@Nullable
		@Override
		public Boolean getInterDcTcpNodelay() {
			return this.interDcTcpNodelay;
		}

		@Nullable
		@Override
		public Integer getTombstoneWarnThreshold() {
			return this.tombstoneWarnThreshold;
		}

		@Nullable
		@Override
		public Integer getTombstoneFailureThreshold() {
			return this.tombstoneFailureThreshold;
		}

		@Nullable
		@Override
		public Integer getIndexSummaryCapacityInMb() {
			return this.indexSummaryCapacityInMb;
		}

		@Nullable
		@Override
		public Integer getIndexSummaryResizeIntervalInMinutes() {
			return this.indexSummaryResizeIntervalInMinutes;
		}

		@Nullable
		@Override
		public Long getGcLogThresholdInMs() {
			return this.gcLogThresholdInMs;
		}

		@Nullable
		@Override
		public Long getGcWarnThresholdInMs() {
			return this.gcWarnThresholdInMs;
		}

		@Nullable
		@Override
		public MemtableAllocationType getMemtableAllocationType() {
			return this.memtableAllocationType;
		}

		@Nullable
		@Override
		public Long getTracetypeQueryTtl() {
			return this.tracetypeQueryTtl;
		}

		@Nullable
		@Override
		public Long getTracetypeRepairTtl() {
			return this.tracetypeRepairTtl;
		}

		@Nullable
		@Override
		public String getOtcCoalescingStrategy() {
			return this.otcCoalescingStrategy;
		}

		@Nullable
		@Override
		public Long getOtcCoalescingWindowUs() {
			return this.otcCoalescingWindowUs;
		}

		@Nullable
		@Override
		public Integer getOtcCoalescingEnoughCoalescedMessages() {
			return this.otcCoalescingEnoughCoalescedMessages;
		}

		@Nullable
		@Override
		public Long getOtcBacklogExpirationIntervalMs() {
			return this.otcBacklogExpirationIntervalMs;
		}

		@Nullable
		@Override
		public Integer getWindowsTimerInterval() {
			return this.windowsTimerInterval;
		}

		@Nullable
		@Override
		public Integer getPreparedStatementsCacheSizeMb() {
			return this.preparedStatementsCacheSizeMb;
		}

		@Nullable
		@Override
		public Boolean getEnableUserDefinedFunctions() {
			return this.enableUserDefinedFunctions;
		}

		@Nullable
		@Override
		public Boolean getEnableScriptedUserDefinedFunctions() {
			return this.enableScriptedUserDefinedFunctions;
		}

		@Nullable
		@Override
		public Boolean getBackPressureEnabled() {
			return this.backPressureEnabled;
		}

		@Nullable
		@Override
		public ParameterizedClass getBackPressureStrategy() {
			return this.backPressureStrategy;
		}

		@Nullable
		@Override
		public DiskAccessMode getDiskAccessMode() {
			return this.diskAccessMode;
		}

	}


	/**
	 * Utility class to generate random port if specified port is {@code null}.
	 */
	private static final class Port {

		private volatile int port;

		private Port(int port) {
			this.port = port;
		}


		int getPort() {
			if (this.port == 0) {
				synchronized (this) {
					if (this.port == 0) {
						this.port = PortUtils.getPort();
					}
				}
			}
			return this.port;
		}


		private static final class PortUtils {

			private final static int MAX = 65535;

			private final static int MIN = 1024;

			private static int sequence = MIN;

			synchronized static int getPort() {
				int port = getPort(sequence, MAX);
				if (port == -1) {
					port = getPort(MIN, MAX);
				}
				if (port == -1) {
					throw new IllegalStateException("Could not find available port");
				}
				sequence = port + 1;
				return port;
			}

			private static int getPort(int min, int max) {
				for (int i = min; i <= max; i++) {
					try (ServerSocket serverSocket = new ServerSocket(i)) {
						return serverSocket.getLocalPort();
					}
					catch (IOException ignore) {
					}
				}
				return -1;
			}

		}
	}
}

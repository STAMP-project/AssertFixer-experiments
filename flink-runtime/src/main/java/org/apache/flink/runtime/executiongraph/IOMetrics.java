/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.executiongraph;

import org.apache.flink.metrics.Meter;

import java.io.Serializable;

/**
 * An instance of this class represents a snapshot of the io-related metrics of a single task.
 */
public class IOMetrics implements Serializable {

	private static final long serialVersionUID = -7208093607556457183L;

	protected long numRecordsIn;
	protected long numRecordsOut;

	protected double numRecordsInPerSecond;
	protected double numRecordsOutPerSecond;

	protected long numBytesInLocal;
	protected long numBytesInRemote;
	protected long numBytesOut;

	protected double numBytesInLocalPerSecond;
	protected double numBytesInRemotePerSecond;
	protected double numBytesOutPerSecond;

	protected long numBuffersInLocal;
	protected long numBuffersInRemote;
	protected long numBuffersOut;

	protected double numBuffersInLocalPerSecond;
	protected double numBuffersInRemotePerSecond;
	protected double numBuffersOutPerSecond;

	public IOMetrics(
			Meter recordsIn,
			Meter recordsOut,
			Meter bytesLocalIn,
			Meter bytesRemoteIn,
			Meter bytesOut,
			Meter buffersLocalIn,
			Meter buffersRemoteIn,
			Meter buffersOut) {
		this.numRecordsIn = recordsIn.getCount();
		this.numRecordsInPerSecond = recordsIn.getRate();
		this.numRecordsOut = recordsOut.getCount();
		this.numRecordsOutPerSecond = recordsOut.getRate();

		this.numBytesInLocal = bytesLocalIn.getCount();
		this.numBytesInLocalPerSecond = bytesLocalIn.getRate();
		this.numBytesInRemote = bytesRemoteIn.getCount();
		this.numBytesInRemotePerSecond = bytesRemoteIn.getRate();
		this.numBytesOut = bytesOut.getCount();
		this.numBytesOutPerSecond = bytesOut.getRate();

		this.numBuffersInLocal = buffersLocalIn.getCount();
		this.numBuffersInLocalPerSecond = buffersLocalIn.getRate();
		this.numBuffersInRemote = buffersRemoteIn.getCount();
		this.numBuffersInRemotePerSecond = buffersRemoteIn.getRate();
		this.numBuffersOut = buffersOut.getCount();
		this.numBuffersOutPerSecond = buffersOut.getRate();
	}

	public IOMetrics(
			long numBytesInLocal,
			long numBytesInRemote,
			long numBytesOut,
			long numBuffersInLocal,
			long numBuffersInRemote,
			long numBuffersOut,
			long numRecordsIn,
			long numRecordsOut,
			double numBytesInLocalPerSecond,
			double numBytesInRemotePerSecond,
			double numBytesOutPerSecond,
			double numBuffersInLocalPerSecond,
			double numBuffersInRemotePerSecond,
			double numBuffersOutPerSecond,
			double numRecordsInPerSecond,
			double numRecordsOutPerSecond) {
		this.numBytesInLocal = numBytesInLocal;
		this.numBytesInRemote = numBytesInRemote;
		this.numBytesOut = numBytesOut;
		this.numBuffersInLocal = numBuffersInLocal;
		this.numBuffersInRemote = numBuffersInRemote;
		this.numBuffersOut = numBuffersOut;
		this.numRecordsIn = numRecordsIn;
		this.numRecordsOut = numRecordsOut;
		this.numBytesInLocalPerSecond = numBytesInLocalPerSecond;
		this.numBytesInRemotePerSecond = numBytesInRemotePerSecond;
		this.numBytesOutPerSecond = numBytesOutPerSecond;
		this.numBuffersInLocalPerSecond = numBuffersInLocalPerSecond;
		this.numBuffersInRemotePerSecond = numBuffersInRemotePerSecond;
		this.numBuffersOutPerSecond = numBuffersOutPerSecond;
		this.numRecordsInPerSecond = numRecordsInPerSecond;
		this.numRecordsOutPerSecond = numRecordsOutPerSecond;
	}

	public long getNumRecordsIn() {
		return numRecordsIn;
	}

	public long getNumRecordsOut() {
		return numRecordsOut;
	}

	public long getNumBytesInLocal() {
		return numBytesInLocal;
	}

	public long getNumBytesInRemote() {
		return numBytesInRemote;
	}

	public long getNumBytesInTotal() {
		return numBytesInLocal + numBytesInRemote;
	}

	public long getNumBytesOut() {
		return numBytesOut;
	}

	public long getNumBuffersInLocal() {
		return numBuffersInLocal;
	}

	public long getNumBuffersInRemote() {
		return numBuffersInRemote;
	}

	public long getNumBuffersInTotal() {
		return numBuffersInLocal + numBuffersInRemote;
	}

	public long getNumBuffersOut() {
		return numBuffersOut;
	}

	public double getNumRecordsInPerSecond() {
		return numRecordsInPerSecond;
	}

	public double getNumRecordsOutPerSecond() {
		return numRecordsOutPerSecond;
	}

	public double getNumBytesInLocalPerSecond() {
		return numBytesInLocalPerSecond;
	}

	public double getNumBytesInRemotePerSecond() {
		return numBytesInRemotePerSecond;
	}

	public double getNumBytesOutPerSecond() {
		return numBytesOutPerSecond;
	}

	public double getNumBuffersInLocalPerSecond() {
		return numBuffersInLocalPerSecond;
	}

	public double getNumBuffersInRemotePerSecond() {
		return numBuffersInRemotePerSecond;
	}

	public double getNumBuffersOutPerSecond() {
		return numBuffersOutPerSecond;
	}
}

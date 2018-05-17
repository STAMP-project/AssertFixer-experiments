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

package org.apache.flink.cep.nfa.sharedbuffer;

import org.apache.flink.api.common.typeutils.base.TypeSerializerSingleton;
import org.apache.flink.cep.nfa.DeweyNumber;
import org.apache.flink.core.memory.DataInputView;
import org.apache.flink.core.memory.DataOutputView;

import java.io.IOException;

public class SharedBufferEdge {
	private final NodeId target;
	private final DeweyNumber deweyNumber;

	public SharedBufferEdge(NodeId target, DeweyNumber deweyNumber) {
		this.target = target;
		this.deweyNumber = deweyNumber;
	}

	public NodeId getTarget() {
		return target;
	}

	public DeweyNumber getDeweyNumber() {
		return deweyNumber;
	}

	@Override
	public String toString() {
		return "SharedBufferEdge{" +
			"target=" + target +
			", deweyNumber=" + deweyNumber +
			'}';
	}

	public static class SharedBufferEdgeSerializer extends TypeSerializerSingleton<SharedBufferEdge> {

		static final SharedBufferEdgeSerializer INSTANCE = new SharedBufferEdgeSerializer();

		@Override
		public boolean isImmutableType() {
			return true;
		}

		@Override
		public SharedBufferEdge createInstance() {
			return null;
		}

		@Override
		public SharedBufferEdge copy(SharedBufferEdge from) {
			return new SharedBufferEdge(from.target, from.deweyNumber);
		}

		@Override
		public SharedBufferEdge copy(SharedBufferEdge from, SharedBufferEdge reuse) {
			return copy(from);
		}

		@Override
		public int getLength() {
			return -1;
		}

		@Override
		public void serialize(SharedBufferEdge record, DataOutputView target) throws IOException {
			NodeId.NodeIdSerializer.INSTANCE.serialize(record.target, target);
			DeweyNumber.DeweyNumberSerializer.INSTANCE.serialize(record.deweyNumber, target);
		}

		@Override
		public SharedBufferEdge deserialize(DataInputView source) throws IOException {
			NodeId target = NodeId.NodeIdSerializer.INSTANCE.deserialize(source);
			DeweyNumber deweyNumber = DeweyNumber.DeweyNumberSerializer.INSTANCE.deserialize(source);
			return new SharedBufferEdge(target, deweyNumber);
		}

		@Override
		public SharedBufferEdge deserialize(SharedBufferEdge reuse, DataInputView source) throws IOException {
			return deserialize(source);
		}

		@Override
		public void copy(DataInputView source, DataOutputView target) throws IOException {
			serialize(deserialize(source), target);
		}

		@Override
		public boolean canEqual(Object obj) {
			return obj instanceof SharedBufferEdgeSerializer;
		}
	}
}

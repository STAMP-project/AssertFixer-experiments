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

import org.apache.flink.cep.Event;
import org.apache.flink.cep.nfa.DeweyNumber;
import org.apache.flink.cep.utils.TestSharedBuffer;
import org.apache.flink.util.TestLogger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link SharedBuffer}.
 */
public class SharedBufferTest extends TestLogger {

	@Test
	public void testSharedBuffer() throws Exception {
		SharedBuffer<Event> sharedBuffer = TestSharedBuffer.createTestBuffer(Event.createTypeSerializer());
		int numberEvents = 8;
		Event[] events = new Event[numberEvents];
		long[] eventIds = new long[numberEvents];
		final long timestamp = 1L;

		for (int i = 0; i < numberEvents; i++) {
			events[i] = new Event(i + 1, "e" + (i + 1), i);
			eventIds[i] = sharedBuffer.registerEvent(events[i]);
		}

		Map<String, List<Event>> expectedPattern1 = new HashMap<>();
		expectedPattern1.put("a1", new ArrayList<>());
		expectedPattern1.get("a1").add(events[2]);

		expectedPattern1.put("a[]", new ArrayList<>());
		expectedPattern1.get("a[]").add(events[3]);

		expectedPattern1.put("b", new ArrayList<>());
		expectedPattern1.get("b").add(events[5]);

		Map<String, List<Event>> expectedPattern2 = new HashMap<>();
		expectedPattern2.put("a1", new ArrayList<>());
		expectedPattern2.get("a1").add(events[0]);

		expectedPattern2.put("a[]", new ArrayList<>());
		expectedPattern2.get("a[]").add(events[1]);
		expectedPattern2.get("a[]").add(events[2]);
		expectedPattern2.get("a[]").add(events[3]);
		expectedPattern2.get("a[]").add(events[4]);

		expectedPattern2.put("b", new ArrayList<>());
		expectedPattern2.get("b").add(events[5]);

		Map<String, List<Event>> expectedPattern3 = new HashMap<>();
		expectedPattern3.put("a1", new ArrayList<>());
		expectedPattern3.get("a1").add(events[0]);

		expectedPattern3.put("a[]", new ArrayList<>());
		expectedPattern3.get("a[]").add(events[1]);
		expectedPattern3.get("a[]").add(events[2]);
		expectedPattern3.get("a[]").add(events[3]);
		expectedPattern3.get("a[]").add(events[4]);
		expectedPattern3.get("a[]").add(events[5]);
		expectedPattern3.get("a[]").add(events[6]);

		expectedPattern3.put("b", new ArrayList<>());
		expectedPattern3.get("b").add(events[7]);

		NodeId a10 = sharedBuffer.put("a1", eventIds[0], timestamp, DeweyNumber.fromString("1"));
		NodeId aLoop0 = sharedBuffer.put("a[]", eventIds[1], timestamp, a10, DeweyNumber.fromString("1.0"));
		NodeId a11 = sharedBuffer.put("a1", eventIds[2], timestamp, DeweyNumber.fromString("2"));
		NodeId aLoop1 = sharedBuffer.put("a[]", eventIds[2], timestamp, aLoop0, DeweyNumber.fromString("1.0"));
		NodeId aLoop2 = sharedBuffer.put("a[]", eventIds[3], timestamp, aLoop1, DeweyNumber.fromString("1.0"));
		NodeId aSecondLoop0 = sharedBuffer.put("a[]", eventIds[3], timestamp, a11, DeweyNumber.fromString("2.0"));
		NodeId aLoop3 = sharedBuffer.put("a[]", eventIds[4], timestamp, aLoop2, DeweyNumber.fromString("1.0"));
		NodeId b0 = sharedBuffer.put("b", eventIds[5], timestamp, aLoop3, DeweyNumber.fromString("1.0.0"));
		NodeId aLoop4 = sharedBuffer.put("a[]", eventIds[5], timestamp, aLoop3, DeweyNumber.fromString("1.1"));
		NodeId b1 = sharedBuffer.put("b", eventIds[5], timestamp, aSecondLoop0, DeweyNumber.fromString("2.0.0"));
		NodeId aLoop5 = sharedBuffer.put("a[]", eventIds[6], timestamp, aLoop4, DeweyNumber.fromString("1.1"));
		NodeId b3 = sharedBuffer.put("b", eventIds[7], timestamp, aLoop5, DeweyNumber.fromString("1.1.0"));

		Collection<Map<String, List<Event>>> patterns3 = sharedBuffer.extractPatterns(b3, DeweyNumber.fromString("1.1.0"));
		sharedBuffer.release(b3);
		Collection<Map<String, List<Event>>> patterns4 = sharedBuffer.extractPatterns(b3, DeweyNumber.fromString("1.1.0"));

		Collection<Map<String, List<Event>>> patterns1 = sharedBuffer.extractPatterns(b1, DeweyNumber.fromString("2.0.0"));
		Collection<Map<String, List<Event>>> patterns2 = sharedBuffer.extractPatterns(b0, DeweyNumber.fromString("1.0.0"));
		sharedBuffer.release(b0);
		sharedBuffer.release(b1);

		for (long eventId : eventIds) {
			sharedBuffer.releaseEvent(eventId);
		}

		assertEquals(1L, patterns3.size());
		assertEquals(0L, patterns4.size());
		assertEquals(1L, patterns1.size());
		assertEquals(1L, patterns2.size());

		assertTrue(sharedBuffer.isEmpty());
		assertTrue(patterns4.isEmpty());
		assertEquals(Collections.singletonList(expectedPattern1), patterns1);
		assertEquals(Collections.singletonList(expectedPattern2), patterns2);
		assertEquals(Collections.singletonList(expectedPattern3), patterns3);
	}

	@Test
	public void testClearingSharedBufferWithMultipleEdgesBetweenEntries() throws Exception {
		SharedBuffer<Event> sharedBuffer = TestSharedBuffer.createTestBuffer(Event.createTypeSerializer());
		int numberEvents = 8;
		Event[] events = new Event[numberEvents];
		long[] eventIds = new long[numberEvents];
		final long timestamp = 1L;

		for (int i = 0; i < numberEvents; i++) {
			events[i] = new Event(i + 1, "e" + (i + 1), i);
			eventIds[i] = sharedBuffer.registerEvent(events[i]);
		}

		NodeId start = sharedBuffer.put("start", eventIds[1], timestamp, DeweyNumber.fromString("1"));
		NodeId b0 = sharedBuffer.put("branching", eventIds[2], timestamp, start, DeweyNumber.fromString("1.0"));
		NodeId b1 = sharedBuffer.put("branching", eventIds[3], timestamp, start, DeweyNumber.fromString("1.1"));
		NodeId b00 = sharedBuffer.put("branching", eventIds[3], timestamp, b0, DeweyNumber.fromString("1.0.0"));
		sharedBuffer.put("branching", eventIds[4], timestamp, b00, DeweyNumber.fromString("1.0.0.0"));
		NodeId b10 = sharedBuffer.put("branching", eventIds[4], timestamp, b1, DeweyNumber.fromString("1.1.0"));

		//simulate IGNORE (next event can point to events[2])
		sharedBuffer.lock(b0);

		sharedBuffer.release(b10);

		for (long eventId : eventIds) {
			sharedBuffer.releaseEvent(eventId);
		}

		//There should be still events[1] and events[2] in the buffer
		assertFalse(sharedBuffer.isEmpty());
	}

	@Test
	public void testSharedBufferExtractOrder() throws Exception {
		SharedBuffer<Event> sharedBuffer = TestSharedBuffer.createTestBuffer(Event.createTypeSerializer());
		int numberEvents = 5;
		Event[] events = new Event[numberEvents];
		long[] eventIds = new long[numberEvents];
		final long timestamp = 1L;

		for (int i = 0; i < numberEvents; i++) {
			events[i] = new Event(i + 1, "e" + (i + 1), i);
			eventIds[i] = sharedBuffer.registerEvent(events[i]);
		}

		Map<String, List<Event>> expectedResult = new LinkedHashMap<>();
		expectedResult.put("a", new ArrayList<>());
		expectedResult.get("a").add(events[0]);
		expectedResult.put("b", new ArrayList<>());
		expectedResult.get("b").add(events[1]);
		expectedResult.put("aa", new ArrayList<>());
		expectedResult.get("aa").add(events[2]);
		expectedResult.put("bb", new ArrayList<>());
		expectedResult.get("bb").add(events[3]);
		expectedResult.put("c", new ArrayList<>());
		expectedResult.get("c").add(events[4]);

		NodeId a = sharedBuffer.put("a", eventIds[0], timestamp, DeweyNumber.fromString("1"));
		NodeId b = sharedBuffer.put("b", eventIds[1], timestamp, a, DeweyNumber.fromString("1.0"));
		NodeId aa = sharedBuffer.put("aa", eventIds[2], timestamp, b, DeweyNumber.fromString("1.0.0"));
		NodeId bb = sharedBuffer.put("bb", eventIds[3], timestamp, aa, DeweyNumber.fromString("1.0.0.0"));
		NodeId c = sharedBuffer.put("c", eventIds[4], timestamp, bb, DeweyNumber.fromString("1.0.0.0.0"));

		Collection<Map<String, List<Event>>> patternsResult = sharedBuffer.extractPatterns(c, DeweyNumber.fromString("1.0.0.0.0"));

		List<String> expectedOrder = new ArrayList<>();
		expectedOrder.add("a");
		expectedOrder.add("b");
		expectedOrder.add("aa");
		expectedOrder.add("bb");
		expectedOrder.add("c");

		for (long eventId : eventIds) {
			sharedBuffer.releaseEvent(eventId);
		}

		List<String> resultOrder = new ArrayList<>(patternsResult.iterator().next().keySet());
		assertEquals(expectedOrder, resultOrder);
	}


}

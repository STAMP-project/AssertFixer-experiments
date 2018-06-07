/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.streaming.runtime.tasks;

import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.metrics.Gauge;
import org.apache.flink.runtime.checkpoint.CheckpointOptions;
import org.apache.flink.runtime.io.network.api.CancelCheckpointMarker;
import org.apache.flink.runtime.io.network.api.CheckpointBarrier;
import org.apache.flink.runtime.jobgraph.OperatorID;
import org.apache.flink.runtime.metrics.MetricNames;
import org.apache.flink.runtime.metrics.groups.OperatorMetricGroup;
import org.apache.flink.runtime.metrics.groups.TaskMetricGroup;
import org.apache.flink.runtime.metrics.groups.UnregisteredMetricGroups;
import org.apache.flink.runtime.metrics.util.InterceptingOperatorMetricGroup;
import org.apache.flink.runtime.operators.testutils.MockInputSplitProvider;
import org.apache.flink.runtime.state.TestTaskStateManager;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;
import org.apache.flink.streaming.api.functions.co.RichCoMapFunction;
import org.apache.flink.streaming.api.graph.StreamConfig;
import org.apache.flink.streaming.api.operators.co.CoStreamMap;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.streaming.runtime.streamrecord.StreamRecord;
import org.apache.flink.streaming.runtime.streamstatus.StreamStatus;
import org.apache.flink.streaming.util.TestHarnessUtil;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Tests for {@link org.apache.flink.streaming.runtime.tasks.TwoInputStreamTask}. Theses tests
 * implicitly also test the {@link org.apache.flink.streaming.runtime.io.StreamTwoInputProcessor}.
 *
 * <p>Note:<br>
 * We only use a {@link CoStreamMap} operator here. We also test the individual operators but Map is
 * used as a representative to test TwoInputStreamTask, since TwoInputStreamTask is used for all
 * TwoInputStreamOperators.
 */
public class TwoInputStreamTaskTest {

	/**
	 * This test verifies that open() and close() are correctly called. This test also verifies
	 * that timestamps of emitted elements are correct. {@link CoStreamMap} assigns the input
	 * timestamp to emitted elements.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testOpenCloseAndTimestamps() throws Exception {
		final TwoInputStreamTaskTestHarness<String, Integer, String> testHarness =
				new TwoInputStreamTaskTestHarness<>(
						TwoInputStreamTask::new,
						BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO);
		testHarness.setupOutputForSingletonOperatorChain();

		StreamConfig streamConfig = testHarness.getStreamConfig();
		CoStreamMap<String, Integer, String> coMapOperator = new CoStreamMap<String, Integer, String>(new TestOpenCloseMapFunction());
		streamConfig.setStreamOperator(coMapOperator);
		streamConfig.setOperatorID(new OperatorID());

		long initialTime = 0L;
		ConcurrentLinkedQueue<Object> expectedOutput = new ConcurrentLinkedQueue<Object>();

		testHarness.invoke();
		testHarness.waitForTaskRunning();

		testHarness.processElement(new StreamRecord<String>("Hello", initialTime + 1), 0, 0);
		expectedOutput.add(new StreamRecord<String>("Hello", initialTime + 1));

		// wait until the input is processed to ensure ordering of the output
		testHarness.waitForInputProcessing();

		testHarness.processElement(new StreamRecord<Integer>(1337, initialTime + 2), 1, 0);

		expectedOutput.add(new StreamRecord<String>("1337", initialTime + 2));

		testHarness.endInput();

		testHarness.waitForTaskCompletion();

		Assert.assertTrue("RichFunction methods where not called.", TestOpenCloseMapFunction.closeCalled);

		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());
	}

	/**
	 * This test verifies that watermarks and stream statuses are correctly forwarded. This also checks whether
	 * watermarks are forwarded only when we have received watermarks from all inputs. The
	 * forwarded watermark must be the minimum of the watermarks of all active inputs.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testWatermarkAndStreamStatusForwarding() throws Exception {

		final TwoInputStreamTaskTestHarness<String, Integer, String> testHarness =
			new TwoInputStreamTaskTestHarness<String, Integer, String>(
				TwoInputStreamTask::new,
				2, 2, new int[] {1, 2},
				BasicTypeInfo.STRING_TYPE_INFO,
				BasicTypeInfo.INT_TYPE_INFO,
				BasicTypeInfo.STRING_TYPE_INFO);
		testHarness.setupOutputForSingletonOperatorChain();

		StreamConfig streamConfig = testHarness.getStreamConfig();
		CoStreamMap<String, Integer, String> coMapOperator = new CoStreamMap<String, Integer, String>(new IdentityMap());
		streamConfig.setStreamOperator(coMapOperator);
		streamConfig.setOperatorID(new OperatorID());

		ConcurrentLinkedQueue<Object> expectedOutput = new ConcurrentLinkedQueue<Object>();
		long initialTime = 0L;

		testHarness.invoke();
		testHarness.waitForTaskRunning();

		testHarness.processElement(new Watermark(initialTime), 0, 0);
		testHarness.processElement(new Watermark(initialTime), 0, 1);

		testHarness.processElement(new Watermark(initialTime), 1, 0);

		// now the output should still be empty
		testHarness.waitForInputProcessing();
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		testHarness.processElement(new Watermark(initialTime), 1, 1);

		// now the watermark should have propagated, Map simply forward Watermarks
		testHarness.waitForInputProcessing();
		expectedOutput.add(new Watermark(initialTime));
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		// contrary to checkpoint barriers these elements are not blocked by watermarks
		testHarness.processElement(new StreamRecord<String>("Hello", initialTime), 0, 0);
		testHarness.processElement(new StreamRecord<Integer>(42, initialTime), 1, 1);
		expectedOutput.add(new StreamRecord<String>("Hello", initialTime));
		expectedOutput.add(new StreamRecord<String>("42", initialTime));

		testHarness.waitForInputProcessing();
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		testHarness.processElement(new Watermark(initialTime + 4), 0, 0);
		testHarness.processElement(new Watermark(initialTime + 3), 0, 1);
		testHarness.processElement(new Watermark(initialTime + 3), 1, 0);
		testHarness.processElement(new Watermark(initialTime + 2), 1, 1);

		// check whether we get the minimum of all the watermarks, this must also only occur in
		// the output after the two StreamRecords
		expectedOutput.add(new Watermark(initialTime + 2));
		testHarness.waitForInputProcessing();
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		// advance watermark from one of the inputs, now we should get a new one since the
		// minimum increases
		testHarness.processElement(new Watermark(initialTime + 4), 1, 1);
		testHarness.waitForInputProcessing();
		expectedOutput.add(new Watermark(initialTime + 3));
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		// advance the other two inputs, now we should get a new one since the
		// minimum increases again
		testHarness.processElement(new Watermark(initialTime + 4), 0, 1);
		testHarness.processElement(new Watermark(initialTime + 4), 1, 0);
		testHarness.waitForInputProcessing();
		expectedOutput.add(new Watermark(initialTime + 4));
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		// test whether idle input channels are acknowledged correctly when forwarding watermarks
		testHarness.processElement(StreamStatus.IDLE, 0, 1);
		testHarness.processElement(StreamStatus.IDLE, 1, 0);
		testHarness.processElement(new Watermark(initialTime + 6), 0, 0);
		testHarness.processElement(new Watermark(initialTime + 5), 1, 1); // this watermark should be advanced first
		testHarness.processElement(StreamStatus.IDLE, 1, 1); // once this is acknowledged,
		                                                     // watermark (initial + 6) should be forwarded
		testHarness.waitForInputProcessing();
		expectedOutput.add(new Watermark(initialTime + 5));
		// We don't expect to see Watermark(6) here because the idle status of one
		// input doesn't propagate to the other input. That is, if input 1 is at WM 6 and input
		// two was at WM 5 before going to IDLE then the output watermark will not jump to WM 6.
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		// make all input channels idle and check that the operator's idle status is forwarded
		testHarness.processElement(StreamStatus.IDLE, 0, 0);
		testHarness.waitForInputProcessing();
		expectedOutput.add(StreamStatus.IDLE);
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		// make some input channels active again and check that the operator's active status is forwarded only once
		testHarness.processElement(StreamStatus.ACTIVE, 1, 0);
		testHarness.processElement(StreamStatus.ACTIVE, 0, 1);
		testHarness.waitForInputProcessing();
		expectedOutput.add(StreamStatus.ACTIVE);
		TestHarnessUtil.assertOutputEquals("Output was not correct.", expectedOutput, testHarness.getOutput());

		testHarness.endInput();

		testHarness.waitForTaskCompletion();

		List<String> resultElements = TestHarnessUtil.getRawElementsFromOutput(testHarness.getOutput());
		Assert.assertEquals(2, resultElements.size());
	}

	/**
	 * This test verifies that checkpoint barriers are correctly forwarded.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testCheckpointBarriers() throws Exception {
		final TwoInputStreamTaskTestHarness<String, Integer, String> testHarness =
				new TwoInputStreamTaskTestHarness<String, Integer, String>(
						TwoInputStreamTask::new,
						2, 2, new int[] {1, 2},
						BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO);
		testHarness.setupOutputForSingletonOperatorChain();

		StreamConfig streamConfig = testHarness.getStreamConfig();
		CoStreamMap<String, Integer, String> coMapOperator = new CoStreamMap<String, Integer, String>(new IdentityMap());
		streamConfig.setStreamOperator(coMapOperator);
		streamConfig.setOperatorID(new OperatorID());

		ConcurrentLinkedQueue<Object> expectedOutput = new ConcurrentLinkedQueue<Object>();
		long initialTime = 0L;

		testHarness.invoke();
		testHarness.waitForTaskRunning();

		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 0, 0);

		// This element should be buffered since we received a checkpoint barrier on
		// this input
		testHarness.processElement(new StreamRecord<String>("Hello-0-0", initialTime), 0, 0);

		// This one should go through
		testHarness.processElement(new StreamRecord<String>("Ciao-0-0", initialTime), 0, 1);
		expectedOutput.add(new StreamRecord<String>("Ciao-0-0", initialTime));

		testHarness.waitForInputProcessing();

		// These elements should be forwarded, since we did not yet receive a checkpoint barrier
		// on that input, only add to same input, otherwise we would not know the ordering
		// of the output since the Task might read the inputs in any order
		testHarness.processElement(new StreamRecord<Integer>(11, initialTime), 1, 1);
		testHarness.processElement(new StreamRecord<Integer>(111, initialTime), 1, 1);
		expectedOutput.add(new StreamRecord<String>("11", initialTime));
		expectedOutput.add(new StreamRecord<String>("111", initialTime));

		testHarness.waitForInputProcessing();

		// Wait to allow input to end up in the output.
		// TODO Use count down latches instead as a cleaner solution
		for (int i = 0; i < 20; ++i) {
			if (testHarness.getOutput().size() >= expectedOutput.size()) {
				break;
			} else {
				Thread.sleep(100);
			}
		}

		// we should not yet see the barrier, only the two elements from non-blocked input
		TestHarnessUtil.assertOutputEquals("Output was not correct.",
			expectedOutput,
			testHarness.getOutput());

		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 0, 1);
		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 1, 0);
		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 1, 1);

		testHarness.waitForInputProcessing();
		testHarness.endInput();
		testHarness.waitForTaskCompletion();

		// now we should see the barrier and after that the buffered elements
		expectedOutput.add(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()));
		expectedOutput.add(new StreamRecord<String>("Hello-0-0", initialTime));

		TestHarnessUtil.assertOutputEquals("Output was not correct.",
				expectedOutput,
				testHarness.getOutput());

		List<String> resultElements = TestHarnessUtil.getRawElementsFromOutput(testHarness.getOutput());
		Assert.assertEquals(4, resultElements.size());
	}

	/**
	 * This test verifies that checkpoint barriers and barrier buffers work correctly with
	 * concurrent checkpoint barriers where one checkpoint is "overtaking" another checkpoint, i.e.
	 * some inputs receive barriers from an earlier checkpoint, thereby blocking,
	 * then all inputs receive barriers from a later checkpoint.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testOvertakingCheckpointBarriers() throws Exception {
		final TwoInputStreamTaskTestHarness<String, Integer, String> testHarness =
				new TwoInputStreamTaskTestHarness<>(
						TwoInputStreamTask::new,
						2, 2, new int[] {1, 2},
						BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO);

		testHarness.setupOutputForSingletonOperatorChain();

		StreamConfig streamConfig = testHarness.getStreamConfig();
		CoStreamMap<String, Integer, String> coMapOperator = new CoStreamMap<String, Integer, String>(new IdentityMap());
		streamConfig.setStreamOperator(coMapOperator);
		streamConfig.setOperatorID(new OperatorID());

		ConcurrentLinkedQueue<Object> expectedOutput = new ConcurrentLinkedQueue<Object>();
		long initialTime = 0L;

		testHarness.invoke();
		testHarness.waitForTaskRunning();

		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 0, 0);

		// These elements should be buffered until we receive barriers from
		// all inputs
		testHarness.processElement(new StreamRecord<String>("Hello-0-0", initialTime), 0, 0);
		testHarness.processElement(new StreamRecord<String>("Ciao-0-0", initialTime), 0, 0);

		// These elements should be forwarded, since we did not yet receive a checkpoint barrier
		// on that input, only add to same input, otherwise we would not know the ordering
		// of the output since the Task might read the inputs in any order
		testHarness.processElement(new StreamRecord<Integer>(42, initialTime), 1, 1);
		testHarness.processElement(new StreamRecord<Integer>(1337, initialTime), 1, 1);
		expectedOutput.add(new StreamRecord<String>("42", initialTime));
		expectedOutput.add(new StreamRecord<String>("1337", initialTime));

		testHarness.waitForInputProcessing();
		// we should not yet see the barrier, only the two elements from non-blocked input
		TestHarnessUtil.assertOutputEquals("Output was not correct.",
				expectedOutput,
				testHarness.getOutput());

		// Now give a later barrier to all inputs, this should unblock the first channel,
		// thereby allowing the two blocked elements through
		testHarness.processEvent(new CheckpointBarrier(1, 1, CheckpointOptions.forCheckpointWithDefaultLocation()), 0, 0);
		testHarness.processEvent(new CheckpointBarrier(1, 1, CheckpointOptions.forCheckpointWithDefaultLocation()), 0, 1);
		testHarness.processEvent(new CheckpointBarrier(1, 1, CheckpointOptions.forCheckpointWithDefaultLocation()), 1, 0);
		testHarness.processEvent(new CheckpointBarrier(1, 1, CheckpointOptions.forCheckpointWithDefaultLocation()), 1, 1);

		expectedOutput.add(new CancelCheckpointMarker(0));
		expectedOutput.add(new StreamRecord<String>("Hello-0-0", initialTime));
		expectedOutput.add(new StreamRecord<String>("Ciao-0-0", initialTime));
		expectedOutput.add(new CheckpointBarrier(1, 1, CheckpointOptions.forCheckpointWithDefaultLocation()));

		testHarness.waitForInputProcessing();

		TestHarnessUtil.assertOutputEquals("Output was not correct.",
				expectedOutput,
				testHarness.getOutput());

		// Then give the earlier barrier, these should be ignored
		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 0, 1);
		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 1, 0);
		testHarness.processEvent(new CheckpointBarrier(0, 0, CheckpointOptions.forCheckpointWithDefaultLocation()), 1, 1);

		testHarness.waitForInputProcessing();

		testHarness.endInput();

		testHarness.waitForTaskCompletion();

		TestHarnessUtil.assertOutputEquals("Output was not correct.",
				expectedOutput,
				testHarness.getOutput());
	}

	@Test
	public void testWatermarkMetrics() throws Exception {
		final TwoInputStreamTaskTestHarness<String, Integer, String> testHarness = new TwoInputStreamTaskTestHarness<>(TwoInputStreamTask::new, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO);

		CoStreamMap<String, Integer, String> headOperator = new CoStreamMap<>(new IdentityMap());
		final OperatorID headOperatorId = new OperatorID();

		OneInputStreamTaskTest.WatermarkMetricOperator chainedOperator = new OneInputStreamTaskTest.WatermarkMetricOperator();
		OperatorID chainedOperatorId = new OperatorID();

		testHarness.setupOperatorChain(headOperatorId, headOperator)
			.chain(chainedOperatorId, chainedOperator, BasicTypeInfo.STRING_TYPE_INFO.createSerializer(new ExecutionConfig()))
			.finish();

		InterceptingOperatorMetricGroup headOperatorMetricGroup = new InterceptingOperatorMetricGroup();
		InterceptingOperatorMetricGroup chainedOperatorMetricGroup = new InterceptingOperatorMetricGroup();
		TaskMetricGroup taskMetricGroup = new UnregisteredMetricGroups.UnregisteredTaskMetricGroup() {
			@Override
			public OperatorMetricGroup addOperator(OperatorID id, String name) {
				if (id.equals(headOperatorId)) {
					return headOperatorMetricGroup;
				} else if (id.equals(chainedOperatorId)) {
					return chainedOperatorMetricGroup;
				} else {
					return super.addOperator(id, name);
				}
			}
		};

		StreamMockEnvironment env = new StreamMockEnvironment(
			testHarness.jobConfig, testHarness.taskConfig, testHarness.memorySize, new MockInputSplitProvider(), testHarness.bufferSize, new TestTaskStateManager()) {
			@Override
			public TaskMetricGroup getMetricGroup() {
				return taskMetricGroup;
			}
		};

		testHarness.invoke(env);
		testHarness.waitForTaskRunning();

		Gauge<Long> headInput1WatermarkGauge = (Gauge<Long>) headOperatorMetricGroup.get(MetricNames.IO_CURRENT_INPUT_1_WATERMARK);
		Gauge<Long> headInput2WatermarkGauge = (Gauge<Long>) headOperatorMetricGroup.get(MetricNames.IO_CURRENT_INPUT_2_WATERMARK);
		Gauge<Long> headInputWatermarkGauge = (Gauge<Long>) headOperatorMetricGroup.get(MetricNames.IO_CURRENT_INPUT_WATERMARK);
		Gauge<Long> headOutputWatermarkGauge = (Gauge<Long>) headOperatorMetricGroup.get(MetricNames.IO_CURRENT_OUTPUT_WATERMARK);
		Gauge<Long> chainedInputWatermarkGauge = (Gauge<Long>) chainedOperatorMetricGroup.get(MetricNames.IO_CURRENT_INPUT_WATERMARK);
		Gauge<Long> chainedOutputWatermarkGauge = (Gauge<Long>) chainedOperatorMetricGroup.get(MetricNames.IO_CURRENT_OUTPUT_WATERMARK);

		Assert.assertEquals(Long.MIN_VALUE, headInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, headInput1WatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, headInput2WatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, headOutputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, chainedInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, chainedOutputWatermarkGauge.getValue().longValue());

		testHarness.processElement(new Watermark(1L), 0, 0);
		testHarness.waitForInputProcessing();
		Assert.assertEquals(Long.MIN_VALUE, headInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(1L, headInput1WatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, headInput2WatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, headOutputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, chainedInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(Long.MIN_VALUE, chainedOutputWatermarkGauge.getValue().longValue());

		testHarness.processElement(new Watermark(2L), 1, 0);
		testHarness.waitForInputProcessing();
		Assert.assertEquals(1L, headInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(1L, headInput1WatermarkGauge.getValue().longValue());
		Assert.assertEquals(2L, headInput2WatermarkGauge.getValue().longValue());
		Assert.assertEquals(1L, headOutputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(1L, chainedInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(2L, chainedOutputWatermarkGauge.getValue().longValue());

		testHarness.processElement(new Watermark(3L), 0, 0);
		testHarness.waitForInputProcessing();
		Assert.assertEquals(2L, headInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(3L, headInput1WatermarkGauge.getValue().longValue());
		Assert.assertEquals(2L, headInput2WatermarkGauge.getValue().longValue());
		Assert.assertEquals(2L, headOutputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(2L, chainedInputWatermarkGauge.getValue().longValue());
		Assert.assertEquals(4L, chainedOutputWatermarkGauge.getValue().longValue());

		testHarness.endInput();
		testHarness.waitForTaskCompletion();
	}

	// This must only be used in one test, otherwise the static fields will be changed
	// by several tests concurrently
	private static class TestOpenCloseMapFunction extends RichCoMapFunction<String, Integer, String> {
		private static final long serialVersionUID = 1L;

		public static boolean openCalled = false;
		public static boolean closeCalled = false;

		@Override
		public void open(Configuration parameters) throws Exception {
			super.open(parameters);
			if (closeCalled) {
				Assert.fail("Close called before open.");
			}
			openCalled = true;
		}

		@Override
		public void close() throws Exception {
			super.close();
			if (!openCalled) {
				Assert.fail("Open was not called before close.");
			}
			closeCalled = true;
		}

		@Override
		public String map1(String value) throws Exception {
			if (!openCalled) {
				Assert.fail("Open was not called before run.");
			}
			return value;
		}

		@Override
		public String map2(Integer value) throws Exception {
			if (!openCalled) {
				Assert.fail("Open was not called before run.");
			}
			return value.toString();
		}
	}

	private static class IdentityMap implements CoMapFunction<String, Integer, String> {
		private static final long serialVersionUID = 1L;

		@Override
		public String map1(String value) throws Exception {
			return value;
		}

		@Override
		public String map2(Integer value) throws Exception {

			return value.toString();
		}
	}
}


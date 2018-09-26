/*
 * Copyright (c) 2015-2018, David A. Bauer. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package actor4j.core;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.jctools.queues.MpscArrayQueue;
import org.jctools.queues.MpscLinkedQueue8;

import actor4j.core.messages.ActorMessage;

public class XActorThread extends ActorThread {
	protected Queue<ActorMessage<?>> directiveQueue;
	protected Queue<ActorMessage<?>> priorityQueue;
	protected Queue<ActorMessage<?>> innerQueueL2;
	protected Queue<ActorMessage<?>> innerQueueL1;
	protected Queue<ActorMessage<?>> outerQueueL2B;
	protected Queue<ActorMessage<?>> outerQueueL2A;
	protected Queue<ActorMessage<?>> outerQueueL1;
	protected Queue<ActorMessage<?>> serverQueueL2;
	protected Queue<ActorMessage<?>> serverQueueL1;
	
	protected AtomicBoolean antiFloodingEnabled;
	
	protected AtomicBoolean newMessage;
	
	public XActorThread(ActorSystemImpl system) {
		super(system);
		
		directiveQueue = new MpscArrayQueue<>(system.getQueueSize());
		priorityQueue  = new PriorityBlockingQueue<>(system.getQueueSize());
		serverQueueL2  = new MpscArrayQueue<>(system.getQueueSize());
		serverQueueL1  = new ArrayDeque<>(system.getBufferQueueSize());
		outerQueueL2B  = new MpscLinkedQueue8<>(); 
		outerQueueL2A  = new MpscArrayQueue<>(system.getQueueSize());
		outerQueueL1   = new ArrayDeque<>(system.getBufferQueueSize());
		innerQueueL2   = new LinkedList<>();
		innerQueueL1   = new CircularFifoQueue<>(system.getQueueSize());
		
		antiFloodingEnabled = new AtomicBoolean(false);
		
		newMessage = new AtomicBoolean(true);
	}
	
	public void innerQueue(ActorMessage<?> message) {
		if ((((CircularFifoQueue<ActorMessage<?>>)innerQueueL1).isAtFullCapacity() || !innerQueueL2.isEmpty()) && !antiFloodingEnabled.get())
			innerQueueL2.offer(message);
		else
			innerQueueL1.offer(message);
	}
	
	public void outerQueue(ActorMessage<?> message) {
		if ((((MpscArrayQueue<ActorMessage<?>>)outerQueueL2A).size()==system.getQueueSize() || !outerQueueL2B.isEmpty()) && !antiFloodingEnabled.get())
			outerQueueL2B.offer(message);
		else
			outerQueueL2A.offer(message);
	}
	
	@Override
	public void onRun() {
		boolean hasNextDirective;
		boolean hasNextPriority;
		int hasNextServer;
		int hasNextOuter;
		int hasNextInner;
		int idle = 0;
		
		while (!isInterrupted()) {
			hasNextDirective = false;
			hasNextPriority  = false;
			hasNextServer    = 0;
			hasNextOuter     = 0;
			hasNextInner     = 0;
			
			while (poll(directiveQueue)) 
				hasNextDirective=true;
			
			while (poll(priorityQueue)) 
				hasNextPriority=true;
			
			if (system.clientMode) {
				for (; hasNextServer<system.throughput && poll(serverQueueL1); hasNextServer++);
				if (hasNextServer<system.throughput && serverQueueL2.peek()!=null) {
					ActorMessage<?> message = null;
					for (int j=0; j<system.getBufferQueueSize() && (message=serverQueueL2.poll())!=null; j++)
						serverQueueL1.offer(message);
				
					for (; hasNextServer<system.throughput && poll(serverQueueL1); hasNextServer++);
				}
			}
			
			for (; hasNextOuter<system.throughput && poll(outerQueueL1); hasNextOuter++);
			if (hasNextOuter<system.throughput && outerQueueL2A.peek()!=null) {
				ActorMessage<?> message = null;
				for (int j=0; j<system.getBufferQueueSize() && (message=outerQueueL2A.poll())!=null; j++)
					outerQueueL1.offer(message);

				for (; hasNextOuter<system.throughput && poll(outerQueueL1); hasNextOuter++);
			}
			if (hasNextOuter<system.throughput && outerQueueL2B.peek()!=null) {
				ActorMessage<?> message = null;
				for (int j=0; j<system.getBufferQueueSize() && (message=outerQueueL2B.poll())!=null; j++)
					outerQueueL1.offer(message);

				for (; hasNextOuter<system.throughput && poll(outerQueueL1); hasNextOuter++);
			}
			
			for (; hasNextInner<system.throughput && poll(innerQueueL1); hasNextInner++);
			if (hasNextInner<system.throughput && innerQueueL2.peek()!=null) {
				ActorMessage<?> message = null;
				for (int j=0; j<system.getQueueSize() && (message=innerQueueL2.poll())!=null; j++)
					innerQueueL1.offer(message);

				for (; hasNextInner<system.throughput && poll(innerQueueL1); hasNextInner++);
			}
			
			if (hasNextInner==0 && hasNextOuter==0 && hasNextServer==0 && !hasNextPriority && !hasNextDirective) {
				idle++;
				if (idle>system.idle) {
					idle = 0;
					if (system.threadMode==ActorThreadMode.PARK) {
						if (newMessage.compareAndSet(true, false))
							LockSupport.park(this);
					}
					else if (system.threadMode==ActorThreadMode.SLEEP) {
						try {
							sleep(system.sleepTime);
						} catch (InterruptedException e) {
							interrupt();
						}
					}
					else
						yield();
				}
			}
			else
				idle = 0;
		}		
	}
	
	protected void newMessage() {
		if (system.threadMode==ActorThreadMode.PARK && newMessage.compareAndSet(false, true))
			LockSupport.unpark(this);
	}
	
	public Queue<ActorMessage<?>> getDirectiveQueue() {
		return directiveQueue;
	}
	
	public Queue<ActorMessage<?>> getPriorityQueue() {
		return priorityQueue;
	}

	public Queue<ActorMessage<?>> getInnerQueue() {
		return innerQueueL1;
	}
	
	public Queue<ActorMessage<?>> getOuterQueue() {
		return outerQueueL2A;
	}
	
	public Queue<ActorMessage<?>> getServerQueue() {
		return serverQueueL2;
	}
}

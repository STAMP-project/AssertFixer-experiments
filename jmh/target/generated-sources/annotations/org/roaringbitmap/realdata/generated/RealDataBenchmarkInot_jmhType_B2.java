package org.roaringbitmap.realdata.generated;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
public class RealDataBenchmarkInot_jmhType_B2 extends RealDataBenchmarkInot_jmhType_B1 {
    public volatile int setupTrialMutex;
    public volatile int tearTrialMutex;
    public final static AtomicIntegerFieldUpdater<RealDataBenchmarkInot_jmhType_B2> setupTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(RealDataBenchmarkInot_jmhType_B2.class, "setupTrialMutex");
    public final static AtomicIntegerFieldUpdater<RealDataBenchmarkInot_jmhType_B2> tearTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(RealDataBenchmarkInot_jmhType_B2.class, "tearTrialMutex");

    public volatile int setupIterationMutex;
    public volatile int tearIterationMutex;
    public final static AtomicIntegerFieldUpdater<RealDataBenchmarkInot_jmhType_B2> setupIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(RealDataBenchmarkInot_jmhType_B2.class, "setupIterationMutex");
    public final static AtomicIntegerFieldUpdater<RealDataBenchmarkInot_jmhType_B2> tearIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(RealDataBenchmarkInot_jmhType_B2.class, "tearIterationMutex");

    public volatile int setupInvocationMutex;
    public volatile int tearInvocationMutex;
    public final static AtomicIntegerFieldUpdater<RealDataBenchmarkInot_jmhType_B2> setupInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(RealDataBenchmarkInot_jmhType_B2.class, "setupInvocationMutex");
    public final static AtomicIntegerFieldUpdater<RealDataBenchmarkInot_jmhType_B2> tearInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(RealDataBenchmarkInot_jmhType_B2.class, "tearInvocationMutex");

}

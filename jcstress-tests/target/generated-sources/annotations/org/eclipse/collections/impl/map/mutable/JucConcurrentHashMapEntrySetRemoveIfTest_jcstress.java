package org.eclipse.collections.impl.map.mutable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.openjdk.jcstress.infra.runners.TestConfig;
import org.openjdk.jcstress.infra.collectors.TestResultCollector;
import org.openjdk.jcstress.infra.runners.Runner;
import org.openjdk.jcstress.infra.runners.StateHolder;
import org.openjdk.jcstress.util.Counter;
import org.openjdk.jcstress.vm.WhiteBoxSupport;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.Collections;
import java.util.List;
import org.eclipse.collections.impl.map.mutable.JucConcurrentHashMapEntrySetRemoveIfTest;
import org.openjdk.jcstress.infra.results.Z_Result_jcstress;

public class JucConcurrentHashMapEntrySetRemoveIfTest_jcstress extends Runner<Z_Result_jcstress> {

    volatile StateHolder<JucConcurrentHashMapEntrySetRemoveIfTest, Z_Result_jcstress> version;

    public JucConcurrentHashMapEntrySetRemoveIfTest_jcstress(TestConfig config, TestResultCollector collector, ExecutorService pool) {
        super(config, collector, pool, "org.eclipse.collections.impl.map.mutable.JucConcurrentHashMapEntrySetRemoveIfTest");
    }

    @Override
    public Counter<Z_Result_jcstress> sanityCheck() throws Throwable {
        Counter<Z_Result_jcstress> counter = new Counter<>();
        sanityCheck_API(counter);
        sanityCheck_Footprints(counter);
        return counter;
    }

    private void sanityCheck_API(Counter<Z_Result_jcstress> counter) throws Throwable {
        final JucConcurrentHashMapEntrySetRemoveIfTest s = new JucConcurrentHashMapEntrySetRemoveIfTest();
        final Z_Result_jcstress r = new Z_Result_jcstress();
        Collection<Future<?>> res = new ArrayList<>();
        res.add(pool.submit(() -> s.setFoo()));
        res.add(pool.submit(() -> s.removeIf()));
        for (Future<?> f : res) {
            try {
                f.get();
            } catch (ExecutionException e) {
                throw e.getCause();
            }
        }
        try {
            pool.submit(() ->s.after(r)).get();
        } catch (ExecutionException e) {
            throw e.getCause();
        }
        counter.record(r);
    }

    private void sanityCheck_Footprints(Counter<Z_Result_jcstress> counter) throws Throwable {
        config.adjustStrides(size -> {
            version = new StateHolder<>(new JucConcurrentHashMapEntrySetRemoveIfTest[size], new Z_Result_jcstress[size], 2, config.spinLoopStyle);
            for (int c = 0; c < size; c++) {
                Z_Result_jcstress r = new Z_Result_jcstress();
                JucConcurrentHashMapEntrySetRemoveIfTest s = new JucConcurrentHashMapEntrySetRemoveIfTest();
                version.rs[c] = r;
                version.ss[c] = s;
                s.setFoo();
                s.removeIf();
                s.after(r);
                counter.record(r);
            }
        });
    }

    @Override
    public Counter<Z_Result_jcstress> internalRun() {
        version = new StateHolder<>(new JucConcurrentHashMapEntrySetRemoveIfTest[0], new Z_Result_jcstress[0], 2, config.spinLoopStyle);

        control.isStopped = false;

        List<Callable<Counter<Z_Result_jcstress>>> tasks = new ArrayList<>();
        tasks.add(this::setFoo);
        tasks.add(this::removeIf);
        Collections.shuffle(tasks);

        Collection<Future<Counter<Z_Result_jcstress>>> results = new ArrayList<>();
        for (Callable<Counter<Z_Result_jcstress>> task : tasks) {
            results.add(pool.submit(task));
        }

        try {
            TimeUnit.MILLISECONDS.sleep(config.time);
        } catch (InterruptedException e) {
        }

        control.isStopped = true;

        waitFor(results);

        Counter<Z_Result_jcstress> counter = new Counter<>();
        for (Future<Counter<Z_Result_jcstress>> f : results) {
            try {
                counter.merge(f.get());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        return counter;
    }

    public final void jcstress_consume(StateHolder<JucConcurrentHashMapEntrySetRemoveIfTest, Z_Result_jcstress> holder, Counter<Z_Result_jcstress> cnt, int a, int actors) {
        JucConcurrentHashMapEntrySetRemoveIfTest[] ss = holder.ss;
        Z_Result_jcstress[] rs = holder.rs;
        int len = ss.length;
        int left = a * len / actors;
        int right = (a + 1) * len / actors;
        for (int c = left; c < right; c++) {
            Z_Result_jcstress r = rs[c];
            JucConcurrentHashMapEntrySetRemoveIfTest s = ss[c];
            s.after(r);
            ss[c] = new JucConcurrentHashMapEntrySetRemoveIfTest();
            cnt.record(r);
            r.r1 = false;
        }
    }

    public final void jcstress_updateHolder(StateHolder<JucConcurrentHashMapEntrySetRemoveIfTest, Z_Result_jcstress> holder) {
        if (!holder.tryStartUpdate()) return;
        JucConcurrentHashMapEntrySetRemoveIfTest[] ss = holder.ss;
        Z_Result_jcstress[] rs = holder.rs;
        int len = ss.length;

        int newLen = holder.updateStride ? Math.max(config.minStride, Math.min(len * 2, config.maxStride)) : len;

        JucConcurrentHashMapEntrySetRemoveIfTest[] newS = ss;
        Z_Result_jcstress[] newR = rs;
        if (newLen > len) {
            newS = Arrays.copyOf(ss, newLen);
            newR = Arrays.copyOf(rs, newLen);
            for (int c = len; c < newLen; c++) {
                newR[c] = new Z_Result_jcstress();
                newS[c] = new JucConcurrentHashMapEntrySetRemoveIfTest();
            }
         }

        version = new StateHolder<>(control.isStopped, newS, newR, 2, config.spinLoopStyle);
        holder.finishUpdate();
   }

    public final Counter<Z_Result_jcstress> setFoo() {

        Counter<Z_Result_jcstress> counter = new Counter<>();
        while (true) {
            StateHolder<JucConcurrentHashMapEntrySetRemoveIfTest,Z_Result_jcstress> holder = version;
            if (holder.stopped) {
                return counter;
            }

            JucConcurrentHashMapEntrySetRemoveIfTest[] ss = holder.ss;
            Z_Result_jcstress[] rs = holder.rs;
            int size = ss.length;

            holder.preRun();

            for (int c = 0; c < size; c++) {
                JucConcurrentHashMapEntrySetRemoveIfTest s = ss[c];
                s.setFoo();
            }

            holder.postRun();

            jcstress_consume(holder, counter, 0, 2);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    public final Counter<Z_Result_jcstress> removeIf() {

        Counter<Z_Result_jcstress> counter = new Counter<>();
        while (true) {
            StateHolder<JucConcurrentHashMapEntrySetRemoveIfTest,Z_Result_jcstress> holder = version;
            if (holder.stopped) {
                return counter;
            }

            JucConcurrentHashMapEntrySetRemoveIfTest[] ss = holder.ss;
            Z_Result_jcstress[] rs = holder.rs;
            int size = ss.length;

            holder.preRun();

            for (int c = 0; c < size; c++) {
                JucConcurrentHashMapEntrySetRemoveIfTest s = ss[c];
                s.removeIf();
            }

            holder.postRun();

            jcstress_consume(holder, counter, 1, 2);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

}

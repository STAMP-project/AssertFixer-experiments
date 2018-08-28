package datawave.query.index.lookup;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import datawave.query.index.lookup.IndexStream.StreamContext;

import com.google.common.collect.Lists;

/**
 * Callable class that the executor will use to stand up the ScannerSessions
 *
 * We are not concerned about the threads in this pool as we are simply building a scanner session when we call hasnext, if records exist.
 */
public class ConcurrentScannerInitializer implements Callable<IndexStream> {
    
    private IndexStream stream;
    
    public ConcurrentScannerInitializer(IndexStream stream) {
        this.stream = stream;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public IndexStream call() throws Exception {
        if (stream.context() == StreamContext.INITIALIZED) {
            if (stream.hasNext()) {
                
                return ScannerStream.variable(stream, stream.currentNode());
            } else {
                return ScannerStream.noData(stream.currentNode());
            }
        } else {
            return stream;
            
        }
        
    }
    
    public static Collection<IndexStream> initializeScannerStreams(List<ConcurrentScannerInitializer> todo, ExecutorService executor) {
        
        List<Future<IndexStream>> futures;
        List<IndexStream> streams = Lists.newArrayList();
        try {
            futures = executor.invokeAll(todo);
            
            for (Future<IndexStream> future : futures) {
                Exception sawException = null;
                try {
                    IndexStream newStream = null;
                    
                    while (!executor.isShutdown()) {
                        try {
                            newStream = future.get(1, TimeUnit.SECONDS);
                            break;
                        } catch (TimeoutException e) {
                            
                        }
                    }
                    if (executor.isShutdown())
                        future.cancel(true);
                    if (newStream != null) {
                        streams.add(newStream);
                    }
                } catch (InterruptedException e) {
                    sawException = (Exception) e.getCause();
                } catch (ExecutionException e) {
                    sawException = (Exception) e.getCause();
                }
                
                if (null != sawException) {
                    throw new RuntimeException(sawException);
                }
            }
            
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            todo.clear();
        }
        
        return streams;
        
    }
    
}

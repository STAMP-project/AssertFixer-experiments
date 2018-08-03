package datawave.query.function;

import java.io.IOException;
import java.util.Map;

import org.apache.accumulo.core.iterators.IteratorEnvironment;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public interface SourcedFunction<A,B> extends com.google.common.base.Function<A,B> {
    /**
     * Initializes the iterator. Data should not be read from the source in this method.
     * 
     * @param source
     *            <tt>SortedKeyValueIterator</tt> source to read data from.
     * @param options
     *            <tt>Map</tt> map of string option names to option values.
     * @param env
     *            <tt>IteratorEnvironment</tt> environment in which iterator is being run.
     * @throws IOException
     *             unused.
     * @exception IllegalArgumentException
     *                if there are problems with the options.
     * @exception UnsupportedOperationException
     *                if not supported.
     */
    <K extends WritableComparable<?>,V extends Writable> void init(SortedKeyValueIterator<K,V> source, Map<String,String> options, IteratorEnvironment env)
                    throws IOException;
}

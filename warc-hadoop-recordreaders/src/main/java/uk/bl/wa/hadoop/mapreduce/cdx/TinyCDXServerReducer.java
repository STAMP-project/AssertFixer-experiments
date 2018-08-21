/**
 * 
 */
package uk.bl.wa.hadoop.mapreduce.cdx;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class TinyCDXServerReducer
 extends Reducer<Text, Text, Text, Text> {

    private static final Log log = LogFactory
            .getLog(TinyCDXServerReducer.class);

    private TinyCDXSender tcs;

    private long num_unique;
    private long num_lines;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.hadoop.mapreduce.Reducer#setup(org.apache.hadoop.mapreduce.
     * Reducer.Context)
     */
    @Override
    protected void setup(Reducer<Text, Text, Text, Text>.Context context)
            throws IOException, InterruptedException {
        super.setup(context);

        String endpoint = context.getConfiguration()
                .get("tinycdxserver.endpoint", "http://localhost:9090/test");
        log.warn("Sending to " + endpoint);
        int batch_size = context.getConfiguration()
                .getInt("tinycdxserver.batch_size", 10000);

        this.tcs = new TinyCDXSender(endpoint, batch_size);

        System.setProperty("http.proxyHost", "explorer-private");
        System.setProperty("http.proxyPort", "3127");

        num_unique = 0;
        num_lines = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.hadoop.mapreduce.Reducer#reduce(java.lang.Object,
     * java.lang.Iterable, org.apache.hadoop.mapreduce.Reducer.Context)
     */
    @Override
    protected void reduce(Text arg0, Iterable<Text> arg1,
            Reducer<Text, Text, Text, Text>.Context context)
                    throws IOException, InterruptedException {
        for (Text t : arg1) {
            tcs.add(t);
        }
        // If we're running in produciton context:
        if (context != null) {
            // Record progress:
            context.setStatus("Seen " + tcs.getTotalRecords()
                    + " records, sent " + tcs.getTotalSentRecords() + "...");
            // TODO Also pass to reducer output for cross-checking?
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.hadoop.mapreduce.Reducer#cleanup(org.apache.hadoop.mapreduce.
     * Reducer.Context)
     */
    @Override
    protected void cleanup(Reducer<Text, Text, Text, Text>.Context context)
            throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        super.cleanup(context);
        tcs.close();
        // Update status:
        if (context != null) {
            context.setStatus("Seen " + tcs.getTotalRecords()
                    + " records, sent " + tcs.getTotalSentRecords() + "...");
            // And send totals:
            context.write(new Text("NUM_LINES"), new Text("" + this.num_lines));
            context.write(new Text("NUM_UNIQUE_LINES"),
                    new Text("" + this.num_unique));
        }
    }

}

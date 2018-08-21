package uk.bl.wa.hadoop.outlinks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import uk.bl.wa.hadoop.ArchiveFileInputFormat;

@SuppressWarnings( "deprecation" )
public class OutlinkExtractor extends Configured implements Tool {

	public int run( String[] args ) throws IOException {
		JobConf conf = new JobConf( getConf(), OutlinkExtractor.class );

		String line = null;
		BufferedReader br = new BufferedReader( new FileReader( args[ 0 ] ) );
		while( ( line = br.readLine() ) != null ) {
			FileInputFormat.addInputPath( conf, new Path( line ) );
		}
		FileOutputFormat.setOutputPath( conf, new Path( args[ 1 ] ) );

		conf.setJobName( args[ 0 ] + "_" + System.currentTimeMillis() );
		conf.setInputFormat( ArchiveFileInputFormat.class );
		conf.setMapperClass( OutlinkExtractorMapper.class );
		conf.setReducerClass( FrequencyCountingReducer.class );
		conf.setOutputFormat( TextOutputFormat.class );

		conf.setOutputKeyClass( Text.class );
		conf.setOutputValueClass( Text.class );
//		JobClient.runJob( conf );
		new JobClient( conf ).submitJob( conf );
		return 0;
	}

	public static void main( String[] args ) throws Exception {
		if( args.length != 2 ) {
			System.out.println( "Need input file list and output dir!" );
			System.exit( 1 );

		}
		int ret = ToolRunner.run( new OutlinkExtractor(), args );
		System.exit( ret );
	}
}

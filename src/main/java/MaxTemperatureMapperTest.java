
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by HP1 on 4/15/2017.
 */
public class MaxTemperatureMapperTest {
	@Test
	public void parsesValidRecord() throws IOException, InterruptedException {
		Text value = new Text("0043011990999991950051518004+68750+023550FM-12+0382" +
		// Year ^^^^
				"99999V0203201N00261220001CN9999999N9-00111+99999999999");
		// Temperature ^^^^^
		new MapDriver<LongWritable, Text, Text, IntWritable>()
				.withMapper(new MaxTemperatureMapper())
				// OFFSET AND VALUE OF THAT LINE
				.withInput(new LongWritable(0), value)
				// TEST IT OUTPUT KEY EQUAL 1950 AND OUTPUT VALUE -11
				.withOutput(new Text("1950"), new IntWritable(-112)).runTest();
	}

}

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private NcdcRecordParser ncdc = new NcdcRecordParser();
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		
		System.out.println(line);
//		String year = line.substring(15, 19);
//		int airTemperature = Integer.parseInt(line.substring(87, 92));
		
		ncdc.parse(line);
		
		System.out.println(ncdc.getYear() + " ==> " + ncdc.getAirTemperature());
		context.write(new Text(ncdc.getYear()), new IntWritable(ncdc.getAirTemperature()));
	}
}
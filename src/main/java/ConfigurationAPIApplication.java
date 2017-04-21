

import org.apache.hadoop.conf.Configuration;

/**
 * Created by HP1 on 4/14/2017.
 */
public class ConfigurationAPIApplication {

    public static void main(String args[]){
        Configuration configuration = new Configuration();
        configuration.addResource("configuration-1.xml");
        configuration.addResource("configuration-2.xml");

        System.out.println(configuration.get("color"));
        System.out.println(configuration.get("size"));
        System.out.println(configuration.get("breadth", "wide"));

    }
}
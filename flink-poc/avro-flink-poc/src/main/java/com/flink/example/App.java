package com.flink.example;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.TableDescriptor;
import org.apache.flink.table.api.TableResult;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.api.Table;
/**
 * Hello world!      
 *
 */
public class App {
    public static void main( String[] args ) throws Exception
    {
        StreamExecutionEnvironment environment 
        = StreamExecutionEnvironment.createLocalEnvironment();

    StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(environment);
        
       TableResult table = streamTableEnvironment.executeSql("CREATE TEMPORARY TABLE demo_sql (\r\n`parameter` INT\r\n) WITH (\r\n  'connector' = 'kafka',\r\n  'topic' = 'test2',\r\n  'properties.bootstrap.servers' = 'localhost:9092',\r\n  'value.format' = 'avro-confluent',\r\n  'value.avro-confluent.url' = 'localhost:8082',\r\n'properties.auto.offset.reset'='earliest',\r\n'properties.group.id' = 'demo-id'\r\n)");

       Table userTable = streamTableEnvironment.from("demo_sql");
//       userTable.distinct().fetch(0).execute().print();
        userTable.distinct().execute().print();
       userTable.printSchema();
       environment.execute(); 

    }
}

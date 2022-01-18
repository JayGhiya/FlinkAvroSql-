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
        
        
       TableResult table = streamTableEnvironment.executeSql("CREATE TEMPORARY TABLE test1 (\r\n  `parameter` int,\r\n  `timestamp` TIMESTAMP(3) METADATA\r\n) WITH (\r\n  'connector' = 'kafka',\r\n  'topic' = 'test1',\r\n  'properties.bootstrap.servers' = 'localhost:9092',\r\n  'properties.group.id' = 'testGroup',\r\n 'properties.schema.registry.url' = 'http://127.0.0.1:8081',\r\n  'scan.startup.mode' = 'earliest-offset',\r\n  'format' = 'avro'\r\n)\r\n");

       Table userTable = streamTableEnvironment.from("test1");
       userTable.distinct().execute().print();
       
       userTable.printSchema();
       environment.execute(); 

    }
}

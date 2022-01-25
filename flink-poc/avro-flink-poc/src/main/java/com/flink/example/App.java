package com.flink.example;

import java.beans.Expression;

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
       StreamExecutionEnvironment environment = StreamExecutionEnvironment.createLocalEnvironment();

       StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(environment);
        
       //Source Table
       TableResult table = streamTableEnvironment.executeSql("CREATE TEMPORARY TABLE demo_sql (\r\n`A` INT,\r\n`B` INT,\r\n`C` INT\r\n) WITH (\r\n  'connector' = 'kafka',\r\n'scan.startup.mode' = 'earliest-offset',\r\n  'topic' = 'test2',\r\n  'properties.bootstrap.servers' = 'http://localhost:9092',\r\n  'value.format' = 'avro-confluent',\r\n  'value.avro-confluent.url' = 'http://localhost:8081',\r\n'properties.auto.offset.reset'='earliest',\r\n'properties.group.id' = 'demo-id'\r\n)");
    
       //Sink Table
       TableResult sinkTable = streamTableEnvironment.executeSql("CREATE TEMPORARY TABLE demo_sql_sink (\r\n`A` INT\r\n) WITH (\r\n  'connector' = 'kafka',\r\n  'topic' = 'test4',\r\n  'properties.bootstrap.servers' = 'http://localhost:9092',\r\n  'value.format' = 'avro-confluent',\r\n  'value.avro-confluent.url' = 'http://localhost:8081'\r\n)");
       
       Table userTable = streamTableEnvironment.from("demo_sql");
       
       Table sinkTable2 = streamTableEnvironment.from("demo_sql_sink");

       Table parameterAdata = userTable.select("A");
        
       System.out.println(parameterAdata.getResolvedSchema());
      // parameterAdata.distinct().execute().print();
       parameterAdata.executeInsert("demo_sql_sink").await();

       environment.execute();

    }
}

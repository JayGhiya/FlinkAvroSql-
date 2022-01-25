package com.schema.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.flink.schema.testSample;
import com.flink.schema.parameter;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.network.Send;
import org.apache.kafka.common.serialization.StringSerializer;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerializer;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;

/**
 * Hello world!
 *
 */
public class App 
{

    private testSample prepareObj()
    {
        return testSample.newBuilder().setA(10).setB(20).setC(30).build();
    }

    public void sendDataToTopic1(Map<String, Object> properties)
    {
        
        Producer<String, testSample> producer = new KafkaProducer<String, testSample>(properties);
        ProducerRecord<String,testSample> producerRecord = new ProducerRecord<String,testSample>("test2", "testKey",prepareObj()); 
        producer.send(producerRecord);
        producer.flush();
    }


    public void sendDataToTopic2(Map<String, Object> properties)
    {
        
        Producer<String, parameter> producer2 = new KafkaProducer<String, parameter>(properties);
        ProducerRecord<String,parameter> producerRecord = new ProducerRecord<String,parameter>("test4", "testKey",parameter.newBuilder().setA(10).build()); 
        producer2.send(producerRecord);
        producer2.flush();
    }

    public static void main( String[] args )
    {
        Map<String,Object> properties = new HashMap<String,Object>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,KafkaAvroSerializer.class.getName());
        properties.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,"http://localhost:8081");
        App app = new App();
        app.sendDataToTopic1(properties);
        app.sendDataToTopic2(properties);
    }
}

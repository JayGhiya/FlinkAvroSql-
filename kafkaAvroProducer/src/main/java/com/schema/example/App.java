package com.schema.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.flink.schema.sampleData;
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

    private sampleData prepareObj()
    {
        return sampleData.newBuilder().setParameter(10).build();
    }

    public void sendData(Map<String, Object> properties)
    {
        
        Producer<String, sampleData> producer = new KafkaProducer<String, sampleData>(properties);
        ProducerRecord<String,sampleData> producerRecord = new ProducerRecord<String,sampleData>("test1", "testKey",prepareObj()); 
        producer.send(producerRecord);
        producer.flush();
    }

    public static void main( String[] args )
    {
        Map<String,Object> properties = new HashMap<String,Object>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,KafkaAvroSerializer.class.getName());
        properties.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,"http://localhost:8081");
        App app = new App();
        app.sendData(properties);
        

        
    }
}

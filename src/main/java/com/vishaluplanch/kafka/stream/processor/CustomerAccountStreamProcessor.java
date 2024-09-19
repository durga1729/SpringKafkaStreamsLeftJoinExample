package com.vishaluplanch.kafka.stream.processor;

import com.vishaluplanch.kafka.avro.schema.Department;
import com.vishaluplanch.kafka.avro.schema.Employee;
import com.vishaluplanch.kafka.avro.schema.EmployeeDepartment;

import com.vishaluplanch.kafka.joiner.EmployeeValueJoiner;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import jakarta.annotation.PostConstruct;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;

@Service
public class CustomerAccountStreamProcessor {

    @Value("${spring.kafka.abc.emp.topic}")
    private String abcBankAccountTopic;

    @Value("${spring.kafka.xyz.dept.topic}")
    private String xyzBankAccountTopic;

    @Autowired
    private StreamsBuilder streamBuilder;

    @Autowired
    private KafkaProperties kafkaProperties;

    @PostConstruct
    public void joinEmployee() {
        KStream<Long, Employee> xyzKStream = streamBuilder.stream(abcBankAccountTopic, Consumed.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));

        KStream<Long, Department> abcKStream = streamBuilder.stream(xyzBankAccountTopic, Consumed.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));

        KStream<Long, EmployeeDepartment> joinedStream = xyzKStream.leftJoin(abcKStream, new EmployeeValueJoiner(), JoinWindows.of(Duration.ofMinutes(1)), StreamJoined.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>()), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));
        joinedStream.filter((key, value) -> key != null && value != null)
                .peek((key, mergedAccountDetail) -> System.out.println("Key =>" + key + " Value in Join =>" + mergedAccountDetail.toString()));

        joinedStream.filter((key,value)->key !=null && value != null).to("employee-department-ouput", Produced.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));
        Topology topology=streamBuilder.build();
        KafkaStreams streams=new KafkaStreams(topology,new StreamsConfig(kafkaProperties.buildStreamsProperties()));
        streams.start();
    }



    <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde(SpecificAvroSerde<T> serde) {
        HashMap<String, String> map = new HashMap<>();
        map.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProperties().get("schema.registry.url"));
        serde.configure(map, false);
        return serde;
    }
}

package com.vishaluplanch.kafka.stream.processor;

import com.vishaluplanch.kafka.avro.schema.Account;
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
public class AccountProcessor {
    @Value("${spring.kafka.account.in.topic}")
    private String accountIn;

    @Value("${spring.kafka.account.out.topic}")
    private String accountOut;


    @Value("${spring.kafka.account.balance.topic}")
    private String balanceTopic;

    @Autowired
    private StreamsBuilder streamBuilder;

    @Autowired
    private KafkaProperties kafkaProperties;


    @PostConstruct
    public void filterAccounts() {
        KStream<Long, Account> accountStream = streamBuilder.stream(accountIn, Consumed.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));

        // Filter accounts based on status and forward to a new topic
        KStream<Long, Account> filteredAccounts = accountStream
                .filter((key, account) -> "ACTIVE".equalsIgnoreCase(account.getAccountStatus().toString()));

        // Send filtered accounts to output topic
        filteredAccounts.to(accountOut, Produced.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));


        KStream<Long, Account> filteredAccountsByBalance = accountStream
                .filter((key, account) -> account.getBalance() < 10000);

        // Send filtered accounts to output topic
        filteredAccountsByBalance.to(balanceTopic, Produced.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));


        Topology topology = streamBuilder.build();
        KafkaStreams streams = new KafkaStreams(topology, new StreamsConfig(kafkaProperties.buildStreamsProperties()));
        streams.start();
    }


    <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde(SpecificAvroSerde<T> serde) {
        HashMap<String, String> map = new HashMap<>();
        map.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProperties().get("schema.registry.url"));
        serde.configure(map, false);
        return serde;
    }
}

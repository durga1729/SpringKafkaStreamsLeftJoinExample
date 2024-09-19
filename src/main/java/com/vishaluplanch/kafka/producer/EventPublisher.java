package com.vishaluplanch.kafka.producer;

import com.vishaluplanch.kafka.avro.schema.Department;
import com.vishaluplanch.kafka.avro.schema.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class EventPublisher {

    @Value("${spring.kafka.abc.emp.topic}")
    private String abcBankAccountTopic;

    @Value("${spring.kafka.xyz.dept.topic}")
    private String xyzBankAccountTopic;

    @Autowired
    private KafkaTemplate<Long, Object> abcBankKafkaTemplate;
    @Autowired
    private KafkaTemplate<Long, Object> xyzBankKafkaTemplate;

    private Random random = new Random();


    @GetMapping(value = "/generateEmployee")
    public void publish() throws InterruptedException {
        Employee e = new Employee();
        e.setId(1729l);
        e.setName("ddddddddddd");
        e.setDepartmentId(7000);
        xyzBankKafkaTemplate.send(abcBankAccountTopic, (long) e.getDepartmentId(), e);

        Employee e1 = new Employee();
        e1.setId(1728l);
        e1.setName("pppppppppp");
        e1.setDepartmentId(3000);
        xyzBankKafkaTemplate.send(abcBankAccountTopic, (long) e1.getDepartmentId(), e1);


        Thread.sleep(9000);
        Department d = new Department();
        d.setDepartmentId(7000);
        d.setDepartmentName("hrrrrr");
        abcBankKafkaTemplate.send(xyzBankAccountTopic, (long) d.getDepartmentId(), d);
    }
}

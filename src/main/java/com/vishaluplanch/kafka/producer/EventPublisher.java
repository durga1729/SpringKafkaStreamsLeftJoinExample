package com.vishaluplanch.kafka.producer;

import com.vishaluplanch.kafka.avro.schema.Account;
import com.vishaluplanch.kafka.avro.schema.Department;
import com.vishaluplanch.kafka.avro.schema.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class EventPublisher {

    @Value("${spring.kafka.abc.emp.topic}")
    private String abcBankAccountTopic;

    @Value("${spring.kafka.xyz.dept.topic}")
    private String xyzBankAccountTopic;


    @Value("${spring.kafka.account.in.topic}")
    private String accountInTopic;

    @Value("${spring.kafka.account.out.topic}")
    private String accountOutTopic;

    @Autowired
    private KafkaTemplate<Long, Object> abcBankKafkaTemplate;
    @Autowired
    private KafkaTemplate<Long, Object> xyzBankKafkaTemplate;


    @Autowired
    private KafkaTemplate<Long, Object> accountTemplate;

    private Random random = new Random();


    @GetMapping(value = "/generateEmployee")
    public void publish() throws InterruptedException {
        Employee e = new Employee();
        e.setId(17299999l);
        e.setName("durga");
        e.setDepartmentId(1729);
        xyzBankKafkaTemplate.send(abcBankAccountTopic, (long) e.getDepartmentId(), e);

        Employee e1 = new Employee();
        e1.setId(172888888l);
        e1.setName("prasad");
        e1.setDepartmentId(3000);
        xyzBankKafkaTemplate.send(abcBankAccountTopic, (long) e1.getDepartmentId(), e1);


        Thread.sleep(9000);
        Department d = new Department();
        d.setDepartmentId(1729);
        d.setDepartmentName("hrrrrr");
        abcBankKafkaTemplate.send(xyzBankAccountTopic, (long) d.getDepartmentId(), d);
    }


    @PostMapping(value = "/postAccount")
    public ResponseEntity<String> publishAccount(@RequestBody Account account) {

        accountTemplate.send(accountInTopic, account.getId(), account);

        return new ResponseEntity<>("Successfully published accounts", HttpStatus.OK);

    }
}

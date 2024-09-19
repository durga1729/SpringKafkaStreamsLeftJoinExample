package com.vishaluplanch.kafka.joiner;


import com.vishaluplanch.kafka.avro.schema.Department;
import com.vishaluplanch.kafka.avro.schema.Employee;
import com.vishaluplanch.kafka.avro.schema.EmployeeDepartment;
import lombok.Getter;
import org.apache.kafka.streams.kstream.ValueJoiner;

@Getter
public class EmployeeValueJoiner implements ValueJoiner<Employee, Department, EmployeeDepartment> {

    @Override
    public EmployeeDepartment apply(Employee xyzAccount, Department abcAccount) {
        if (xyzAccount == null || abcAccount == null) {
            return null; // Handle nulls here
        }

        EmployeeDepartment employeeDepartment = EmployeeDepartment.newBuilder().
                setId(xyzAccount.getId()).setName(xyzAccount.getName()).setDepartmentId(xyzAccount.getDepartmentId())
                .setDepartmentName(abcAccount.getDepartmentName()).
                build();
        return employeeDepartment;
    }
}


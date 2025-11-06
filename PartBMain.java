package com.example.partb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PartBMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        Employee emp = new Employee();
        emp.setName("Nansi Kumari");
        emp.setDepartment("IT");
        emp.setSalary(60000);

        employeeDAO.saveEmployee(emp);

        System.out.println("✅ Employee saved successfully!");

        context.close();
    }
}

package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.exercise.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class FindEmployees {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //list all employees
            List<Employee> employeeList = session.createQuery("from Employee ").getResultList();

            //display all employees
            displayEmployees(employeeList);


            //show employees from Arthur House
            employeeList = session.createQuery("from Employee e where e.company='Arthur House'").getResultList();
            displayEmployees(employeeList);



        } finally {
            factory.close();
        }

    }

    private static void displayEmployees(List<Employee> employeeList) {
        for (Employee tempEmployee : employeeList) {
            System.out.println(tempEmployee);
        }
    }
}

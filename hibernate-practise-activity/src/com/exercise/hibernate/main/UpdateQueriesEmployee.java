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

import javax.persistence.Query;
import java.util.List;

public class UpdateQueriesEmployee {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {
            //start transaction
            session.beginTransaction();
            //define id that you want to update data
            int updatedEmployeeID = 6;
            int updatedID = 8;


            //Employee updateEmployee = session.get(Employee.class, updatedEmployeeID);
            Employee updateEmployee = session.get(Employee.class, updatedID);

            System.out.println("Employee before update: "+updateEmployee);

            updateEmployee.setCompany("LArche TOronto");




            //commit
            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }


}

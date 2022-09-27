package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.exercise.hibernate.entity.Employee;
import com.exercise.utils.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateEmployees {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {
            //create employee objects
//
//            Employee employee1 = new Employee("Cory", "Conson", "Arthur House");
//            Employee employee2 = new Employee("Lee Ann", "Sansor", "Mclachlin House");
//            Employee employee3 = new Employee("Edna", "Naapang", "McLachlin House");
//            Employee employee4 = new Employee("Tracy", "Tanedoro", "Larche Arnprior");
//            Employee employee5 = new Employee("Amanda", "Sardin", "Arthur House");
          //  Employee employee6 = new Employee("Smitha", "Katha", "Arthur House");
             String date = "14/05/1992";
            Date theDate = DateUtils.parseDate(date);
            Employee employee7 = new Employee("Kasia","Khole",theDate,"Arthur House");


            //start a transaction
            session.beginTransaction();


            //save the employees
            System.out.println("Added employees saving...");
//            session.save(employee1);
//            session.save(employee2);
//            session.save(employee3);
//            session.save(employee4);
//            session.save(employee5);
            session.save(employee7);

            //commit transaction
            session.getTransaction().commit();
      //      System.out.println("Employees added: "+ employee7);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {

            factory.close();
        }
    }
}

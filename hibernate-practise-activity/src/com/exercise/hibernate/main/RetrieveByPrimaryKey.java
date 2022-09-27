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

public class RetrieveByPrimaryKey {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {
            //create new employee
     //       Employee emp = new Employee("Ilham","Mammadli","McLachlin");

            //start transaction
            session.beginTransaction();

            //save
      //      session.save(emp);
            session.getTransaction().commit();
            System.out.println("Added");

            //now retrieve by id
           session= factory.getCurrentSession();
            session.beginTransaction();

       //     System.out.println("Getting employee by id: "+emp.getID());

     //       Employee tempEmployee = session.get(Employee.class, emp.getID());
     //       System.out.println("New Employee joined our team: "+tempEmployee);

            //commit
            session.getTransaction().commit();





        } finally {
            factory.close();
        }
    }
}

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

public class DeleteQuery {
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

            //define id that you want to delete data

            //this is one way of delete data
           int delID = 7;

           Employee deletedEmployee = session.get(Employee.class, delID);

//           session.delete(deletedEmployee);
            System.out.println("Show deleted Employee: "+deletedEmployee);
            //2nd way of delete
            session.createQuery("delete from Employee where id=7").executeUpdate();






            //commit
            session.getTransaction().commit();





        } finally {
            factory.close();
        }
    }
}

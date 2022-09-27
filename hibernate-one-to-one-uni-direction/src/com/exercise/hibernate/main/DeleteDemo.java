package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.exercise.hibernate.entity.Instructor;
import com.exercise.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        //create session factory
        //and add annotated classes
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {
           //start the transaction
            session.beginTransaction();

          //get instructor by primary key//id
            int getByID = 2;

            Instructor deleteThisInstructor = session.get(Instructor.class,getByID);

            System.out.println("Found instructor: "+deleteThisInstructor);


            //delete insturctor
             //you should check if onject exit in database bedore do anything with it
            //for safety process
            if(deleteThisInstructor!= null) {

                System.out.println("Deleting instructor: "+deleteThisInstructor);

                //Note: it will delete also InstructorDetail object as well
                //because of CascadeType.ALL
                session.delete(deleteThisInstructor);
            }

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {

            factory.close();
        }
    }
}

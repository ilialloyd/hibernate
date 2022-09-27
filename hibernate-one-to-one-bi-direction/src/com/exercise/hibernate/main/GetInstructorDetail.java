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

public class GetInstructorDetail {
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

            int id = 10;

            //get the instructor detail object
            InstructorDetail inDetail =
                    session.get(InstructorDetail.class, id);


                    //print the instructor detail
            System.out.println("InstructorDetail: "+inDetail);

                    //print the associated instructor
            System.out.println("The associated instructor: "+inDetail.getInstructor());

                    //commit transaction
                    session.getTransaction().commit();
            System.out.println("Done!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //prevent the leaks
            session.close();

            factory.close();
        }
    }
}

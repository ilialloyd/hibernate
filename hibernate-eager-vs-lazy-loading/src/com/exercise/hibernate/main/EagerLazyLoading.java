package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
             UniDirectional relationship
  Bu o deməkdir ki biz birinci İnstractor yaradıb sonra onun
  İnstractor_details ini yaradırıq.
 */

import com.exercise.hibernate.entity.Course;
import com.exercise.hibernate.entity.Instructor;
import com.exercise.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyLoading {
    public static void main(String[] args) {

        //create session factory
        //and add annotated classes
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {

            //start the transaction
            session.beginTransaction();

            //Get instructor from database
            int instructorId = 7;

            Instructor tempInstructor = session.get(Instructor.class,instructorId);

            System.out.println("Kriptodersler : Instructor: "+tempInstructor);


            System.out.println("Kriptodersler : Courses "+tempInstructor.getCourseList() );


            //commit transaction
            session.getTransaction().commit();

           //close session
           session.close();

            System.out.println("Session is closed!!!\n");

           //since courselist is lazy loaded... this should fail

           //get courses
           System.out.println("Kriptodersler : Courses "+tempInstructor.getCourseList() );


            System.out.println("Kriptodersler: Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

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

public class DeleteCourses {
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

            //Get course from database
            int courseID = 19;

            Course course = session.get(Course.class, courseID);


            //delete course
            System.out.println("Deleting COurse:  " + course);
            session.delete(course);


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

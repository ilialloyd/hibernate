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

public class CreateInstructorAndCourses {
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


            Instructor ins1 = new Instructor("Ilham","Mammadli","ilialloyd@gmail.com");

            //create some courses
          Course course1 = new Course("Binance Birja");
          Course course2 = new Course("Qrafik Indiqator Tehlil");
          Course course3 = new Course("DEFI ");




            //add courses to instructor
           ins1.add(course1);
           ins1.add(course2);
           ins1.add(course3);


            //save the courses
            System.out.println("New Instructor added: "+ ins1);
            System.out.println("Saving Courses: "+
                    "Course 1: "+course1+
                    "Course 2: "+ course2+
                    "Course 3: "+ course3);


            //When we use persist to save new Instructor object and Course objects,
            // persist will save both of them correctly
            session.persist(ins1);






            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

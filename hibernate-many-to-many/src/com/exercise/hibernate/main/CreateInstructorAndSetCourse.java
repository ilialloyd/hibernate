package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
             UniDirectional relationship
  Bu o deməkdir ki biz birinci İnstractor yaradıb sonra onun
  İnstractor_details ini yaradırıq.
 */

import com.exercise.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorAndSetCourse {
    public static void main(String[] args) {

        //create session factory
        //and add annotated classes
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {

            //start the transaction
            session.beginTransaction();


            int courseItID1 = 10;
            int courseItID2 = 13;
            int courseEnglishID = 11;

            Course courseIT1 = session.get(Course.class, courseItID1);
            Course courseIT2 = session.get(Course.class, courseItID2);
            Course courseEnglish = session.get(Course.class, courseEnglishID);

            Instructor itInstructor = new Instructor("Serxan", "Resullu", "serxan@gmail.com");
            Instructor englishInstructor = new Instructor("Intizar", "Mehdi", "intizar@gmail.com");

            //saving courses to Instructor
            itInstructor.add(courseIT1);
            itInstructor.add(courseIT2);
            englishInstructor.add(courseEnglish);


            //save the Instructors
            System.out.println("\n Students saving...");
            session.save(itInstructor);
            session.save(englishInstructor);
            //diagnostic
            System.out.println("IT Instructor: " + itInstructor);
            System.out.println("English Instructor: " + englishInstructor);


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

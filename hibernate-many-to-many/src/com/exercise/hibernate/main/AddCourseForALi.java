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

public class AddCourseForALi {
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


            //get the student
            int stID = 7;
            Student student= session.get(Student.class,stID);


            System.out.println("\n Loaded student: "+ student);
            System.out.println("\nCourses: "+student.getCourses());

            Course course = new Course("Front-End Developing - Land a job quick");

            //add student to course
            course.addStudent(student);


            //save the course
            System.out.println("\n Saving courses...");
            session.save(course);


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

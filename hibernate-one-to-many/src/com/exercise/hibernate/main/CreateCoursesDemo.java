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

public class CreateCoursesDemo {
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
            int instructorId = 1;

            Instructor tempInstructor = session.get(Instructor.class,instructorId);


            //create some courses
          Course tempCourse1 = new Course("Java Core - Beginner Course");
          Course tempCourse2 = new Course("SQL Database - Learn From Zero");


            //add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);


            //save the courses
            System.out.println("Saving Courses: "+
                    "Course 1: "+tempCourse1+
                    "Course 2: "+ tempCourse2);
            session.save(tempCourse1);
            session.save(tempCourse2);




            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

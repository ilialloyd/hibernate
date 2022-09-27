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
import org.hibernate.query.Query;

import java.util.List;

public class FetchJoin_GetCoursesLaterOn {
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

            Instructor instructor = session.get(Instructor.class,instructorId);

            System.out.println("\nKriptodersler's Instructor: "+ instructor+"\n");

            //commit transaction
            session.getTransaction().commit();

            //close session
            session.close();
            System.out.println("Session ins closed now!\n");


            //
            // THIS HAPPENS SOMEWHERE ELSE / LATER IN THE PROGRAM
            // YOU NEED TO GET A NEW SESSION
            //


            System.out.println("Starting a new session\n");


            session = factory.getCurrentSession();


            session.beginTransaction();


            //get courses for given instructor
            Query<Course>courseQuery = session.createQuery("select course from Course course "
                                             +"where course.instructor.id=:theCourseInstructorID", Course.class);


            courseQuery.setParameter("theCourseInstructorID",instructorId);

            List<Course>courses = courseQuery.getResultList();

            System.out.println("Available Courses : "+courses+"\n");

            //assign to instructor object in the memory

            //in this line we set courses actually for instructor that later on when we call getCourseList()
            // we will be able refer this method because we have  set here
            instructor.setCourseList(courses);


            System.out.println("Kriptodersler Courses: "+instructor.getCourseList()+"\n");

            //commit transaction
            session.getTransaction().commit();

            //close session
            session.close();

            System.out.println("Session is closed!!!\n");

            System.out.println("Kriptodersler: Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

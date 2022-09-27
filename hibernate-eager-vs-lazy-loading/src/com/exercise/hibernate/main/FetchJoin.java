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

public class FetchJoin {
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

            //hibernate query with hql
            //make sure you import query from ***import org.hibernate.query.Query;***

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courseList "
                                    + "where i.id=:theInstructorId",
                            Instructor.class);


            //set parameter on query
            query.setParameter("theInstructorId",instructorId);


            //execute query and get instructor
            //getSingleResult - will Load instructor and courses at once
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("Kriptodersler : Instructor: " + tempInstructor);


            //commit transaction
            session.getTransaction().commit();

            //close session
            session.close();

            System.out.println("Session is closed!!!\n");


            //get courses
            System.out.println("Kriptodersler : Courses " + tempInstructor.getCourseList());


            System.out.println("Kriptodersler: Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

package com.exercise.hibernate.main.courseANDreview;


import com.exercise.hibernate.entity.Course;
import com.exercise.hibernate.entity.Instructor;
import com.exercise.hibernate.entity.InstructorDetail;
import com.exercise.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
    public static void main(String[] args) {

        //create session factory
        //and add annotated classes
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {

            //start the transaction
            session.beginTransaction();

            //Get course from database
            int courseID = 12;

            Course course = session.get(Course.class, courseID);


            //delete course
            //it will delete reviews as well, Because of Cascade type
            System.out.println("Deleting Course:  " + course);
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

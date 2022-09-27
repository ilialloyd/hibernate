package com.exercise.hibernate.main.courseANDreview;
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
import com.exercise.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
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


            //create a course
            Course course = new Course("Servlet - How Servlets Works");


            //ad some reviews
            course.addReview(new Review("Great Explanation... Love it!"));
            course.addReview(new Review("Easy to Understand... Keep going!"));
            course.addReview(new Review("That was what a was looking for... so cool!"));


            System.out.println("Saving the course...");


            System.out.println("Saved Course: "+course+"\n");

            System.out.println("Reviews about course: "+course.getReviews()+"\n");



            //save the course...and leverage the cascade all
            //Basically cascade.all will also save reviews as well

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

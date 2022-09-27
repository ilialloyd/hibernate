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

public class CreateInstructorDemo {
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
            //create the objects

            Instructor tempInstructor =
                    new Instructor(
                            "Serxan", "Resullu", "Serxan.Resul@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "youtube.com/javawithSerxan", "Video Games");



            //assosiate the objects. this part handle instructor foreign key side

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start the transaction
            session.beginTransaction();

            //save the instructor
            //this will save details as well
            //because of CascadeType.All
            System.out.println("Saving instructor: "+tempInstructor);
            session.save(tempInstructor);




            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

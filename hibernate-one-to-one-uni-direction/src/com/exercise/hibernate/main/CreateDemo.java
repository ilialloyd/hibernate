package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
             UniDirectional relationship
  Bu o deməkdir ki biz birinci İnstractor yaradıb sonra onun
  İnstractor_details ini yaradırıq.
 */

import com.exercise.hibernate.entity.Instructor;
import com.exercise.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        //create session factory
        //and add annotated classes
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();


        try {
            //create the objects
/*
            //instructor 1
            Instructor tempInstructor =
                    new Instructor(
                            "Ilham", "Mammadli", "ilham@kriptodersler.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "kriptodersler.com/youtube", "Jiu-jitsu");

*/
            Instructor tempInstructor =
                    new Instructor(
                            "Chad", "Darby", "ChadDarby@love2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "love2code.com/youtube", "coding");



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

            factory.close();
        }
    }
}

package com.exercise.hibernate.main;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.exercise.hibernate.entity.Instructor;
import com.exercise.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOnlyInstructorDetail {
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
            //start the transaction
            session.beginTransaction();

            int id = 4;

            //get the instructor detail object
            InstructorDetail inDetail =
                    session.get(InstructorDetail.class, id);


                    //print the associated instructor
            System.out.println("The associated instructor: "+inDetail.getInstructor());

            //deleting instructorDetail
/*

            //When we just run we will get error
            // that is why we need to  : break bi-directional link before delete the detail object

            //we set InstructorDetail's value to null to break the relation between InstructorDetail - Instructor fields

            also when we delete InstructorDetail, It will be deleted from database,
            But because below, we set the value null, break the line,Instructor will not be deleted
 */

            //Imporetant: if we want to delete child but keep the parent table,
            // we should break the link before opetation
            inDetail.getInstructor().setInstructorDetail(null);


            System.out.println("Delete InstructorDetail: "+inDetail);
            session.delete(inDetail);
/*
            When we just run we will get error that we need to break
            bi-directional link
            Error: deleted object would be re-saved by cascade (remove deleted object from associations):
*/

                    //commit transaction
                    session.getTransaction().commit();
            System.out.println("Done!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //prevent the leaks
            session.close();

            factory.close();
        }
    }
}

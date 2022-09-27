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

public class CreateInstructorAndCourses_saveMethod {
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

            //create instructor


            Instructor ins1 = new Instructor("Tracy", "Tanedero", "Tracy.t@gmail.com");

            //create instructor_Detail
            InstructorDetail detail = new InstructorDetail("Youtube/TracyTheFilippino", "Biking");

            //create courses
            Course course4 = new Course("Food Handling ");
            Course course5 = new Course("First Aid ");


        //set detail to instructor
            ins1.setInstructorDetail(detail);

            //add courses to instructor
            ins1.add(course4);
            ins1.add(course5);
//           ins1.add(course2);
//           ins1.add(course3);


            //save the courses
            System.out.println("New Instructor added: " + ins1);
            System.out.println("Saving Courses: " +
//                    "Course 1: "+course1+
//                    "Course 2: "+ course2+
                    "Course 1: " + course4+
                    "Course 2: "+ course5);

           //when we try to save then it will not add courses. it will just create Instructor
            session.save(ins1);
//


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

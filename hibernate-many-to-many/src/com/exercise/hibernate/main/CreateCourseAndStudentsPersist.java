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

public class CreateCourseAndStudentsPersist {
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


            //create a course
            Course course1 = new Course("Natiqlik Seneti");
            Course course2 = new Course("Fransiz dili ");


            System.out.println("\nSaving the courses.." + course1 + "\n");
            System.out.println("\nSaving the courses..." + course2 + "\n");

            //add the students
            Student student1 = new Student("Aysen", "Nazim", "aysen.azim@gmail.com");
            Student student2 = new Student("Selale", "ahmetli", "selale@gmail.com");


            //add students to the course
            course1.addStudent(student1);
            course2.addStudent(student1);
            course2.addStudent(student2);

            //save the courses
            System.out.println("\n Students saving...");
            session.persist(course1);
            session.persist(course2);
            System.out.println("\n Registered students for "+course1+" : "+course1.getStudents()
                    +
                    "\n Registered students for "+course2+" : "+course2.getStudents()
                                );

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

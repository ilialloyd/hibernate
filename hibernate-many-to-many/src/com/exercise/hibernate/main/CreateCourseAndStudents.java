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

public class CreateCourseAndStudents {
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
            Course course1 = new Course("IT Course - Become Backend Developer");
            Course course2 = new Course("English - Beginner to Intermediate");
            Course course3 = new Course("SMM - Learn Social Media Management");


            System.out.println("\nSaving the courses.." + course1 + "\n");
            System.out.println("\nSaving the courses..." + course2 + "\n");
            System.out.println("\nSaving the courses..." + course3 + "\n");

            //saving courses
            session.save(course1);
            session.save(course2);
            session.save(course3);


            //add the students
            Student student1 = new Student("Ali", "Azimli", "ali.azim@gmail.com");
            Student student2 = new Student("Nura", "Babanli", "nura@gmail.com");


            //add students to the course
            course1.addStudent(student1);
            course2.addStudent(student1);
            course2.addStudent(student2);
            course3.addStudent(student2);


            //save the students
            System.out.println("\n Students saving...");
            session.save(student1);
            session.save(student2);
            System.out.println("\n Registered students for "+course1+" : "+course1.getStudents()
                    +
                    "\n Registered students for "+course2+" : "+course2.getStudents()+
                    "\n Registered students for "+course3+" : "+course3.getStudents()
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

package com.exercise.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    //define fields


    //define constructors, getter setter, tostring

    //annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "title")
    private String title;


    //For foreign key column we use @JoinColumn, instead of @Column
    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    //adding review section
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)//if we delete course, wewant to delete reviews as well
    @JoinColumn(name = "course_id")
    private List<Review> reviews;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",  //name of table
            joinColumns = @JoinColumn(name = "course_id"), // fk name that points course
            inverseJoinColumns = @JoinColumn(name = "student_id")  // fk name that points student
    )
    List<Student> students;


    //adding reviews method

    public void addReview(Review tempReview) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(tempReview);
    }

    //add student
    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public Course(String title) {
        this.title = title;
    }

}

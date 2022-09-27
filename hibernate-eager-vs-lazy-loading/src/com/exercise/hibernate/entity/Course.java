package com.exercise.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    public Course(String title) {
        this.title = title;
    }


}

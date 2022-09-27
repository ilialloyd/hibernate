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
   Cascading is a feature in Hibernate, which is used to manage
   the state of the mapped entity whenever the state of its
   relationship owner (superclass) affected. When the relationship
   owner (superclass) is saved/ deleted, then the mapped entity
   associated with it should also be saved/ deleted automatically.
 */
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "instructor")
public class Instructor {
    //annotate the class an entity and map to db table

    //define the fields

    //annotate the fields with db column names

    //*** set up mapping to InstructorDetail and Courses entity

    //create constructor

    //generate getter/setter methods

    //generate toString method
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email")
    private String email;


    @ToString.Exclude
    //this section is the foreign key session
    @OneToOne(cascade = CascadeType.ALL) //this basically define map style and cascade
    @JoinColumn(name = "instructor_detail_id") //this is the actual map that define whch column gonna be key
    private InstructorDetail instructorDetail;

    @ToString.Exclude
    @OneToMany(mappedBy = "instructor",        //instructor from Course class
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courseList; //because we will have many courses we use List


    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }


    //add convenience methods for bi-directional relationship
    //Bu method sayesinde istiqameti kursdan goturub
    // sonra instructora gele, ya da tersini ede bilerem
    public void add(Course tempCourse) {

        if (courseList == null) {//eger instructor hele yaradilmayibsa
            courseList = new ArrayList<>();//yarat
        }
        courseList.add(tempCourse);//eger yaradilibsa sadece liste add ele
        tempCourse.setInstructor(this);
    }


}

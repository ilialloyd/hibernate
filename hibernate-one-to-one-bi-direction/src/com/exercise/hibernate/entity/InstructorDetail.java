package com.exercise.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 Bi Directional relationship is that you start from de detail and then you go to the
 İnstructor itselt
 */


@Getter
@Setter
@ToString
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    //annotate the class an entity and map to db table

    //define the fields

    //annotate the fields with db column names

    //create constructor

    //generate getter/setter methods

    //generate toString method
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    //bidirectional
    //add new fiend for instructor
    //add One2One annotation


    //When you define CascadeType - ALL, when you delete or update,it does its parent, child table as well
    // @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)  this is All one

    // now lets change cascade type to delete instructorDetails but keep Instructor
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ToString.Exclude
    private Instructor instructor;


    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }


}

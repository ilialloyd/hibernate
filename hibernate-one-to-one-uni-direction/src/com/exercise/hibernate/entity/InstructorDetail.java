package com.exercise.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */


@Getter
@Setter
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


    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }


}

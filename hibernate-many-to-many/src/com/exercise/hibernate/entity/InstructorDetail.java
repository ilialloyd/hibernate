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
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;


    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }


}

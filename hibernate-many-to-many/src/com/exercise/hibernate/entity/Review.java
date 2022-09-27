package com.exercise.hibernate.entity;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "review")
public class Review {


    //define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;



    @Column(name="comment")
    private String comment;






    //define construction,getter setter, toString

    //annotate the fields


    public Review(String comment) {
        this.comment = comment;
    }
}

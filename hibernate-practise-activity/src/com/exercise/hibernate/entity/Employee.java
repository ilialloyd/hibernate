package com.exercise.hibernate.entity;

import com.exercise.utils.DateUtils;

import javax.persistence.*;
import java.util.Date;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id//declare that its primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name ="date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "company")
    private String company;



    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(String firstName, String lastName, Date dateOfBirth, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + DateUtils.formatDate(dateOfBirth) +
                ", company='" + company + '\'' +
                '}';
    }
//    public Employee(String firstName, String lastName, String company) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.company = company;
//
//    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Employee() {

    }
}

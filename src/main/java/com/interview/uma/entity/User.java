package com.interview.uma.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
//User ORM which represents the user table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private String surename;

    @Getter
    @Setter
    @Column
    private Date date;

    @Getter
    @Setter
    @Column
    private String email;

    @Getter
    @Setter
    @Column
    private String password;

    @Getter
    @Setter
    @Column
    private String phone;

}

package com.api.rest.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Getter @Setter @Id @Column(name="id") @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="surname") //Change surname to lastname in db
    private String lastname;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="phone")
    private String phone;

    @Getter @Setter @Column(name="password")
    private String password;

}

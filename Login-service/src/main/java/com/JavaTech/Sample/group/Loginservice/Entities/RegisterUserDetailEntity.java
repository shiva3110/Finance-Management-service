package com.JavaTech.Sample.group.Loginservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "user_data")
public class RegisterUserDetailEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String passsword;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;
}

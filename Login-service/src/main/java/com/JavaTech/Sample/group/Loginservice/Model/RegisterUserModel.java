package com.JavaTech.Sample.group.Loginservice.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //parameterizes
@NoArgsConstructor //default
public class RegisterUserModel {
    private String fname;
    private String lname;
    private String email;
    private String passsword;
    private String mobile;
    private String address;//lombok

    //setter getter -->boilerPlate code
}

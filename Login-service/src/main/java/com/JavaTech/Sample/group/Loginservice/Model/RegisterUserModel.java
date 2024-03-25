package com.JavaTech.Sample.group.Loginservice.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //parameterizes
@NoArgsConstructor //default
public class RegisterUserModel {

    @NotBlank
    @Size(min = 2, max=25, message = "first name must be in range 2 to 25")
    private String fname;

    @NotNull
    @Size(min = 2, max=25, message = "last name must be in range 2 to 25")
    private String lname;

    @NotNull
    @Email(message = "Provide a vaid email id")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*!@$&:;,?~_]).{8,32}$")
    private String passsword;//pass min 8 char one cap one digit one small oru specifical

    @Size(min=10, max= 10)
    private String mobile;

    @Size(max=100)
    private String address;//lombok

    //setter getter -->boilerPlate code
}

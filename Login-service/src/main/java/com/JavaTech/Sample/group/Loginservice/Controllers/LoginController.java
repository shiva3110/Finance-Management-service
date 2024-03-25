package com.JavaTech.Sample.group.Loginservice.Controllers;

import com.JavaTech.Sample.group.Loginservice.Model.RegisterUserModel;
import com.JavaTech.Sample.group.Loginservice.Model.RequestModel;
import com.JavaTech.Sample.group.Loginservice.Model.ResponseModel;
import com.JavaTech.Sample.group.Loginservice.Service.RegisterService;
import com.JavaTech.Sample.group.Loginservice.exception.UserNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login-service")
public class LoginController {

    @Autowired //create and intiliaze object
    RegisterService registerService;

//    public LoginController(RegisterService registerService) {
//        this.registerService = registerService;
//    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //  http://localhost:8080/login-service/login&username=mani&password=mani
    public ResponseEntity<ResponseModel> loginLogic(@RequestBody @Valid RequestModel input) throws Exception {

        ResponseModel model = new ResponseModel();

        model.setResult("OK");
        model.setMessage(input.getUsername());//business-logic//service-layer

        registerService.loginuser();

        return new ResponseEntity<>(model, HttpStatus.CREATED);
        //plain-text--expected->json {result:OK,
        // username :'mani'}
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE
    ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerLogic(@RequestBody @Valid RegisterUserModel userData){

     boolean accountCreated = registerService.createUserData(userData);
        ResponseModel response = new ResponseModel();

       if (accountCreated){
           response.setResult("OK");
           response.setMessage("Registration successfull");
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }
       else {
           response.setResult("KO");
           response.setMessage("Registration unsuccessfull");
           return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }



}

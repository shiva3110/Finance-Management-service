package com.JavaTech.Sample.group.Loginservice.Controllers;

import com.JavaTech.Sample.group.Loginservice.Model.FilterUserModel;
import com.JavaTech.Sample.group.Loginservice.Model.RegisterUserModel;
import com.JavaTech.Sample.group.Loginservice.Model.RequestModel;
import com.JavaTech.Sample.group.Loginservice.Model.ResponseModel;
import com.JavaTech.Sample.group.Loginservice.Service.RegisterService;
import com.JavaTech.Sample.group.Loginservice.exception.UserNotFound;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@RestController
@RequestMapping("login-service")
@Log4j2 // log object
public class LoginController {

    @Autowired //create and intiliaze object
    RegisterService registerService;

    @Autowired
    MessageSource messageSource;

//    public LoginController(RegisterService registerService) {
//        this.registerService = registerService;
//    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //  http://localhost:8080/login-service/login&username=mani&password=mani
    public ResponseEntity<String> loginLogic(@RequestBody @Valid RequestModel input) throws Exception {

        log.info("request reached login controller");
        log.trace("demooo debug");
        ResponseModel model = new ResponseModel();

        model.setResult("OK");
        model.setMessage(input.getUsername());//business-logic//service-layer
        ArrayList<String> searchFields = new ArrayList<>();

       // validation

        log.info("request passes validation and starting to servic layer");
      String username =  registerService.loginuser(input.getPassword());//to mock

        return new ResponseEntity<>(username, HttpStatus.CREATED);
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

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> searchUser(@RequestBody @Valid FilterUserModel userData){
       String fname = registerService.fetchUserFromDb(userData);

        ResponseModel model = new ResponseModel();
        model.setResult(fname);
        model.setMessage("success");
        return new ResponseEntity<>(model,HttpStatus.OK);

    }

    @GetMapping("/internationalisation")
    public ResponseEntity<String> throwErrorLogin(
            @RequestHeader(name = "Accept-Language",required = false)Locale locale){//ta

        return new ResponseEntity<>(
                messageSource.getMessage("user.wrong.credential",null,locale),HttpStatus.OK);

        //give a key it will return a message
    }



}

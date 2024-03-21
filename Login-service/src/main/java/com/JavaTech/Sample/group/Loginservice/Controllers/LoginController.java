package com.JavaTech.Sample.group.Loginservice.Controllers;

import com.JavaTech.Sample.group.Loginservice.Model.RequestModel;
import com.JavaTech.Sample.group.Loginservice.Model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login-service")
public class LoginController {

    //  http://localhost:8080/login-service

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //  http://localhost:8080/login-service/login&username=mani&password=mani
    public ResponseEntity<ResponseModel> loginLogic(@RequestBody RequestModel input){

        ResponseModel model = new ResponseModel();
        model.setResult("OK");
        model.setUsername(input.getUsername());


        return new ResponseEntity<>(model, HttpStatus.CREATED);
        //plain-text--expected->json {result:OK,
        // username :'mani'}
    }

    @GetMapping(value = "/register/{username}")//  http://localhost:8080/login-service/register/mani
    public String registerLogic(@PathVariable String username){
        return username;
    }

}

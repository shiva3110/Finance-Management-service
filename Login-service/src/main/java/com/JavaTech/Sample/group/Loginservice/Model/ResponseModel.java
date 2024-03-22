package com.JavaTech.Sample.group.Loginservice.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseModel {
    private String result;

    private String message;

    public ResponseModel(){

    }
    public ResponseModel(String result, String message) {
        this.result = result;
        this.message = message;
    }


}

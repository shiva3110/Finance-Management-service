package com.JavaTech.Sample.group.Loginservice.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestModel {
   private String username;
    private String  password;

    public RequestModel(){

    }
    public RequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String toJSONString() throws Exception {//object  --> json --> string
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}

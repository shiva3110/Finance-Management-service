package com.JavaTech.Sample.group.Loginservice.Service.impl;

import com.JavaTech.Sample.group.Loginservice.Entities.RegisterUserDetailEntity;
import com.JavaTech.Sample.group.Loginservice.Model.RegisterUserModel;
import com.JavaTech.Sample.group.Loginservice.Repository.RegisterRepository;
import com.JavaTech.Sample.group.Loginservice.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    @Override
    public boolean createUserData(RegisterUserModel model) {
        RegisterUserDetailEntity userObject = new RegisterUserDetailEntity();
        userObject.setFname(model.getFname());
        userObject.setLname(model.getLname());
        userObject.setEmail(model.getEmail());
        userObject.setAddress(model.getAddress());
        userObject.setMobile(model.getMobile());
        userObject.setPasssword(model.getPasssword());

        RegisterUserDetailEntity returnedEnitity = registerRepository.save(userObject);

       if(!returnedEnitity.getFname().isEmpty())
           return true;

        return false;
    }


}


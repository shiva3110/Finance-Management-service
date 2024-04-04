package com.JavaTech.Sample.group.Loginservice.Service.impl;

import com.JavaTech.Sample.group.Loginservice.Entities.RegisterUserDetailEntity;
import com.JavaTech.Sample.group.Loginservice.Model.FilterUserModel;
import com.JavaTech.Sample.group.Loginservice.Model.RegisterUserModel;
import com.JavaTech.Sample.group.Loginservice.Repository.RegisterRepository;
import com.JavaTech.Sample.group.Loginservice.Service.RegisterService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
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

    @Override
    public String loginuser(String password) throws Exception {
        log.debug("user receiver password = " + password);

        RegisterUserDetailEntity userdata= registerRepository.findByPasssword(password);

        registerRepository.findByPasssword(password);


log.warn("sample warning message");


       if(Objects.nonNull(userdata)) {
           if (userdata.getPasssword().equals(password))
               log.info("service layer bussiness logic complete success");
               return userdata.getFname();
       }
        log.info("service layer bussiness logic complete success");
        return userdata.getFname();
    }

    @Override
    public String fetchUserFromDb(FilterUserModel model) {

        RegisterUserDetailEntity userObject = new RegisterUserDetailEntity();
        userObject.setFname(model.getFname());
        userObject.setLname(model.getLname());
        userObject.setEmail(model.getEmail());
        userObject.setAddress(model.getAddress());
        userObject.setMobile(model.getMobile());
        userObject.setPasssword(model.getPasssword());

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(userObject,matcher);

       List<RegisterUserDetailEntity> listOfUsers = registerRepository.findAll(example);
        RegisterUserModel fetchedrecord1 = new RegisterUserModel();
       fetchedrecord1.setFname(listOfUsers.get(0).getFname());

        return fetchedrecord1.getFname();
    }


}


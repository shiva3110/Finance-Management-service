package com.JavaTech.Sample.group.Loginservice.Service;

import com.JavaTech.Sample.group.Loginservice.Model.FilterUserModel;
import com.JavaTech.Sample.group.Loginservice.Model.RegisterUserModel;

public interface RegisterService{

    boolean createUserData(RegisterUserModel model);

    boolean loginuser (String password) throws Exception;

    String fetchUserFromDb(FilterUserModel model);

}

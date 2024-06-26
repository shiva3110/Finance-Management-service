package com.JavaTech.Sample.group.Loginservice.Repository;

import com.JavaTech.Sample.group.Loginservice.Entities.RegisterUserDetailEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;


@Repository
public interface RegisterRepository extends JpaRepository<RegisterUserDetailEntity,Integer> {

    RegisterUserDetailEntity findByPasssword(String password);

    RegisterUserDetailEntity findByMobile(String mobile);


}

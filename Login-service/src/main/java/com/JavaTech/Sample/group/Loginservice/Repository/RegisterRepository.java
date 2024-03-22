package com.JavaTech.Sample.group.Loginservice.Repository;

import com.JavaTech.Sample.group.Loginservice.Entities.RegisterUserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterUserDetailEntity,Integer> {


}

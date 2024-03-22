package com.JavaTech.Sample.group.Loginservice.Repository;

import com.JavaTech.Sample.group.Loginservice.Entities.RegisterUserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterUserDetailEntity,Long> {


}

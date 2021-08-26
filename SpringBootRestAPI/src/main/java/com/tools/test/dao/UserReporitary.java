package com.tools.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.tools.test.entity.Users;

public interface UserReporitary  extends CrudRepository<Users, Integer>{

}

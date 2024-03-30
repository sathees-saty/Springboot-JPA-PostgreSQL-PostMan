package com.curd.rest.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.rest.postgresql.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}

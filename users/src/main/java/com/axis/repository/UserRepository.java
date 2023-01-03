package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}

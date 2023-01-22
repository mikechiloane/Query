package com.faboda.query.repository;

import com.faboda.query.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserName(String userName);
    User findByUserNameAndPassword(String userName, String password);



}

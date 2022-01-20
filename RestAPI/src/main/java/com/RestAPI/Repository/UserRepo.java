package com.RestAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	
}

package com.app.CarWasher.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.CarWasher.Model.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
	
	UserModel findByUsername(String username);
	
}

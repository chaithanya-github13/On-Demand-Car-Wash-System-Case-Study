package com.app.CarWasher.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.CarWasher.Model.IdGenerator;


	@Repository
	public interface IdRepository extends MongoRepository<IdGenerator, String>{

	}


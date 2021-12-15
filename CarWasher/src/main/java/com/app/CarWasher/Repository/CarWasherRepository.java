package com.app.CarWasher.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.CarWasher.Model.CarWasher;
@Repository
public interface CarWasherRepository extends MongoRepository<CarWasher, Integer> {


}

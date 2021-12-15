package com.app.Customer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.Customer.Model.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
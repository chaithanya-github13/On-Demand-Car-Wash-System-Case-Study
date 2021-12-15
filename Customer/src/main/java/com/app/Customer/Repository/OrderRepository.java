package com.app.Customer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.Customer.Model.Customer;
import com.app.Customer.Model.Order;
@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
}

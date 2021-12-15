package com.app.AdminPanel.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.AdminPanel.Model.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin, Integer> {

}

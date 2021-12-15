package com.app.Customer.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="CustomerData")
public class Customer {
	@Id
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private long phNum;
	private String address;}
	

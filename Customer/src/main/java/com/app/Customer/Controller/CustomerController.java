package com.app.Customer.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.Customer.Model.CarWasher;
import com.app.Customer.Model.Customer;
import com.app.Customer.Repository.CustomerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/allCarWashers")
	@HystrixCommand(fallbackMethod="getFallbackCarWashers")
	public List<?> getCarWashers(){
		return  this.restTemplate.getForObject("http://CarWasherMicroService/Carwashers/allcarwashers", List.class);
	}
	public List<?> getFallbackCarWashers(){
		return Arrays.asList(new CarWasher(0,"No Carwasher",000000000000000,"No model"));
	}
	@PostMapping("/customer")
	public String addorder(@RequestBody Customer customer) {
		customerrepository.save(customer);
		return "Customer  with Id: "+customer.getId()+" has been processed";
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") int id, @RequestBody Customer customer) {
		customerrepository.save(customer);
	}
	
	@GetMapping("/allcustomers")
	public List<Customer>getords(){
		return customerrepository.findAll();
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deletebook(@PathVariable int id) {
		customerrepository.deleteById(id);
		return "Order Deleted with id :"+id;	
	}
	
	@GetMapping("/findord/{id}")
	public Optional<Customer>getord(@PathVariable int id){
		return customerrepository.findById(id);
	}
}
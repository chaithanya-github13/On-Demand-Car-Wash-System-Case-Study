package com.app.AdminPanel.Controller;



import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.AdminPanel.Model.Admin;
import com.app.AdminPanel.Model.CarWasher;
import com.app.AdminPanel.Repository.AdminRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	
	private AdminRepository adminrepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/allorders")
	
	public List<?> getOrders(){
		return  this.restTemplate.getForObject("http://Customer/Ord/allorders", List.class);
	}
	@GetMapping("/allcars")
	public List<?> getCars(){
		return  this.restTemplate.getForObject("http://Customer/Car/allcars", List.class);
	}

	
	@GetMapping("/allCarWashers")
	@HystrixCommand(fallbackMethod="getFallbackCarWashers")
	public List<?> getCarWashers(){
		return  this.restTemplate.getForObject("http://CarWasher/Carwashers/allcarwashers", List.class);
	}
	public List<?> getFallbackCarWashers(){
		return Arrays.asList(new CarWasher(0,"No Carwasher",000000000000000,"No model"));
	}
	
	
	@PostMapping("/admin")
	public String addorder(@RequestBody Admin admin) {
		adminrepository.save(admin);
		return "Admin  with Id: "+admin.getAdminid()+" has been Added";
	}
	
	@RequestMapping(value="/admin/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") int id, @RequestBody Admin admin) {
		adminrepository.save(admin);
	}
	
	@GetMapping("/admindata")
	public List<Admin> getadmin(){
		return adminrepository.findAll();
	}

	
}
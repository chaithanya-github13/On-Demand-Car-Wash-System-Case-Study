package com.app.CarWasher.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.CarWasher.Model.CarWasher;
import com.app.CarWasher.Model.IdGenerator;
import com.app.CarWasher.Repository.CarWasherRepository;
import com.app.CarWasher.Repository.IdRepository;



@RestController
@RequestMapping("/Carwashers")
public class CarWasherController {

	@Autowired
	CarWasherRepository carwasherrepository;
	@Autowired
	IdRepository idRepo;
	@Autowired
	private RestTemplate restTemplate;
	@PostMapping("/post")
	public void addCarWasher(@RequestBody CarWasher carWash) {
		IdGenerator idGen= idRepo.findById("carWashId").get();
		carWash.setId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		carwasherrepository.save(carWash);
	}
	@GetMapping("/allorders")
	//@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getOrders(){
		return  this.restTemplate.getForObject("http://Customer/Ord/allorders", List.class);
	}
	//public List<?> getFallbackCarwasher(){
	//	return Arrays.asList(new CarWasher(0,"No",0,00000000,"No service"));
	@GetMapping("/allcars")
	public List<?> getCars(){
		return  this.restTemplate.getForObject("http://Customer/Car/allcars", List.class);
	}
	@PostMapping("/carwasher")
	public String addcarwasher(@RequestBody CarWasher carwasher) {
		carwasherrepository.save(carwasher);
		return "CarWahser  with Id: "+carwasher.getId()+" has been added";
	}
	
	@PutMapping(value="/carwasher/{id}")
	public void update(@PathVariable("id") int id, @RequestBody CarWasher carwasher) {
		carwasherrepository.save(carwasher);
	}
	
	@GetMapping("/allcarwashers")
	public List<CarWasher> getcarwashers(){
		return carwasherrepository.findAll();
	}
	
	@DeleteMapping("/deletecarwasher/{id}")
	public String deletebook(@PathVariable int id) {
		carwasherrepository.deleteById(id);
		return "Order Deleted with id :"+id;	
	}
	
	@GetMapping("/findord/{id}")
	public Optional<CarWasher>getord(@PathVariable int id){
		return carwasherrepository.findById(id);
	}
}
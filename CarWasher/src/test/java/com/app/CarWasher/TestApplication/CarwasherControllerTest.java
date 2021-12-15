package com.app.CarWasher.TestApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import com.app.CarWasher.Controller.CarWasherController;
import com.app.CarWasher.Model.CarWasher;
import com.app.CarWasher.Repository.CarWasherRepository;

@TestConfiguration
@SpringBootTest
public class CarwasherControllerTest {
	@Mock
	private CarWasherRepository carRepo;

	@InjectMocks
	private CarWasherController contr;
	
	public List<CarWasher> carwasher;
	
	@Test 
	void getAllCarWasherTest() {
		when(carRepo.findAll()).thenReturn(Stream
				.of(new CarWasher(1,"chay","v","chay@gmail.com","9505752699","tadepalligudem"),
					new CarWasher(2,"chay","","","","")).collect(Collectors.toList()));
		assertEquals(2,contr.getcarwashers().size());
	}
	
	
	
	@Test 
	public void getCarWasherByIdTest(){
		CarWasher carWasher = new CarWasher (1,"33","mahi","mahi@gmail.com","5y","Engine specialist");
		Optional<CarWasher> op = Optional.of(carWasher);
		when(carRepo.findById(2)).thenReturn(op);
		assertEquals(5,op.get().getId());
	}
	
//	@Test 
//	public void TestFindByName(){
//		CarWasher carWasher = new CarWasher(7,"","","","");
//		//carwasher.add(new CarWasher (7,129,"","","",""));
//		Optional<CarWasher> op = Optional.of(carWasher);
//		when(carRepo.findByName("")).thenReturn(op);
//		assertEquals("",carWasher.getCarwashername());
//	}

	//@Test 
	//public void UpdateCarWasherByIdTest(){
	//	CarWasher carWasher = new CarWasher (5,"33","","","","");
	//	Optional<CarWasher> op = Optional.of(carWasher);
	//when(contr.update(6, carWasher)).thenReturn(op);
	//	assertEquals(6,op.get().getId());
	//}
//	
}
package com.app.CarWasher.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.CarWasher.Model.AuthenticationRequest;
import com.app.CarWasher.Model.AuthenticationResponse;
import com.app.CarWasher.Model.UserModel;
import com.app.CarWasher.Repository.CarWasherRepository;
import com.app.CarWasher.Repository.UserRepository;
import com.app.CarWasher.service.UserService;
import com.app.CarWasher.util.JwtUtil;



@RestController
public class AuthController {
	
	@Autowired
	private CarWasherRepository carwasherrepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
//To Subscribe to the green car wash like register
	//To Subscribe to the green car wash like register
		@PostMapping("/subs")
		private ResponseEntity<?> subscibeCustomer(@RequestBody AuthenticationRequest authenticationRequest){
			String username = authenticationRequest.getUsername();
			String password = authenticationRequest.getPassword();
		
			UserModel userModel = new UserModel();
			userModel.setUsername(username);
			userModel.setPassword(password);
			
			try {
				userRepository.save(userModel);
			} catch (Exception e) {
				return ResponseEntity.ok(new AuthenticationResponse("Error creating user with username: "+ username));
			}
			return ResponseEntity.ok(new AuthenticationResponse("Created user with username: "+ username));
		}
		
	//For authentication
		@PostMapping("/auth")
		private ResponseEntity<?> authenticateCustomer(@RequestBody AuthenticationRequest authenticationRequest){
			String username = authenticationRequest.getUsername();
			String password = authenticationRequest.getPassword();
			
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			}catch(Exception e) {
				return ResponseEntity.ok(new AuthenticationResponse("No user found with username: "+ username));
			}
			UserDetails loadedUser =userService.loadUserByUsername(username);
			String generatedToken = jwtUtil.generateToken(loadedUser);
			
			return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		}}
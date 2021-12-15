package com.app.Customer.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CarWahserData")
public class CarWasher {
	
	
	public CarWasher() {
	}
	@Id
	private int carwasherid;
	private String carwashername;
	private int rating;
	private String carwasherservices;
	public CarWasher(int carwasherid, String carwashername, int rating, String carwasherservices) {
		super();
		this.carwasherid = carwasherid;
		this.carwashername = carwashername;
		this.rating = rating;
		this.carwasherservices = carwasherservices;
	}
	public int getCarwasherid() {
		return carwasherid;
	}
	public void setCarwasherid(int carwasherid) {
		this.carwasherid = carwasherid;
	}
	public String getCarwashername() {
		return carwashername;
	}
	public void setCarwashername(String carwashername) {
		this.carwashername = carwashername;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCarwasherservices() {
		return carwasherservices;
	}
	public void setCarwasherservices(String carwasherservices) {
		this.carwasherservices = carwasherservices;
	}
	@Override
	public String toString() {
		return "CarWasher [carwasherid=" + carwasherid + ", carwashername=" + carwashername + ", rating=" + rating
				+ ", carwasherservices=" + carwasherservices + "]";
	}
}
	
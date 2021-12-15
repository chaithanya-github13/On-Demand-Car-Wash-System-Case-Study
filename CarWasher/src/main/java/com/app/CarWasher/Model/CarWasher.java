package com.app.CarWasher.Model;
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
@Document(collection="CarWasherData")
public class CarWasher {
	@Id
	public long id;
	private String firstName;
	private String lastName;
	public String emailId;
	public String phNum;
	public String address;
}
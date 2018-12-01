package tj.udemy.userdetails.dto;

import tj.udemy.Commons.BaseClass.BaseDto;

public class UserDetailsDto extends BaseDto{

	private String phoneNumber;
	
	private String address;
	
	private String city;

	public UserDetailsDto(Long id, String phoneNumber, String address, String city) {
		super(id);
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
	}

	public UserDetailsDto() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	
}

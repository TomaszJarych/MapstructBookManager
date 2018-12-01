package tj.udemy.userdetails.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tj.udemy.Commons.BaseClass.BaseEntity;

@Entity
@Table(name = "app_user_details")
public class UserDetails extends BaseEntity {

	private String phoneNumber;

	private String address;

	private String city;

	public UserDetails() {
		super();
	}

	public UserDetails(Long id, String phoneNumber, String address, String city) {
		super(id);
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
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

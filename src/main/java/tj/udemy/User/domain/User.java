package tj.udemy.User.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import tj.udemy.Commons.BaseClass.BaseEntity;
import tj.udemy.Commons.ENUM.UserRole;

@Entity
@Table(name="app_user")
public class User  extends BaseEntity{
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String login;
	
	private LocalDateTime created = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User(Long id, String firstName, String lastName, String email, String login, LocalDateTime created,
			UserRole userRole) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.created = created;
		this.userRole = userRole;
	}

	public User() {
		super();
	}
	
	
	
	
	
	

	
	
}

package tj.udemy.User.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import tj.udemy.Commons.BaseClass.BaseDto;
import tj.udemy.Commons.ENUM.UserRole;
import tj.udemy.book.dto.BookDto;
import tj.udemy.userdetails.dto.UserDetailsDto;

public class UserDto extends BaseDto {

	private String firstName;

	private String lastName;

	private String email;

	private String login;

	private LocalDateTime created = LocalDateTime.now();

	private UserRole userRole;
	
	private String password;
	
	private UserDetailsDto details;
	
	List<BookDto> books = new ArrayList<>();


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
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(Long id, String firstName, String lastName, String email, String login, LocalDateTime created,
			UserRole userRole) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.created = created;
		this.userRole = userRole;
	}

	public UserDto() {
		super();
	}

	public UserDetailsDto getDetails() {
		return details;
	}

	public void setDetails(UserDetailsDto details) {
		this.details = details;
	}

	public List<BookDto> getBooks() {
		return books;
	}

	public void setBooks(List<BookDto> books) {
		this.books = books;
	}
	
	

	
}

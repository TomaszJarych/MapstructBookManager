package tj.udemy.User.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import tj.udemy.Commons.BaseClass.BaseEntity;
import tj.udemy.Commons.ENUM.UserRole;
import tj.udemy.book.domain.Book;
import tj.udemy.userdetails.domain.UserDetails;

@Entity
@Table(name="app_user")
public class User  extends BaseEntity{
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String login;
	
	private LocalDateTime created = LocalDateTime.now();
	
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@OneToOne(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="app_user_details_id")
	private UserDetails details;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
	private List<Book> books = new ArrayList<>();

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

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	
	
	
	
	
	
	

	
	
}

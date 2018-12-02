package tj.udemy.book.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import tj.udemy.Commons.BaseClass.BaseEntity;
import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;

public class BookDto extends BaseEntity {

	private String title;
	private String isbn;
	private String author;

	private UserDto owner;

	public BookDto() {
		super();
	}

	public BookDto(Long id, String title, String isbn, String author, UserDto owner) {
		super(id);
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

}

package tj.udemy.book.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tj.udemy.Commons.BaseClass.BaseEntity;
import tj.udemy.User.domain.User;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

	private String title;
	private String isbn;
	private String author;

	@ManyToOne(fetch=FetchType.EAGER)
	private User owner;

	public Book() {
		super();
	}

	public Book(Long id, String title, String isbn, String author, User owner) {
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}

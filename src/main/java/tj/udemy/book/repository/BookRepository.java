package tj.udemy.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tj.udemy.book.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

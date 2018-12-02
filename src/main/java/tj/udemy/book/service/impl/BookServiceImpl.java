package tj.udemy.book.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tj.udemy.book.domain.Book;
import tj.udemy.book.dto.BookDto;
import tj.udemy.book.mapper.BookMapper;
import tj.udemy.book.repository.BookRepository;
import tj.udemy.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final BookMapper mapper;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository, BookMapper mapper) {
		this.bookRepository = bookRepository;
		this.mapper = mapper;
	}

	@Override
	public BookDto getOneById(Long id) {
		return mapper.bookToBookDto(bookRepository.getOne(id));
	}

	@Override
	public BookDto save(BookDto dto) {
		return mapper.bookToBookDto(bookRepository.save(mapper.bookDtoToBookEntity(dto)));
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			bookRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<BookDto> getAllFromDB() {
		return toBookDtoList(bookRepository.findAll());
	}

	private List<BookDto> toBookDtoList(List<Book> list) {
		return list.stream().filter(Objects::nonNull).map(mapper::bookToBookDto).collect(Collectors.toList());
	}

}

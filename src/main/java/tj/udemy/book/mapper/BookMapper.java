package tj.udemy.book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import tj.udemy.User.mapper.UserMapper;
import tj.udemy.book.domain.Book;
import tj.udemy.book.dto.BookDto;
import tj.udemy.userdetails.mapper.UserDetailsMapper;

@Mapper(componentModel="spring", uses= {UserMapper.class, UserDetailsMapper.class})
public interface BookMapper {
	
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	
	@Mapping(target="owner", qualifiedByName="simpleUserMapper")
	BookDto bookToBookDto(Book book);
	
	Book bookDtoToBookEntity(BookDto dto);

}

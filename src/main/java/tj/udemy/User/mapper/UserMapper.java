package tj.udemy.User.mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;
import tj.udemy.book.domain.Book;
import tj.udemy.book.dto.BookDto;
import tj.udemy.book.mapper.BookMapper;
import tj.udemy.book.mapper.BookMapperImpl;
import tj.udemy.userdetails.mapper.UserDetailsMapper;

@Mapper(componentModel = "spring", uses = {UserDetailsMapper.class,BookMapper.class })
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(ignore = true, target = "password")
	@Mapping(target="details", nullValueCheckStrategy=NullValueCheckStrategy.ALWAYS)
	@Mapping(target="books", qualifiedByName="booksConverter")
	UserDto userToUserDto(User user);
	
	@Named("booksConverter")
	default List<BookDto> toBookList(List<Book> list){
		return list.stream().map(el -> BookMapper.INSTANCE.bookToBookDto(el)).collect(Collectors.toList());
	}
	
	@Mapping(nullValuePropertyMappingStrategy = IGNORE, target = "password")
	User userDtoToUser(UserDto dto);

	@Named("simpleUserMapper")
	@Mapping(target = "books", ignore = true)
	UserDto toSimpleUserDto(User user);

}

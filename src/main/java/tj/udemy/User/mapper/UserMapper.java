package tj.udemy.User.mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;
import tj.udemy.userdetails.mapper.UserDetailsMapper;

@Mapper(componentModel="spring", uses=UserDetailsMapper.class)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(ignore=true, target = "password")
	UserDto userToUserDto(User user);
	
	@Mapping(nullValuePropertyMappingStrategy=IGNORE, target = "password")
	User userDtoToUser(UserDto dto);
	
}

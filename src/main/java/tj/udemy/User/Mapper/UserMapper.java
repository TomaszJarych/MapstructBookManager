package tj.udemy.User.Mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;

@Mapper(componentModel="spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDto userToUserDto(User user);
	
	@InheritInverseConfiguration
	User userDtoToUser(UserDto dto);
}

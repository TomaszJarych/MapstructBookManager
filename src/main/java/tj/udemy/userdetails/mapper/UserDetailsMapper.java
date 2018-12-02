package tj.udemy.userdetails.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import tj.udemy.userdetails.domain.UserDetails;
import tj.udemy.userdetails.dto.UserDetailsDto;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

	UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

	UserDetailsDto userDetailsToUserDetailsDto(UserDetails details);

	UserDetails userDetailsDtoToUserDetailsEntity(UserDetailsDto dto);

}

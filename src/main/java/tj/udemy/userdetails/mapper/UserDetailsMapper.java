package tj.udemy.userdetails.mapper;

import org.mapstruct.Mapper;

import tj.udemy.userdetails.domain.UserDetails;
import tj.udemy.userdetails.dto.UserDetailsDto;

@Mapper(componentModel="spring")
public interface UserDetailsMapper {
	
	UserDetailsDto userDetailsToUserDetailsDto(UserDetails details);
	
	UserDetails userDetailsDtoToUserDetailsEntity(UserDetailsDto dto);

}

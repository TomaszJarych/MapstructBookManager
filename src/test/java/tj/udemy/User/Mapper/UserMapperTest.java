package tj.udemy.User.Mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tj.udemy.Commons.ENUM.UserRole;
import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;
import tj.udemy.User.mapper.UserMapper;

class UserMapperTest {
	
	

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private LocalDateTime created;
	private UserRole userRole;

	@BeforeEach
	void setUp() throws Exception {
		id = 1L;
		firstName="Jan";
		lastName="Kowalski";
		email="email@wp.pl";
		login="jankowal";
		created = LocalDateTime.now();
		userRole = UserRole.USER;
	}

	@Test
	void toUserDtoMethodTest() {
		// given
		User user = new User(id, firstName, lastName, email, login, created, userRole);
		
		UserDto expected = new UserDto(id, firstName, lastName, email, login, created, userRole);
		
		// when
		
		UserDto actual = UserMapper.INSTANCE.userToUserDto(user);
		
		//then
		
		assertNotNull(actual);
		assertAll("UserMapper toUserDto test", 
				()-> assertEquals(expected.getId(), actual.getId()),
				()-> assertEquals(expected.getFirstName(), actual.getFirstName()),
				()-> assertEquals(expected.getLastName(), actual.getLastName()),
				()-> assertEquals(expected.getEmail(), actual.getEmail()),
				()-> assertEquals(expected.getLogin(), actual.getLogin()),
				()-> assertEquals(expected.getCreated(), actual.getCreated()),
				()-> assertEquals(expected.getUserRole(), actual.getUserRole()));
	}
	
	@Test
	void toUserEntityMethodTest() {
		// given
		
		UserDto dto = new UserDto(id, firstName, lastName, email, login, created, userRole);
		
		User expected = new User(id, firstName, lastName, email, login, created, userRole);
		// when
		
		User actual = UserMapper.INSTANCE.userDtoToUser(dto);
		
		//then
		
		assertNotNull(actual);
		assertAll("UserMapper toUserEntity test", 
				()-> assertEquals(expected.getId(), actual.getId()),
				()-> assertEquals(expected.getFirstName(), actual.getFirstName()),
				()-> assertEquals(expected.getLastName(), actual.getLastName()),
				()-> assertEquals(expected.getEmail(), actual.getEmail()),
				()-> assertEquals(expected.getLogin(), actual.getLogin()),
				()-> assertEquals(expected.getCreated(), actual.getCreated()),
				()-> assertEquals(expected.getUserRole(), actual.getUserRole()));
	}

}

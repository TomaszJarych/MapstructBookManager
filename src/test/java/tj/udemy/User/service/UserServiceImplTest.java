package tj.udemy.User.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tj.udemy.Commons.ENUM.UserRole;
import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;
import tj.udemy.User.mapper.UserMapper;
import tj.udemy.User.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	private UserServiceImpl service;

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private LocalDateTime created;
	private UserRole userRole;

	@BeforeEach
	void setUp() throws Exception {
		service = new UserServiceImpl(userRepository, UserMapper.INSTANCE);

		id = 1L;
		firstName = "Jan";
		lastName = "Kowalski";
		email = "email@wp.pl";
		login = "jankowal";
		created = LocalDateTime.now();
		userRole = UserRole.USER;

	}

	@Test
	void testGetOneById() {
		// given
		UserDto expected = new UserDto(id, firstName, lastName, email, login, created, userRole);
		User stub = new User(id, firstName, lastName, email, login, created, userRole);

		when(userRepository.getOne(id)).thenReturn(stub);

		// when
		UserDto actual = service.getOneById(id);

		// then
		verify(userRepository, times(1)).getOne(id);
		assertNotNull(actual);
		assertAll("UserService getById() method test", () -> assertEquals(expected.getId(), actual.getId()),
				() -> assertEquals(expected.getFirstName(), actual.getFirstName()),
				() -> assertEquals(expected.getLastName(), actual.getLastName()),
				() -> assertEquals(expected.getEmail(), actual.getEmail()),
				() -> assertEquals(expected.getLogin(), actual.getLogin()),
				() -> assertEquals(expected.getCreated(), actual.getCreated()),
				() -> assertEquals(expected.getUserRole(), actual.getUserRole()));
	}

	@Test
	void testSave() {
		// given
		UserDto expected = new UserDto(id, firstName, lastName, email, login, created, userRole);
		UserDto dtoStub = new UserDto(id, firstName, lastName, email, login, created, userRole);
		User entityStub = new User(id, firstName, lastName, email, login, created, userRole);

		when(userRepository.save(any(User.class))).thenReturn(entityStub);

		// when
		UserDto actual = service.save(dtoStub);

		// then

		verify(userRepository, times(1)).save(any(User.class));
		assertNotNull(actual);
		assertAll("UserService save() method test", () -> assertEquals(expected.getId(), actual.getId()),
				() -> assertEquals(expected.getFirstName(), actual.getFirstName()),
				() -> assertEquals(expected.getLastName(), actual.getLastName()),
				() -> assertEquals(expected.getEmail(), actual.getEmail()),
				() -> assertEquals(expected.getLogin(), actual.getLogin()),
				() -> assertEquals(expected.getCreated(), actual.getCreated()),
				() -> assertEquals(expected.getUserRole(), actual.getUserRole()));

	}

	@Test
	void testDeleteById() {
		// when
		service.deleteById(id);
		// then
		verify(userRepository, times(1)).deleteById(Mockito.anyLong());
	}

	@Test
	void testGetAllFromDB() {
		// given
		List<UserDto> expected = Arrays
				.asList(new UserDto(id, firstName, lastName, email, login, created, userRole),
						new UserDto(id, firstName, lastName, email, login, created, userRole));

		List<User> userListStub = Arrays
				.asList(new User(id, firstName, lastName, email, login, created, userRole),
						new User(id, firstName, lastName, email, login, created, userRole));
		
		when(userRepository.findAll()).thenReturn(userListStub);
		
		//when
		
		List<UserDto> actual = service.getAllFromDB();
		
		//then
		
		verify(userRepository, times(1)).findAll();
		assertNotNull(actual);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).getId(), actual.get(i).getId());
			assertEquals(expected.get(i).getFirstName(), actual.get(i).getFirstName());
			assertEquals(expected.get(i).getLastName(), actual.get(i).getLastName());
			assertEquals(expected.get(i).getLogin(), actual.get(i).getLogin());
			assertEquals(expected.get(i).getEmail(), actual.get(i).getEmail());
			assertEquals(expected.get(i).getCreated(), actual.get(i).getCreated());
			assertEquals(expected.get(i).getUserRole(), actual.get(i).getUserRole());
		}
		
		
	}

	@Test
	void testToUserDtoList() {
		// given
		List<User> entityList = Arrays.asList(new User(id, firstName, lastName, email, login, created, userRole));
		List<UserDto> expected = Arrays.asList(new UserDto(id, firstName, lastName, email, login, created, userRole));
		// when
		List<UserDto> actual = service.toUserDtoList(entityList);

		// then
		assertNotNull(actual);
		assertEquals(expected.size(), actual.size());

		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).getId(), actual.get(i).getId());
			assertEquals(expected.get(i).getFirstName(), actual.get(i).getFirstName());
			assertEquals(expected.get(i).getLastName(), actual.get(i).getLastName());
			assertEquals(expected.get(i).getLogin(), actual.get(i).getLogin());
			assertEquals(expected.get(i).getEmail(), actual.get(i).getEmail());
			assertEquals(expected.get(i).getCreated(), actual.get(i).getCreated());
			assertEquals(expected.get(i).getUserRole(), actual.get(i).getUserRole());
		}
//		assertAll("List checking", 
//				() -> assertEquals(expected.get(0).getId(), actual.get(0).getId()),
//				() -> assertEquals(expected.get(0).getFirstName(), actual.get(0).getFirstName()),
//				() -> assertEquals(expected.get(0).getLastName(), actual.get(0).getLastName()),
//				() -> assertEquals(expected.get(0).getLogin(), actual.get(0).getLogin()),
//				() -> assertEquals(expected.get(0).getEmail(), actual.get(0).getEmail()),
//				() -> assertEquals(expected.get(0).getCreated(), actual.get(0).getCreated()),
//				() -> assertEquals(expected.get(0).getUserRole(), actual.get(0).getUserRole()));
	}

}

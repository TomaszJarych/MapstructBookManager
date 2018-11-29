package tj.udemy.User.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tj.udemy.Commons.ENUM.UserRole;
import tj.udemy.User.dto.UserDto;
import tj.udemy.User.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path = "/create", produces = APPLICATION_JSON_UTF8_VALUE)
	public UserDto createData() {
		UserDto dto = new UserDto(null, "Jan", "Kowalski", "email@wp.pl", 
				"jankowal", LocalDateTime.now(),UserRole.ADMIN);
		return userService.save(dto);
	}

}

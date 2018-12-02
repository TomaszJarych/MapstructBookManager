package tj.udemy.User.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tj.udemy.Commons.ENUM.UserRole;
import tj.udemy.Commons.Result.Result;
import tj.udemy.User.dto.UserDto;
import tj.udemy.User.service.UserService;
import tj.udemy.userdetails.dto.UserDetailsDto;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path = "/create", produces = APPLICATION_JSON_UTF8_VALUE)
	public Result createData() {
		UserDto dto = new UserDto(null, "Jan", "Kowalski", "email@wp.pl", "jankowal", LocalDateTime.now(),
				UserRole.ADMIN);
		UserDetailsDto details = new UserDetailsDto(null, "123556", "Piłsudskiego", "Wrocław");
//		dto.setDetails(details);
		return Result.ok(userService.save(dto));
	}

	@GetMapping(path = "/all", produces = APPLICATION_JSON_UTF8_VALUE)
	public Result getAllUsers() {
		return Result.ok(userService.getAllFromDB());
	}

	@GetMapping(path = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	public Result getUserById(@PathVariable("id") Long id) {
		return Result.ok(userService.getOneById(id));
	}

	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	public Result createNewUser(@RequestBody UserDto dto) {
		return Result.ok(userService.save(dto));
	}

	@PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	public Result updateUser(@RequestBody UserDto dto) {
		return Result.ok(userService.save(dto));
	}

	@DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	public Result deleteUser(@PathVariable("id") Long id) {
		return (userService.deleteById(id)) ? Result.okMessage() : Result.error("Cannot delete USER");

	}

}

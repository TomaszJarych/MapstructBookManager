package tj.udemy.User.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tj.udemy.User.domain.User;
import tj.udemy.User.dto.UserDto;
import tj.udemy.User.mapper.UserMapper;
import tj.udemy.User.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public UserDto getOneById(Long id) {
		return userMapper.userToUserDto(userRepository.getOne(id));
	}

	@Override
	public UserDto save(UserDto dto) {
		return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(dto)));
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException | EntityNotFoundException e) {
			return false;
		}
	}

	@Override
	public List<UserDto> getAllFromDB() {
		return toUserDtoList(userRepository.findAll());
	}

	public List<UserDto> toUserDtoList(List<User> list) {
		return list.stream().map(userMapper::userToUserDto).collect(Collectors.toList());
	}

}

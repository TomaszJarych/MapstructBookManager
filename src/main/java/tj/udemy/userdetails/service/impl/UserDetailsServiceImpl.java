package tj.udemy.userdetails.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tj.udemy.User.repository.UserRepository;
import tj.udemy.userdetails.domain.UserDetails;
import tj.udemy.userdetails.dto.UserDetailsDto;
import tj.udemy.userdetails.mapper.UserDetailsMapper;
import tj.udemy.userdetails.repository.UserDetailsRepository;
import tj.udemy.userdetails.service.UserDetailsSrvice;

@Service
public class UserDetailsServiceImpl implements UserDetailsSrvice {

	private final UserDetailsRepository userDetailsRepository;
	private final UserDetailsMapper mapper;

	public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserDetailsMapper mapper) {
		this.userDetailsRepository = userDetailsRepository;
		this.mapper = mapper;
	}

	@Override
	public UserDetailsDto getOneById(Long id) {
		return mapper.userDetailsToUserDetailsDto(userDetailsRepository.getOne(id));
	}

	@Override
	public UserDetailsDto save(UserDetailsDto dto) {
		return mapper
				.userDetailsToUserDetailsDto(userDetailsRepository.save(mapper.userDetailsDtoToUserDetailsEntity(dto)));
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			userDetailsRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<UserDetailsDto> getAllFromDB() {
		return toUserDetailsDtoList(userDetailsRepository.findAll());
	}

	private List<UserDetailsDto> toUserDetailsDtoList(List<UserDetails> list) {
		return list.stream().filter(Objects::nonNull).map(mapper::userDetailsToUserDetailsDto)
				.collect(Collectors.toList());
	}
}

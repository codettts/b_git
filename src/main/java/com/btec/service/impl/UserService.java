package com.btec.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.btec.converter.UserConverter;
import com.btec.dto.UserDTO;
import com.btec.entity.ClassEntity;
import com.btec.entity.UserEntity;
import com.btec.repository.RoleRepository;
import com.btec.repository.UserRepository;
import com.btec.service.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired UserConverter userConverter;
	
	@Override
	public UserDTO findOne(String username) {
		// TODO Auto-generated method stub
		UserDTO usermodel = new UserDTO();
		UserEntity entities = userRepository.findOne(username);
		usermodel = userConverter.toDto(entities);
		return usermodel;
	}

	@Override
	public Map<String, String> findAllTrainer() {
		Long roleId = 2L;
		Map<String, String> result = new HashMap<>();
		List<UserEntity> entities = roleRepository.findOne(roleId).getUsers();
		for (UserEntity item: entities) {
			result.put(item.getUsername(), item.getFullName());
		}
		return result;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> model = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(item.getUsername());
			userDTO.setFullName(item.getFullName());
			userDTO.setPassword(item.getPassword());
			userDTO.setDob(item.getDob());
			userDTO.setEmail(item.getEmail());
			userDTO.setPhoneNumber(item.getPhone());
			model.add(userDTO);
		}
		return model;
	}

	@Override
	public Integer getTotalItem() {
		return (int) userRepository.count();
	}

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item: entities) {
			result.put(item.getUsername(), item.getFullName());
		}
		return result;
	}
	

}

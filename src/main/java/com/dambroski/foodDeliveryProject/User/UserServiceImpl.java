package com.dambroski.foodDeliveryProject.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dambroski.foodDeliveryProject.Address.Address;
import com.dambroski.foodDeliveryProject.error.EmailAlreadyTakenException;
import com.dambroski.foodDeliveryProject.error.MissMatchException;
import com.dambroski.foodDeliveryProject.error.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public List<User> getAll() {
		
		return repository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		return user.get();
	}
	
	@Override
	public List<User>  getUserByName(String name) {
		// TODO Auto-generated method stub
		return repository.getUserByName(name);
	}
	
	@Override
	public User getUserByEmail(String email) {
		User user  = repository.findUserByEmail(email);
		if(user == null) {
			throw new UserNotFoundException("Email Not Found");
		}
		return user;
	}

	
	@Override
	public User postUserAdmin(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		if(repository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyTakenException("Email Arealdy taken");
		}
		user.setRole("admin");
		return repository.save(user);
	}

	@Override
	public User postUser(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		if(repository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyTakenException("Email Arealdy taken");
		}
		user.setRole("user");	
		return repository.save(user);
	}
	
	@Override
	public User postUserDelivery(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		if(repository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyTakenException("Email Arealdy taken");
		}
		user.setRole("delivery");	
		return repository.save(user);
	}
	
	@Override
	public User postUserRestaurant(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		if(repository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyTakenException("Email Arealdy taken");
		}
		user.setRole("restaurant");
		return repository.save(user);
	}
	

	@Override
	public void deleteById(Long id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		repository.deleteById(id);
		
	}

	@Override
	public User editUser(User user,Long id) {
		Optional<User> optionalUser = repository.findById(id);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("UserNotFound");
		}
		User newUser = optionalUser.get();
		if(Objects.nonNull(user.getName()) && !"".equals(user.getName())) {
			newUser.setName(user.getName());
		}
		if(Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())) {
			newUser.setEmail(user.getEmail());
		}
		if(Objects.nonNull(user.getBirthDate())) {
			newUser.setBirthDate(user.getBirthDate());
		}

		
		repository.save(newUser);
		return newUser;
	}

	@Override
	public User addAddress(Address address, Long userId) {
		Optional<User> optionalUser = repository.findById(userId);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		User user =  optionalUser.get();
		if(user.getAddresses() == null) {
			List<Address> listAddress = new ArrayList<>();
			user.setAddresses(listAddress);
		}
		address.setType("USER");
		address.setTypeId(user.getUserId());
		user.getAddresses().add(address);
		return repository.save(user);
	}

	@Override
	public User editAddress(Address address,Long userId, Long addressId) {
		Optional<User> optionalUser = repository.findById(userId);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		User user = optionalUser.get();
		boolean find = false;
		List<Address> addresses = user.getAddresses();
		for (Address addressList : addresses) {
			if(addressList.getId() == addressId) {
				find=true;
				if(Objects.nonNull(address.getAddress())) {
					addressList.setAddress(address.getAddress());
				}if(Objects.nonNull(address.getCity())) {
					addressList.setCity(address.getCity());
				}if(Objects.nonNull(address.getState())) {
					addressList.setState(address.getState());
				}
			}
		}
		if(!find) {
			throw new MissMatchException("User dont have this address");
		}
		user.setAddresses(addresses);
		repository.save(user);
		return user;
	}

	

	

	
	

	

	

}

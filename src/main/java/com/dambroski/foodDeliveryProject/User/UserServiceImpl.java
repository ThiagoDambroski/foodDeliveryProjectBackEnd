package com.dambroski.foodDeliveryProject.User;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	
	@Override
	public User postUserAdmin(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		user.setRole("admin");
		return repository.save(user);
	}

	@Override
	public User postUser(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		user.setRole("user");	
		return repository.save(user);
	}
	
	@Override
	public User postUserDelivery(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		user.setRole("delivery");	
		return repository.save(user);
	}
	
	@Override
	public User postUserRestaurant(User user) {
		user.setPwd(encoder.encode(user.getPwd()));
		user.setRole("restaurant");
		return repository.save(user);
	}
	

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public User editUser(User user,Long id) {
		User newUser = repository.findById(id).get();
		if(Objects.nonNull(user.getName()) && !"".equals(user.getName())) {
			newUser.setName(user.getName());
		}
		if(Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())) {
			newUser.setEmail(user.getEmail());
		}
		newUser.setBirthDate(user.getBirthDate());
		
		repository.save(newUser);
		return newUser;
	}

	

	

	

}

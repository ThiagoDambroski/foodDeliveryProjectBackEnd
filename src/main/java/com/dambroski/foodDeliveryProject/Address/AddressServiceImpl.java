package com.dambroski.foodDeliveryProject.Address;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.error.AddressNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository repository;

	@Override
	public List<Address> getAll() {

		
		return repository.findAll();
	}

	@Override
	public void deleteAddress(Long addressId) {
		Optional<Address> optionalAddress = repository.findById(addressId);
		if(optionalAddress.isEmpty()) {
			throw new AddressNotFoundException("Address Not Found");
		}
		repository.deleteById(addressId);
		
	}

}

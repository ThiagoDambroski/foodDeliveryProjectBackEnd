package com.dambroski.foodDeliveryProject.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService service;

	@GetMapping("/getAll")
	public List<Address> getAllAddress(){
		return service.getAll();
	}
	
	@DeleteMapping("/deleteAddres/{addressId}")
	public void deleteAddress(@PathVariable("addressId")Long addressId) {
		service.deleteAddress(addressId);
	}
}

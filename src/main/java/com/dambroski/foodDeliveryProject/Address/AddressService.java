package com.dambroski.foodDeliveryProject.Address;

import java.util.List;

public interface AddressService {

	List<Address> getAll();

	void deleteAddress(Long addressId);

}

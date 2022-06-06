package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.AddressData;
import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.model.Address;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class AddressService {
	@Autowired
	private AddressData addressData;

	public List<Address> findAll() {
		return addressData.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = addressData.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Address insert(Address obj) {
		return addressData.save(obj);
	}

	public void delete(Long id) {
		try {
			addressData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Address update(Long id, Address obj) {
		Address entity = addressData.getReferenceById(id);
		updateData(entity, obj);
		return addressData.save(entity);
	}

	private void updateData(Address entity, Address obj) {
		entity.setStreet(obj.getStreet());
		entity.setNumber(obj.getNumber());
		entity.setCity(obj.getCity());
		entity.setDistrict(obj.getDistrict());
		entity.setState(obj.getState());
		entity.setZipcode(obj.getZipcode());
	}

}

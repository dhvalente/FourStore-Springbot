package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientData clientData;

	public List<Client> findAll() {
		return clientData.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> obj = clientData.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return clientData.save(obj);
	}
	
	public void delete(Long id) {
		try {
			clientData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Client update(Long id, Client obj) {
		Client entity = clientData.getReferenceById(id);
		updateData(entity, obj);
		return clientData.save(entity);
	}

	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
		
	}
}

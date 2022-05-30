package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.model.Client;

@Service
public class ClientService {
	@Autowired
	private ClientData clientData;

	public List<Client> findAll() {
		return clientData.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> obj = clientData.findById(id);
		return obj.get();
	}
}

package br.com.foursys.fourcamp.fourstore.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.foursys.fourcamp.fourstore.dto.ClientDto;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<ClientDto>> findAll(String cpf) {
		if(cpf == null) {
			List<Client> list = clientService.findAll();
			return ResponseEntity.ok().body(ClientDto.converter(list));
		}
		List<Client> list = clientService.findByCpf(cpf);
		return ResponseEntity.ok().body(ClientDto.converter(list));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client obj = clientService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Client> insert(@Valid @RequestBody Client obj) {
		obj = clientService.insert(obj);
		// Para retornar com status 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id , @RequestBody Client obj) {
		obj = clientService.update(id, obj);
		return ResponseEntity.ok(obj);
	}
}

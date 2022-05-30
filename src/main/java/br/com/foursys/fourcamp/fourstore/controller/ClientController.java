package br.com.foursys.fourcamp.fourstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursys.fourcamp.fourstore.model.Client;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@GetMapping
	public ResponseEntity<Client> findAll(){
		Client c = new Client(12L, "Diogo Valente", "08899977712");
		return ResponseEntity.ok().body(c);
	}
}

/*package br.com.foursys.fourcamp.fourstore.controller;

import java.net.URI;
import java.util.List;

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

import br.com.foursys.fourcamp.fourstore.model.Season;
import br.com.foursys.fourcamp.fourstore.model.Stock;
import br.com.foursys.fourcamp.fourstore.service.SeasonService;
import br.com.foursys.fourcamp.fourstore.service.StockService;

@RestController
@RequestMapping(value = "/stocks")
public class StockController {
	@Autowired
	private StockService stockService;

	@GetMapping
	public ResponseEntity<List<Stock>> findAll() {
		List<Stock> list = stockService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Stock> findById(@PathVariable Long id) {
		Stock obj = stockService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Stock> insert(@RequestBody Stock obj) {
		obj = stockService.insert(obj);
		// Para retornar com status 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		stockService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	

}*/
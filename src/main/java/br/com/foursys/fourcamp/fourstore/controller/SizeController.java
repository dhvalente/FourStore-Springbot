package br.com.foursys.fourcamp.fourstore.controller;

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
import br.com.foursys.fourcamp.fourstore.model.Size;
import br.com.foursys.fourcamp.fourstore.service.SizeService;

@RestController
@RequestMapping(value = "/sizes")
public class SizeController {
	@Autowired
	private SizeService sizeService;

	@GetMapping
	public ResponseEntity<List<Size>> findAll() {
		List<Size> list = sizeService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Size> findById(@PathVariable Long id) {
		Size obj = sizeService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Size> insert(@RequestBody Size obj) {
		obj = sizeService.insert(obj);
		// Para retornar com status 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		sizeService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Size> update(@PathVariable Long id, @RequestBody Size obj) {
		obj = sizeService.update(id, obj);
		return ResponseEntity.ok(obj);
	}

}

package br.com.foursys.fourcamp.fourstore.dto;

import java.io.Serializable;

import br.com.foursys.fourcamp.fourstore.model.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;

	public ClientDTO() {		
	}
	
	public ClientDTO(Long id, Client client) {
		this.id = id;
		this.name = client.getName();
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}

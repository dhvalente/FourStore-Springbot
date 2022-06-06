package br.com.foursys.fourcamp.fourstore.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.foursys.fourcamp.fourstore.model.Client;

public class ClientDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String cpf;
	
	public ClientDto(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
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
	

	public String getCpf() {
		return cpf;
	}

	public void setRua(String cpf) {
		this.cpf = cpf;
	}

	public static List<ClientDto> converter(List<Client> topicos) {
		return topicos.stream().map(ClientDto::new).collect(Collectors.toList());
	}

}

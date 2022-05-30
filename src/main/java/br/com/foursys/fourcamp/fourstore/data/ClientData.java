package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.fourstore.model.Client;

public interface ClientData extends JpaRepository<Client, Long> {

}

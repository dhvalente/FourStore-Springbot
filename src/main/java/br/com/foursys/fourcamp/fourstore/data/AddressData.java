package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.fourstore.model.Address;


public interface AddressData extends JpaRepository<Address, Long> {

}
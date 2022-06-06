package br.com.foursys.fourcamp.fourstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_stock")
public class Stock implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
    @OneToOne
	private Product product;
    
	private Integer quantity;
	
	public Stock() {		
	}

	public Stock(Long id, Product product, Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}	
	

	public Long getId() {
		return id;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Stock [product=" + product.getName() + ", quantity=" + quantity + "]";
	}
	
	
}

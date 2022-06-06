package br.com.foursys.fourcamp.fourstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	private String name;
	private Double purchasePrice;
	private Double sellPrice;
	private String sku;	

	
	@ManyToOne
	@JoinColumn(name="tb_season", referencedColumnName = "id")  
	private Season season;
	
	@ManyToOne
	@JoinColumn(name="tb_size", referencedColumnName = "id")  
	private Size size;
	

	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	

	
	public Product() {	
	}

	public Product(Long id, String name, Season season, Size size, Double purchasePrice,
			Double sellPrice) {
		super();
		this.id = id;
		this.name = name;
		this.season = season;
		this.size = size;
		this.purchasePrice = purchasePrice;
		this.sellPrice = sellPrice;

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


	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}


	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	@JsonIgnore
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> set = new HashSet<>();
		for (OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", season=" + season + ", size=" + size
				+ ", purchasePrice=" + purchasePrice + ", sellPrice=" + sellPrice + ", sku=" + sku + ", categories="
				+ categories + ", items=" + items + "]";
	}

}

package com.restex.RestApi.entity;
//import java.util.Date;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_info")
public class Item {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private Double ReservePrice;
	private LocalDateTime DateAdded;

	public Item() {
		
	}

	public Item(int id, String description, Double reservePrice) {
		super();
		this.id = id;
		this.description = description;
		ReservePrice = reservePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "ReservePrice", nullable = false)
	public Double getReservePrice() {
		return ReservePrice;
	}

	public void setReservePrice(Double ReservePrice) {
		this.ReservePrice = ReservePrice;
	}

	public LocalDateTime getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		DateAdded =  LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", ReservePrice=" + ReservePrice + "]";
	}

}


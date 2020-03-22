package com.restex.RestApi.entity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// NOTE: The bids themselves are being created by a trigger on the item info table.
@Entity
@Table(name = "bids")
public class Bid {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int item_id;
	private String itemDescription;
	private Double ReservePrice;
	private LocalDateTime DateAdded;
	
	public Bid() {
		
	};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	@Column(name = "item_description", nullable = false)
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	@Column(name = "ReservePrice", nullable = false)
	public Double getReservePrice() {
		return ReservePrice;
	}
	public void setReservePrice(Double reservePrice) {
		ReservePrice = reservePrice;
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		DateAdded =  LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Item [id=" + item_id + ", description=" + itemDescription + ", ReservePrice=" + ReservePrice + "]";
	}

}

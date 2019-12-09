package com.nishant.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nishant.models.ItemModel;

@Entity
@Table(name = "ITEM")
public class ItemEntity implements ItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EXPIRY")
	private String expiry;

	@Column(name = "PURCHASE_DATE", nullable = false)
	private Date purchaseDate;

	@Override
	public boolean equals(ItemModel obj) {// use impl/entity
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		ItemEntity other = (ItemEntity) obj;
		if (this.expiry == null) {
			if (other.expiry != null) {
				return false;
			}
		} else if (!this.expiry.equals(other.expiry)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.purchaseDate == null) {
			if (other.purchaseDate != null) {
				return false;
			}
		} else if (!this.purchaseDate.equals(other.purchaseDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String getExpiry() {
		return this.expiry;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	@Override
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;

	}

	@Override
	public String toString() {
		return "Item [id=" + this.id + ", name=" + this.name + ", expiry=" + this.expiry + ", purchaseDate="
				+ this.purchaseDate + "]";
	}

}

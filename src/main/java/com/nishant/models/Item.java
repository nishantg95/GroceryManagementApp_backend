package com.nishant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.naming.java.javaURLContextFactory;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="EXPIRY")
	private String expiry;
	
	
	@Column(name="PURCHASE_DATE",nullable = false)
	private java.sql.Date purchaseDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public java.sql.Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(java.sql.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiry == null) ? 0 : expiry.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (expiry == null) {
			if (other.expiry != null)
				return false;
		} else if (!expiry.equals(other.expiry))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", expiry=" + expiry + ", purchaseDate=" + purchaseDate + "]";
	}

	
	
	
	
}

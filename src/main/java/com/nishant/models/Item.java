package com.nishant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EXPIRY")
	private String expiry;

	// Server is running in CST timezone, better approach- custom JSON
	// Serializer/Deserializer
	@JsonFormat(pattern = "MM-dd-yyyy", timezone = "CST")
	@Column(name = "PURCHASE_DATE", nullable = false)
	private Date purchaseDate;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
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

	public String getExpiry() {
		return this.expiry;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.expiry == null) ? 0 : this.expiry.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.purchaseDate == null) ? 0 : this.purchaseDate.hashCode());
		return result;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPurchaseDate(Date purchaseDate) {
		// TODO Auto-generated constructor stub
		this.purchaseDate = purchaseDate;

	}

	@Override
	public String toString() {
		return "Item [id=" + this.id + ", name=" + this.name + ", expiry=" + this.expiry + ", purchaseDate="
				+ this.purchaseDate + "]";
	}

}

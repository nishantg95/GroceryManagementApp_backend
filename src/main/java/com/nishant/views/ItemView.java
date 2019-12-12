/**
 *
 */
package com.nishant.views;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nishant.models.ItemModel;

/**
 * @author nishant.b.grover
 *
 */
public class ItemView implements ItemModel {

	private Integer id;

	private String name;

	private String expiry;

	// Server is running in CST timezone, better approach- custom JSON
	// Serializer/Deserializer
	@JsonFormat(pattern = "MM-dd-yyyy", timezone = "CST")
	private Date purchaseDate;

	@Override
	public boolean equals(ItemModel obj) {
		// TODO Auto-generated method stub
		return false;
	}

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
		ItemView other = (ItemView) obj;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.expiry == null) ? 0 : this.expiry.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.purchaseDate == null) ? 0 : this.purchaseDate.hashCode());
		return result;
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

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

	@Column(name = "SHELF_LIFE")
	private String shelfLife;

	@Column(name = "STORAGE_STATE", nullable = false)
	private String storageState;

	@Column(name = "PURCHASE_DATE", nullable = false)
	private Date purchaseDate;

	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;

	@Override
	public Date getExpiryDate() {
		return this.expiryDate;
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
	public String getShelfLife() {
		return this.shelfLife;
	}

	@Override
	public String getStorageState() {
		return this.storageState;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	@Override
	public void setStorageState(String storageState) {
		this.storageState = storageState;
	}
}

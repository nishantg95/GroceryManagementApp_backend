package com.nishant.models;

import java.util.Date;

public interface ItemModel {

	public Date getExpiryDate();

	public Integer getId();

	public String getName();

	public Date getPurchaseDate();

	public String getShelfLife();

	public String getStorageState();

	public void setExpiryDate(Date expiryDate);

	public void setId(Integer id);

	public void setName(String name);

	public void setPurchaseDate(Date purchaseDate);

	public void setShelfLife(String shelfLife);

	public void setStorageState(String storageState);

}

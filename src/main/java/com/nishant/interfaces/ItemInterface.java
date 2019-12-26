package com.nishant.interfaces;

import java.util.Date;

public interface ItemInterface {

	Date getExpiryDate();

	Integer getId();

	String getName();

	Date getPurchaseDate();

	String getShelfLife();

	String getStorageState();

	void setExpiryDate(Date expiryDate);

	void setId(Integer id);

	void setName(String name);

	void setPurchaseDate(Date purchaseDate);

	void setShelfLife(String shelfLife);

	void setStorageState(String storageState);

}

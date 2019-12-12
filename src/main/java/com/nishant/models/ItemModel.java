package com.nishant.models;

import java.util.Date;

public interface ItemModel {

	public boolean equals(ItemModel obj);

	public String getExpiry();

	public Integer getId();

	public String getName();

	public Date getPurchaseDate();

	public void setExpiry(String expiry);

	public void setId(Integer id);

	public void setName(String name);

	public void setPurchaseDate(Date purchaseDate);

	@Override
	public String toString();

}

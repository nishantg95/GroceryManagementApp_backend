/**
 *
 */
package com.nishant.models;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemsModel {

	public String getrFreezeDate();

	public String getrFridgeDate();

	public Integer getrId();

	public String getrName();

	public String getrPantryDate();

	public void setrFreezeDate(String rFreezeDate);

	public void setrFridgeDate(String rFridgeDate);

	public void setrId(Integer rId);

	public void setrName(String rName);

	public void setrPantryDate(String rPantryDate);
}

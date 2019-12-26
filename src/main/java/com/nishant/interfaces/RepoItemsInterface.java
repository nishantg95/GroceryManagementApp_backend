/**
 *
 */
package com.nishant.interfaces;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemsInterface {

	String getrFreezeDate();

	String getrFridgeDate();

	Integer getrId();

	String getrName();

	String getrPantryDate();

	void setrFreezeDate(String rFreezeDate);

	void setrFridgeDate(String rFridgeDate);

	void setrId(Integer rId);

	void setrName(String rName);

	void setrPantryDate(String rPantryDate);
}

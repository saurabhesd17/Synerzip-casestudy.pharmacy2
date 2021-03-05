package com.example.services;

import java.util.List;

import com.example.entities.Medicine;

public interface MedicineService {
	/**
	 * @return number of rows affected after inserting new medicine
	 */
	public int create(Medicine medicine);

	/**
	 * @return number of rows affected below method deletes the medicine from table
	 *         by getting id.
	 */
	public int delete(int id);

	/**
	 * @return list of medicines searches medicine by name.
	 */
	public List<Medicine> searchByName(String name);

	/**
	 * @return list of medicines searches medicine by brand.
	 */
	public List<Medicine> searchByBrand(String name);
}

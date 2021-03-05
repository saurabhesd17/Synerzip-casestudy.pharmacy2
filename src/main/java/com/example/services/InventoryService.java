package com.example.services;

import java.util.List;

import com.example.entities.Inventory;

public interface InventoryService {
	/**
	 * @return number of rows affected after adding medicine in inventory
	 */
	public int create(Inventory inventory);

	/**
	 * @return list of all medicines in the inventory
	 */
	public List<Inventory> medicineList();
}

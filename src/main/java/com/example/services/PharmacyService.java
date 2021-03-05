package com.example.services;

import java.util.List;

import com.example.entities.Order;
import com.example.entities.Pharmacy;

public interface PharmacyService {
	/**
	 * @return number of rows affected after inserting new row in pharmacy column.
	 */
	public int create(Pharmacy pharmacy);

	/**
	 * @return number of rows affected deletes the pharmacy from pharmacy table by
	 *         getting id of pharmacy.
	 */
	public int delete(int id);

	/**
	 * @return pharmacy below method returns the information of Pharmacy from
	 *         pharmacy table it accepts id of pharmacy and stores the info on
	 *         pharmacy object.
	 */
	public Pharmacy information(int id);
	
	/**
	 * 
	 * @param id
	 * @return list of all orders in pharmacy.
	 */
	public List<Order> showAllOrders(int id);
}

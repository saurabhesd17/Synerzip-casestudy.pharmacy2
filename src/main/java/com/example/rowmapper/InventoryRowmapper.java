package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.entities.Inventory;
import com.example.entities.Medicine;
import com.example.entities.Pharmacy;

public class InventoryRowmapper implements RowMapper<Inventory>{

	public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Inventory inventory = new Inventory();
		inventory.setId(rs.getInt(1));	
		
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt(2));
		inventory.setMedicine(medicine);
		
		inventory.setStock(rs.getLong(3));
		
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setId(rs.getInt(4));
		inventory.setPharmacy(pharmacy);
		return inventory;
	}
	
}

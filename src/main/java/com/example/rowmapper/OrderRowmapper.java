package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.entities.Medicine;
import com.example.entities.Order;
import com.example.entities.Pharmacy;

public class OrderRowmapper implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt(1));
		
		order.setOrderStatus(rs.getString(2));
		
		order.setQuantity(rs.getInt(3));
		
		Medicine medicine = new  Medicine();
		medicine.setId(rs.getInt(4));
		order.setMedicine(medicine);
		
		
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setId(rs.getInt(5));
		order.setPharmacy(pharmacy);
		return order;
	}
	
}

package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.entities.Inventory;
import com.example.rowmapper.InventoryRowmapper;
import com.example.services.InventoryService;

public class InventoryServiceImpl implements InventoryService {
	private JdbcTemplate jdbcTemplate;

	public int create(Inventory inventory) {
		String query = "insert into inventory(id, medicine_id, stock, pharmacy_id) values(?,?,?,?)";
		int count = this.jdbcTemplate.update(query, inventory.getId(), inventory.getMedicine().getId(),
				inventory.getStock(), inventory.getPharmacy().getId());
		return count;
	}

	public List<Inventory> medicineList() {
		String query = "select * from inventory";
		List<Inventory> medicine = this.jdbcTemplate.query(query, new InventoryRowmapper());
		return medicine;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

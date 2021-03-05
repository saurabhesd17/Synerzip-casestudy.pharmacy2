package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.entities.Order;
import com.example.entities.Pharmacy;
import com.example.rowmapper.OrderRowmapper;
import com.example.rowmapper.PharmacyRowmapper;
import com.example.services.PharmacyService;

public class PharmacyServiceImpl implements PharmacyService {
	private JdbcTemplate jdbcTemplate;

	public int create(Pharmacy pharmacy) {
		String query = "insert into pharmacy(id, name, license, address, contact) values(?,?,?,?,?)";
		int count = this.jdbcTemplate.update(query, pharmacy.getId(), pharmacy.getName(), pharmacy.getLicense(),
				pharmacy.getAddress(), pharmacy.getContact());
		return count;
	}

	public int delete(int id) {
		String query = "delete from pharmacy where id=?";
		int count = this.jdbcTemplate.update(query, id);
		return count;
	}

	public Pharmacy information(int id) {
		String query = "select * from pharmacy where id=?";
		RowMapper<Pharmacy> rowMapper = new PharmacyRowmapper();
		Pharmacy pharmacy = this.jdbcTemplate.queryForObject(query, rowMapper, id);
		return pharmacy;
	}

	public List<Order> showAllOrders(int id) {
		String query = "select * from orders where pharmacy_id = ?";
		List<Order> orders = this.jdbcTemplate.query(query, new OrderRowmapper(), id);
		return orders;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

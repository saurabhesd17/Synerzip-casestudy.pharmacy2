package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.entities.Medicine;
import com.example.rowmapper.MedicineRowmapper;
import com.example.services.MedicineService;

public class MedicineServiceImpl implements MedicineService {
	private JdbcTemplate jdbcTemplate;

	public int create(Medicine medicine) {
		String query = "insert into medicine(id, name, brand) values(?,?,?)";
		int count = this.jdbcTemplate.update(query, medicine.getId(), medicine.getName(), medicine.getBrand());
		return count;
	}

	public int delete(int id) {
		String query = "delete from medicine where id=?";
		int count = this.jdbcTemplate.update(query, id);
		return count;
	}

	public List<Medicine> searchByName(String name) {
		String query = "select * from medicine where name like '%" + name + "%' ";
		List<Medicine> medicine = this.jdbcTemplate.query(query, new MedicineRowmapper());
		return medicine;
	}

	public List<Medicine> searchByBrand(String name) {
		String query = "select * from medicine where brand like '%" + name + "%' ";
		List<Medicine> medicine = this.jdbcTemplate.query(query, new MedicineRowmapper());
		return medicine;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

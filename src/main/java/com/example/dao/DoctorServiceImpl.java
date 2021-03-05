package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.entities.Doctor;
import com.example.rowmapper.DoctorRowmapper;
import com.example.services.DoctorService;

public class DoctorServiceImpl implements DoctorService {
	private JdbcTemplate jdbcTemplate;

	public int create(Doctor doctor) {
		String query = "insert into doctor(id, first_name, last_name) values(?,?,?)";
		int count = this.jdbcTemplate.update(query, doctor.getId(), doctor.getFirstName(), doctor.getLastName());
		return count;
	}

	public int delete(int id) {
		String query = "delete from doctor where id=?";
		int count = this.jdbcTemplate.update(query, id);
		return count;
	}

	public List<Doctor> search(String name) {
		String query = "select * from doctor where first_name like '%" + name + "%' or last_name like '%" + name + "%'";
		List<Doctor> doctor = jdbcTemplate.query(query, new DoctorRowmapper());
		return doctor;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

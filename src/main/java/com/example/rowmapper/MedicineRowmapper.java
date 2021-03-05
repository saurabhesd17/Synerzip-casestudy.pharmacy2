package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.entities.Medicine;

public class MedicineRowmapper implements RowMapper<Medicine>{

	public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt(1));
		medicine.setName(rs.getString(2));
		medicine.setBrand(rs.getString(3));
		return medicine;
	}

}

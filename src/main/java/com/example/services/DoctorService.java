package com.example.services;

import java.util.List;

import com.example.entities.Doctor;

public interface DoctorService {
	/**
	 * @return number of rows affected after successfully creating new row.
	 */
	public int create(Doctor doctor);

	/**
	 * @return number of rows affected deletes the doctor from table by getting
	 *         doctor id.
	 */
	public int delete(int id);

	/**
	 * below methods accepts one parameter as name and searches for either first
	 * name or last name and returns list of matching result.
	 * 
	 * @param name
	 * @return list of doctors
	 */
	public List<Doctor> search(String name);
}

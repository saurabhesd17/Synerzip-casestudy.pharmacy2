package com.example.entities;

public class Inventory {
	private int id;
	private Medicine medicine;
	private Pharmacy pharmacy;
	private long stock;

	public int getId() {
		return id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public long getStock() {
		return stock;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", medicine_id=" + medicine.getId() + ", pharmacy_id=" + pharmacy.getId() + ", stock=" + stock + "]";
	}

}

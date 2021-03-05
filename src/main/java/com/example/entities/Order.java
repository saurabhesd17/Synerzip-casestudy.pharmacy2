package com.example.entities;

public class Order {
	private int id;
	private String orderStatus = "PENDING";
	private int quantity;
	private Medicine medicine;
	private Pharmacy pharmacy;

	public int getId() {
		return id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderStatus=" + orderStatus + ", quantity=" + quantity + ", medicine=" + medicine.getId()
				+ ", pharmacy=" + pharmacy.getId() + "]";
	}

}

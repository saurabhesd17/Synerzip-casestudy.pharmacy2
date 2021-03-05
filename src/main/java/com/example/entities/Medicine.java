package com.example.entities;

public class Medicine {
	private int id;
	private String name;
	private String brand;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", brand=" + brand + "]";
	}

}

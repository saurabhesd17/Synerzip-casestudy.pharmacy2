package com.example.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/Pharmacy.properties")
public class Pharmacy {
	@Value("${id}")
	private int id;
	@Value("${name}")
	private String name;
	@Value("${license}")
	private long license;
	@Value("${address}")
	private String address;
	@Value("${contact}")
	private long contact;
	private Inventory inventory;
	private List<Order> orders;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getLicense() {
		return license;
	}

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLicense(long license) {
		this.license = license;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", name=" + name + ", license=" + license + ", address=" + address + ", contact="
				+ contact + "]";
	}

}

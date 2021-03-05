package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.entities.Order;
import com.example.rowmapper.OrderRowmapper;
import com.example.services.OrderService;

public class OrderServiceImpl implements OrderService {
	private JdbcTemplate jdbcTemplate;

	public int makeOrder(Order order) {
		String query = "insert into orders(id, medicine_id, quantity, status, pharmacy_id) values(?,?,?,?,?)";
		int count = this.jdbcTemplate.update(query, order.getId(), order.getMedicine().getId(), order.getQuantity(),
				order.getOrderStatus(), order.getPharmacy().getId());
		return count;
	}

	public List<Order> pendingOrders() {
		String query = "select * from orders where status like '%pending%'";
		List<Order> order = jdbcTemplate.query(query, new OrderRowmapper());
		return order;
	}

	public int completeOrder(int id) {
		String getQuantity = "select * from orders where id=" + id + " ";
		RowMapper<Order> rowMapper = new OrderRowmapper();
		Order order = this.jdbcTemplate.queryForObject(getQuantity, rowMapper);

		String query = "update orders,inventory set orders.status = 'COMPLETE', inventory.stock = inventory.stock + "
				+ order.getQuantity() + " " + "where orders.medicine_id =" + order.getMedicine().getId() + " and "
						+ "inventory.medicine_id=" + order.getMedicine().getId() + " ";
		int count = jdbcTemplate.update(query);
		return count;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

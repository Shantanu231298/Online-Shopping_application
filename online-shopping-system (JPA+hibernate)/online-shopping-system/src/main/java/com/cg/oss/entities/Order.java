package com.cg.oss.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_pr")
public class Order {
	@Id
	@Column(name = "orderId")
	private String orderId;
	@Column(name = "userId")
	private String userId;
	@Column(name = "addressId")
	private String addressId;
	@Column(name = "orderStatus")
	private String orderStatus;
	@Column(name = "orderdate")
	private LocalDate orderDate;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private Product product;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customer;
	@Embedded
	private Address address;

	public Order() {
	}

	public Order(String orderId, String userId, String addressId, String orderStatus, LocalDate orderDate,
			Product product, Customer customer, Address address) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.addressId = addressId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.product = product;
		this.customer = customer;
		this.address = address;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", addressId=" + addressId + ", orderStatus="
				+ orderStatus + ", orderDate=" + orderDate + ", product=" + product + ", customer=" + customer
				+ ", address=" + address + "]";
	}

}

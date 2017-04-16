package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the vendor database table.
 * 
 */
@Entity
@Table(name="vendor")
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VENDOR_ID", unique=true, nullable=false)
	private int vendorId;

	//bi-directional one-to-one association to Account
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VENDOR_ID", nullable = false, insertable = false, updatable = false)
	private Account account;

	@Column(name="`DESC`", length=200)
	private String desc;

	@Column(length=45)
	private String name;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="vendor")
	private List<Order> orders;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="vendor")
	private List<Product> products;

	public Vendor() {
	}

	public int getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setVendor(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setVendor(null);

		return order;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setVendor(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setVendor(null);

		return product;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
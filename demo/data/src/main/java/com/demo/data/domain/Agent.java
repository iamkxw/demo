package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the agent database table.
 * 
 */
@Entity
@Table(name="agent")
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AGENT_ID", unique=true, nullable=false)
	private int agentId;

    //bi-directional one-to-one association to Account
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AGENT_ID", nullable = false, insertable = false, updatable = false)
    private Account account;

	private int level;

	@Column(nullable=false, length=10)
	private String name;

	@Column(nullable=false, length=18)
	private String pid;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="agent")
	private List<Address> addresses;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="agent")
	private List<Order> orders;

	@OneToMany(mappedBy="agent")
	private List<Cart> carts;

	public Agent() {
	}

	public int getAgentId() {
		return this.agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setAgent(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setAgent(null);

		return address;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setAgent(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setAgent(null);

		return order;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart){
		getCarts().add(cart);
		cart.setAgent(this);

		return cart;
	}

	public Cart removeCart(Cart cart){
		getCarts().remove(cart);
		cart.setAgent(null);

		return cart;
	}

}
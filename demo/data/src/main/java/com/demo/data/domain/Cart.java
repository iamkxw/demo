package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@Table(name="cart")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CART_ID", unique=true, nullable=false)
	private int cartId;

	@Column(nullable=false)
	private int quantity;

	@Column(name="IS_REMOVED", nullable=false)
	private boolean isRemoved;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;

	public Cart() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isRemoved() {
		return isRemoved;
	}

	public void setRemoved(boolean removed) {
		isRemoved = removed;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
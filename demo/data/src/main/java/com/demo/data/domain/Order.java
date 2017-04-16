package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name="order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID", unique=true, nullable=false)
	private int orderId;

	@Column(name="COMPLETED_TIME")
	private Timestamp completedTime;

	@Column(name="DELIVERED_TIME")
	private Timestamp deliveredTime;

	@Column(name="EXPRESS_CODE", length=25)
	private String expressCode;

	@Column(name="GENERATED_TIME", nullable=false)
	private Timestamp generatedTime;

	@Column(nullable=false)
	private int price;

	@Column(nullable=false)
	private byte status;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="VENDOR_ID", nullable=false)
	private Vendor vendor;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to OrderStatusLog
	@OneToMany(mappedBy="order")
	private List<OrderStatusLog> orderStatusLogs;

	//bi-directional many-to-one association to Transactions
	@OneToMany(mappedBy="order")
	private List<Transaction> transactions;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Timestamp getCompletedTime() {
		return this.completedTime;
	}

	public void setCompletedTime(Timestamp completedTime) {
		this.completedTime = completedTime;
	}

	public Timestamp getDeliveredTime() {
		return this.deliveredTime;
	}

	public void setDeliveredTime(Timestamp deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public String getExpressCode() {
		return this.expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public Timestamp getGeneratedTime() {
		return this.generatedTime;
	}

	public void setGeneratedTime(Timestamp generatedTime) {
		this.generatedTime = generatedTime;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

	public List<OrderStatusLog> getOrderStatusLogs() {
		return this.orderStatusLogs;
	}

	public void setOrderStatusLogs(List<OrderStatusLog> orderStatusLogs) {
		this.orderStatusLogs = orderStatusLogs;
	}

	public OrderStatusLog addOrderStatusLog(OrderStatusLog orderStatusLog) {
		getOrderStatusLogs().add(orderStatusLog);
		orderStatusLog.setOrder(this);

		return orderStatusLog;
	}

	public OrderStatusLog removeOrderStatusLog(OrderStatusLog orderStatusLog) {
		getOrderStatusLogs().remove(orderStatusLog);
		orderStatusLog.setOrder(null);

		return orderStatusLog;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setOrder(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setOrder(null);

		return transaction;
	}

}
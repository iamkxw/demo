package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the order_status_log database table.
 * 
 */
@Entity
@Table(name="order_status_log")
@NamedQuery(name="OrderStatusLog.findAll", query="SELECT o FROM OrderStatusLog o")
public class OrderStatusLog extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_STATUS_LOG_ID")
	private int orderStatusLogId;

	@Column(name="FROM_STATUS", nullable=false)
	private byte fromStatus;

	@Column(name="MODIFIED_TIME", nullable=false)
	private Timestamp modifiedTime;

	@Column(name="TO_STATUS", nullable=false)
	private byte toStatus;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDER_ID", nullable=false)
	private Order order;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY", nullable=false)
	private Account account;

	public OrderStatusLog() {
	}

	public byte getFromStatus() {
		return this.fromStatus;
	}

	public void setFromStatus(byte fromStatus) {
		this.fromStatus = fromStatus;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public byte getToStatus() {
		return this.toStatus;
	}

	public void setToStatus(byte toStatus) {
		this.toStatus = toStatus;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
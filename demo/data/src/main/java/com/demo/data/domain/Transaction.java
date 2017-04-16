package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@Table(name="transaction")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID", unique=true, nullable=false)
	private int transactionId;

	@Column(name="CANCEL_TIME")
	private Timestamp cancelTime;

	@Column(nullable=false)
	private byte channel;

	@Column(name="EXPIRED_TIME")
	private Timestamp expiredTime;

	@Column(name="GENERATED_TIME", nullable=false)
	private Timestamp generatedTime;

	@Column(name="MERCHANT_CODE", nullable=false, length=45)
	private String merchantCode;

	@Column(name="PAIED_TIME")
	private Timestamp paiedTime;

	@Column(nullable=false)
	private int price;

	@Column(nullable=false)
	private byte status;

	//bi-directional one-to-one association to Alipay
	@OneToOne(mappedBy="transaction")
	private Alipay alipay;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDER_ID", nullable=false)
	private Order order;

	//bi-directional one-to-one association to Wxpay
	@OneToOne(mappedBy="transaction")
	private Wxpay wxpay;

	public Transaction() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Timestamp getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Timestamp cancelTime) {
		this.cancelTime = cancelTime;
	}

	public byte getChannel() {
		return this.channel;
	}

	public void setChannel(byte channel) {
		this.channel = channel;
	}

	public Timestamp getExpiredTime() {
		return this.expiredTime;
	}

	public void setExpiredTime(Timestamp expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Timestamp getGeneratedTime() {
		return this.generatedTime;
	}

	public void setGeneratedTime(Timestamp generatedTime) {
		this.generatedTime = generatedTime;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Timestamp getPaiedTime() {
		return this.paiedTime;
	}

	public void setPaiedTime(Timestamp paiedTime) {
		this.paiedTime = paiedTime;
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

	public Alipay getAlipay() {
		return this.alipay;
	}

	public void setAlipay(Alipay alipay) {
		this.alipay = alipay;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Wxpay getWxpay() {
		return this.wxpay;
	}

	public void setWxpay(Wxpay wxpay) {
		this.wxpay = wxpay;
	}

}
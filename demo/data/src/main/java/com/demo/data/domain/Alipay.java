package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alipay database table.
 * 
 */
@Entity
@Table(name="alipay")
@NamedQuery(name="Alipay.findAll", query="SELECT a FROM Alipay a")
public class Alipay extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID", unique=true, nullable=false)
	private int transactionId;

	@Column(name="ALIPAY_CODE", length=45)
	private String alipayCode;

	@Column(name="WAP_URL", length=1000)
	private String wapUrl;

	//bi-directional one-to-one association to Transactions
	@OneToOne
	@JoinColumn(name="TRANSACTION_ID", nullable=false, insertable=false, updatable=false)
	private Transaction transaction;

	public Alipay() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAlipayCode() {
		return this.alipayCode;
	}

	public void setAlipayCode(String alipayCode) {
		this.alipayCode = alipayCode;
	}

	public String getWapUrl() {
		return this.wapUrl;
	}

	public void setWapUrl(String wapUrl) {
		this.wapUrl = wapUrl;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
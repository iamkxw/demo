package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wxpay database table.
 * 
 */
@Entity
@Table(name="wxpay")
@NamedQuery(name="Wxpay.findAll", query="SELECT w FROM Wxpay w")
public class Wxpay extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID", unique=true, nullable=false)
	private int transactionId;

	@Column(name="PRE_CODE", length=45)
	private String preCode;

	@Column(length=45)
	private String qrcode;

	@Column(name="WXPAY_CODE", length=45)
	private String wxpayCode;

	//bi-directional one-to-one association to Transactions
	@OneToOne
	@JoinColumn(name="TRANSACTION_ID", nullable=false, insertable=false, updatable=false)
	private Transaction transaction;

	public Wxpay() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getPreCode() {
		return this.preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getWxpayCode() {
		return this.wxpayCode;
	}

	public void setWxpayCode(String wxpayCode) {
		this.wxpayCode = wxpayCode;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
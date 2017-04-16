package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;
import com.demo.common.enums.AccountType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACCOUNT_ID", unique=true, nullable=false)
	private int accountId;

	@Column(name="IS_VALID", nullable=false)
	private boolean isValid;

	@Column(length = 80)
	private String password;

	@Column
	private byte type;

	@Column(nullable=false, length=11)
	private String phone;

	@Column(name="REGISTERED_TIME", nullable=false)
	private Timestamp registeredTime;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public boolean getIsValid() {
		return this.isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getType() {
		return AccountType.valueOf(type);
	}

	public void setType(AccountType type) {
		this.type = (byte) type.value();
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getRegisteredTime() {
		return this.registeredTime;
	}

	public void setRegisteredTime(Timestamp registeredTime) {
		this.registeredTime = registeredTime;
	}

}
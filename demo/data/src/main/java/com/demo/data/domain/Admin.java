package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Table(name="admin")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADMIN_ID", unique=true, nullable=false)
	private int adminId;

	//bi-directional one-to-one association to Account
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADMIN_ID", nullable=false, insertable=false, updatable=false)
	private Account account;

    @Column(length = 45)
    private String name;

	public Admin() {
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
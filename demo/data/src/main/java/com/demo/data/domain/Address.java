package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID", unique=true, nullable=false)
	private int addressId;

	@Column(name="DETAIL_ADDRESS", nullable=false, length=45)
	private String detailAddress;

	@Column(name="FULL_ADDRESS", nullable=false, length=100)
	private String fullAddress;

	//bi-directional many-to-one association to Street
	@ManyToOne
	@JoinColumn(name="STREET_ID", nullable=false)
	private Street street;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDetailAddress() {
		return this.detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getFullAddress() {
		return this.fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
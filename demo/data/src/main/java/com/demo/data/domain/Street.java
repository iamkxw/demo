package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the street database table.
 * 
 */
@Entity
@Table(name="street")
@NamedQuery(name="Street.findAll", query="SELECT s FROM Street s")
public class Street extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STREET_ID", unique=true, nullable=false)
	private int streetId;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="street")
	private List<Address> addresses;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="REGION_ID", nullable=false)
	private Region region;

	public Street() {
	}

	public int getStreetId() {
		return this.streetId;
	}

	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setStreet(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setStreet(null);

		return address;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region database table.
 * 
 */
@Entity
@Table(name="region")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID", unique=true, nullable=false)
	private int regionId;

	@Column(length=25)
	private String name;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY_ID", nullable=false)
	private City city;

	//bi-directional many-to-one association to Street
	@OneToMany(mappedBy="region")
	private List<Street> streets;

	public Region() {
	}

	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Street> getStreets() {
		return this.streets;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

	public Street addStreet(Street street) {
		getStreets().add(street);
		street.setRegion(this);

		return street;
	}

	public Street removeStreet(Street street) {
		getStreets().remove(street);
		street.setRegion(null);

		return street;
	}

}
package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@Table(name="city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CITY_ID", unique=true, nullable=false)
	private int cityId;

	@Column(nullable=false, length=10)
	private String name;

	//bi-directional many-to-one association to Region
	@OneToMany(mappedBy="city")
	private List<Region> regions;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Region addRegion(Region region) {
		getRegions().add(region);
		region.setCity(this);

		return region;
	}

	public Region removeRegion(Region region) {
		getRegions().remove(region);
		region.setCity(null);

		return region;
	}

}
package ua.ksstroy.hibermodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zones", catalog = "ksstroy")
public class ZoneModel implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "width")
	private Double width;

	@Column(name = "height")
	private Double height;

	@Column(name = "mesure_name")
	private String mesureName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "surplus_zones")
	private Set<SurplusZoneModel> setSurZones = new LinkedHashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adddit_zones")
	private Set<AdditionalZonesModel> setAddZones = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getMesureName() {
		return mesureName;
	}

	public void setMesureName(String mesureName) {
		this.mesureName = mesureName;
	}

	public Set<SurplusZoneModel> getSetSurZones() {
		return setSurZones;
	}

	public void setSetSurZones(Set<SurplusZoneModel> setSurZones) {
		this.setSurZones = setSurZones;
	}

	public Set<AdditionalZonesModel> getSetAddZones() {
		return setAddZones;
	}

	public void setSetAddZones(Set<AdditionalZonesModel> setAddZones) {
		this.setAddZones = setAddZones;
	}

}
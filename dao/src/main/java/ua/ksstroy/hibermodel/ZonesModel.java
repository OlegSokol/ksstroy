package ua.ksstroy.hibermodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zones", catalog = "ksstroy")
public class ZonesModel implements Serializable {

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

	/*
	 * One to many zone for surplusesZones
	 */

	@OneToMany(mappedBy = "zonesSurpluses")
	private List<SurplusZonesModel> surpluses = new ArrayList<>();

	/*
	 * One to many zone for addotionalZones
	 */

	@OneToMany(mappedBy = "zonesAdditionals")
	private List<AdditionalZonesModel> additionals = new ArrayList<>();

	/*
	 * Many to one zones for group
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "group_for_zones_id")
	private GroupsModel groupsModel;

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

	public List<SurplusZonesModel> getSurpluses() {
		return surpluses;
	}

	public void setSurpluses(List<SurplusZonesModel> surpluses) {
		this.surpluses = surpluses;
	}

	public List<AdditionalZonesModel> getAdditionals() {
		return additionals;
	}

	public void setAdditionals(List<AdditionalZonesModel> additionals) {
		this.additionals = additionals;
	}

	public GroupsModel getGroupsModel() {
		return groupsModel;
	}

	public void setGroupsModel(GroupsModel groupsModel) {
		this.groupsModel = groupsModel;
	}

}
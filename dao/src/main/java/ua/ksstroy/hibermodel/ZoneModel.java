package ua.ksstroy.hibermodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
	private List<SurplusZonesModel> setSurZones = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adddit_zones")
	private List<AdditionalZonesModel> setAddZones = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
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

	public List<SurplusZonesModel> getSetSurZones() {
		return setSurZones;
	}

	public void setSetSurZones(List<SurplusZonesModel> setSurZones) {
		this.setSurZones = setSurZones;
	}

	public List<AdditionalZonesModel> getSetAddZones() {
		return setAddZones;
	}

	public void setSetAddZones(List<AdditionalZonesModel> setAddZones) {
		this.setAddZones = setAddZones;
	}

	public GroupsModel getGroupsModel() {
		return groupsModel;
	}

	public void setGroupsModel(GroupsModel groupsModel) {
		this.groupsModel = groupsModel;
	}

}
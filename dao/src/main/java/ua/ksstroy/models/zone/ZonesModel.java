package ua.ksstroy.models.zone;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
//TODO : add ability to sent whole zoneData object with included additional and surplus zones
//now additional and surplus zones can being added only separately via add setAdditionalIdForZone(ZoneModel) 
//and setSurplusIdForZone(ZoneModel)
@SuppressWarnings("serial")
@Entity
@Table(name = "zones", catalog = "ksstroy")
public class ZonesModel implements Serializable {

	//TODO: add ability to specify id explicitly  e.g( setId("10500")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "width")
	private Double width;

	@Column(name = "height")
	private Double height;

	@Column(name = "mesure_name")
	private String measureName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_group_id")
	private GroupsModel groupIdForZone;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "surplus_for_zones_id")
	private ZonesModel surplusIdForZone;

	@OneToMany(mappedBy = "surplusIdForZone")
	private List<ZonesModel> surplusZone = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addit_for_zones_id")
	private ZonesModel additIdForZone;

	@OneToMany(mappedBy = "additIdForZone")
	private List<ZonesModel> additionalZone = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return measureName;
	}

	public void setMesureName(String measureName) {
		this.measureName = measureName.toString();
	}

	public GroupsModel getGroupIdForZone() {
		return groupIdForZone;
	}

public void setGroupIdForZone(GroupsModel groupIdForZone) {
		this.groupIdForZone = groupIdForZone;
	}

	public ZonesModel getSurplusIdForZone() {
		return surplusIdForZone;
	}

	public void setSurplusIdForZone(ZonesModel surplusIdForZone) {
		this.surplusIdForZone = surplusIdForZone;
	}

	public List<ZonesModel> getSurplusZone() {
		return surplusZone;
	}

	public void setSurplusZone(List<ZonesModel> surplusZone) {
		this.surplusZone = surplusZone;
	}

	public ZonesModel getAdditIdForZone() {
		return additIdForZone;
	}

	public void setAdditIdForZone(ZonesModel additIdForZone) {
		this.additIdForZone = additIdForZone;
	}

	public List<ZonesModel> getAdditionalZone() {
		return additionalZone;
	}

	public void setAdditionalZone(List<ZonesModel> additionalZone) {
		this.additionalZone = additionalZone;
	}

}
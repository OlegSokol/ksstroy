package ua.ksstroy.models.zone;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "zones", catalog = "ksstroy")
public class ZonesModel implements Serializable {

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


	@OneToMany(mappedBy = "additZoneToRootZone")
	private Set<ZonesModel> additionalZone = new HashSet<>();

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addit_for_zones_id")
	private ZonesModel additZoneToRootZone;


	@OneToMany(mappedBy = "surplusZoneToRootZone")
	private Set<ZonesModel> surplusZone = new HashSet<>();



	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "surplus_for_zones_id")
	private ZonesModel surplusZoneToRootZone;

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

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(Enum measureName) {
		this.measureName = measureName.toString();
	}

	public GroupsModel getGroupIdForZone() {
		return groupIdForZone;
	}

	public void setGroupIdForZone(GroupsModel groupIdForZone) {
		this.groupIdForZone = groupIdForZone;
	}

	public Set<ZonesModel> getAdditionalZone() {
		return additionalZone;
	}

	public void setAdditionalZone(Set<ZonesModel> additionalZone) {
		this.additionalZone = additionalZone;
	}

	public ZonesModel getAdditZoneToRootZone() {
		return additZoneToRootZone;
	}

	public void setAdditZoneToRootZone(ZonesModel additZoneToRootZone) {
		this.additZoneToRootZone = additZoneToRootZone;
	}

	public Set<ZonesModel> getSurplusZone() {
		return surplusZone;
	}

	public void setSurplusZone(Set<ZonesModel> surplusZone) {
		this.surplusZone = surplusZone;
	}

	public ZonesModel getSurplusZoneToRootZone() {
		return surplusZoneToRootZone;
	}

	public void setSurplusZoneToRootZone(ZonesModel surplusZoneToRootZone) {
		this.surplusZoneToRootZone = surplusZoneToRootZone;
	}

}
package ua.ksstroy.models.zone;

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
	private String mesureName;

	/*
	 * Many to one zones for group
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "group_for_zones_id")
	private ZonesModel groupIdForZone;

	/*
	 * Many to one surplus Zone for zone
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "surplus_for_zones_id")
	private ZonesModel surplusIdForZone;

	/*
	 * Many to one additional zone for zone
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addit_for_zones_id")
	private ZonesModel additIdForZone;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return the mesureName
	 */
	public String getMesureName() {
		return mesureName;
	}

	/**
	 * @param mesureName
	 *            the mesureName to set
	 */
	public void setMesureName(String mesureName) {
		this.mesureName = mesureName;
	}

	/**
	 * @return the groupIdForZone
	 */
	public ZonesModel getGroupIdForZone() {
		return groupIdForZone;
	}

	/**
	 * @param groupIdForZone
	 *            the groupIdForZone to set
	 */
	public void setGroupIdForZone(ZonesModel groupIdForZone) {
		this.groupIdForZone = groupIdForZone;
	}

	/**
	 * @return the surplusIdForZone
	 */
	public ZonesModel getSurplusIdForZone() {
		return surplusIdForZone;
	}

	/**
	 * @param surplusIdForZone
	 *            the surplusIdForZone to set
	 */
	public void setSurplusIdForZone(ZonesModel surplusIdForZone) {
		this.surplusIdForZone = surplusIdForZone;
	}

	/**
	 * @return the additIdForZone
	 */
	public ZonesModel getAdditIdForZone() {
		return additIdForZone;
	}

	/**
	 * @param additIdForZone
	 *            the additIdForZone to set
	 */
	public void setAdditIdForZone(ZonesModel additIdForZone) {
		this.additIdForZone = additIdForZone;
	}

}
package ua.ksstroy.models.zone;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "groups", catalog = "ksstroy")
public class GroupsModel implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	/*
	 * One to many group for zones
	 */

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupIdForZone")
	private Set<ZonesModel> zonesGroup = new HashSet<>();

	/*
	 * Many to one subgroups for root group same one entity
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_group_id")
	private GroupsModel rootgroup;

	/*
	 * One to many root group for subgroups
	 */

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rootgroup")
	private Set<GroupsModel> subgroupToGroup = new HashSet<>();

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

	public GroupsModel getRootgroup() {
		return rootgroup;
	}

	public void setRootgroup(GroupsModel rootgroup) {
		this.rootgroup = rootgroup;
	}

	public Set<GroupsModel> getSubgroupToGroup() {
		return subgroupToGroup;
	}

	public void setSubgroupToGroup(Set<GroupsModel> subgroupToGroup) {
		this.subgroupToGroup = subgroupToGroup;
	}

	public Set<ZonesModel> getZonesGroup() {
		return zonesGroup;
	}

	public void setZonesGroup(Set<ZonesModel> zonesGroup) {
		this.zonesGroup = zonesGroup;
	}

}
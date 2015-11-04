package ua.ksstroy.models.zone;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_group_id")
	private Set<ZonesModel> zonesGroup = new HashSet<>();

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id")
	private Set<GroupsModel> subGroups = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private GroupsModel subGroupsToRootGroup;

	public GroupsModel() {

	}

	public GroupsModel(String name) {
		this.name = name;
	}

	public GroupsModel(String name, Set<GroupsModel> subGroups) {
		this.name = name;
		this.subGroups = subGroups;
	}

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

	public Set<ZonesModel> getZonesGroup() {
		return zonesGroup;
	}

	public void setZonesGroup(Set<ZonesModel> zonesGroup) {
		this.zonesGroup = zonesGroup;
	}

	public Set<GroupsModel> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(Set<GroupsModel> subGroups) {
		this.subGroups = subGroups;
	}

}
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

	/*
	 * One to many group for zones
	 */

	@OneToMany(mappedBy = "groupIdForZone")
	private Set<ZonesModel> zonesGroup = new HashSet<>();

	/*
	 * One to group for subGroup
	 */

	@OneToMany(mappedBy = "subGroups")
	private Set<GroupsModel> subGroup = new HashSet<>();

	/*
	 * Many to one subgroup to rootGroup
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id")
	private GroupsModel subGroups;

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

	public Set<GroupsModel> getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(Set<GroupsModel> subGroup) {
		this.subGroup = subGroup;
	}

	public GroupsModel getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(GroupsModel subGroups) {
		this.subGroups = subGroups;
	}

}
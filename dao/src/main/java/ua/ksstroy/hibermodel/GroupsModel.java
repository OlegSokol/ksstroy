package ua.ksstroy.hibermodel;

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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "groups", catalog = "ksstroy")
public class GroupsModel implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "groups", cascade = CascadeType.ALL)
//	private ProjectModel projectModel;

	/*
	 * One to many group for zones
	 */

	@OneToMany(mappedBy = "groupsModel")
	private List<ZonesModel> zones = new ArrayList<ZonesModel>();

	/*
	 * Many to one subgroups for rootgroup same one entity
	 */

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id")
	private GroupsModel rootgroup;

	/*
	 * One to many root rootgroup for subgroups same one entity
	 */

	@OneToMany(mappedBy = "rootgroup")
	private List<GroupsModel> subgroups = new ArrayList<>();

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

	public GroupsModel getRootgroup() {
		return rootgroup;
	}

	public void setRootgroup(GroupsModel rootgroup) {
		this.rootgroup = rootgroup;
	}

	public List<GroupsModel> getSubgroups() {
		return subgroups;
	}

	public void setSubgroups(List<GroupsModel> subgroups) {
		this.subgroups = subgroups;
	}

	public List<ZonesModel> getZones() {
		return zones;
	}

	public void setZones(List<ZonesModel> zones) {
		this.zones = zones;
	}

//	public ProjectModel getProjectModel() {
//		return projectModel;
//	}
//
//	public void setProjectModel(ProjectModel projectModel) {
//		this.projectModel = projectModel;
//	}

}
package ua.ksstroy.hibermodel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "projects", catalog = "ksstroy")
public class ProjectModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer Id;

	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@Column(name = "DESCRIPTION")
	private String description;

//	@GenericGenerator(name = "generator", strategy = "foreign", 
//			parameters = @Parameter(name = "property", value = "groups"))
//	@Id
//	@GeneratedValue(generator = "generator")
//	@Column(name = "ID_GROUP", nullable = false)
//	private Integer idGroup;
//
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	private GroupsModel groupsModel;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
	private List<UserModel> users;

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

//	public GroupsModel getGroupsModel() {
//		return groupsModel;
//	}
//
//	public void setGroupsModel(GroupsModel groupsModel) {
//		this.groupsModel = groupsModel;
//	}
//
//	public Integer getIdGroup() {
//		return idGroup;
//	}
//
//	public void setIdGroup(Integer idGroup) {
//		this.idGroup = idGroup;
//	}

}

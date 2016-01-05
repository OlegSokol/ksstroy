package ua.ksstroy.models.project;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import ua.ksstroy.models.user.UserModel;
import ua.ksstroy.models.zone.GroupsModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "projects", catalog = "ksstroy")
public class ProjectModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private String Id;

	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_GROUP")
	private GroupsModel groupsModel;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
	private List<UserModel> users;

	public ProjectModel() {

	}

	public ProjectModel(String projectName, String description, GroupsModel groupsModel) {
		this.projectName = projectName;
		this.description = description;
		this.groupsModel = groupsModel;
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
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

	public GroupsModel getGroupsModel() {
		return groupsModel;
	}

	public void setGroupsModel(GroupsModel groupsModel) {
		this.groupsModel = groupsModel;
	}

}

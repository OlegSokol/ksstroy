package ua.ksstroy.models.worktype;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "worktype_groups", catalog = "ksstroy")
public class WorkTypeGroupModel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_group_id")
	@OrderBy
	private List<WorkTypeModel> workTypeGroup;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id")
	@OrderBy
	private List<WorkTypeGroupModel> subGroups;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private WorkTypeGroupModel subGroupsToRootGroup;
	
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

	public List<WorkTypeModel> getWorkTypeGroup() {
		return workTypeGroup;
	}

	public void setWorkTypeGroup(List<WorkTypeModel> workTypeGroup) {
		this.workTypeGroup = workTypeGroup;
	}

	public List<WorkTypeGroupModel> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<WorkTypeGroupModel> subGroups) {
		this.subGroups = subGroups;
	}

	public WorkTypeGroupModel getSubGroupsToRootGroup() {
		return subGroupsToRootGroup;
	}

	public void setSubGroupsToRootGroup(WorkTypeGroupModel subGroupsToRootGroup) {
		this.subGroupsToRootGroup = subGroupsToRootGroup;
	}
	
	
}

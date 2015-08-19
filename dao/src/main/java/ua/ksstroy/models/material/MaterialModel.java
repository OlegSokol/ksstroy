package ua.ksstroy.models.material;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ua.ksstroy.models.worktype.WorkTypeModel;

@Entity
@Table(name = "materials", catalog = "ksstroy")
public class MaterialModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "materials")
	private Set<WorkTypeModel> workTypes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<WorkTypeModel> getWorkTypes() {
		return workTypes;
	}

	public void setWorkTypes(Set<WorkTypeModel> workTypes) {
		this.workTypes = workTypes;
	}
	

}

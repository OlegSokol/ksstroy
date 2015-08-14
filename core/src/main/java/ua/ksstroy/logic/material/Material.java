package ua.ksstroy.logic.material;

import java.util.Set;

import ua.ksstroy.logic.worktype.WorkType;

public class Material {
	
	private int id;
	
	private String name;
	
	private Set<WorkType> workTypes; 

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

	public Set<WorkType> getWorkTypes() {
		return workTypes;
	}

	public void setWorkTypes(Set<WorkType> workTypes) {
		this.workTypes = workTypes;
	}

}

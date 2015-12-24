package ua.ksstroy.models.worktype;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.zone.GroupsModel;

@Entity
@Table(name = "worktypes", catalog = "ksstroy")
public class WorkTypeModel implements Serializable {
	
	
	private static final long serialVersionUID = -940277992431249690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worktype_id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id")
	private WorkTypeModel parentWorkType;
	
	@OneToMany(mappedBy = "parentWorkType")
	private Set<WorkTypeModel> childWorkTypes = new HashSet<WorkTypeModel>();
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "measure_name")
	private String measureName;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_group_id")
	private WorkTypeGroupModel groupIdForZone;
	
	/*TODO add materials
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "worktype_material_rel", joinColumns = @JoinColumn(name = "worktype_id"), inverseJoinColumns = @JoinColumn(name = "material_id"))
	private Set<MaterialModel> materials;
	*/
	public WorkTypeModel () {
	}
	
	
	public WorkTypeModel (String name, String description, Measure measure, Double unitPrice) {
		this.name = name;
		this.description = description;
		this.measureName = measureName.toString();
		this.unitPrice = unitPrice;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WorkTypeModel getParentWorkType() {
		return parentWorkType;
	}

	public void setParentWorkType(WorkTypeModel parentWorkType) {
		this.parentWorkType = parentWorkType;
	}

	public Set<WorkTypeModel> getChildWorkTypes() {
		return childWorkTypes;
	}

	public void setChildWorkTypes(Set<WorkTypeModel> childWorkTypes) {
		this.childWorkTypes = childWorkTypes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(Measure measureName) {
		this.measureName = measureName.toString();
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/*
	public Set<MaterialModel> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<MaterialModel> materials) {
		this.materials = materials;
	}*/

}


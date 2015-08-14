package ua.ksstroy.models.worktype;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.material.MaterialModel;

@Entity
@Table(name = "worktypes", catalog = "ksstroy")
public class WorkTypeModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id; 
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "measure_name")
	private Measure measure;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "worktype_material_rel", joinColumns = @JoinColumn(name = "worktype_id"), inverseJoinColumns = @JoinColumn(name = "material_id"))
	private Set<MaterialModel> materials;
//	
//	@OneToOne
//	@JoinColumn
//	private WorkTypeModel workTypeModel;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Enumerated(EnumType.STRING)
	public Measure getMeasure() {
		return measure;
	}
	
	@Enumerated(EnumType.STRING)
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Set<MaterialModel> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<MaterialModel> materials) {
		this.materials = materials;
	}

//	public WorkTypeModel getWorkTypeModel() {
//		return workTypeModel;
//	}
//
//	public void setWorkTypeModel(WorkTypeModel workTypeModel) {
//		this.workTypeModel = workTypeModel;
//	}	

}

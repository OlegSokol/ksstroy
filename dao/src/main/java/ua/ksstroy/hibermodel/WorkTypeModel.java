package ua.ksstroy.hibermodel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import ua.ksstroy.logic.zone.Measure;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "worktypes", catalog = "ksstroy")
public class WorkTypeModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
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
	@JoinTable(name = "worktype_material_rel", joinColumns = @JoinColumn(name = "worktype_id"), inverseJoinColumns = @JoinColumn(name = "material"))
	private List<MaterialModel> materials;
	
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

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<MaterialModel> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialModel> materials) {
		this.materials = materials;
	}	

}

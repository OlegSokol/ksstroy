package ua.ksstroy.logic.worktype;

import java.util.List;

import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.zone.Measure;

public class WorkTypeData {
	
	private Integer id;

	private String name;

	private String description;
	
	private Measure measure;
	
	private Double unitPrice;

	private List<MaterialData> materials;

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

	public List<MaterialData> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialData> materials) {
		this.materials = materials;
	}

	public Double getGetPricePerMesure() {
		return unitPrice;
	}

	public void setGetPricePerMesure(Double getPricePerMesure) {
		this.unitPrice = getPricePerMesure;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

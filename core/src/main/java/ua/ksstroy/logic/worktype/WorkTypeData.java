package ua.ksstroy.logic.worktype;

import java.util.List;

public class WorkTypeData {
	
	private String name;

	private String description;

	private Double getPricePerMesure;
	
	private String mesureName;
	
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
		return getPricePerMesure;
	}

	public void setGetPricePerMesure(Double getPricePerMesure) {
		this.getPricePerMesure = getPricePerMesure;
	}

	public String getMesureName() {
		return mesureName;
	}

	public void setMesureName(String mesureName) {
		this.mesureName = mesureName;
	}

}

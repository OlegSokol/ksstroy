package ua.ksstroy.logic.new_material;

import ua.ksstroy.logic.material.MaterialTypeData;

public class MaterialData {

	private MaterialTypeData type;

	private Double unitsPerWorkZoneMesure;

	private Double planedCost;

	private Double closedCost;

	private Double dealCost;

	public MaterialTypeData getType() {
		return type;
	}

	public void setType(MaterialTypeData type) {
		this.type = type;
	}

	public Double getPlanedCost() {
		return planedCost;
	}

	public void setPlanedCost(Double planedCost) {
		this.planedCost = planedCost;
	}

	public Double getClosedCost() {
		return closedCost;
	}

	public void setClosedCost(Double closedCost) {
		this.closedCost = closedCost;
	}

	public Double getDealCost() {
		return dealCost;
	}

	public void setDealCost(Double dealCost) {
		this.dealCost = dealCost;
	}

	public Double getUnitsPerWorkZoneMesure() {
		return unitsPerWorkZoneMesure;
	}

	public void setUnitsPerWorkZoneMesure(Double unitsPerWorkZoneMesure) {
		this.unitsPerWorkZoneMesure = unitsPerWorkZoneMesure;
	}

}

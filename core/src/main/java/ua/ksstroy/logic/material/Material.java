package ua.ksstroy.logic.material;

import ua.ksstroy.logic.material.MaterialTypeGroupData;

public class Material {

	private MaterialTypeGroupData type;

	private Double unitsPerWorkZoneMeasure;

	private Double planedCost;

	private Double closedCost;

	private Double dealCost;

	public MaterialTypeGroupData getType() {
		return type;
	}

	public void setType(MaterialTypeGroupData type) {
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

	public Double getUnitsPerWorkZoneMeasure() {
		return unitsPerWorkZoneMeasure;
	}

	public void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure) {
		this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
	}

}

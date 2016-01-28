package ua.ksstroy.logic.material;

public class MaterialData {

    private String id;

    private MaterialTypeData materialType;

    private Double unitsPerWorkZoneMeasure;

    private Double planedCost;

    private Double dealCost;

    private Double closedCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MaterialTypeData getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialTypeData materialType) {
        this.materialType = materialType;
    }

    public Double getUnitsPerWorkZoneMeasure() {
        return unitsPerWorkZoneMeasure;
    }

    public void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure) {
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
    }

    public Double getPlanedCost() {


        return planedCost;
    }

    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;
    }

    public Double getDealCost() {
        return dealCost;
    }

    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;
    }

    public Double getClosedCost() {
        return closedCost;
    }

    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;
    }

}
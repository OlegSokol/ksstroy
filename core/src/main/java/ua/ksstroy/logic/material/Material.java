package ua.ksstroy.logic.material;

public class Material{

    private String id;

    private MaterialType materialType;

    private Double unitsPerWorkZoneMeasure;

    private Double planedCost;

    private Double dealCost;

    private Double closedCost;

   
    public MaterialType getMaterialType() {
        return materialType;
    }

   
    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

   
    public Double getUnitsPerWorkZoneMeasure() {
        return unitsPerWorkZoneMeasure;
    }

   
    public void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure) {
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
    }

    /*
    Calculate quantity on price for unit
     */
   
    public Double getPlanedCost() {
        planedCost = unitsPerWorkZoneMeasure * materialType.getPricePerUnit();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
package ua.ksstroy.logic.material;

public interface Material {

    MaterialType getMaterialType();

    void setMaterialType(MaterialType materialType);

    Double getUnitsPerWorkZoneMeasure();

    void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure);

    Double getPlanedCost();

    void setPlanedCost(Double planedCost);

    Double getDealCost();

    void setDealCost(Double dealCost);

    Double getClosedCost();

    void setClosedCost(Double closedCost);

}
package ua.ksstroy.logic.material;

public interface Material {
    //TODO:finish after obtain more specific information about the entity

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
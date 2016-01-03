package ua.ksstroy.logic.material;

import ua.ksstroy.logic.zoneGroup.Measure;

public interface Material {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    Measure getMeasure();

    void setMeasure(Measure measure);

    Double getSize();

    void setSize(Double size);

    Double getPlanedCost();

    void setPlanedCost(Double planedCost);

    Double getDealCost();

    void setDealCost(Double dealCost);

    Double getClosedCost();

    void setClosedCost(Double closedCost);

    /*
    * Calculate price all material into material Type
    */

    Double getSummaryPriceMaterial();

    /*
    * Calculate quantity all material into material Type
    */

    Double getSummaryQuantityMaterial();

}

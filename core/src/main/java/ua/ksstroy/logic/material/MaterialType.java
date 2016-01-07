package ua.ksstroy.logic.material;

public interface MaterialType {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    Double getPricePerUnit();

    void setPricePerUnit(Double pricePerUnit);

    String getUnitName();

    void setUnitName(String unitName);

    /*
    * Calculate price all material into material Type
    */

    Double getSummaryPriceMaterial();

    /*
    * Calculate quantity all material into material Type
    */

    Double getSummaryQuantityMaterial();

}

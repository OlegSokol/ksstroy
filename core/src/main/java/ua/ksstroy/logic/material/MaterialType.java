package ua.ksstroy.logic.material;

public class MaterialType{

    private String id;

    private String name;

    private String description;

    private Double pricePerUnit;

    private String unitName;

    public MaterialType() {
    }

    public MaterialType( String name, String description, Double pricePerUnit, String unitName) {

        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.unitName = unitName;
    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
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

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricaPerUnit) {
        this.pricePerUnit = pricaPerUnit;
    }

    
    public String getUnitName() {
        return unitName;
    }

    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    
    public Double getSummaryPriceMaterial() {
        return null;
    }

    
    public Double getSummaryQuantityMaterial() {
        return null;
    }
}
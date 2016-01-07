package ua.ksstroy.logic.material;

public class MaterialTypeData {

    private String id;

    private String name;

    private String description;

    private Double pricePerUnit;

    private String unitName;

    public MaterialTypeData() {
    }

    public MaterialTypeData(String id, String name, String description, Double pricePerUnit, String unitName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.unitName = unitName;
    }

    public MaterialTypeData(String name, String description, Double pricePerUnit, String unitName) {
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

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
package ua.ksstroy.logic.material;

public class MaterialTypeImpl implements MaterialType {

    private String id;

    private String name;

    private String description;

    private Double pricePerUnit;

    private String unitName;

    public MaterialTypeImpl() {
    }

    public MaterialTypeImpl(String id, String name, String description, Double pricePerUnit, String unitName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.unitName = unitName;
    }

    public MaterialTypeImpl(String name, String description, Double pricePerUnit, String unitName) {
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.unitName = unitName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricaPerUnit) {
        this.pricePerUnit = pricaPerUnit;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }

    @Override
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public Double getSummaryPriceMaterial() {
        return null;
    }

    @Override
    public Double getSummaryQuantityMaterial() {
        return null;
    }
}
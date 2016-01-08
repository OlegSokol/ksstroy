package ua.ksstroy.logic.worktype;

import ua.ksstroy.logic.material.MaterialImpl;

import java.util.List;

public class WorkTypeImpl implements WorkType {

    private Integer id;

    private String name;

    private String description;

    private String measure;

    private Double unitPrice;

    private List<MaterialImpl> materials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public List<MaterialImpl> getMaterials() {
        return materials;
    }

    @Override
    public void setMaterials(List<MaterialImpl> materials) {
        this.materials = materials;
    }
}

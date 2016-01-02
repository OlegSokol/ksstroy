package ua.ksstroy.logic.worktype;

import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.zone.Measure;

import java.util.Set;

/**
 * Logic for WorkTypes
 * Created by soklakov on 30.12.2015.
 */
public class WorkTypeImpl implements WorkType {

    private Integer id;

    private String name;

    private String description;

    private String measure;

    private Double unitPrice;

    private Set<Material> materials;

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

    //TODO add material when material will be ready
    /*public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }*/
}

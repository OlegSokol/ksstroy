package ua.ksstroy.logic.worktype;

import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.zone.Measure;

import java.util.Set;

public interface WorkType {


    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public Measure getMeasure();

    public void setMeasure(Measure measure);

    public Double getUnitPrice();

    public void setUnitPrice(Double unitPrice);

    public Set<Material> getMaterials();

    public void setMaterials(Set<Material> materials);

}
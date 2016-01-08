package ua.ksstroy.logic.worktype;

import ua.ksstroy.logic.material.MaterialImpl;

import java.util.List;

public interface WorkType {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getMeasure();

    void setMeasure(String measure);

    Double getUnitPrice();

    void setUnitPrice(Double unitPrice);


    List<MaterialImpl> getMaterials();
    void setMaterials(List<MaterialImpl> materials);

}
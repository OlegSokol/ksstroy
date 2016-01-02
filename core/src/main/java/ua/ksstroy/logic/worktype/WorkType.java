package ua.ksstroy.logic.worktype;

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

    //TODO add materials when materials will be ready
    //Set<Material> getMaterials();

    //void setMaterials(Set<Material> materials);

}
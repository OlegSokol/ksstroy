package ua.ksstroy.logic.worktype;

public interface WorkType {

    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public String getMeasure();

    public void setMeasure(String measure);

    public Double getUnitPrice();

    public void setUnitPrice(Double unitPrice);

    //TODO add materials when materials will be ready
    //public Set<Material> getMaterials();

    //public void setMaterials(Set<Material> materials);

}
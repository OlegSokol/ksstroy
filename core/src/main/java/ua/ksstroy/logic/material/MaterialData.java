package ua.ksstroy.logic.material;

import ua.ksstroy.logic.zoneGroup.Measure;

public class MaterialData {

    private Integer id;

    private String name;

    private String description;

    private Measure measure;

    private Double size;

    private Double planedCost;

    private Double dealCost;

    private Double closedCost;

    public MaterialData() {
    }

    public MaterialData(Integer id, String name, String description, Measure measure,
                        Double size, Double planedCost, Double dealCost, Double closedCost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.measure = measure;
        this.size = size;
        this.planedCost = planedCost;
        this.dealCost = dealCost;
        this.closedCost = closedCost;
    }

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

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getPlanedCost() {
        return planedCost;
    }

    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;
    }

    public Double getDealCost() {
        return dealCost;
    }

    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;
    }

    public Double getClosedCost() {
        return closedCost;
    }

    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;
    }
}
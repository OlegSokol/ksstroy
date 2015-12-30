package ua.ksstroy.logic.material;

import ua.ksstroy.logic.zone.Measure;

/**
 * Created by Zheka on 30.12.2015.
 */
public class MaterialImpl implements Material{

    private Integer id;

    private String name;

    private String description;

    private Measure measure;

    private Double size;

    private Double planedCost;

    private Double dealCost;

    private Double closedCost;

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

    @Override
    public Double getSummaryPriceMaterial() {
        return null;
    }

    @Override
    public Double getSummaryQuantityMaterial() {
        return null;
    }
}

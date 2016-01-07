package ua.ksstroy.models.material;


import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "materials", catalog = "ksstroy")
public class MaterialModel implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "units_per_work_zone_measure")
    private String unitsPerWorkZoneMeasure;

    @Column(name = "planed_cost")
    private Double planedCost;

    @Column(name = "deal_cost")
    private Double dealCost;

    @Column(name = "closed_cost")
    private Double closedCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id_for_type")
    private MaterialTypeModel materialTypeModel;

    public MaterialModel() {
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

    public String getUnitsPerWorkZoneMeasure() {
        return unitsPerWorkZoneMeasure;
    }

    public void setUnitsPerWorkZoneMeasure(String unitsPerWorkZoneMeasure) {
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
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

    public MaterialTypeModel getMaterialTypeModel() {
        return materialTypeModel;
    }

    public void setMaterialTypeModel(MaterialTypeModel materialTypeModel) {
        this.materialTypeModel = materialTypeModel;
    }
}
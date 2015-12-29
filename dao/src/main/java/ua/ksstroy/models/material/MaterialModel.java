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

    @Column(name = "measure_name")
    private String measureName;

    @Column(name = "size")
    private Double size;

    @Column(name = "planed_cost")
    private Double planedCost;

    @Column(name = "deal_cost")
    private Double dealCost;

    @Column(name = "closed_cost")
    private Double closedCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MaterialTypeModel materialTypeModel;

    public MaterialModel() {
    }

    public MaterialModel(String id, String name, String description, String measureName, Double size, Double planedCost, Double dealCost, Double closedCost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.measureName = measureName;
        this.size = size;
        this.planedCost = planedCost;
        this.dealCost = dealCost;
        this.closedCost = closedCost;
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

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
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

    public MaterialTypeModel getMaterialTypeModel() {
        return materialTypeModel;
    }

    public void setMaterialTypeModel(MaterialTypeModel materialTypeModel) {
        this.materialTypeModel = materialTypeModel;
    }

}
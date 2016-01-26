package ua.ksstroy.models.material;

import ua.ksstroy.models.worktype.WorkTypeModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "materials", catalog = "ksstroy")
public class MaterialModel implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "units_per_work_zone_measure")
    private Double unitsPerWorkZoneMeasure;

    @Column(name = "planed_cost")
    private Double planedCost;

    @Column(name = "deal_cost")
    private Double dealCost;

    @Column(name = "closed_cost")
    private Double closedCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_type_id")
    private MaterialTypeModel materialType;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "materials")
    private List<WorkTypeModel> workTypeModels;

    public MaterialModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getUnitsPerWorkZoneMeasure() {
        return unitsPerWorkZoneMeasure;
    }

    public void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure) {
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


    public MaterialTypeModel getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialTypeModel materialType) {
        this.materialType = materialType;
    }

    public List<WorkTypeModel> getWorkTypeModels() {
        return workTypeModels;
    }

    public void setWorkTypeModels(List<WorkTypeModel> workTypeModels) {
        this.workTypeModels = workTypeModels;
    }
}

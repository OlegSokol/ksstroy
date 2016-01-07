package ua.ksstroy.models.material;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "material_type", catalog = "ksstroy")
public class MaterialTypeModel implements Serializable {

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id_for_type")
    @OrderBy
    private Set<MaterialModel> materialTypeToMaterial = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MaterialTypeGroupModel materialTypeGroupModel;

    public MaterialTypeModel() {
    }

    public MaterialTypeModel(String name, String description, Double pricePerUnit, String unitName) {
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.unitName = unitName;
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

    public MaterialTypeGroupModel getMaterialTypeGroupModel() {
        return materialTypeGroupModel;
    }

    public void setMaterialTypeGroupModel(MaterialTypeGroupModel materialTypeGroupModel) {
        this.materialTypeGroupModel = materialTypeGroupModel;
    }

}
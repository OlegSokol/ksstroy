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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @OrderBy
    private Set<MaterialModel> materialTypeToMaterial = new LinkedHashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    @OrderBy
    private Set<MaterialTypeModel> materialType = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MaterialTypeModel subMaterialTypeToRootType;

    public MaterialTypeModel() {
    }

    public MaterialTypeModel(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Set<MaterialModel> getMaterialTypeToMaterial() {
        return materialTypeToMaterial;
    }

    public void setMaterialTypeToMaterial(Set<MaterialModel> materialTypeToMaterial) {
        this.materialTypeToMaterial = materialTypeToMaterial;
    }

    public Set<MaterialTypeModel> getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Set<MaterialTypeModel> materialType) {
        this.materialType = materialType;
    }

    public MaterialTypeModel getSubMaterialTypeToRootType() {
        return subMaterialTypeToRootType;
    }

    public void setSubMaterialTypeToRootType(MaterialTypeModel subMaterialTypeToRootType) {
        this.subMaterialTypeToRootType = subMaterialTypeToRootType;
    }
}
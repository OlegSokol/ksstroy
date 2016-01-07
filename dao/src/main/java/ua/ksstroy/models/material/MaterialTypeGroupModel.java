package ua.ksstroy.models.material;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "material_type", catalog = "ksstroy")
public class MaterialTypeGroupModel implements Serializable {

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
    private Set<MaterialTypeModel> materialTypeToMaterial = new LinkedHashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    @OrderBy
    private Set<MaterialTypeGroupModel> materialType = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MaterialTypeGroupModel subMaterialTypeToRootType;

    public MaterialTypeGroupModel() {
    }

    public MaterialTypeGroupModel(String name, String description) {
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

    public Set<MaterialTypeModel> getMaterialTypeToMaterial() {
        return materialTypeToMaterial;
    }

    public void setMaterialTypeToMaterial(Set<MaterialTypeModel> materialTypeToMaterial) {
        this.materialTypeToMaterial = materialTypeToMaterial;
    }

    public Set<MaterialTypeGroupModel> getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Set<MaterialTypeGroupModel> materialType) {
        this.materialType = materialType;
    }

    public MaterialTypeGroupModel getSubMaterialTypeToRootType() {
        return subMaterialTypeToRootType;
    }

    public void setSubMaterialTypeToRootType(MaterialTypeGroupModel subMaterialTypeToRootType) {
        this.subMaterialTypeToRootType = subMaterialTypeToRootType;
    }
}
package ua.ksstroy.models.material;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "material_type_group", catalog = "ksstroy")
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
    private Set<MaterialTypeModel> materialTypeGroupToMaterialType = new LinkedHashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    @OrderBy
    private Set<MaterialTypeGroupModel> materialTypeGroup = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MaterialTypeGroupModel subMaterialTypeGroup;

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

    public Set<MaterialTypeModel> getMaterialTypeGroupToMaterialType() {
        return materialTypeGroupToMaterialType;
    }

    public void setMaterialTypeGroupToMaterialType(Set<MaterialTypeModel> materialTypeGroupToMaterialType) {
        this.materialTypeGroupToMaterialType = materialTypeGroupToMaterialType;
    }

    public Set<MaterialTypeGroupModel> getMaterialTypeGroup() {
        return materialTypeGroup;
    }

    public void setMaterialTypeGroup(Set<MaterialTypeGroupModel> materialTypeGroup) {
        this.materialTypeGroup = materialTypeGroup;
    }

    public MaterialTypeGroupModel getSubMaterialTypeGroup() {
        return subMaterialTypeGroup;
    }

    public void setSubMaterialTypeGroup(MaterialTypeGroupModel subMaterialTypeGroup) {
        this.subMaterialTypeGroup = subMaterialTypeGroup;
    }
}
package ua.ksstroy.logic.material;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeImpl implements MaterialType {

    private Integer id;

    private String name;

    private String description;

    private List<MaterialType> materialTypeImplList = new ArrayList<>();

    private List<Material> materialImplList = new ArrayList<>();

    public MaterialTypeImpl() {

    }

    public MaterialTypeImpl(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public List<MaterialType> getMaterialTypeImplList() {
        return materialTypeImplList;
    }

    @Override
    public void setMaterialTypeImplList(List<MaterialType> materialTypeImplList) {
        this.materialTypeImplList = materialTypeImplList;
    }

    @Override
    public List<Material> getMaterialImplList() {
        return materialImplList;
    }

    @Override
    public void setMaterialImplList(List<Material> materialImplList) {
        this.materialImplList = materialImplList;
    }
}
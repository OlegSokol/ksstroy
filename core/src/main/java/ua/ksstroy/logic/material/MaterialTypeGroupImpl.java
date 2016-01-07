package ua.ksstroy.logic.material;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroupImpl implements MaterialTypeGroup {

    private Integer id;

    private String name;

    private String description;

    private List<MaterialTypeGroup> materialTypeGroupImplList = new ArrayList<>();

    private List<MaterialType> materialTypeImplList = new ArrayList<>();

    public MaterialTypeGroupImpl() {

    }

    public MaterialTypeGroupImpl(Integer id, String name, String description) {
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

    public List<MaterialTypeGroup> getMaterialTypeGroupImplList() {
        return materialTypeGroupImplList;
    }

    @Override
    public void setMaterialTypeGroupImplList(List<MaterialTypeGroup> materialTypeGroupImplList) {
        this.materialTypeGroupImplList = materialTypeGroupImplList;
    }

    @Override
    public List<MaterialType> getMaterialTypeImplList() {
        return materialTypeImplList;
    }

    @Override
    public void setMaterialTypeImplList(List<MaterialType> materialTypeImplList) {
        this.materialTypeImplList = materialTypeImplList;
    }
}
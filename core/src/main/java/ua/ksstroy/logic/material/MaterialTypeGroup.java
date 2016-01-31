package ua.ksstroy.logic.material;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroup{

    private String id;

    private String name;

    private String description;

    private List<MaterialTypeGroup> materialTypeGroupImplList = new ArrayList<>();

    private List<MaterialType> materialTypeImplList = new ArrayList<>();

    public MaterialTypeGroup() {

    }

    public MaterialTypeGroup(String id, String name, String description) {
        this.id = id;
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

    public List<MaterialTypeGroup> getMaterialTypeGroupImplList() {
        return materialTypeGroupImplList;
    }

    
    public void setMaterialTypeGroupImplList(List<MaterialTypeGroup> materialTypeGroupImplList) {
        this.materialTypeGroupImplList = materialTypeGroupImplList;
    }

    
    public List<MaterialType> getMaterialTypeImplList() {
        return materialTypeImplList;
    }

    
    public void setMaterialTypeImplList(List<MaterialType> materialTypeImplList) {
        this.materialTypeImplList = materialTypeImplList;
    }
}
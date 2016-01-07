package ua.ksstroy.logic.material;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroupData {

    private Integer id;

    private String name;

    private String description;

    private List<MaterialTypeGroupData> materialTypeGroupDataList = new ArrayList<>();

    private List<MaterialTypeData> materialTypeDataList = new ArrayList<>();

    public MaterialTypeGroupData() {
    }

    public MaterialTypeGroupData(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<MaterialTypeGroupData> getMaterialTypeGroupDataList() {
        return materialTypeGroupDataList;
    }

    public void setMaterialTypeGroupDataList(List<MaterialTypeGroupData> materialTypeGroupDataList) {
        this.materialTypeGroupDataList = materialTypeGroupDataList;
    }

    public List<MaterialTypeData> getMaterialTypeDataList() {
        return materialTypeDataList;
    }

    public void setMaterialTypeDataList(List<MaterialTypeData> materialTypeDataList) {
        this.materialTypeDataList = materialTypeDataList;
    }
}
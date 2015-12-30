package ua.ksstroy.logic.material;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeData {

    private Integer id;

    private String name;

    private String description;

    private List<MaterialTypeData> materialTypeDataList = new ArrayList<>();

    private List<MaterialData> materialDataList = new ArrayList<>();

    public MaterialTypeData() {

    }

    public MaterialTypeData(String name, String description) {
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

    public List<MaterialTypeData> getMaterialTypeDataList() {
        return materialTypeDataList;
    }

    public void setMaterialTypeDataList(List<MaterialTypeData> materialTypeDataList) {
        this.materialTypeDataList = materialTypeDataList;
    }

    public List<MaterialData> getMaterialDataList() {
        return materialDataList;
    }

    public void setMaterialDataList(List<MaterialData> materialDataList) {
        this.materialDataList = materialDataList;
    }
}
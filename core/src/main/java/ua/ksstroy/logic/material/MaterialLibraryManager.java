package ua.ksstroy.logic.material;

public interface MaterialLibraryManager {

    MaterialTypeGroup getMaterialHierarchy();

    void addMaterialTypeGroup(MaterialTypeGroup materialTypeGroupDao);

    void addMaterialTypeGroupByParent(MaterialTypeGroup materialTypeGroupDao, String parentMaterialTypeGroupId);

    void updateMaterialTypeGroup(String materialTypeGroupId, MaterialTypeGroup newMaterialTypeGroup);

    void removeMaterialTypeGroup(String materialTypeGroupId);

    void addMaterialType(MaterialType materialTypeData, String parentMaterialTypeId);

    void updateMaterialType(String materialTypeId, MaterialType newMaterialType);

    void removeMaterialType(String materialTypeId);

}
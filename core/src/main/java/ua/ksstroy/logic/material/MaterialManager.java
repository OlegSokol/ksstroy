package ua.ksstroy.logic.material;

public interface MaterialManager {

    MaterialTypeGroupData getMaterialHierarchy();

    void addMaterialTypeGroup(MaterialTypeGroupData materialTypeGroupDao);

    void addMaterialTypeGroupByParent(MaterialTypeGroupData materialTypeGroupDao, String parentMaterialTypeGroupId);

    void updateMaterialTypeGroup(String materialTypeGroupId, MaterialTypeGroupData newMaterialTypeGroup);

    void removeMaterialTypeGroup(String materialTypeGroupId);

    void addMaterialType(MaterialTypeData materialTypeData, String parentMaterialTypeId);

    void updateMaterialType(String materialTypeId, MaterialTypeData newMaterialType);

    void removeMaterialType(String materialTypeId);

}
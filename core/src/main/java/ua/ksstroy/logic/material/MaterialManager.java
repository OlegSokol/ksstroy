package ua.ksstroy.logic.material;

public interface MaterialManager {

    MaterialTypeData getMaterialHierarchy();

    void addMaterialType(MaterialTypeData materialTypeDao);

    void addMaterialTypeByParent(MaterialTypeData materialTypeDao, String parentMaterialTypeId);

    void updateMaterialType(String materialId, MaterialTypeData newMaterialType);

    void removeMaterialType(String materialId);

    void addMaterial(MaterialData materialData, String parentMaterialTypeId);

    void updateMaterial(String materialId, MaterialData newMaterial);

    void removeMaterial(String materialId);

}
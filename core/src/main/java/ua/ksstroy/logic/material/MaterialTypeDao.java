package ua.ksstroy.logic.material;

public interface MaterialTypeDao {

    MaterialTypeData getMaterialHierarhy();

    void addMaterialType(MaterialTypeData materialTypeDao);

    void addMaterialTypeByParent(MaterialTypeData materialTypeDao, String parentMaterialTypeId);

    void updateMaterialType(String materialId, MaterialTypeData newMaterialType);

    void removeMaterialType(String materialId);

}
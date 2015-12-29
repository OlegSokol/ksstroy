package ua.ksstroy.logic.material;

public interface MaterialTypeDao {

    MaterialTypeData getMaterialHierarchy();

    void addMaterialType(final MaterialTypeData materialTypeDao);

    void addMaterialTypeByParent(final MaterialTypeData materialTypeDao, final String parentMaterialTypeId);

    void updateMaterialType(final String materialId, final MaterialTypeData newMaterialType);

    void removeMaterialType(final String materialId);

}
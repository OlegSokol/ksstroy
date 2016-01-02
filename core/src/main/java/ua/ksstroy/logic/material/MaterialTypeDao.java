package ua.ksstroy.logic.material;

public interface MaterialTypeDao {

    MaterialType getMaterialHierarchy();

    void addMaterialType(final MaterialType materialTypeDao);

    void addMaterialTypeByParent(final MaterialType materialTypeDao, final String parentMaterialTypeId);

    void updateMaterialType(final String materialId, final MaterialType newMaterialType);

    void removeMaterialType(final String materialId);

}
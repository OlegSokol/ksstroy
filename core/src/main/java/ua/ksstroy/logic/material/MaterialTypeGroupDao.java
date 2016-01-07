package ua.ksstroy.logic.material;

public interface MaterialTypeGroupDao {

    MaterialTypeGroup getMaterialHierarchy();

    void addMaterialTypeGroup(final MaterialTypeGroup materialTypeGroup);

    void addMaterialTypeGroupByParent(final MaterialTypeGroup materialTypeGroupDao, final String parentMaterialTypeGroupId);

    void updateMaterialTypeGroup(final String materialTypeGroupId, final MaterialTypeGroup newMaterialTypeGroup);

    void removeMaterialTypeGroup(final String materialTypeGroupId);

}
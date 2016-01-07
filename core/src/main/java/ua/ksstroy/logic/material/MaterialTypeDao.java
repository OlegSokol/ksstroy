package ua.ksstroy.logic.material;

public interface MaterialTypeDao {

    void addMaterialType(final MaterialType materialType, final String parentMaterialTypeGroupId);

    void updateMaterialType(final String materialTypeId, final MaterialType newMaterialType);

    void removeMaterialType(final String materialTypeId);

}
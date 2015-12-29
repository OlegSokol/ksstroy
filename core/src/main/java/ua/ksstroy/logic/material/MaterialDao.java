package ua.ksstroy.logic.material;

public interface MaterialDao {

    void addMaterial(final MaterialData materialData, final String parentMaterialTypeId);

    void updateMaterial(final String materialId, final MaterialData newMaterial);

    void removeMaterial(final String materialId);

}
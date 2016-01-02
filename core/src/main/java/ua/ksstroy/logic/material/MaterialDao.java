package ua.ksstroy.logic.material;

public interface MaterialDao {

    void addMaterial(final Material materialData, final String parentMaterialTypeId);

    void updateMaterial(final String materialId, final Material newMaterial);

    void removeMaterial(final String materialId);

}
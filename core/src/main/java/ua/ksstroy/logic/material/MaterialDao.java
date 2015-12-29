package ua.ksstroy.logic.material;

public interface MaterialDao {

    void addMaterial(MaterialData materialData, String parentMaterialTypeId);

    void updateMaterial(String materialId, MaterialData newMaterial);

    void removeMaterial(String materialId);

}
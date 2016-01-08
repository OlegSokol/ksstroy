package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialDao {
    //TODO:finish after obtain more specific information about the entity

    List<MaterialData> getAllMaterialsByPoject(String projectId);

   /* void addMaterial(final Material material, final String parentMaterialTypeId);

    void updateMaterial(final String materialId, final Material newMaterial);

    void removeMaterial(final String materialId);*/

}
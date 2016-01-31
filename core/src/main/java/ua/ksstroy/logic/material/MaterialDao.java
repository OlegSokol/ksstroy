package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialDao {
    //TODO:finish after obtain more specific information about the entity

    List<Material> getAllMaterials();

    void purchaseMaterial(final Material material, final String materialTypeId);
}
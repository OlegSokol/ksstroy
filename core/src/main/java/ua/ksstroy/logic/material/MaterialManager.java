package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialManager {

    List<Material> getAllMaterials();

    void purchaseMaterial(Material material, String materialTypeId);
}

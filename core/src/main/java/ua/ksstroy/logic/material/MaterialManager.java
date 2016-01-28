package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialManager {

    List<MaterialData> getAllMaterials();

    void purchaseMaterial(MaterialData materialData, String materialTypeId);
}

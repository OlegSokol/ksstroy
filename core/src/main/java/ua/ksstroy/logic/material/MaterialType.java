package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialType {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<MaterialType> getMaterialTypeImplList();

    void setMaterialTypeImplList(List<MaterialType> materialTypeImplList);

    List<Material> getMaterialImplList();

    void setMaterialImplList(List<Material> materialImplList);

}
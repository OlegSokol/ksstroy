package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialTypeGroup {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<MaterialTypeGroup> getMaterialTypeGroupImplList();

    void setMaterialTypeGroupImplList(List<MaterialTypeGroup> materialTypeGroupImplList);

    List<MaterialType> getMaterialTypeImplList();

    void setMaterialTypeImplList(List<MaterialType> materialTypeImplList);

}
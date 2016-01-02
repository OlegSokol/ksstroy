package ua.ksstroy.logic.material;

import java.util.List;

public interface MaterialType {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<MaterialTypeImpl> getMaterialTypeImplList();

    void setMaterialTypeImplList(List<MaterialTypeImpl> materialTypeImplList);

    List<MaterialImpl> getMaterialImplList();

    void setMaterialImplList(List<MaterialImpl> materialImplList);

}
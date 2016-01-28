package ua.ksstroy.implementations;

import org.springframework.stereotype.Repository;
import ua.ksstroy.converter.material.MaterialModelToImplConverter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialDao;
import ua.ksstroy.logic.material.MaterialImpl;
import ua.ksstroy.models.material.MaterialModel;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MaterialDaoImpl implements MaterialDao {

    private TransactionHelper helper = new TransactionHelper();

    @Override
    public List<MaterialImpl> getAllMaterials() {
        return helper.simpleAction(new GetInTransaction<List<MaterialImpl>>() {
            @Override
            public List<MaterialImpl> process(SessionWrapper session) {
                List<MaterialImpl> materialList = new ArrayList<>();
                List<MaterialModel> materialModelsList = session.getAll(new MaterialModel());

                for (MaterialModel materialModel : materialModelsList) {
                    materialList.add(new MaterialModelToImplConverter().convert(materialModel));
                }
                return materialList;
            }
        });

    }

    public MaterialModel getMaterial() {
        return helper.simpleAction(new GetInTransaction<MaterialModel>() {
            @Override
            public MaterialModel process(SessionWrapper session) {
                return session.get(MaterialModel.class, "1");
            }
        });
    }

    @Override
    public void purchaseMaterial(final Material material, final String materialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialModel materialModel = new MaterialModel();
                materialModel.setUnitsPerWorkZoneMeasure(material.getUnitsPerWorkZoneMeasure());
                materialModel.setMaterialType(session.get(MaterialTypeModel.class, materialTypeId));
                session.save(materialModel);
            }
        });
    }

}
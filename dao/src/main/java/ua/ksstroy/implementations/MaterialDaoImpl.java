package ua.ksstroy.implementations;

import org.springframework.stereotype.Repository;
import ua.ksstroy.logic.material.MaterialDao;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialImpl;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.List;

@Repository
public class MaterialDaoImpl implements MaterialDao {

    private TransactionHelper helper = new TransactionHelper();
    @Override
    public List<MaterialData> getAllMaterialsByPoject(String projectId) {
        helper.simpleAction(new GetInTransaction<MaterialImpl>() {
            @Override
            public MaterialImpl process(SessionWrapper session) {
                //TODO:finish after obtain more specific information about the entity
                return null;
            }
        });
        return null;
    }
}

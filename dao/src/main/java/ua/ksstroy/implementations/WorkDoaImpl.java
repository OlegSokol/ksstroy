package ua.ksstroy.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.AdjustmentToAdjustmentModelConverter;
import ua.ksstroy.converter.CoverToCoverModelConverter;
import ua.ksstroy.converter.WorkToWorkModelConverter;
import ua.ksstroy.logic.work.Adjustment;
import ua.ksstroy.logic.work.Cover;
import ua.ksstroy.logic.work.Work;
import ua.ksstroy.logic.work.WorkDao;
import ua.ksstroy.models.work.WorkGroupModel;
import ua.ksstroy.models.work.WorkModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Component
public class WorkDoaImpl implements WorkDao {
    private TransactionHelper helper = new TransactionHelper();

    @Override
    public void addWork(final Work work, final String parentGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkModel workModel = new WorkToWorkModelConverter().convert(work);
                WorkGroupModel workGroupModel = session.get(WorkGroupModel.class, parentGroupId);
                workGroupModel.getWorks().add(workModel);
                session.saveOrUpdate(workGroupModel);
            }
        });
    }

    @Override
    public void addCoverToWork(final Cover cover, final String workId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkModel workModel = session.get(WorkModel.class, workId);
                workModel.getAllCovers().add(new CoverToCoverModelConverter().convert(cover));
                session.saveOrUpdate(workModel);
            }
        });
    }

    @Override
    public void addAdjustmentToWork(final Adjustment adjustment, final String workId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkModel workModel = session.get(WorkModel.class, workId);
                workModel.getAdjustments().add(new AdjustmentToAdjustmentModelConverter().convert(adjustment));
                session.saveOrUpdate(workModel);
            }
        });
    }

    @Override
    public void updateWork(final String workId, final Work work) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkModel newWorkModel = new WorkToWorkModelConverter().convert(work);
                newWorkModel.setId(workId);
                session.saveOrUpdate(newWorkModel);
            }
        });
    }

    @Override
    public void remoteWork(final String workId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(WorkModel.class, workId));
            }
        });
    }

}

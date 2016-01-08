package ua.ksstroy.converter;

import ua.ksstroy.converter.worktype.WorkTypeToWorkTypeModelConvert;
import ua.ksstroy.logic.work.Adjustment;
import ua.ksstroy.logic.work.Cover;
import ua.ksstroy.logic.work.Work;
import ua.ksstroy.logic.zonegroup.Zone;
import ua.ksstroy.models.work.AdjustmentModel;
import ua.ksstroy.models.work.CoverModel;
import ua.ksstroy.models.work.WorkModel;
import ua.ksstroy.models.zone.ZonesModel;

import java.util.ArrayList;
import java.util.List;

public class WorkToWorkModelConverter implements Converter<Work, WorkModel> {

    @Override
    public WorkModel convert(Work work) {
        WorkModel workModel = new WorkModel();
        workModel.setId(work.getId());
        workModel.setName(work.getName());
        workModel.setType(new WorkTypeToWorkTypeModelConvert().convert(work.getType()));
        workModel.setPlanedCost(work.getPlanedCost());
        workModel.setPerspectiveCost(work.getPerspectiveCost());
        workModel.setClosedCost(work.getClosedCost());
        workModel.setDealCost(work.getDealCost());

        List<ZonesModel> zonesModels = new ArrayList<>();
        for (Zone zone : work.getWorkZones()) {
            zonesModels.add(new ZoneToZoneModelConverter().convert(zone));
        }
        workModel.setWorkZones(zonesModels);

        List<CoverModel> coverModels = new ArrayList<>();
        for (Cover cover : work.getAllCovers()) {
            coverModels.add(new CoverToCoverModelConverter().convert(cover));
        }
        workModel.setAllCovers(coverModels);

        List<AdjustmentModel> adjustmentModels = new ArrayList<>();
        for (Adjustment adjustment : work.getAdjustments()) {
            adjustmentModels.add(new AdjustmentToAdjustmentModelConverter().convert(adjustment));
        }
        workModel.setAdjustments(adjustmentModels);

        return workModel;
    }

}
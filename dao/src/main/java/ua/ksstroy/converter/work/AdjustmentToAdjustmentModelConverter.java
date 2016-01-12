package ua.ksstroy.converter.work;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.work.Adjustment;
import ua.ksstroy.models.work.AdjustmentModel;

public class AdjustmentToAdjustmentModelConverter implements Converter<Adjustment, AdjustmentModel> {
    @Override
    public AdjustmentModel convert(Adjustment adjustment) {
        AdjustmentModel adjustmentModel = new AdjustmentModel();
        adjustmentModel.setId(adjustment.getId());
        adjustmentModel.setValue(adjustment.getValue());
        adjustmentModel.setAbsolute(adjustment.isAbsolute());

        return adjustmentModel;

    }
}

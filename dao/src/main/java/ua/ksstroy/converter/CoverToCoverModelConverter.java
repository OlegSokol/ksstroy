package ua.ksstroy.converter;

import ua.ksstroy.logic.work.Cover;
import ua.ksstroy.models.work.CoverModel;

public class CoverToCoverModelConverter implements Converter<Cover, CoverModel> {
    @Override
    public CoverModel convert(Cover cover) {
        CoverModel coverModel = new CoverModel();
        coverModel.setId(cover.getId());
        coverModel.setDescription(cover.getDescription());
        coverModel.setDate(cover.getDate());
        coverModel.setValue(cover.getValue());

        return coverModel;

    }
}

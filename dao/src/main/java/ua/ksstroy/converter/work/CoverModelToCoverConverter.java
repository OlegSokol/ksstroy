package ua.ksstroy.converter.work;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.work.Cover;
import ua.ksstroy.models.work.CoverModel;

public class CoverModelToCoverConverter implements Converter<CoverModel, Cover> {
    @Override
    public Cover convert(CoverModel coverModel) {
        Cover cover = new Cover();
        cover.setId(coverModel.getId());
        cover.setDate(coverModel.getDate());
        cover.setDescription(coverModel.getDescription());
        cover.setValue(coverModel.getValue());

        return cover;
    }
}

package ua.ksstroy.logic.zone;

import java.util.List;

/*
 * Интерфейс служит для управления таблицей содержащей зоны
 */

public interface ZoneDataDao {

	/*
	 * добавить имя зоны
	 */
	void addZoneName(String zoneName);

	/*
	 * добавить ширину
	 */
	void addZoneWidth(Double width);

	/*
	 * добавить высоту
	 */

	void addZoneHeight(Double height);

	/*
	 * предполагаем что это произведение ширины на высоту
	 */

	void addZoneValue(Double value);

	/*
	 * получить зону по имени
	 * 
	 * @return List<ZoneData>
	 */

	List<ZoneData> getAllZoneDataByName(String zoneName);

	/*
	 * добавить дополнительные зоны
	 */

	List<ZoneData> addZoneAdditional(String zoneName, Double width,
			Double height, Double value);

	/*
	 * добавить избыточные зоны
	 */

	List<ZoneData> addZoneSurplus(String zoneName, Double width, Double height,
			Double value);

	/*
	 * добавить величину измерения
	 */

	void addZoneMesureName(String mesureName);

}

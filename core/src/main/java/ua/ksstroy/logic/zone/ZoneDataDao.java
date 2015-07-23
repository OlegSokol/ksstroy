package ua.ksstroy.logic.zone;

import java.util.List;

/*
<<<<<<< HEAD
 * Ð˜Ð½Ñ‚ÐµÑ€Ñ„ÐµÐ¹Ñ ÑÐ»ÑƒÐ¶Ð¸Ñ‚ Ð´Ð»Ñ ÑƒÐ¿Ñ€Ð°Ð²Ð»ÐµÐ½Ð¸Ñ Ñ‚Ð°Ð±Ð»Ð¸Ñ†ÐµÐ¹ ÑÐ¾Ð´ÐµÑ€Ð¶Ð°Ñ‰ÐµÐ¹ Ð·Ð¾Ð½Ñ‹
=======
 * Èíòåðôåéñ ñëóæèò äëÿ óïðàâëåíèÿ òàáëèöåé ñîäåðæàùåé çîíû
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
 */

public interface ZoneDataDao {

	/*
<<<<<<< HEAD
	 * Ð´Ð¾Ð±Ð°Ð²Ð¸Ñ‚ÑŒ Ð¸Ð¼Ñ Ð·Ð¾Ð½Ñ‹
=======
	 * äîáàâèòü èìÿ çîíû
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */
	void addZoneName(String zoneName);

	/*
<<<<<<< HEAD
	 * Ð´Ð¾Ð±Ð°Ð²Ð¸Ñ‚ÑŒ ÑˆÐ¸Ñ€Ð¸Ð½Ñƒ
=======
	 * äîáàâèòü øèðèíó
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */
	void addZoneWidth(Double width);

	/*
<<<<<<< HEAD
	 * Ð´Ð¾Ð±Ð°Ð²Ð¸Ñ‚ÑŒ Ð²Ñ‹ÑÐ¾Ñ‚Ñƒ
=======
	 * äîáàâèòü âûñîòó
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	void addZoneHeight(Double height);

	/*
<<<<<<< HEAD
	 * Ð¿Ñ€ÐµÐ´Ð¿Ð¾Ð»Ð°Ð³Ð°ÐµÐ¼ Ñ‡Ñ‚Ð¾ ÑÑ‚Ð¾ Ð¿Ñ€Ð¾Ð¸Ð·Ð²ÐµÐ´ÐµÐ½Ð¸Ðµ ÑˆÐ¸Ñ€Ð¸Ð½Ñ‹ Ð½Ð° Ð²Ñ‹ÑÐ¾Ñ‚Ñƒ
=======
	 * ïðåäïîëàãàåì ÷òî ýòî ïðîèçâåäåíèå øèðèíû íà âûñîòó
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	void addZoneValue(Double value);

	/*
<<<<<<< HEAD
	 * Ð¿Ð¾Ð»ÑƒÑ‡Ð¸Ñ‚ÑŒ Ð·Ð¾Ð½Ñƒ Ð¿Ð¾ Ð¸Ð¼ÐµÐ½Ð¸
=======
	 * ïîëó÷èòü çîíó ïî èìåíè
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 * 
	 * @return List<ZoneData>
	 */

	List<ZoneData> getAllZoneDataByName(String zoneName);

	/*
<<<<<<< HEAD
	 * Ð´Ð¾Ð±Ð°Ð²Ð¸Ñ‚ÑŒ Ð´Ð¾Ð¿Ð¾Ð»Ð½Ð¸Ñ‚ÐµÐ»ÑŒÐ½Ñ‹Ðµ Ð·Ð¾Ð½Ñ‹
=======
	 * äîáàâèòü äîïîëíèòåëüíûå çîíû
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	List<ZoneData> addZoneAdditional(String zoneName, Double width,
			Double height, Double value);

	/*
<<<<<<< HEAD
	 * Ð´Ð¾Ð±Ð°Ð²Ð¸Ñ‚ÑŒ Ð¸Ð·Ð±Ñ‹Ñ‚Ð¾Ñ‡Ð½Ñ‹Ðµ Ð·Ð¾Ð½Ñ‹
=======
	 * äîáàâèòü èçáûòî÷íûå çîíû
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	List<ZoneData> addZoneSurplus(String zoneName, Double width, Double height,
			Double value);

	/*
<<<<<<< HEAD
	 * Ð´Ð¾Ð±Ð°Ð²Ð¸Ñ‚ÑŒ Ð²ÐµÐ»Ð¸Ñ‡Ð¸Ð½Ñƒ Ð¸Ð·Ð¼ÐµÑ€ÐµÐ½Ð¸Ñ
=======
	 * äîáàâèòü âåëè÷èíó èçìåðåíèÿ
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	void addZoneMesureName(String mesureName);

}

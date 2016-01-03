package ua.ksstroy.logic.zoneGroup;

import java.util.List;

/*
 * An object representing a particular single zoneGroup in
 * a building (e.g Zone "Kitchen" contains surplus zones: Windows, Door etc.).
 */

public interface Zone {

	String getId();

	void setId(String id);

	String getName();

	void setName(String name);

	List<Zone> getAdditional();

	void setAdditional(List<Zone> additional);

	void addAdditional(Zone zoneAddit);

	List<Zone> getSurplus();

	void setSurplus(List<Zone> surplus);

	void addSurplus(Zone zoneSurpl);

	Measure getMeasure();

	void setMeasure(Measure measure);

	Double getWidth();

	void setWidth(Double width);

	Double getHeight();

	void setHeight(Double height);

	/*
	 * calculate square of the Zone according to additional and surplus zones
	 * squares.
	 */
	Double getValue();

}
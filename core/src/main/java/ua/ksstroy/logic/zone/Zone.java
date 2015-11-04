package ua.ksstroy.logic.zone;

import java.util.List;

/*
 * An object representing a particular single zone in 
 * a building (e.g Zone "Kitchen" contains surplus zones: Windows, Door etc.).
 */

public interface Zone {

	public String getId();

	public void setId(String id);

	public String getName();

	public void setName(String name);

	public List<Zone> getAdditional();

	public void setAdditional(List<Zone> additional);

	public void addAdditional(Zone zoneAddit);

	public List<Zone> getSurplus();

	public void setSurplus(List<Zone> surplus);

	public void addSurplus(Zone zoneSurpl);

	public Measure getMeasure();

	public void setMeasure(Measure measure);

	public Double getWidth();

	public void setWidth(Double width);

	public Double getHeight();

	public void setHeight(Double height);

	/*
	 * calculate square of the Zone according to additional and surplus zones
	 * squares.
	 */
	public Double getValue();

}

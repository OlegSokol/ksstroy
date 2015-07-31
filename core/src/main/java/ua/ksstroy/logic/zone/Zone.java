package ua.ksstroy.logic.zone;

import java.util.List;
/*
 * An object representing a particular single zone in 
 * a building (e.g Zone "Kitchen" contains surplus zones: Windows, Door etc.).
 */

public interface Zone {

	
	public String getId();
	
	public String getName();

	public List<Zone> getAdditional();

	public List<Zone> getSurplus();

	public Measure getMeasure();

	public Double getWidth();

	public Double getHeight();
/*
 * calculate square of the Zone according to additional and surplus
 * zones squares.
 */
	public Double getValue();

}

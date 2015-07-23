package ua.ksstroy.logic.zone;

import java.util.List;

public interface Zone {

	public String getId();
	
	public String getName();

	public List<Zone> getAdditional();

	public List<Zone> getSurplus();

	public Mesure getMesure();

	public Double getWidth();

	public Double getHeight();

	public Double getValue();

}

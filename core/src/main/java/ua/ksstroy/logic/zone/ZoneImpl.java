package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

public class ZoneImpl implements Zone
{
	ZoneData zoneData = new ZoneData(); 
	public String getId()
	{
		return zoneData.getId();
	}
	
	public String getName()
	{
		return zoneData.getName();
	}
		
	public List<Zone> getAdditional()
	{
		List<Zone> zoneAdds = new ArrayList<Zone>();
		return zoneAdds;
	}

	public List<Zone> getSurplus()
	{
		List<Zone> zoneSurplus = new ArrayList<Zone>();
		return zoneSurplus;
	}

	public Measure getMeasure()
	{
		Measure measure = Measure.M2;
		return measure;
	}

	public Double getWidth()
	{
		return zoneData.getWidth();
	}

	public Double getHeight()
	{
		return zoneData.getHeight();
	}

	public Double getValue()
	{
		return getHeight()*getWidth();
	}
	
	
	
}

package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ZoneImpl implements Zone
{
	@Resource
	ZoneData zoneData;
	public String getId()
	{
		return zoneData.getId();
	}
	
	public String getName()
	{
		return zoneData.getName();
	}
		
	public List<ZoneData> getAdditional()
	{
		return zoneData.getAdditional();
	}

	public List<Zone> getSurplus()
	{
		return zoneData.getSurplus();
	}

	public Mesure getMesure()
	{
		return zoneData.getMesureName();
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

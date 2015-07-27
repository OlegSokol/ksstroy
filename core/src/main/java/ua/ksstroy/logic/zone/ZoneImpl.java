import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


public class ZoneImpl implements Zone
{
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
		return zoneData.getAdditional();
	}

	public List<Zone> getSurplus()
	{
		return zoneData.getSurplus();
	}

	public Mesure getMesure()
	{
		return zoneData.getMesure();
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

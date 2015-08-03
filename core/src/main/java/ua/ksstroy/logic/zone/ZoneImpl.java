package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

public class ZoneImpl implements Zone
{
	ZoneData zoneData = new ZoneData(); 

	private String id;

	private String name;

	private List<Zone> additional; 

	private List<Zone> surplus; 

	private Double width;

	private Double height;

	private Double value; 

	private Measure measureName;

	public String getId()
	{
		return this.id;
	}

	public void setId()
	{
		this.id = zoneData.getId();
	}

	public String getName()
	{
		return this.name;
	}

	public void setName()
	{
		this.name = zoneData.getName();
	}

	public List<Zone> getAdditional()
	{
		return this.additional;
	}

	public void setAdditional()
	{
		// need fix
		List<ZoneData> tempZone = zoneData.getAdditional();

	}

	public List<Zone> getSurplus()
	{
		return this.surplus;
	}

	public void setSurplus()
	{
		//need fix
		List<ZoneData> tempZone = zoneData.getAdditional();
		System.out.println(tempZone.isEmpty());
	}

	public Measure getMeasureName()
	{
		return this.measureName;
	}

	public void setMesuareName()
	{
		this.measureName = zoneData.getMeasureName();
	}

	public Double getWidth()
	{
		return this.width;
	}

	public void setWidth()
	{
		this.width = zoneData.getWidth();
	}
	public Double getHeight()
	{
		return this.height;
	}

	public void setHeight()
	{
		this.height = zoneData.getHeight();
	}

	public Double getValue()
	{
		return this.value;
	}

	public void setValue()
	{
		this.value = this.height * this.width;

	}
}

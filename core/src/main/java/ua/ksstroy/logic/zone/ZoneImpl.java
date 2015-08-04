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

	private Measure measure;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Zone> getAdditional() {
		return additional;
	}

	public void setAdditional(List<Zone> additional) {
		this.additional = additional;
	}
	
	public void addAdditional(Zone zoneAddit) {
		this.additional.add(zoneAddit);
	}

	public List<Zone> getSurplus() {
		return surplus;
	}

	public void setSurplus(List<Zone> surplus) {
		this.surplus = surplus;
	}

	public void addSurplus(Zone zoneSurpl) {
		this.surplus.add(zoneSurpl);
	}
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	
}

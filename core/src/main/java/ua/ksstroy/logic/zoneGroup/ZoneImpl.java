package ua.ksstroy.logic.zonegroup;

import java.util.ArrayList;
import java.util.List;

public class ZoneImpl implements Zone {

	private String id;

	private String name;

	private List<Zone> additional = new ArrayList<>();

	private List<Zone> surplus = new ArrayList<>();

	private Double width;

	private Double height;

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

	public void addAdditional(Zone zoneAdditional) {
		this.additional.add(zoneAdditional);
	}

	public List<Zone> getSurplus() {
		return surplus;
	}

	public void setSurplus(List<Zone> surplus) {
		this.surplus = surplus;
	}

	public void addSurplus(Zone zoneSurplus) {
		this.surplus.add(zoneSurplus);
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
		// TODO curiosity: is it a good design ?
		Double value = 0.0;
		Double addValue = 0.0;
		for (Zone addZone : getAdditional()) {
			addValue += addZone.getValue();
		}
		Double surValue = 0.0;
		for (Zone surZone : getSurplus()) {
			surValue += surZone.getValue();
		}
		value = getHeight() * getWidth() + addValue - surValue;
		return value;

	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

}
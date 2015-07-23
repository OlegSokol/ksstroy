package ua.ksstroy.logic.zone;

import java.util.List;

public class ZoneData {

	private String id;

	private String name;

	private List<ZoneData> additional; 

	private List<ZoneData> surplus; 

	private Double width;

	private Double height;

	private Double value; 

	private String mesureName;

	public List<ZoneData> getAdditional() {
		return additional;
	}

	public void setAdditional(List<ZoneData> additional) {
		this.additional = additional;
	}

	public List<ZoneData> getSurplus() {
		return surplus;
	}

	public void setSurplus(List<ZoneData> surplus) {
		this.surplus = surplus;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

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

	public String getMesureName() {
		return mesureName;
	}

	public void setMesureName(String mesureName) {
		this.mesureName = mesureName;
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

}

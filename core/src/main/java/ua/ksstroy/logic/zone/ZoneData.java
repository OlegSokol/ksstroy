package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;
/*	
 The class is contain all information about particular zone in building
 with additional and surplus zones. Literally it is "castrated" implementation
 of Zone object. Doesn't contains any business logic. Just pure data
 representation sends to web tier and vice-versa. 
 (e.g Zone "Kitchen" contains surplus zones: Windows, Door etc.)
*/

public class ZoneData {

	private String id;

	private String name;

	private List<ZoneData> additional = new ArrayList<>();

	private List<ZoneData> surplus = new ArrayList<>();

	private Double width;

	private Double height;

	private Double value;

	private String measureName;

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

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
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

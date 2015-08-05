package ua.ksstroy.logic.work;

public class AdjustmentImpl implements Adjustment {

	private Double value;
	
	private boolean isAbsolute;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public boolean isAbsolute() {
		return isAbsolute;
	}

	public void setAbsolute(boolean isAbsolute) {
		this.isAbsolute = isAbsolute;
	}

}

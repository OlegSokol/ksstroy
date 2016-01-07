package ua.ksstroy.logic.work;

public interface Adjustment {

	public String getId();

	public void setId(String id);

	public Double getValue();

	public void setValue(Double value);

	public boolean isAbsolute();

	public void setAbsolute(boolean isAbsolute);
	
}

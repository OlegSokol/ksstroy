package ua.ksstroy.logic.work;

import java.util.List;

import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneData;

public interface Work {
	
	public WorkType getType();

	public void setType(WorkType type);

	public List<Zone> getWorkZones();

	public void setWorkZones(List<Zone> workZones);

	public List<Cover> getAllCovers();

	public void setAllCovers(List<Cover> allCovers);

	public String getId(); 

	public void setId(String id); 

	public String getName(); 
	
	public void setName(String name); 

	public Double getPlanedCost(); 

	public void setPlanedCost(Double planedCost);

	public Double getPerspectiveCost();

	public void setPerspectiveCost(Double perspectiveCost); 

	public Double getClosedCost(); 

	public void setClosedCost(Double closedCost); 

	public Double getDealCost(); 

	public void setDealCost(Double dealCost); 

	public List<Adjustment> getAdjustments();

	public void setAdjustments(List<Adjustment> adjustments);

}

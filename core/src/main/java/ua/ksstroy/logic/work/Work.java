package ua.ksstroy.logic.work;

import java.util.List;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zone.ZoneData;

public interface Work {
	
	public WorkTypeData getType(); 

	public void setType(WorkTypeData type); 

	public List<ZoneData> getWorkZones(); 

	public void setWorkZones(List<ZoneData> workZones); 

	public List<CoverData> getAllCovers(); 

	public void setAllCovers(List<CoverData> allCovers); 

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

	public List<AdjustmentData> getAdjustments(); 

	public void setAdjustments(List<AdjustmentData> adjustments); 

}

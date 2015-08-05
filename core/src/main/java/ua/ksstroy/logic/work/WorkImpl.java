package ua.ksstroy.logic.work;

import java.util.List;

import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zone.ZoneData;

public class WorkImpl implements Work{

	WorkData workData = new WorkData(); 
	
private String id;
	
	private String name;
	
	private WorkTypeData type;
	
	private List<ZoneData> workZones;
	
	private List<CoverData> allCovers;
	
	private Double planedCost;
	
	private Double perspectiveCost;
	
	private Double closedCost;

	private Double dealCost;
	
	private List<AdjustmentData> adjustments;
	
	@Override
	public WorkTypeData getType() {
	
		return type;
	}

	@Override
	public void setType(WorkTypeData type) {

		this.type=type;
	}

	@Override
	public List<ZoneData> getWorkZones() {
		
		return workZones;
	}

	@Override
	public void setWorkZones(List<ZoneData> workZones) {
		this.workZones=workZones;
		
	}

	@Override
	public List<CoverData> getAllCovers() {
		return allCovers;
	}

	@Override
	public void setAllCovers(List<CoverData> allCovers) {
		this.allCovers=allCovers;
		
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id=id;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
		
	}

	@Override
	public Double getPlanedCost() {
		// TODO Auto-generated method stub
		return planedCost;
	}

	@Override
	public void setPlanedCost(Double planedCost) {
		this.planedCost=planedCost;
		
	}

	@Override
	public Double getPerspectiveCost() {
		// TODO Auto-generated method stub
		return perspectiveCost;
	}

	@Override
	public void setPerspectiveCost(Double perspectiveCost) {
		this.perspectiveCost=perspectiveCost;
		
	}

	@Override
	public Double getClosedCost() {
		// TODO Auto-generated method stub
		return closedCost;
	}

	@Override
	public void setClosedCost(Double closedCost) {
		this.closedCost=closedCost;
		
	}

	@Override
	public Double getDealCost() {
		// TODO Auto-generated method stub
		return dealCost;
	}

	@Override
	public void setDealCost(Double dealCost) {
		this.dealCost=dealCost;
		
	}

	@Override
	public List<AdjustmentData> getAdjustments() {
		// TODO Auto-generated method stub
		return adjustments;
	}

	@Override
	public void setAdjustments(List<AdjustmentData> adjustments) {
	this.adjustments=adjustments;
		
	}

}

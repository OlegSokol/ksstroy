package ua.ksstroy.logic.work;

import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.zone.Zone;

import java.util.List;

public class Work {

    private String id;

    private String name;

    private WorkType type;

    private List<Zone> workZones;

    private List<Cover> allCovers;

    private Double planedCost;

    private Double perspectiveCost;

    private Double closedCost;

    private Double dealCost;

    private List<Adjustment> adjustments;

    
    public WorkType getType() {

        return type;
    }

    
    public void setType(WorkType type) {

        this.type = type;
    }

    
    public List<Zone> getWorkZones() {

        return workZones;
    }

    
    public void setWorkZones(List<Zone> workZones) {
        this.workZones = workZones;

    }

    
    public List<Cover> getAllCovers() {
        return allCovers;
    }

    
    public void setAllCovers(List<Cover> allCovers) {
        this.allCovers = allCovers;

    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;

    }

    
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    
    public void setName(String name) {
        this.name = name;

    }

    
    public Double getPlanedCost() {
        double costForAllMaterials=0;
        double valueForAllZones=0;

        List<Material> listMaterials = type.getMaterials();

        for (int i = 0; i < listMaterials.size(); i++) {
            costForAllMaterials = costForAllMaterials + listMaterials.get(i).getPlanedCost();
        }

        for (int i = 0; i < workZones.size(); i++) {
            valueForAllZones = valueForAllZones + workZones.get(i).getValue();
        }

        this.planedCost = type.getUnitPrice() + (costForAllMaterials * valueForAllZones );

        return this.planedCost;
    }

    
    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;

    }

    
    public Double getPerspectiveCost() {
        // TODO Auto-generated method stub
        return perspectiveCost;
    }

    
    public void setPerspectiveCost(Double perspectiveCost) {
        this.perspectiveCost = perspectiveCost;

    }

    
    public Double getClosedCost() {
        // TODO Auto-generated method stub
        return closedCost;
    }

    
    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;

    }

    
    public Double getDealCost() {
        // TODO Auto-generated method stub
        return dealCost;
    }

    
    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;

    }

    
    public List<Adjustment> getAdjustments() {
        // TODO Auto-generated method stub
        return adjustments;
    }

    
    public void setAdjustments(List<Adjustment> adjustments) {
        this.adjustments = adjustments;

    }

}
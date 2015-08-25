package ua.ksstroy.mocks;

import java.util.ArrayList;

import ua.ksstroy.logic.zone.ZoneData;

public class ZoneHierarchiDataFactory2 {
	 int zoneCount=0;

	public ZoneData createZoneData(String zoneType) {
	ZoneData zd=new ZoneData();
	zd.setId(new Integer(zoneCount).toString());//set id based on static counter, increment and cast
	zoneCount++;//increment counter
	zd.setName(zoneType);
	zd.setHeight(1.0);
	zd.setWidth(1.1);
	zd.setValue(666.0);
	zd.setMeasureName("mm^2");
		return zd;
	}
	
	/*
	 * return ZoneData object with filled additional and surplus fields
	 */
	public ZoneData createZoneDataWithAdditionalAndSurplus(String zoneType,String additionalType,String surplusType) {
		ZoneData zdWithAdditionalAndSurplus=createZoneData(zoneType);
		
		
		return zdWithAdditionalAndSurplus;
		
		
	}
	
	
}

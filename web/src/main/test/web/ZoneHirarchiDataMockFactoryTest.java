package web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import ua.ksstroy.mocks.ZoneData;
import ua.ksstroy.mocks.ZoneHierarchyData;
import ua.ksstroy.mocks.ZoneHierarchyMockFactory;

public class ZoneHirarchiDataMockFactoryTest {

	ZoneHierarchyMockFactory zhdFactory;
	ZoneHierarchyData rootZhd;
	
	@Before
	public void setUp(){
		zhdFactory=new ZoneHierarchyMockFactory();
		rootZhd=zhdFactory.createZoneHierarchyDataWith2Groups();
		
	}
	@Test
	public void returnTypeTest() {
		assertThat((ZoneHierarchyData.class).equals(zhdFactory.createZoneHierarchyDataWith2Groups().getClass()));
	}



@Test
public void additionalName() throws Exception {
	List<ZoneData> zones= rootZhd.getGroups().get(0).getZones();
	List<ZoneData> additionals=zones.get(0).getAdditional();
assertEquals("additional",additionals.get(0).getName());
	
}	

@Test
public void SurplusName() throws Exception {
	List<ZoneData> zones= rootZhd.getGroups().get(0).getZones();
	List<ZoneData> surplus=zones.get(0).getSurplus();
	assertEquals("surplus",surplus.get(0).getName());
	assertThat(surplus.get(0).getName().contains("surplus"));
	
}	
@Test
public void testName() throws Exception {
	String string1="azaza";
	String string2=0+"azaza";
	assertThat(string2.contains(string1));
}

@Test
public void zoneIdOrderTest() throws Exception {
	
	
	
}

}

package web;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.ksstroy.mocks.ZoneHierarchyData;
import ua.ksstroy.mocks.ZoneHierarchyMockFactory;

public class ZoneHierarhiDataTest {

	@Test
	public void test() {
		ZoneHierarchyData zoneGraph = ZoneHierarchyMockFactory.createZoneHierarchyDataWith2Groups();
//	zoneGraph.printInfo();
//	zoneGraph.printInfoForWeb();
//	System.out.println(zoneGraph.webInfo);
	}

}

package ua.ksstroy.implementations;

import org.junit.*;

public class TestZonesGroup {
@Test
    public void testGetZonesGroup(){
    System.out.println(new ZoneGroupDaoImpl().getZonesByParentGroupId("4"));
}
}

package ua.ksstroy.models.zone;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.persistence.HibernateUtil;

public class GroupsMappingTest {

	private ZoneGroupImpl zoneGroup;
	private Session session;
	private GroupsMappingTest test;

	@Test
	public void subGroupTest() {
		test = new GroupsMappingTest();
		Set<Object> group = new HashSet<>();
		for (ZoneGroupImpl subGroup : test.getSubGroupByRootGroupId("1")) {
			group.add(subGroup.getName());
		}

		Set<String> mockSubGroup = new HashSet<>();
		mockSubGroup.add("Kuhnya");
		mockSubGroup.add("Spalnya");

		assertEquals(mockSubGroup, group);

	}

	public Set<ZoneGroupImpl> getSubGroupByRootGroupId(String groupId) {
		session = HibernateUtil.getSessionFactory().openSession();
		Set<ZoneGroupImpl> group = new HashSet<>();
		for (Object zone : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getSubGroup())
			group.add(convertGroup((GroupsModel) zone));
		return group;
	}

	@Test
	public void rootGroupTest() {
		session = HibernateUtil.getSessionFactory().openSession();
		ProjectModel project = (ProjectModel) session.get(ProjectModel.class,
				33);
		GroupsModel groupsModel = project.getGroupsModel();
		ZoneGroupImpl groupImpl = convertGroup(groupsModel);

		assertEquals("Kvartira", groupImpl.getName());

	}

	private ZoneGroupImpl convertGroup(GroupsModel groupsModel) {
		zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(groupsModel.getId());
		zoneGroup.setName(groupsModel.getName());
		return zoneGroup;
	}

}

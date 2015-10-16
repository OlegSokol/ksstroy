package ua.ksstroy.models.TestMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.persistence.HibernateUtil;

public class SubGropByRootGroupTest {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		SubGropByRootGroupTest test = new SubGropByRootGroupTest();
		List<Object> array = new ArrayList<>();
		for (ZoneGroupImpl subGroup : test.getSubGroupByRootGroupId("1")) {
			array.add(subGroup.getName());
		}
		System.out.println(array.toString());
	}

	public List<ZoneGroupImpl> getSubGroupByRootGroupId(String groupId) {
		List<ZoneGroupImpl> group = new ArrayList<>();
		for (Object zone : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getSubGroup())
			group.add(convertGroup((GroupsModel) zone));
		return group;
	}

	private ZoneGroupImpl convertGroup(GroupsModel groupsModel) {
		ZoneGroupImpl zone = new ZoneGroupImpl();
		zone.setId(groupsModel.getId());
		zone.setName(groupsModel.getName());
		return zone;
	}

}

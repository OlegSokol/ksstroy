package ua.ksstroy.models.TestMapping;

import org.hibernate.Session;

import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.persistence.HibernateUtil;

public class RootGroupByProject {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		RootGroupByProject test = new RootGroupByProject();
		System.out.println(test.getRootGroupByProjectId("33"));
	}

	public ZoneGroupImpl getRootGroupByProjectId(String projectId) {

		ProjectModel project = (ProjectModel) session.get(ProjectModel.class,
				Integer.parseInt(projectId));
		GroupsModel groupsModel = project.getGroupsModel();

		ZoneGroupImpl groupImpl = convert(groupsModel);

		return groupImpl;
	}

	private ZoneGroupImpl convert(GroupsModel groupsModel) {
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(groupsModel.getId());
		zoneGroup.setName(groupsModel.getName());

		return zoneGroup;
	}
}
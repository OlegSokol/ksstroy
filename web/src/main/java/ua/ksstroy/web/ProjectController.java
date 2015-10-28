package ua.ksstroy.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneManager;

@Controller
public class ProjectController {

	@Resource(name = "ZoneManagerImpl")
	ZoneManager zoneManager;

	ModelAndView project;

	@RequestMapping(value = "/projects/{projectId}", method = RequestMethod.GET)
	public ModelAndView showZHD(@PathVariable String projectId) {
		project = new ModelAndView("project");
		project.addObject("projectName", projectId);// the project name from
													// PathVariabl
		project.addObject("zhd", zoneManager.getRootZoneHierarchy(projectId));
		return project;

	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/addRootGroupToProject", method = RequestMethod.POST)
	public ModelAndView addRootGroupToProject(@RequestParam("groupName") String groupName,
			@RequestParam("projectId") String projectId) {

		zoneManager.addRootGroupToProject(groupName, projectId);

		return project;
	}

	@RequestMapping(value = "/projects/addGroupToGroup", method = RequestMethod.POST)
	public ModelAndView addGroupToGroup(@RequestParam("groupName") String groupName,
			@RequestParam("parentGroupId") String parentGroupId) {

		zoneManager.addGroupToGroup(groupName, parentGroupId);

		return project;
	}

	@RequestMapping(value = "/projects/addZone", method = RequestMethod.POST)
	public ModelAndView addZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentGroupId") String parentGroupId) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.addZone(zoneFromWeb, parentGroupId);
		return project;
	}

	@RequestMapping(value = "/projects/addAdditionalZone", method = RequestMethod.POST)
	public ModelAndView addAdditionalZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentZoneId") String parentZoneId) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.addAdditionalToZone(zoneFromWeb, parentZoneId);
		return project;
	}

	@RequestMapping(value = "/projects/addSurplusZone", method = RequestMethod.POST)
	public ModelAndView addSurplusZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentZoneId") String parentZoneId) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.addSurplusToZone(zoneFromWeb, parentZoneId);
		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/updateZone", method = RequestMethod.POST)
	public ModelAndView updateZone(@RequestParam("zoneId") String zoneId, @RequestParam("name") String name,
			@RequestParam("width") String width, @RequestParam("heigh") String height,
			@RequestParam("measureName") String measureName) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.updateZone(zoneId, zoneFromWeb);
		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/updateAdditionalZone", method = RequestMethod.POST)
	public ModelAndView updateAdditionalZone(@RequestParam("zoneId") String zoneId, @RequestParam("name") String name,
			@RequestParam("width") String width, @RequestParam("heigh") String height,
			@RequestParam("measureName") String measureName, @RequestParam("parentZoneId") String parentZoneId) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.updateAdditionalZone(zoneId, zoneFromWeb, parentZoneId);
		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/updateSurplusZone", method = RequestMethod.POST)
	public ModelAndView updateSurplusZone(@RequestParam("zoneId") String zoneId, @RequestParam("name") String name,
			@RequestParam("width") String width, @RequestParam("heigh") String height,
			@RequestParam("measureName") String measureName, @RequestParam("parentZoneId") String parentZoneId) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.updateSurplusZone(zoneId, zoneFromWeb, parentZoneId);
		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/removeZone", method = RequestMethod.POST)
	public ModelAndView removeZone(@RequestParam("zoneId") String zoneId) {

		zoneManager.removeZone(zoneId);

		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/updateGroup", method = RequestMethod.POST)
	public ModelAndView updateGroup(@RequestParam("groupId") String groupId, @RequestParam("name") String newGroup) {

		zoneManager.updateGroup(groupId, newGroup);

		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/updateSubGroup", method = RequestMethod.POST)
	public ModelAndView updateSubGroup(@RequestParam("groupId") String groupId, @RequestParam("name") String newGroup,
			@RequestParam("parentGroupId") String parentGroupId) {

		zoneManager.updateSubGroup(groupId, newGroup, parentGroupId);

		return project;
	}

	// TODO requires the implementation of
	@RequestMapping(value = "/projects/removeGroup", method = RequestMethod.POST)
	public ModelAndView removeGroup(@RequestParam("groupId") String groupId) {

		zoneManager.removeGroup(groupId);

		return project;
	}

}

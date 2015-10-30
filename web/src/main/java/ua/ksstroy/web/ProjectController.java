package ua.ksstroy.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public String addRootGroupToProject(@RequestParam("groupName") String groupName,
			@RequestParam("projectId") Integer projectId, HttpServletRequest request) {

		zoneManager.addRootGroupToProject(groupName, projectId);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/addGroupToGroup", method = RequestMethod.POST)
	public String addGroupToGroup(@RequestParam("groupName") String groupName,
			@RequestParam("parentGroupId") String parentGroupId, HttpServletRequest request) {

		zoneManager.addGroupToGroup(groupName, parentGroupId);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/addZone", method = RequestMethod.POST)
	public String addZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentGroupId") String parentGroupId, HttpServletRequest request) {

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
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/addAdditionalZone", method = RequestMethod.POST)
	public String addAdditionalZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentZoneId") String parentZoneId, HttpServletRequest request) {

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
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/addSurplusZone", method = RequestMethod.POST)
	public String addSurplusZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentZoneId") String parentZoneId, HttpServletRequest request) {

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
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/removeZone", method = RequestMethod.POST)
	public String removeZone(@RequestParam("zoneId") String zoneId, HttpServletRequest request) {

		zoneManager.removeZone(zoneId);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/removeGroup", method = RequestMethod.POST)
	public String removeGroup(@RequestParam("groupId") String groupId, HttpServletRequest request) {

		zoneManager.removeGroup(groupId);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/updateGroup", method = RequestMethod.POST)
	public String updateGroup(@RequestParam("groupId") String groupId, @RequestParam("groupName") String newGroup,
			HttpServletRequest request) {

		zoneManager.updateGroup(groupId, newGroup);

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/projects/updateZone", method = RequestMethod.POST)
	public String updateZone(@RequestParam("zoneId") String zoneId, @RequestParam("name") String name,
			@RequestParam("width") String width, @RequestParam("heigh") String height,
			@RequestParam("measureName") String measureName, HttpServletRequest request) {

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
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

}

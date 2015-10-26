package ua.ksstroy.web;

import javax.annotation.Resource;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.logic.zone.NameConflictException;
import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.zoneManager;

import ua.ksstroy.mocks.ZoneHierarchyMockFactory;

@Controller
public class ProjectController {

	@Resource(name="ZoneManagerImpl")
	zoneManager zoneManager;

	@RequestMapping(value = "/projects/{projectId}", method = RequestMethod.GET)
	public ModelAndView showZHD(@PathVariable String projectId) {
		ModelAndView project = new ModelAndView("project");
		project.addObject("projectName", projectId);// the project name from
														// PathVariabl
		project.addObject("zhd",
				zoneManager.getRootZoneHierarchy(projectId));
		return project;

	}

	// TODO add current project name to SessionContext and use in redirect URL
	// e.g project name = mock; redirect to project/mock


	
	@RequestMapping(value = "/projects/getRootZoneHierarchy", method = RequestMethod.POST)
	public String getRootZoneHierarchy(
			@RequestParam("projectId") String projectId)   {
		zoneManager.getRootZoneHierarchy(projectId);
		return ("redirect:/projects/mock");
	}

	@RequestMapping(value = "/projects/addGroupToGroup", method = RequestMethod.POST)
	public String addGroupToGroup(String projectId, @RequestParam("groupName") String groupName,
			@RequestParam("parentGroupId") String parentGroupId, @RequestParam("projectId") String id) {
		zoneManager.addGroupToGroup(groupName, parentGroupId);
		return "redirect:/projects/" + id;
	}

	/*
	 * create new ZoneData object based on data from the web page and invoke
	 * according ZoneManager method
	 */
	@RequestMapping(value = "/projects/addZone", method = RequestMethod.POST)
	public String addZone(
			@RequestParam("name") String name,
			@RequestParam("parentGroupId") String parentGroupId,
			@RequestParam("measureName") String measureName,
			@RequestParam("width") String width,
			@RequestParam("heigh") String height) {

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
		return ("redirect:/projects/mock"); 
	}

	/*
	 * create new ZoneData object representing additionalZone in some Zone,
	 * based on data from the web page and invoke according ZoneManager method
	 */
	@RequestMapping(value = "/projects/addZoneToZone", method = RequestMethod.POST)
	public String addZoneToZone(
			@RequestParam("name") String name,
			@RequestParam("parentZoneId") String parentZoneId,
			@RequestParam("measureName") String measureName,
			@RequestParam("width") String width,
			@RequestParam("heigh") String height) {

		ZoneData additionalZoneFromWeb = new ZoneData();
		additionalZoneFromWeb.setName(name);
		try {
			additionalZoneFromWeb.setHeight(new Double(height).doubleValue());
			additionalZoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		additionalZoneFromWeb.setMeasureName(measureName);
		zoneManager.addZoneToZone(additionalZoneFromWeb, parentZoneId);
		return ("redirect:/projects/mock");
	}

	/*
	 * create new ZoneData object representing surplusZone in some Zone,
	 * based on data from the web page and invoke according ZoneManager method
	 */
	@RequestMapping(value = "/projects/subtractZoneFromZone", method = RequestMethod.POST)
	public String subtractZoneFromZone(
			@RequestParam("name") String name,
			@RequestParam("parentZoneId") String parentZoneId,
			@RequestParam("measureName") String measureName,
			@RequestParam("width") String width,
			@RequestParam("heigh") String height) {
		ZoneData surplusZoneFromWeb = new ZoneData();
		surplusZoneFromWeb .setName(name);
		try {
			surplusZoneFromWeb .setHeight(new Double(height).doubleValue());
			surplusZoneFromWeb .setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		surplusZoneFromWeb .setMeasureName(measureName);
		zoneManager.subtractZoneFromZone(surplusZoneFromWeb, parentZoneId);
		return ("redirect:/projects/mock");
	}

}

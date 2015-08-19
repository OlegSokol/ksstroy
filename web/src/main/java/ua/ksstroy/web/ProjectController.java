package ua.ksstroy.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.mocks.ZoneData;
import ua.ksstroy.mocks.ZoneHierarchyMockFactory;
import ua.ksstroy.mocks.ZoneManager;

@Controller
public class ProjectController {
	
	@Resource
	ZoneManager zoneManager;
	
	@RequestMapping (value="/{projectName}", method=RequestMethod.GET)
public ModelAndView showZHD(@PathVariable String projectName){
	ModelAndView project =new ModelAndView("project");
	project.addObject("projectName",projectName);//the project name from PathVariabl
	project.addObject("zhd",zoneManager.getRootZoneHierarchy("33"));
	return project;
}
	//TODO add current project name to SessionContext and use in redirect URL
	//e.g project name = mock; redirect to project/mock
	@RequestMapping (value="/formTest", method=RequestMethod.POST)
	public String formTest(){
		return("redirect:/mock");
	}
	
/*
 * handlers for ZoneManager methods
 */
	@RequestMapping (value="/getRootZoneHierarchy", method=RequestMethod.POST)
	public String getRootZoneHierarchy(@RequestParam("projectId") String projectId){
		zoneManager.getRootZoneHierarchy(projectId);
		return("redirect:/mock");
	}
	
	@RequestMapping (value="/addGroupToGroup", method=RequestMethod.POST)
	public String addGroupToGroup(@RequestParam("groupName") String groupName,@RequestParam("groupName") String parentGroupId){
		zoneManager.addGroupToGroup(groupName, parentGroupId);
		return("redirect:/mock");
	}
	
	
	/*
	 * create new ZoneData object based on data from the web page
	 * and invoke according ZoneManager method
	 */
		@RequestMapping (value="/addZone", method=RequestMethod.POST)
	public String addZone(@RequestParam("id") String id,@RequestParam("name")String name,@RequestParam("parentGroupId")String parentGroupId,@RequestParam("measureName")String measureName,@RequestParam("width")String width,@RequestParam("heigh")String height){
	
		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setId(id);
		zoneFromWeb.setName(name);
		try{
		zoneFromWeb.setHeight( new Double(height).doubleValue());
		zoneFromWeb.setWidth( new Double(width).doubleValue());}
		catch(NumberFormatException exception){
			//TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		zoneFromWeb.setMesureName(measureName);
		
		zoneManager.addZone(zoneFromWeb,  parentGroupId);
		return("redirect:/mock");
	}
	
		/*
		 * create new ZoneData object representing additionalZone in some Zone,
		 *  based on data from the web page
		 * and invoke according ZoneManager method
		 */
	@RequestMapping (value="/addZoneToZone", method=RequestMethod.POST)
	public String addZoneToZone(@RequestParam("id") String id,@RequestParam("name")String name,@RequestParam("parentZoneId")String parentZoneId,@RequestParam("measureName")String measureName,@RequestParam("width")String width,@RequestParam("heigh")String height){
	
		ZoneData additionalZoneFromWeb  = new ZoneData();
		additionalZoneFromWeb .setId(id);
		additionalZoneFromWeb .setName(name);
		try{
		additionalZoneFromWeb .setHeight( new Double(height).doubleValue());
		additionalZoneFromWeb .setWidth( new Double(width).doubleValue());}
		catch(NumberFormatException exception){
			//TODO: logging an exception
			System.out.println("empty string from web!!!");
		}
		additionalZoneFromWeb .setMesureName(measureName);
		zoneManager.addZoneToZone(additionalZoneFromWeb, parentZoneId);
		return("redirect:/mock");
	}
	
	@RequestMapping (value="/subtractZoneFromZone", method=RequestMethod.POST)
	public String subtractZoneFromZone(@RequestParam("zone") String zoneId, @RequestParam("zone") String parentZoneId){
		//TODO select ZoneData by zoneId parameter
		ZoneData zone = new ZoneData();
		zoneManager.subtractZoneFromZone( zone,  parentZoneId);
		return("redirect:/mock");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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

/*
 * A Spring-MVC controller to manage full ZoneGroup three 
 * via web page, using zoneManager implementation injected as @Resource. 
 * Methods are representing corresponding methods of ZoneManager.
 */
@Controller
public class ZoneManagerController {
	
	@Resource
	ZoneManager zoneManager;
	
	@RequestMapping (value="/projects/{projectName}", method=RequestMethod.GET)
public ModelAndView showZHD(@PathVariable String projectName){
	ModelAndView project =new ModelAndView("project");
	project.addObject("projectName",projectName);//the project name from PathVariable
	return project;
	
	
}
	//TODO add current project name to SessionContext and use in redirect URL
	//e.g project name = mock; redirect to http://.../project/mock
	
	/*
	 * for test purposes only
	 */
	@RequestMapping (value="/projects/formTest", method=RequestMethod.POST)
	public String formTest(){
		return("redirect:/projects/mock");
	}
	
/*
 * handlers for ZoneManager methods
 */
	@RequestMapping (value="/projects/getRootZoneHierarchy", method=RequestMethod.POST)
	public String getRootZoneHierarchy(@RequestParam("projectId") String projectId){
		zoneManager.getRootZoneHierarchy(projectId);
		return("redirect:/projects/mock");
	}
	
	@RequestMapping (value="/projects/addGroupToGroup", method=RequestMethod.POST)
	public String addGroupToGroup(@RequestParam("groupName") String groupName,@RequestParam("groupName") String parentGroupId){
		zoneManager.addGroupToGroup(groupName, parentGroupId);
		return("redirect:/projects/mock");
	}
	@RequestMapping (value="/projects/addZone", method=RequestMethod.POST)
	public String addZone(@RequestParam("zone") String zoneId,@RequestParam("parentGroupId")String parentGroupId){
		//TODO create ZoneData by zoneId parameter
		ZoneData zone = new ZoneData();
		zoneManager.addZone(zone,  parentGroupId);
		return("redirect:/projects/mock");
	}
	@RequestMapping (value="/projects/addZoneToZone", method=RequestMethod.POST)
	public String addZoneToZone(@RequestParam("zone") String zoneId, @RequestParam("zone") String parentZoneId){
		//TODO create ZoneData by zoneId parameter
				ZoneData zone = new ZoneData();
		zoneManager.addZoneToZone(zone, parentZoneId);
		return("redirect:/projects/mock");
	}
	
	@RequestMapping (value="/projects/subtractZoneFromZone", method=RequestMethod.POST)
	public String subtractZoneFromZone(@RequestParam("zone") String zoneId, @RequestParam("zone") String parentZoneId){
		//TODO create ZoneData by zoneId parameter
		ZoneData zone = new ZoneData();
		zoneManager.subtractZoneFromZone( zone,  parentZoneId);
		return("redirect:/projects/mock");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

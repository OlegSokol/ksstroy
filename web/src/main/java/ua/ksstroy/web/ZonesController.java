package ua.ksstroy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneManager;

import javax.annotation.Resource;

@Controller
public class ZonesController {

    private final Logger logger = LoggerFactory.getLogger(IndexPageController.class);
    @Resource(name = "ZoneManagerImpl")
    ZoneManager zoneManager;
    ModelAndView project;

    @RequestMapping(value = "/projects/{projectId}/zones", method = RequestMethod.GET)
    public ModelAndView showZHD(@PathVariable("projectId") String projectId) {
        project = new ModelAndView("zones");
        project.addObject("projectId", projectId);
        ZoneGroup zhd = zoneManager.getRootZoneHierarchy(projectId);
        project.addObject("rootGroupId", zhd.getId());
        project.addObject("zhd", zhd);
        return project;
    }

    @RequestMapping(value = "/projects/addGroupToGroup", method = RequestMethod.POST)
    public String addGroupToGroup(@RequestParam("groupName") String groupName,
                                  @RequestParam("parentGroupId") String parentGroupId,
                                  @RequestParam("projectId") String projectId) {

        zoneManager.addGroupToGroup(groupName, parentGroupId);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/addZone", method = RequestMethod.POST)
    public String addZone(@RequestParam("name") String name, @RequestParam("width") String width,
                          @RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
                          @RequestParam("parentGroupId") String parentGroupId,
                          @RequestParam("projectId") String projectId) {

        Zone zoneFromWeb = new Zone();
        zoneFromWeb.setName(name);
        try {
            zoneFromWeb.setHeight(new Double(height).doubleValue());
            zoneFromWeb.setWidth(new Double(width).doubleValue());
        } catch (NumberFormatException exception) {
            // TODO curiosity:CANT GET THIS MESSAGE EXPLICITLY!!
            logger.debug("empty string from web!!!");
        }
        zoneFromWeb.setMeasure(Measure.valueOf(measureName));
        zoneManager.addZone(zoneFromWeb, parentGroupId);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/addAdditionalZone", method = RequestMethod.POST)
    public String addAdditionalZone(@RequestParam("name") String name, @RequestParam("width") String width,
                                    @RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
                                    @RequestParam("parentZoneId") String parentZoneId,
                                    @RequestParam("projectId") String projectId) {

        Zone zoneFromWeb = new Zone();
        zoneFromWeb.setName(name);
        try {
            zoneFromWeb.setHeight(new Double(height).doubleValue());
            zoneFromWeb.setWidth(new Double(width).doubleValue());
        } catch (NumberFormatException exception) {
            logger.debug("empty string from web!!!");
        }
        zoneFromWeb.setMeasure(Measure.valueOf(measureName));
        zoneManager.addAdditionalToZone(zoneFromWeb, parentZoneId);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/addSurplusZone", method = RequestMethod.POST)
    public String addSurplusZone(@RequestParam("name") String name, @RequestParam("width") String width,
                                 @RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
                                 @RequestParam("parentZoneId") String parentZoneId,
                                 @RequestParam("projectId") String projectId) {

        Zone zoneFromWeb = new Zone();
        zoneFromWeb.setName(name);
        try {
            zoneFromWeb.setHeight(new Double(height).doubleValue());
            zoneFromWeb.setWidth(new Double(width).doubleValue());
        } catch (NumberFormatException exception) {
            logger.debug("empty string from web!!!");
        }
        zoneFromWeb.setMeasure(Measure.valueOf(measureName));

        zoneManager.addSurplusToZone(zoneFromWeb, parentZoneId);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/removeZone", method = RequestMethod.POST)
    public String removeZone(@RequestParam("zoneId") String zoneId,
                             @RequestParam("projectId") String projectId) {

        zoneManager.removeZone(zoneId);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/removeGroup", method = RequestMethod.POST)
    public String removeGroup(@RequestParam("groupId") String groupId,
                              @RequestParam("projectId") String projectId) {

        zoneManager.removeGroup(groupId);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/updateGroup", method = RequestMethod.POST)
    public String updateGroup(@RequestParam("id") String groupId,
                              @RequestParam("groupName") String newGroup,
                              @RequestParam("projectId") String projectId) {

        zoneManager.updateGroup(groupId, newGroup);
        return "redirect:" + projectId + "/zones";
    }

    @RequestMapping(value = "/projects/updateZone", method = RequestMethod.POST)
    public String updateZone(@RequestParam("zoneId") String zoneId, @RequestParam("name") String name,
                             @RequestParam("width") String width, @RequestParam("heigh") String height,
                             @RequestParam("measureName") String measureName,
                             @RequestParam("projectId") String projectId) {

        Zone zoneFromWeb = new Zone();
        zoneFromWeb.setName(name);
        try {
            zoneFromWeb.setHeight(new Double(height).doubleValue());
            zoneFromWeb.setWidth(new Double(width).doubleValue());
        } catch (NumberFormatException exception) {
            logger.info("empty string from web!!!");
        }
        zoneFromWeb.setMeasure(Measure.valueOf(measureName));

        zoneManager.updateZone(zoneId, zoneFromWeb);
        return "redirect:" + projectId + "/zones";
    }

}
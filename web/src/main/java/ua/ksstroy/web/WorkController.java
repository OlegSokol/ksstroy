package ua.ksstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.work.*;
import ua.ksstroy.logic.worktype.WorkTypeManagerImpl;
import ua.ksstroy.logic.zone.ZoneManagerImpl;

import javax.annotation.Resource;

@Controller
public class WorkController {

    @Resource(name = "WorkManagerImpl")
    WorkManager workManager;

    @Resource(name = "WorkTypeManagerImpl")
    WorkTypeManagerImpl workTypeManager;

    @Resource(name = "ZoneManagerImpl")
    ZoneManagerImpl zoneManager;

    ModelAndView workModelView;
    Work Work;
    Cover cover;
    Adjustment adjustment;

    @RequestMapping(value = "/projects/{projectId}/work", method = RequestMethod.GET)
    public ModelAndView showZHD(@PathVariable("projectId") String projectId) {
        workModelView = new ModelAndView("works");
        workModelView.addObject("projectId", projectId);
        workModelView.addObject("WorkHierarchy", workManager.getWorkHierarchy());
        workModelView.addObject("workType", workTypeManager.getWorkTypeHierarchy());
        workModelView.addObject("ZoneHierarchy", zoneManager.getRootZoneHierarchy(projectId));

        return workModelView;
    }

    @RequestMapping(value = "/projects/addOuterWorkGroup", method = RequestMethod.POST)
    public String addOuterWorkGroup(@RequestParam("name") String outerWorkTypeGroupName,
                                    @RequestParam("projectId") String projectId) {

        workManager.addWorkGroup(outerWorkTypeGroupName);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/addInnerWorkGroup", method = RequestMethod.POST)
    public String addInnerWorkGroup(@RequestParam("name") String innerWorkTypeGroupName,
                                    @RequestParam("parentId") String parentWorkTypeGroupId,
                                    @RequestParam("projectId") String projectId) {

        workManager.addWorkGroup(innerWorkTypeGroupName, parentWorkTypeGroupId);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/removeWorkGroup", method = RequestMethod.POST)
    public String removeWorkGroup(@RequestParam("id") String id,
                                  @RequestParam("projectId") String projectId) {

        workManager.removeWorkTypeGroup(id);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/updateWorkGroupName", method = RequestMethod.POST)
    public String updateWorkGroupName(@RequestParam("groupId") String groupId,
                                      @RequestParam("newGroupName") String newGroupName,
                                      @RequestParam("projectId") String projectId) {

        workManager.updateWorkGroupName(groupId, newGroupName);

        return "redirect:" + projectId + "/work";
    }


    @RequestMapping(value = "/projects/addWork", method = RequestMethod.POST)
    public String addWork(@RequestParam("name") String name,
                          @RequestParam("planedCost") String planedCoast,
                          @RequestParam("perspectiveCost") String perspectiveCost,
                          @RequestParam("closedCost") String closedCost,
                          @RequestParam("dealCost") String dealCost,
                          @RequestParam("parentId") String parentWorkTypeGroupId,
                          @RequestParam("projectId") String projectId,
                          @RequestParam("workTypeId") String workTypeId,
                          @RequestParam("zoneId") String zoneId) {

        Work = new Work();
        Work.setName(name);

        Work.setType(workTypeManager.getWorkTypeById(workTypeId));

        /*List<ZoneData> listZones = new ArrayList<>();
        listZones.add(new ZoneData());
        Work.setWorkZones(listZones);

        Work.setAllCovers();

        Work.setAdjustments();*/

        try {
            Work.setPlanedCost(new Double(planedCoast).doubleValue());
            Work.setPerspectiveCost(new Double(perspectiveCost).doubleValue());
            Work.setClosedCost(new Double(closedCost).doubleValue());
            Work.setDealCost(new Double(dealCost).doubleValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.addWork(Work, parentWorkTypeGroupId);
        System.out.println("add work");
        return "redirect:" + projectId + "/work";
    }


    @RequestMapping(value = "/projects/removeWork", method = RequestMethod.POST)
    public String removeWork(@RequestParam("id") String id,
                             @RequestParam("projectId") String projectId) {

        workManager.remoteWork(id);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/updateWork", method = RequestMethod.POST)
    public String updateWork(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("planedCost") String planedCoast,
                             @RequestParam("perspectiveCost") String perspectiveCost,
                             @RequestParam("closedCost") String closedCost,
                             @RequestParam("dealCost") String dealCost,
                             @RequestParam("projectId") String projectId) {

        Work = new Work();
        Work.setName(name);
        try {
            Work.setPlanedCost(new Double(planedCoast).doubleValue());
            Work.setPerspectiveCost(new Double(perspectiveCost).doubleValue());
            Work.setClosedCost(new Double(closedCost).doubleValue());
            Work.setDealCost(new Double(dealCost).doubleValue());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.updateWork(id, Work);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/addCoverToWork", method = RequestMethod.POST)
    public String addCoverToWork(@RequestParam("projectId") String projectId,
                                 @RequestParam("workId") String workId,
                                 @RequestParam("value") String value,
                                 @RequestParam("date") String date,
                                 @RequestParam("description") String description) {

        cover = new Cover();
        cover.setDescription(description);
        cover.setDate(date);

        try {
            cover.setValue(new Double(value).doubleValue());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.addCoverToWork(cover, workId);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/addAdjustmentToWork", method = RequestMethod.POST)
    public String addAdjustmentToWork(@RequestParam("projectId") String projectId,
                                      @RequestParam("workId") String workId,
                                      @RequestParam("value") String value,
                                      @RequestParam("isAbsolute") String isAbsolute) {

        adjustment = new Adjustment();
        try {
            System.out.println("VALUE IS STARTING ASSIGNED");
            adjustment.setValue(new Double(value).doubleValue());
            System.out.println("VALUE ASSIGNED!!");
            adjustment.setAbsolute(new Boolean(isAbsolute).booleanValue());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.addAdjustmentToWork(adjustment, workId);

        return "redirect:" + projectId + "/work";
    }

}

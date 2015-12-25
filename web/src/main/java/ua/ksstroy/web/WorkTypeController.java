package ua.ksstroy.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.worktype.WorkTypeManager;
import ua.ksstroy.logic.zone.Measure;

@Controller
public class WorkTypeController {

	 @Resource(name = "WorkTypeManagerImpl")
      WorkTypeManager workTypeManager;
	     
    ModelAndView workTypeObject;
    WorkTypeData workTypeData;

    @RequestMapping(value = "/workType", method = RequestMethod.GET)
    public ModelAndView showZHD() {
        workTypeObject = new ModelAndView("worktypes");
        workTypeObject.addObject("workTypeObject", workTypeManager.getWorkTypeHierarchy());
        return workTypeObject;
    }

    @RequestMapping(value = "/workType/addOuterWorkTypeGroup", method = RequestMethod.POST)
    public String addOuterWorkTypeGroup(@RequestParam("name") String outerWorkTypeGroupName,
                                        @RequestParam("projectId") String projectId) {

        workTypeManager.addWorkTypeGroup(outerWorkTypeGroupName);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/workType/addInnerWorkTypeGroup", method = RequestMethod.POST)
    public String addInnerWorkTypeGroup(@RequestParam("name") String innerWorkTypeGroupName,
                                        @RequestParam("parentId") String parentWorkTypeGroupId,
                                        @RequestParam("projectId") String projectId) {

        workTypeManager.addWorkTypeGroup(innerWorkTypeGroupName, parentWorkTypeGroupId);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/workType/removeWorkTypeGroup", method = RequestMethod.POST)
    public String removeWorkTypeGroup(@RequestParam("id") String id,
                                      @RequestParam("projectId") String projectId) {

        workTypeManager.removeWorkTypeGroup(id);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/workType/addWorkType", method = RequestMethod.POST)
    public String addWorkType(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("measure") String measure,
                              @RequestParam("unitPrice") String unitPrice,
                              @RequestParam("parentId") String parentWorkTypeGroupId,
                              @RequestParam("projectId") String projectId) {

        workTypeData = new WorkTypeData();
        workTypeData.setName(name);
        workTypeData.setDescription(description);
        workTypeData.setMeasure(Measure.valueOf(measure));

        try {
            workTypeData.setUnitPrice(new Double(unitPrice).doubleValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workTypeManager.addWorkType(workTypeData, parentWorkTypeGroupId);
        System.out.println("add work type");
        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/workType/removeWorkType", method = RequestMethod.POST)
    public String removeWorkType(@RequestParam("id") String id,
                                 @RequestParam("projectId") String projectId) {

        workTypeManager.removeWorkType(id);

        return "redirect:" + projectId;
    }


    @RequestMapping(value = "/workType/updateWorkTypeGroupName", method = RequestMethod.POST)
    public String updateWorkTypeGroupName(@RequestParam("groupId") String groupId,
                                 @RequestParam("newGroupName") String newGroupName,
                                 @RequestParam("projectId") String projectId){
        workTypeManager.updateWorkTypeGroupName(groupId,newGroupName);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/workType/updateWorkType", method = RequestMethod.POST)
    public String updateWorkType(@RequestParam("id") String id,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("measure") String measure,
                                 @RequestParam("unitPrice") String unitPrice,
                                 @RequestParam("projectId") String projectId) {

        workTypeData = new WorkTypeData();
        workTypeData.setName(name);
        workTypeData.setDescription(description);
        workTypeData.setMeasure(Measure.valueOf(measure));
        try {
            workTypeData.setUnitPrice(new Double(unitPrice).doubleValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workTypeManager.updateWorkType(id, workTypeData);

        return "redirect:" + projectId;
    }

}
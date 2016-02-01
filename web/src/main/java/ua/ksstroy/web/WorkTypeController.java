package ua.ksstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeManager;

import javax.annotation.Resource;

@Controller
public class WorkTypeController {

    @Resource(name = "WorkTypeManagerImpl")
    WorkTypeManager workTypeManager;

    ModelAndView workTypeModelView;
    WorkType workTypeData;

    @RequestMapping(value = "/projects/{projectId}/library_worktypes", method = RequestMethod.GET)
    public ModelAndView showZHD(@PathVariable("projectId") String projectId) {
        workTypeModelView = new ModelAndView("library_worktypes");
        workTypeModelView.addObject("projectId", projectId);
        workTypeModelView.addObject("workTypeObject", workTypeManager.getWorkTypeHierarchy());
        return workTypeModelView;
    }

    @RequestMapping(value = "/projects/addOuterWorkTypeGroup", method = RequestMethod.POST)
    public String addOuterWorkTypeGroup(@RequestParam("name") String outerWorkTypeGroupName,
                                        @RequestParam("projectId") String projectId) {

        workTypeManager.addWorkTypeGroup(outerWorkTypeGroupName);

        return "redirect:" + projectId + "/library_worktypes";
    }

    @RequestMapping(value = "/projects/addInnerWorkTypeGroup", method = RequestMethod.POST)
    public String addInnerWorkTypeGroup(@RequestParam("name") String innerWorkTypeGroupName,
                                        @RequestParam("parentId") String parentWorkTypeGroupId,
                                        @RequestParam("projectId") String projectId) {

        workTypeManager.addWorkTypeGroup(innerWorkTypeGroupName, parentWorkTypeGroupId);

        return "redirect:" + projectId + "/library_worktypes";
    }

    @RequestMapping(value = "/projects/removeWorkTypeGroup", method = RequestMethod.POST)
    public String removeWorkTypeGroup(@RequestParam("id") String id,
                                      @RequestParam("projectId") String projectId) {

        workTypeManager.removeWorkTypeGroup(id);

        return "redirect:" + projectId + "/library_worktypes";
    }

    @RequestMapping(value = "/projects/addWorkType", method = RequestMethod.POST)
    public String addWorkType(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("measure") String measure,
                              @RequestParam("unitPrice") String unitPrice,
                              @RequestParam("parentId") String parentWorkTypeGroupId,
                              @RequestParam("projectId") String projectId) {

        workTypeData = new WorkType();
        workTypeData.setName(name);
        workTypeData.setDescription(description);
        workTypeData.setMeasure(measure);

        try {
            workTypeData.setUnitPrice(new Double(unitPrice).doubleValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workTypeManager.addWorkType(workTypeData, parentWorkTypeGroupId);
        System.out.println("add work type");
        return "redirect:" + projectId + "/library_worktypes";
    }

    @RequestMapping(value = "/projects/removeWorkType", method = RequestMethod.POST)
    public String removeWorkType(@RequestParam("id") String id,
                                 @RequestParam("projectId") String projectId) {

        workTypeManager.removeWorkType(id);

        return "redirect:" + projectId + "/library_worktypes";
    }

    @RequestMapping(value = "/projects/updateWorkTypeGroupName", method = RequestMethod.POST)
    public String updateWorkTypeGroupName(@RequestParam("groupId") String groupId,
                                          @RequestParam("newGroupName") String newGroupName,
                                          @RequestParam("projectId") String projectId) {
        workTypeManager.updateWorkTypeGroupName(groupId, newGroupName);

        return "redirect:" + projectId + "/library_worktypes";
    }

    @RequestMapping(value = "/projects/updateWorkType", method = RequestMethod.POST)
    public String updateWorkType(@RequestParam("id") String id,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("measure") String measure,
                                 @RequestParam("unitPrice") String unitPrice,
                                 @RequestParam("projectId") String projectId) {

        workTypeData = new WorkType();
        workTypeData.setName(name);
        workTypeData.setDescription(description);
        workTypeData.setMeasure(measure);
        try {
            workTypeData.setUnitPrice(new Double(unitPrice).doubleValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workTypeManager.updateWorkType(id, workTypeData);

        return "redirect:" + projectId + "/library_worktypes";
    }

}
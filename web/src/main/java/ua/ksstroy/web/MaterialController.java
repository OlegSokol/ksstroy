package ua.ksstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.material.MaterialManager;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.logic.material.MaterialTypeGroupData;

import javax.annotation.Resource;

@Controller
public class MaterialController {

    @Resource(name = "MaterialManagerImpl")
    MaterialManager materialManager;

    ModelAndView materialModelView;
    MaterialTypeData materialTypeData;
    MaterialTypeGroupData materialTypeGroupData;

    @RequestMapping(value = "/projects/{projectId}/material", method = RequestMethod.GET)
    public ModelAndView showZHD(@PathVariable("projectId") String projectId) {
        this.materialModelView = new ModelAndView("materials");
        this.materialModelView.addObject("projectId", projectId);
        this.materialModelView.addObject("materialObject", materialManager.getMaterialHierarchy());

        return materialModelView;
    }

   /* @RequestMapping(value = "/projects/addMaterialTypeGroup", method = RequestMethod.POST)
    public String addOuterMaterialType(@RequestParam("name") String name,
                                       @RequestParam("description") String description,
                                       @RequestParam("projectId") String projectId) {

        this.materialTypeData = new MaterialTypeData();
        this.materialTypeData.setName(name);
        this.materialTypeData.setDescription(description);

        this.materialManager.addMaterialTypeGroup(materialTypeData);

        return "redirect:" + projectId;
    }*/

    @RequestMapping(value = "/projects/addInnerMaterialTypeGroup", method = RequestMethod.POST)
    public String addInnerMaterialTypeGroup(@RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("parentId") String parentMaterialTypeId,
                                            @RequestParam("projectId") String projectId) {

        this.materialTypeGroupData = new MaterialTypeGroupData();
        this.materialTypeGroupData.setName(name);
        this.materialTypeGroupData.setDescription(description);

        this.materialManager.addMaterialTypeGroupByParent(materialTypeGroupData, parentMaterialTypeId);

        return "redirect:" + projectId + "/material";
    }

    @RequestMapping(value = "/projects/updateMaterialTypeGroup", method = RequestMethod.POST)
    public String updateMaterialTypeGroup(@RequestParam("id") String id,
                                          @RequestParam("name") String name,
                                          @RequestParam("description") String description,
                                          @RequestParam("projectId") String projectId) {

        this.materialTypeGroupData = new MaterialTypeGroupData();
        this.materialTypeGroupData.setName(name);
        this.materialTypeGroupData.setDescription(description);

        this.materialManager.updateMaterialTypeGroup(id, materialTypeGroupData);

        return "redirect:" + projectId + "/material";
    }

    @RequestMapping(value = "/projects/removeMaterialTypeGroup", method = RequestMethod.POST)
    public String removeMaterialTypeGroup(@RequestParam("id") String id,
                                          @RequestParam("projectId") String projectId) {

        this.materialManager.removeMaterialTypeGroup(id);

        return "redirect:" + projectId + "/material";
    }

    @RequestMapping(value = "/projects/addMaterialType", method = RequestMethod.POST)
    public String addMaterialType(@RequestParam("name") String name,
                                  @RequestParam("description") String description,
                                  @RequestParam("pricePerUnit") String pricePerUnit,
                                  @RequestParam("unitName") String unitName,
                                  @RequestParam("parentId") String parentMaterialTypeId,
                                  @RequestParam("projectId") String projectId) {

        this.materialTypeData = new MaterialTypeData(name, description, Double.parseDouble(pricePerUnit), unitName);

        this.materialManager.addMaterialType(materialTypeData, parentMaterialTypeId);

        return "redirect:" + projectId + "/material";
    }


    @RequestMapping(value = "/projects/updateMaterialType", method = RequestMethod.POST)
    public String updateMaterialType(@RequestParam("id") String id,
                                     @RequestParam("name") String name,
                                     @RequestParam("description") String description,
                                     @RequestParam("pricePerUnit") String pricePerUnit,
                                     @RequestParam("unitName") String unitName,
                                     @RequestParam("projectId") String projectId) {

        this.materialTypeData = new MaterialTypeData(name, description, Double.parseDouble(pricePerUnit), unitName);

        this.materialManager.updateMaterialType(id, materialTypeData);

        return "redirect:" + projectId + "/material";
    }

    @RequestMapping(value = "/projects/removeMaterialType", method = RequestMethod.POST)
    public String removeMaterialType(@RequestParam("id") String id,
                                     @RequestParam("projectId") String projectId) {

        materialManager.removeMaterialType(id);

        return "redirect:" + projectId + "/material";
    }
}
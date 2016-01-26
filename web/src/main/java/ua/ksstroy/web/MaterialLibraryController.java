package ua.ksstroy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.material.MaterialLibraryManager;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.logic.material.MaterialTypeGroupData;

@Controller
public class MaterialLibraryController {

    @Autowired
    MaterialLibraryManager materialManager;

    ModelAndView materialModelView;
    MaterialTypeData materialTypeData;
    MaterialTypeGroupData materialTypeGroupData;

    //TODO:refactoring: libraries url should be global /libraries/material for example. and what a hell are project id is for?
    @RequestMapping(value = "/projects/{projectId}/library_materials", method = RequestMethod.GET)
    public ModelAndView getAllMaterialsLibrary(@PathVariable("projectId") String projectId) {
        this.materialModelView = new ModelAndView("library_materials");
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

    //TODO:refactoring: erase this redundant part "inner"
    @RequestMapping(value = "/projects/addInnerMaterialTypeGroup", method = RequestMethod.POST)
    public String addInnerMaterialTypeGroup(@RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("parentId") String parentMaterialTypeId,
                                            @RequestParam("projectId") String projectId) {

        this.materialTypeGroupData = new MaterialTypeGroupData();
        this.materialTypeGroupData.setName(name);
        this.materialTypeGroupData.setDescription(description);

        this.materialManager.addMaterialTypeGroupByParent(materialTypeGroupData, parentMaterialTypeId);

        return "redirect:" + projectId + "/library_materials";
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

        return "redirect:" + projectId + "/library_materials";
    }

    @RequestMapping(value = "/projects/removeMaterialTypeGroup", method = RequestMethod.POST)
    public String removeMaterialTypeGroup(@RequestParam("id") String id,
                                          @RequestParam("projectId") String projectId) {

        this.materialManager.removeMaterialTypeGroup(id);

        return "redirect:" + projectId + "/library_materials";
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

        return "redirect:" + projectId + "/library_materials";
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

        return "redirect:" + projectId + "/library_materials";
    }

    @RequestMapping(value = "/projects/removeMaterialType", method = RequestMethod.POST)
    public String removeMaterialType(@RequestParam("id") String id,
                                     @RequestParam("projectId") String projectId) {

        materialManager.removeMaterialType(id);

        return "redirect:" + projectId + "/library_materials";
    }
}
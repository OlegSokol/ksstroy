package ua.ksstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialManager;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.logic.zone.Measure;

import javax.annotation.Resource;

@Controller
public class MaterialController {

    @Resource(name = "MaterialManagerImpl")
    MaterialManager materialManager;

    ModelAndView materialModelView;
    MaterialData materialData;
    MaterialTypeData materialTypeData;

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public ModelAndView showZHD() {

        this.materialModelView = new ModelAndView("materials");
        this.materialModelView.addObject("materialObject", materialManager.getMaterialHierarchy());

        return materialModelView;
    }

   /* @RequestMapping(value = "/material/addMaterialType", method = RequestMethod.POST)
    public String addOuterMaterialType(@RequestParam("name") String name,
                                       @RequestParam("description") String description,
                                       @RequestParam("projectId") String projectId) {

        this.materialTypeData = new MaterialTypeData();
        this.materialTypeData.setName(name);
        this.materialTypeData.setDescription(description);

        this.materialManager.addMaterialType(materialTypeData);

        return "redirect:" + projectId;
    }*/

    @RequestMapping(value = "/material/addMaterialType", method = RequestMethod.POST)
    public String addInnerMaterialType(@RequestParam("name") String name,
                                       @RequestParam("description") String description,
                                       @RequestParam("parentId") String parentMaterialTypeId,
                                       @RequestParam("projectId") String projectId) {

        this.materialTypeData = new MaterialTypeData();
        this.materialTypeData.setName(name);
        this.materialTypeData.setDescription(description);

        this.materialManager.addMaterialTypeByParent(materialTypeData, parentMaterialTypeId);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/material/updateMaterialType", method = RequestMethod.POST)
    public String updateMaterialType(@RequestParam("id") String id,
                                     @RequestParam("name") String name,
                                     @RequestParam("description") String description,
                                     @RequestParam("projectId") String projectId) {

        this.materialTypeData = new MaterialTypeData();
        this.materialTypeData.setName(name);
        this.materialTypeData.setDescription(description);

        this.materialManager.updateMaterialType(id, materialTypeData);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/material/removeMaterialType", method = RequestMethod.POST)
    public String removeMaterialType(@RequestParam("id") String id,
                                     @RequestParam("projectId") String projectId) {

        this.materialManager.removeMaterialType(id);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/material/addMaterial", method = RequestMethod.POST)
    public String addMaterial(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("measure") String measure,
                              @RequestParam("size") String size,
                              @RequestParam("planedCost") String planedCost,
                              @RequestParam("dealCost") String dealCost,
                              @RequestParam("closedCost") String closedCost,
                              @RequestParam("parentId") String parentMaterialTypeId,
                              @RequestParam("projectId") String projectId) {

        this.materialData = new MaterialData();

        this.materialData.setName(name);
        this.materialData.setDescription(description);
        this.materialData.setMeasure(Measure.valueOf(measure));

        try {

            this.materialData.setSize(Double.parseDouble(size));
            this.materialData.setPlanedCost(Double.parseDouble(planedCost));
            this.materialData.setDealCost(Double.parseDouble(dealCost));
            this.materialData.setClosedCost(Double.parseDouble(closedCost));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        this.materialManager.addMaterial(materialData, parentMaterialTypeId);

        return "redirect:" + projectId;
    }


    @RequestMapping(value = "/material/updateMaterial", method = RequestMethod.POST)
    public String updateMaterial(@RequestParam("id") String id,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("measure") String measure,
                                 @RequestParam("size") String size,
                                 @RequestParam("planedCost") String planedCost,
                                 @RequestParam("dealCost") String dealCost,
                                 @RequestParam("closedCost") String closedCost,
                                 @RequestParam("projectId") String projectId) {

        this.materialData = new MaterialData();

        this.materialData.setName(name);
        this.materialData.setDescription(description);
        this.materialData.setMeasure(Measure.valueOf(measure));

        try {

            this.materialData.setSize(Double.parseDouble(size));
            this.materialData.setPlanedCost(Double.parseDouble(planedCost));
            this.materialData.setDealCost(Double.parseDouble(dealCost));
            this.materialData.setClosedCost(Double.parseDouble(closedCost));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        this.materialManager.updateMaterial(id, materialData);

        return "redirect:" + projectId;
    }

    @RequestMapping(value = "/material/removeMaterial", method = RequestMethod.POST)
    public String removeMaterial(@RequestParam("id") String id,
                                 @RequestParam("projectId") String projectId) {

        materialManager.removeMaterial(id);

        return "redirect:" + projectId;
    }
}
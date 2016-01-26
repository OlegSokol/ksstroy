package ua.ksstroy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialManager;

@Controller
public class MaterialController {

    @Autowired
    MaterialManager materialManager;

    MaterialData materialData;
    ModelAndView materialModelView;

    @RequestMapping(value = "/projects/{projectId}/materials", method = RequestMethod.GET)
    public ModelAndView getAllMaterialsByProjectId(@PathVariable("projectId") String projectId) {
        this.materialModelView = new ModelAndView("materials");
        this.materialModelView.addObject("projectId", projectId);
        this.materialModelView.addObject("MaterialsList", materialManager.getAllMaterials());

        return materialModelView;
    }

    @RequestMapping(value = "/projects/purchaseMaterial", method = RequestMethod.POST)
    public String addInnerMaterialTypeGroup(@RequestParam("quantity") String quantity,
                                            @RequestParam("parentId") String parentMaterialTypeId,
                                            @RequestParam("projectId") String projectId) {
        this.materialData = new MaterialData();
        materialData.setUnitsPerWorkZoneMeasure(Double.parseDouble(quantity));

        this.materialManager.purchaseMaterial(materialData, parentMaterialTypeId);

        return "redirect:" + projectId + "/material";
    }

}
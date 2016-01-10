package ua.ksstroy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.material.MaterialDao;
import ua.ksstroy.logic.material.MaterialManager;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.logic.material.MaterialTypeGroupData;

@Controller
public class MaterialController {

    @Autowired
    MaterialManager materialManager;

    ModelAndView materialModelView;




   @RequestMapping(value = "/projects/{projectId}/materials", method = RequestMethod.GET)
    public ModelAndView getAllMaterialsByProjectId(@PathVariable("projectId") String projectId) {
        this.materialModelView = new ModelAndView("materials");
        this.materialModelView.addObject("projectId", projectId);
        this.materialModelView.addObject("MaterialsList", materialManager.getAllMaterials());

        return materialModelView;
    }
}

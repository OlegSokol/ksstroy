package ua.ksstroy.web;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.hibermodel.ProductDAOimpl;
import ua.ksstroy.hibermodel.ProjectDAOimpl;
import ua.ksstroy.logic.HelloWorldService;
import ua.ksstroy.logic.ProductDAO;




@Controller
public class WelcomeController {

	@Resource
	private HelloWorldService helloWorldService;
	
	@Resource
	private ProjectDAOimpl tt;


	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
		helloWorldService.addProduct("moloko");
		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());


		helloWorldService.addProduct(name);
		return model;

	}
	
	@RequestMapping(value="pr", method=RequestMethod.GET)
	public String testDao(Model m){
		ApplicationContext c = new AnnotationConfigWebApplicationContext();
		tt.addProject();
		return "index";
	}

}
package ua.ksstroy.logic;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class HelloWorldService {
	
	@Resource
	private ProductDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "ua.ksstroy";

	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}", name);

		if(StringUtils.isEmpty(name)){
			return "Hello World";
		}else{
			return "Hello " + name + ".!.!.";
		}
		
	}

	public void addProduct(String name) {
		dao.addProduct(name);
		
	}

}

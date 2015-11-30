package ua.ksstroy.logic.worktype;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WorkTypeManagerImplTest {
	
	
	WorkTypeManager manager;

	@Before
	public void setUp(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		manager = context.getBean("WorkTypeManagerImpl", WorkTypeManager.class);
		
	}
	@Test
	public void testAddWorkType() {
		manager.addWorkType(new WorkTypeData());
	}

	@Test
	public void testAddChildWorkType() {
		manager.addChildWorkType(new WorkTypeData(), 1);
	}

	@Test
	public void testGetParentWorkTypes() {
		manager.getParentWorkTypes();
	}

	@Test
	public void testGetChildWorkTypes() {
		manager.getChildWorkTypes(1);
	}

	@Test
	public void testDeleteWorkType() {
		manager.deleteWorkType(1);
	}

}

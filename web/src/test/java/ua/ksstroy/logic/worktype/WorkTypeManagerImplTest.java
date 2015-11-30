package ua.ksstroy.logic.worktype;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	@ContextConfiguration(locations = {"classpath:/spring-beans.xml"})
	@RunWith(SpringJUnit4ClassRunner.class)
	public class WorkTypeManagerImplTest {
	     
	    @Mock
	    private WorkTypeDao workTypeDao;
	     
	    @InjectMocks
	    @Autowired
	    private WorkTypeManager manager;
	     
	     
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        // specify mock behave when method called
	        when(workTypeDao.getChildWorkTypes(1)).thenReturn(new HashSet<WorkType>());
	        when(workTypeDao.getParentWorkTypes()).thenReturn(new HashSet<WorkType>());
	        
	    }
	 
	     
	    @Test
	    public void testgetChildWorkTypes()   {
	        assertNotNull(workTypeDao);
	        assertNotNull(manager);
	        assertEquals(new HashSet<>(), manager.getChildWorkTypes(1));
	        
	    }
	    
	    @Test
	    public void testGetParentWorkTypes(){
	    	  assertNotNull(workTypeDao);
		        assertNotNull(manager);
	    	assertEquals(new HashSet<>(), manager.getParentWorkTypes());
	    	
	    }
	    
	    @Test
	    public void testAddChildWorkType(){
	    	  assertNotNull(workTypeDao);
		        assertNotNull(manager);
	    	manager.addChildWorkType(new WorkTypeData(), 1);
	    }
	    @Test
	    public void testDeleteWorkType(){
	    	  assertNotNull(workTypeDao);
		        assertNotNull(manager);
	    	manager.deleteWorkType(1);
	    }
	    @Test
	    public void testAddWorkType(){
	    	  assertNotNull(workTypeDao);
		        assertNotNull(manager);
	    	manager.addWorkType(new WorkTypeData());
	    }
	    
	}
	
	
	



package ua.ksstroy.logic.worktype;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class WorkTypeManagerImpl implements WorkTypeManager {
	
	@Resource
	WorkTypeDao workTypeDao;

	@Override
	public void addWorkType(WorkTypeData workTypeData) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addChildWorkType(WorkTypeData workTypeData, Integer parentWorkTypeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<WorkType> getParentWorkTypes() {
		// TODO Auto-generated method stub
		
		Set<WorkType> list = new HashSet<>();
		list = workTypeDao.getParentWorkTypes();
		
		return list;
	}

	@Override
	public Set<WorkType> getChildWorkTypes(Integer workTypeId) {

		Set<WorkType> list = new HashSet<>();
		list = workTypeDao.getChildWorkTypes(workTypeId);
		
		return list;
	}

	@Override
	public void deleteWorkType(Integer workTypeId) {
		// TODO Auto-generated method stub
		
	}


}

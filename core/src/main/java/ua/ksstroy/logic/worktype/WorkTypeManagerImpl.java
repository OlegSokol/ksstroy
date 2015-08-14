package ua.ksstroy.logic.worktype;

import java.util.ArrayList;
import java.util.List;

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
	public List<WorkType> getParentWorkTypes() {
		// TODO Auto-generated method stub
		
		List<WorkType> list = new ArrayList<>();
		list = workTypeDao.getParentWorkTypes();
		
		return list;
	}

	@Override
	public List<WorkTypeData> getChildWorkTypes(Integer workTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWorkType(Integer workTypeId) {
		// TODO Auto-generated method stub
		
	}


}

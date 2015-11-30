package ua.ksstroy.logic.worktype;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component(value="MockWorkTypeDao")
public class MockWorkTypeDaoImpl implements WorkTypeDao {

	@Override
	public void saveWorkType(WorkType workType) {
		System.out.println("saveWorkType(WorkType workType)");

	}

	@Override
	public void updateWorkType(WorkType workType) {
		// TODO Auto-generated method stub

	}

	@Override
	public WorkType getWorkTypeById(Integer workTypeId) {
		return new WorkType();
	}

	@Override
	public Set<WorkType> getWorkTypeHierarchy() {
		return new HashSet<WorkType>();
	}

	@Override
	public Set<WorkType> getParentWorkTypes() {
		return new HashSet<WorkType>();
	}

	@Override
	public Set<WorkType> getChildWorkTypes(Integer workTypeId) {
		return new HashSet<WorkType>();
	}

}

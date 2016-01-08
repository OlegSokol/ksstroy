/**
 * 
 */
package ua.ksstroy.logic.work;

import java.util.List;

public interface WorkGroup {
	
	public String getName();

	public void setName(String name);
	
	public String getId();

	public void setId(String id);

	public List<WorkGroup> getGroups();

	public void setGroups(List<WorkGroup> groups);

	public List<Work> getWork();

	public void setWork(List<Work> works);

}
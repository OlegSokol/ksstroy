/**
 * 
 */
package ua.ksstroy.logic.work;

import java.util.List;

/**
 * @author KooZ
 *
 */
public interface WorkGroup {
	
public String getName();
	
	public String getId();

	public List<WorkGroup> getGroups();

	public List<Work> getWork();

}

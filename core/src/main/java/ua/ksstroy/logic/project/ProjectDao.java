package ua.ksstroy.logic.project;

import java.util.List;

public interface ProjectDao {
	List<Project> getAllProjectsByUserName(Integer user);
}

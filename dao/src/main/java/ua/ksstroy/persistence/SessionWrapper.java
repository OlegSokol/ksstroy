package ua.ksstroy.persistence;

import java.util.List;

import org.hibernate.Session;

public class SessionWrapper {

	private Session session;
	
	public SessionWrapper(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, int id) {
		return (T) session.get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, String id) {
		return (T) session.get(clazz, id); 
	}

	public void delete(Object o) {
		session.delete(o);
		
	}

	public void saveOrUpdate(Object o) {
		session.saveOrUpdate(o);
		
	}

	public void save(Object o) {
		session.save(o);
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(T itemClass) {
		return session.createCriteria(itemClass.getClass()).list();
	}

}
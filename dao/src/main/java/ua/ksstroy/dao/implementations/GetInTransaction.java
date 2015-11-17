package ua.ksstroy.dao.implementations;




public interface GetInTransaction<V>{
	V process(SessionWrapper session);
}
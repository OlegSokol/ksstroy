package ua.ksstroy.persistence;

public interface GetInTransaction<V>{
	V process(SessionWrapper session);
}
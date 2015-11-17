package ua.ksstroy.persistence;

public interface DoInTransaction{
	void process(SessionWrapper session);
}
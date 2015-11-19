package ua.ksstroy.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class TransactionHelper {

	private Session session;

	interface TransactionAction<V> {
		V executeInTransaction();
	}

	private void getSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	public void doWithCommit(final DoInTransaction action) {
		action(new TransactionAction<Void>() {
			public Void executeInTransaction() {
				action.process(new SessionWrapper(session));
				session.getTransaction().commit();
				return null;
			}
		});
	}

	public <V> V simpleAction(final GetInTransaction<V> action) {
		return action(new TransactionAction<V>() {
			public V executeInTransaction() {
				return action.process(new SessionWrapper(session));
			}
		});
	}

	private <V> V action(TransactionAction<V> action) {
		try {
			getSession();
			return action.executeInTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
package ua.ksstroy.hibermodel;

import org.hibernate.Session;

import ua.ksstroy.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
       addProduct("asas");
//        session.delete(stock);
    }

	public static void addProduct( String productName ) {
		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Product product = new Product();
        product.setProductName(productName);
        
        session.save(product);
        session.getTransaction().commit();
	}
    
    
}

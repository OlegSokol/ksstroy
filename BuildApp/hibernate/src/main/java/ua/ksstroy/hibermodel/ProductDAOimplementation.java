package ua.ksstroy.hibermodel;

import org.hibernate.Session;

import ua.ksstroy.logic.ProductDAO;
import ua.ksstroy.persistence.HibernateUtil;


public class ProductDAOimplementation implements ProductDAO 
{
	public void addProduct( String productName ) {
		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Product product = new Product();
        product.setProductName(productName);
        
        session.save(product);
        session.getTransaction().commit();
	}
    
}

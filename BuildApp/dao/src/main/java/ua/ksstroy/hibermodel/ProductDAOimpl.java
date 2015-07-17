package ua.ksstroy.hibermodel;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.ProductDAO;
import ua.ksstroy.persistence.HibernateUtil;

@Component("dao")
public class ProductDAOimpl implements ProductDAO 
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

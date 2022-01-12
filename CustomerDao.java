package study.dao;



import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.entity.Customer;

public class CustomerDao
{

	public static Session getSession()
	{
		//READING the hibernate.cfg.xml  from the classpath 
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		// Create MetadataSources
		MetadataSources sources = new MetadataSources(registry);
		// Create Metadata
		Metadata metadata = sources.getMetadataBuilder().build();
		// Create SessionFactory
		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();

		Session session = sessionFactory.openSession(); // start a transaction

		return session;
	}
	public void AddInfo(Customer customer) 
	{
		Session session=getSession();
		
		
		
		session.save(customer);
		session.beginTransaction().commit();
		
		
		
	}

}

package com.hand.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.hand.dao.CustomerDao;
import com.hand.model.Address;
import com.hand.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;
        System.out.println(this.sessionFactory);
        }
	
	public Session getSession() {  
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
        sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
        System.out.println(sessionFactory);      
        return this.sessionFactory.getCurrentSession();  
    } */
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public void create(Customer customer) {
		session = sessionFactory.getCurrentSession();
			session.save(customer);
			System.out.println("插入了一个用户");
	}

	public void delete(int customer_id) {
		session = sessionFactory.getCurrentSession(); 
			Customer customer = 
					(Customer)session.get(Customer.class, customer_id);
			session.delete(customer);
			System.out.println("删除了一个用户");
	}

	public Customer find(int id) {
		session = sessionFactory.getCurrentSession();
		Customer customer = null; 
			customer = (Customer) session.get(Customer.class, id); 
			System.out.println("查找到了："+customer.getFirst_name());

		return customer;
		
	}

	public List<Customer> select(int pagesize, int pagenum) {
		session = sessionFactory.getCurrentSession();
		List<Customer> customer = session.createQuery("FROM Customer").
				setFirstResult((pagenum-1)*pagesize).setMaxResults(pagesize).list();
		return customer;
	}

	public void update(int id, String first_name, String last_name, String email, Address address) {
		session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		customer.setFirst_name(first_name);
		customer.setLast_name(last_name);
		customer.setEmail(email);
		customer.setAddress(address);
		session.update(customer); 
		System.out.println("更新了用户："+customer.getFirst_name());
	}

	public boolean check(Customer customer) {
		session = sessionFactory.getCurrentSession();
		String sql = "select last_name from Customer where first_name='"+customer.getFirst_name()+"'";  
		List list = session.createQuery(sql).list();  
		if(!list.isEmpty()) {  
			Iterator it = list.iterator();  
			while(it.hasNext()) {  
				String get = (String) it.next();  
				System.out.println(get);  
				if(get.equals(customer.getLast_name())) {  

					return true;  
				}  
			}  
		}  
		return false;     
	}  
}

package com.struts.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.struts.app.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private SessionFactory sf;
	
	public EmployeeDAOImpl(SessionFactory sf){
		this.sf = sf;
	}

	
	@Override
	public Employee getEmployeeDetail(int eid) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee where empid=:id");
		query.setInteger("id", eid); 
		Employee emp = (Employee) query.uniqueResult();
		emp.getRoles().forEach(r -> System.out.print(r.getRoleName()));
		if(emp != null){
			System.out.println("Employee Retrieved from DB::"+emp);
		}
		tx.commit();session.close();
		
		return emp;
	}
	
	

}

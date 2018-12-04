package com.struts.app.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.app.bean.Employee;
import com.struts.app.dao.EmployeeDAO;
import com.struts.app.dao.EmployeeDAOImpl;

public class EmployeeDetailAction implements Action, ModelDriven<Employee>, ServletContextAware {
		
		@Override
		public Employee getModel() {
			return emp;
		}
		
		private Employee emp = new Employee();
		
		private ServletContext ctx;
	
		@Override
		public void setServletContext(ServletContext sc) {
			this.ctx = sc;
		}

		@Override
		public String execute() throws Exception {
			
			SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
			EmployeeDAO empDao = new EmployeeDAOImpl(sf);
			Employee empDB = empDao.getEmployeeDetail(emp.getEmpId());
			if(empDB == null) return ERROR;
			else {
				emp.setEmpName(empDB.getEmpName());
				emp.setManagerId(empDB.getManagerId());
				emp.setRoles(empDB.getRoles());
				return SUCCESS;
			}
		}

}

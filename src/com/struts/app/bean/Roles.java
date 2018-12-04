package com.struts.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {
	
		
	Roles(){
		
	}

	public Roles(String roleName, Employee employee) {
		super();
		this.roleName = roleName;
		this.employee = employee;
	}

//	private int empId;
	private String roleName;
	
	@Id
	@Column(name = "RoleName",length = 30)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="EmpId", nullable=false)
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Roles [roleName=" + roleName + ", employee=" + employee + "]";
	}
	
	


	
}

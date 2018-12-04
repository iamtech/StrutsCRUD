package com.struts.app.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	private int empId;
	private String empName;
	private int managerId;

	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 
	 @Column(name = "EmpId", unique = true, nullable = false)
	public int getEmpId() {
		return empId;
	} 
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Column(name = "EmpName", length = 30)
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(name = "ManagerId")
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	
	private Set<Roles> roles;
	
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	/*@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", managerId=" + managerId + ", roles=" + roles
				+ "]";
	}
	*/
	
	
}

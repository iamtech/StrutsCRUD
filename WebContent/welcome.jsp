<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
</head>
<body>

<h3>Your id is <s:property value="empId"></s:property></h3>

<h3>Your name is <s:property value="empName"></s:property></h3>

<h3>Your manager's id is <s:property value="managerId"></s:property></h3>

<h3>Your roles 

	<%-- <s:property value="%{roles.iterator.next.roleName}"/> --%>
	
	<s:property  value="%{roles.{roleName}}" />
	
<%-- 	<s:property  value="%{roles.{roleName}[1]}" /> --%>
</h3>

</body>
</html>
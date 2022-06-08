package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maven.dto.Employee;
import com.maven.service.EmployeeServiceImpl;

/**
 * Servlet implementation class CreateEmployeeServelet
 */
public class CreateEmployeeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		Double empSalary= Double.parseDouble(request.getParameter("empSal"));
		String empDept = request.getParameter("empDept");
		
		Employee employee =new Employee(empId, empDept, empSalary, empDept);
		EmployeeServiceImpl employeeService =new EmployeeServiceImpl();
		Optional<Employee> addedEmployee=employeeService.addEmployee(employee);
		
		List <Employee> employees =employeeService.getEmployees();
		
		PrintWriter out=response.getWriter();
		
		if(addedEmployee.isPresent())
		{
			out.print("<html>");
			out.print("<body bg color='blue'>");
			out.print("<h1>Employee added succesfully</h1>");
			
			out.print("<table>");
			
			out.print("<tr>");
			out.print("<th>Employee Id</th");
			out.print("<th>Employee Name</th");
			out.print("<th>Employee Salary</th");
			out.print("<th>Employee Department</th");
			out.print("<tr/>");
			
			for(Employee empObj:employees)
			{
				out.print("<tr>");
				out.print("<td>"+empObj.getEmpId() +"</td");
				out.print("<td>"+empObj.getEmpName() +"</td");
				out.print("<td>"+empObj.getEmpSal() +"</td");
				out.print("<td>"+empObj.getEmpDep() +"</td");
				out.print("<tr/>");
				
			}
			
			out.print("</table>");
			
			out.print("</body>");
			
			out.print("</html>");
		}
		
		response.getWriter().print("emp details"+empId+empName+empSalary+empDept);
	}

}

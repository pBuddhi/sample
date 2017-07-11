package sample.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import sample.models.Employee;

@ManagedBean(name="empl")
@RequestScoped
public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Employee> employeeList =  getList();
	public ArrayList<Employee> getEmployeeList(){
		return employeeList;
	}
//	public EmployeeBean(){
//		try{
//			employeeList = getList();
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	}
	
	public ArrayList<Employee> getList(){
		ArrayList<Employee> temp = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tbitdb","root","bossisgreat");
	
			if(con==null)
				throw new SQLException("Can't get database connection");
	
			ps = con.prepareStatement(
				   "select * from Employees");
	
			//get empomer data from database
			ResultSet result =  ps.executeQuery();
	
			
	
			while(result.next()){
				Employee emp = new Employee();
	
	//			emp.setname(result.getLong("empomer_id"));
				emp.setId(result.getInt("id"));
				emp.setName(result.getString("name"));
				emp.setDesignation(result.getString("designation"));
				emp.setSalary(result.getString("salary"));
	
				
				temp.add(emp);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return temp;
	}
//	@PostConstruct
//	public void init(){
//		employeeList = new ArrayList<Employee>();
//		Connection con = null;
//		PreparedStatement ps = null;
////		get database connection
//		try{
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tbitdb","root","bossisgreat");
//	
//			if(con==null)
//				throw new SQLException("Can't get database connection");
//	
////			PreparedStatement ps
//			ps	= con.prepareStatement(
//				   "select * from Employees");
//	
//			//get empomer data from database
//			ResultSet result =  ps.executeQuery();
//	
//			
//	
//			while(result.next()){
//				Employee emp = new Employee();
//	
//	//			emp.setname(result.getLong("empomer_id"));
//				emp.setId(result.getInt("id"));
//				emp.setName(result.getString("name"));
//				emp.setDesignation(result.getString("designation"));
//				emp.setSalary(result.getString("salary"));
//	
//				
//				employeeList.add(emp);
//			}
//			if(ps!=null) ps.close();
//			if(con!=null) con.close();
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	
////		return employeeList;
//	}
	public String deleteAction(Employee employee) throws SQLException{
//		return "success";
		employeeList.remove(employee);
//		return null;
		int id = employee.getId();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tbitdb","root","bossisgreat");
		if(con==null)
			throw new SQLException("Can't get database connection");

		PreparedStatement ps
			= con.prepareStatement(
			   "delete from Employees where id="+Integer.toString(id));

		//update employee database
		ps.executeUpdate();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		return null;
	}
}


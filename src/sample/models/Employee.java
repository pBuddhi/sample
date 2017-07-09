package sample.models;

public class Employee {
	private int id;
	private String name;
	private String designation;
	private String salary;
	
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDesignation(String designation){
		this.designation = designation;
	}
	public void setSalary(String salary){
		this.salary = salary;
	}
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getDesignation(){
		return designation;
	}
	public String getSalary(){
		return salary;
	}
}

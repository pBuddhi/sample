package sample.beans;
import java.io.Serializable;


import javax.faces.bean.ManagedBean;


@ManagedBean(name = "login")
public class LoginBean implements Serializable{
	public String name;
	public String password;
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String login(){
		if(name.equals("myname") && password.equals("mypass")) return "displayData.xhtml";
		else return "failure";
	}
}

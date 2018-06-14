package model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Parent extends User{
	List<Student> children;

	public List<Student> getChildren() {
		return children;
	}

	public void setChildren(List<Student> children) {
		this.children = children;
	}
	

}

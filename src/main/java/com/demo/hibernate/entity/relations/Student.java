package com.demo.hibernate.entity.relations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Student {

	@Id
	int rollno;
	String name;
	int marks;
	
	/*@OneToOne
	Laptop laptop;*/
	@OneToMany(mappedBy="student"/*,fetch=FetchType.EAGER*/)
	List<Laptop> laptopList = new ArrayList<Laptop>();
	

	public List<Laptop> getLaptop() {
		return laptopList;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptopList = laptop;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}

}

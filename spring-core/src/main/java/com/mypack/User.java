package com.mypack;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private String name;
	private int roll;
	private Cource cource;
	private List<String> list;
	private Set<String> set;
	private Map<String,String> map;
	
	
	public User() {
	
	}

	public User(String name) {
		this.name = name;
	}
	
	public User(int roll) {
		super();
		this.roll = roll;
	}
	
	public User(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}
	
	public User(Cource cource) {
		super();
		this.cource = cource;
	}
	
	
	public User(Map<String, String> map) {
		super();
		this.map = map;
	}

	public User(Set<String> set) {
		super();
		this.set = set;
	}

	public User(List<String> list) {
		super();
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public Cource getCource() {
		return cource;
	}

	public void setCource(Cource cource) {
		this.cource = cource;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
}
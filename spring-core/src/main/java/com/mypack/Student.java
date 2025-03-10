package com.mypack;

import java.util.List;
import java.util.Map;

public class Student {

	private List<Cource> courceList;
	private Map<Cource, Project> courceProjectMap;
	
	public Student(Map<Cource, Project> courceProjectMap) {
		
		this.courceProjectMap = courceProjectMap;
	}
	public Student(List<Cource> courceList) {
		
		this.courceList = courceList;
	}
	public List<Cource> getCourceList() {
		return courceList;
	}
	public void setCourceList(List<Cource> courceList) {
		this.courceList = courceList;
	}
	public Map<Cource, Project> getCourceProjectMap() {
		return courceProjectMap;
	}
	public void setCourceProjectMap(Map<Cource, Project> courceProjectMap) {
		this.courceProjectMap = courceProjectMap;
	}
	
}

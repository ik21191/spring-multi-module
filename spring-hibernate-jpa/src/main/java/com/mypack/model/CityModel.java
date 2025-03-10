package com.mypack.model;

public class CityModel {

	private Long id;

	private String cityName;

	public CityModel() {

	}

	public CityModel(String cityName) {
		this.cityName = cityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityModel [id=" + id + ", cityName=" + cityName + "]";
	}
	
	
}
